package mp.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mp.model.Usuario;

/**
 *
 * @author Edivania
 */
public class UsuarioDAO {
    
    private File file;
    private int ultimoCodigo;
    
    public Usuario autenticacao(String user, String pass) {
        ArrayList<Usuario> usuarios = this.listar();
        
        for (Usuario usuario : usuarios) {
            if(user.equals(usuario.getUsuario()) && pass.equals(usuario.getSenha())) {
                return usuario;
            }
        }
        
        return null;
    }

    public void inserir(Usuario usuario) {
        try {
            file = new File("data/usuarios.txt");
            
            FileWriter fw = new FileWriter(file, true); //segundo parametro indica que o conteúdo sera acrescentado e nao substituido
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(usuario.getCodigo() + ";" + usuario.getNome() + ";" 
                    + usuario.getUsuario() + ";" + usuario.getSenha() + ";"
                    + usuario.getTipo());
            
            bw.newLine(); //quebra de linha    
            
            bw.close();
            fw.close();        
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
	} catch (IOException e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Usuario> listar() {
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario usuario;

        try {
            file = new File("data/usuarios.txt");
            
            FileReader fr = new FileReader(file);
            BufferedReader br = new  BufferedReader(fr);
            
            //enquanto houver linhas...
            while(br.ready()) {
                String line = br.readLine(); //le proxima linha
                usuario = new Usuario(0,"", "", "", "");
                
                String fields[] = line.split(";"); //preenche vetor com valores separados por ;
                
                int cod = Integer.parseInt(fields[0]);
                
                usuario.setCodigo(cod);
                usuario.setNome(fields[1]);
                usuario.setUsuario(fields[2]);
                usuario.setSenha(fields[3]);                        
                usuario.setTipo(fields[4]);
                
                usuarios.add(usuario);
            }
            
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
	} catch (IOException e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
        
        return usuarios;
    }
    
//    for (Usuario usuario1 : usuarios) {
//            System.out.println(usuario1.getCodigo() +" = "+ usuario1.getNome() + " - " + usuario1.getSenha() + " - " + usuario1.getTipo());
//        }
    
//    public static void main(String[] args) {
//        System.out.println("teste usuario dao............");
//        Usuario u1 = new Usuario();
//        Usuario u2 = new Usuario(1, "Pedro", "pdr", "2389", "comum");
//        
//        UsuarioDAO uDAO = new UsuarioDAO();
//        uDAO.inserir(u1);
//        uDAO.inserir(u2);
//        uDAO.listar();
//        //uDAO.clean();
//    }

       // public void alterar(Usuario novoUsuario, int atualCodigo) { }

    //public void deletar(int codigo) { }
    
}
