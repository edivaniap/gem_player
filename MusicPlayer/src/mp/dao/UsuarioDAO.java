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
 * Representa dados de um usuário
 * 
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 20 de junho de 2018
 */
public class UsuarioDAO implements CRUDInterface {
    
    private File file;
    private FileReader fileReader = null;
    private BufferedReader bufferedReader = null;
    private FileWriter fileWriter = null;
    private BufferedWriter bufferedWriter = null;
    
    public UsuarioDAO() {
        file = new File("data/usuarios.txt");
    }
    
    /**
     * Valida a autenticação do usuario 
     * 
     * @param user Usuario
     * @param pass Senha correspondente ao usuario
     * @return
     */
    public User autenticacao(String user, String pass) {
        ArrayList<User> usuarios = this.list();
        
        for (User usuario : usuarios) {
            if (user.equals(usuario.getUsername()) && pass.equals(usuario.getPassword())) {
                return usuario;
            }
        }
        
        return null;
    }
    
    /**
     * Insere um novo usuario, sua senha e seu tipo (Comum ou VIP) 
     * 
     * @param usuario Usuario atual
     */
    @Override
    public void insert(User usuario) {
        try {
            FileWriter fw = new FileWriter(file, true); 
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(usuario.getNome() + ";"
                    + usuario.getUsername() + ";" + usuario.getPassword() + ";"
                    + usuario.getType());
            
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
     *
     * @return
     */
    @Override
    public ArrayList<User> list() {
        
        ArrayList<User> usuarios = new ArrayList<>();
        User usuario = null;
        
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()) {
                String line = br.readLine(); 

                String fields[] = line.split(";"); 

                if (fields[3].equals("VIP")) {
                    usuario = new VIPUser(fields[0], fields[1], fields[2], fields[3]);
                } else if (fields[3].equals("Comum")) {
                    usuario = new CommonUser(fields[0], fields[1], fields[2], fields[3]);
                } else {
                    System.out.println("[UsuarioDAO - listar()]: Erro no preenchimento do field tipo de usuario...");
                }
                
                usuarios.add(usuario);
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
        
        return usuarios;
    }
    
    /**
     * Remove um usuario
     * 
     * @param lineToRemove Indica a linha correspondente ao usuario a ser removida
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
        
        for (User usuario : currentUsers) {
            this.insert(usuario);
        }
    }
    
    /**
     * Verifica se a senha está inserida em uma lista
     * 
     * @param userKey Senha a ser verificada
     * @return Falso se a senha não existir e verdadeiro caso contrário
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
     *
     * 
     * @param userKey 
     * @return
     */
    public String getSenha(String userKey) {
        ArrayList<User> currentUsers = this.list();
        
        for (User user : currentUsers) {
            if (userKey.equals(user.getUsername())) {
                return user.getPassword();
            }
        }
        return "";
    }
    
    /**
     *
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
     *  
     * 
     * @param newUser
     * @param currentUserKey
     */
    @Override
    public void edit(User newUser, String currentUserKey) {
        ArrayList<User> currentUsers = this.list();
        this.clear();
        
        for (User usuario : currentUsers) {
            if (currentUserKey.equals(usuario.getUsername())) {
                this.insert(newUser);
            } else {
                this.insert(usuario);
            }
        }        
    }
}
