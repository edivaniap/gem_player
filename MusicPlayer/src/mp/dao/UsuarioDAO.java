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
import mp.model.Usuario;
import mp.model.UsuarioComum;
import mp.model.UsuarioVIP;

/**
 *
 * @author Edivania
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
    
    public Usuario autenticacao(String user, String pass) {
        ArrayList<Usuario> usuarios = this.list();
        
        for (Usuario usuario : usuarios) {
            if (user.equals(usuario.getUsuario()) && pass.equals(usuario.getSenha())) {
                return usuario;
            }
        }
        
        return null;
    }
    
    @Override
    public void insert(Usuario usuario) {
        try {
            FileWriter fw = new FileWriter(file, true); //segundo parametro indica que o conteúdo sera acrescentado e nao substituido
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(usuario.getNome() + ";"
                    + usuario.getUsuario() + ";" + usuario.getSenha() + ";"
                    + usuario.getTipo());
            
            bw.newLine(); //quebra de linha    

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
    
    @Override
    public ArrayList<Usuario> list() {
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = null;
        
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            //enquanto houver linhas...
            while (br.ready()) {
                String line = br.readLine(); //le proxima linha

                String fields[] = line.split(";"); //preenche vetor com valores separados por ;

                if (fields[3].equals("VIP")) {
                    usuario = new UsuarioVIP(fields[0], fields[1], fields[2], fields[3]);
                } else if (fields[3].equals("Comum")) {
                    usuario = new UsuarioComum(fields[0], fields[1], fields[2], fields[3]);
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
    
    @Override
    public void delete(int lineToRemove) {
        ArrayList<Usuario> currentUsers = this.list();
        this.clear();
        
        try {
            currentUsers.remove(lineToRemove);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        }
        
        for (Usuario usuario : currentUsers) {
            this.insert(usuario);
        }
    }
    
    @Override
    public boolean alreadyExist(String userKey) {
        ArrayList<Usuario> currentUsers = this.list();
        
        for (Usuario user : currentUsers) {
            if (userKey.equals(user.getUsuario())) {
                return true;
            }
        }
        return false;
    }
    
    public String getSenha(String userKey) {
        ArrayList<Usuario> currentUsers = this.list();
        
        for (Usuario user : currentUsers) {
            if (userKey.equals(user.getUsuario())) {
                return user.getSenha();
            }
        }
        return "";
    }
    
    public void clear() {
        try {
            Writer out = new FileWriter(file.getPath());
            System.out.println(file.getPath());

            //limpa
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
    
    @Override
    public void edit(Usuario newUser, String currentUserKey) {
        ArrayList<Usuario> currentUsers = this.list();
        this.clear();
        
        for (Usuario usuario : currentUsers) {
            if (currentUserKey.equals(usuario.getUsuario())) {
                this.insert(newUser);
            } else {
                this.insert(usuario);
            }
        }        
    }
}
