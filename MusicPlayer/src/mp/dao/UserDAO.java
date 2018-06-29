package mp.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mp.interfaces.CRUDInterface;
import mp.model.User;
import mp.model.CommonUser;
import mp.model.VIPUser;

/**
 * Classe de acesso e persitência dos dados de Usuários
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 20 de junho de 2018
 */
public class UserDAO implements CRUDInterface {

    private File file;
    private FileReader fileReader = null;
    private BufferedReader bufferedReader = null;
    private FileWriter fileWriter = null;
    private BufferedWriter bufferedWriter = null;

    public UserDAO() {
        file = new File("data/usuarios.txt");
    }

    /**
     * Valida a autenticação do usuário pelo pseudonome e senha
     *
     * @param username Pseudonome do usuário
     * @param password Senha correspondente ao usuário
     * @return O usuário caso ele tenha entrado com os dados corretos, null caso
     * contrário
     */
    public User authenticate(String username, String password) {
        ArrayList<User> users = this.list();

        for (User user : users) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return user;
            }
        }

        return null;
    }

    /**
     * Insere um novo usuário no arquivo de texto separando seus atributos por
     * ";"
     *
     * @param user Usuário a ser inserido no arquivo
     */
    @Override
    public void insert(User user) {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(user.getName() + ";" + user.getUsername() + ";" + user.getPassword() + ";" + user.getType());

            bw.newLine();

            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "[UsuarioDAO - inserir()]:" + e.getMessage(), "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "[UsuarioDAO - inserir()]:" + e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "[UsuarioDAO - inserir()]:" + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Percorre o arquivo de usuários, dividindo seus atributos que estão entre
     * ";" e carregando um arranjo de usuários
     *
     * @return Lista com as usuários carregados
     */
    @Override
    public ArrayList<User> list() {

        ArrayList<User> users = new ArrayList<>();
        User user = null;

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()) {
                String line = br.readLine();

                String fields[] = line.split(";");

                if (fields[3].equals("VIP")) {
                    user = new VIPUser(fields[0], fields[1], fields[2]);
                } else if (fields[3].equals("Comum")) {
                    user = new CommonUser(fields[0], fields[1], fields[2]);
                } else {
                    System.out.println("[UsuarioDAO - listar()]: Erro no preenchimento do field tipo de usuario...");
                }

                users.add(user);
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "[UsuarioDAO - listar()]:" + e.getMessage(), "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "[UsuarioDAO - listar()]:" + e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "[UsuarioDAO - listar()]:" + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }

        return users;
    }

    /**
     * Remove um usuário do arquivo apagando a linha que contém seus dados
     *
     * @param lineToRemove Indica a linha a ser removida
     */
    @Override
    public void delete(int lineToRemove) {
        ArrayList<User> currentUsers = this.list();
        this.clear();

        try {
            currentUsers.remove(lineToRemove);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        }

        for (User user : currentUsers) {
            this.insert(user);
        }
    }

    /**
     * Verifica se um usuário com um pseudonome específico já está gravado no arquivo de usuários
     *
     * @param userKey Pseudonome do usuário a ser verificado
     * @return false se o usuário não existir e true caso contrário
     */
    @Override
    public boolean alreadyExist(String userKey) {
        ArrayList<User> currentUsers = this.list();

        for (User user : currentUsers) {
            if (userKey.equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Recupera a senha de um usuário específico do arquivo de usuários
     *
     * @param userKey Pseudonome do usuário da senha buscada
     * @return Senha recuperada ou uma String vazia caso não encontre o usuário
     */
    public String getPassword(String userKey) {
        ArrayList<User> currentUsers = this.list();

        for (User user : currentUsers) {
            if (userKey.equals(user.getUsername())) {
                return user.getPassword();
            }
        }
        return "";
    }

    /**
     * Limpa o arquivo com os dados dos usuários apagando todo texto
     *
     * @
     */
    public void clear() {
        try {
            Writer out = new FileWriter(file.getPath());
            System.out.println(file.getPath());

            out.write("");
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "[UsuarioDAO - clear()]: " + e.getMessage(), "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "[UsuarioDAO - clear()]: " + e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "[UsuarioDAO - clear()]: " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Edita os atributos de um usuário no arquivo
     *
     * @param newUser Novos dados do usuário
     * @param currentUserKey Atual pseudonome do usuário que vai ser editado
     */
    @Override
    public void edit(User newUser, String currentUserKey) {
        ArrayList<User> currentUsers = this.list();
        this.clear();

        for (User user : currentUsers) {
            if (currentUserKey.equals(user.getUsername())) {
                this.insert(newUser);
            } else {
                this.insert(user);
            }
        }
    }
}
