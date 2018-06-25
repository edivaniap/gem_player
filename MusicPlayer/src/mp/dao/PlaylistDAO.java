/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mp.model.Playlist;
/**
 *
 * @author Anne
 */
public class PlaylistDAO {
    
    private File file = null;
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;
    FileWriter fileWriter = null;
    BufferedWriter bufferedWriter = null;

    /**
     *
     * @param playlist
     */
    public PlaylistDAO( ){
       
    }   
    
    public Playlist criar(Playlist playlist){
        
        file = new File("data/" +"Playlist_" + playlist.getNome() + ".txt");
        
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Playlist já inserida");
        }
        
        return null;
    }
    
    public Playlist adicionarMusica( Playlist playlist ){
        
        System.out.println(playlist.getNome());
        
        String caminho = "data/" +"Playlist_" + playlist.getNome() + ".txt";
        
        try {
                file = new File(caminho);
                
                fileWriter = new FileWriter(file, true); 
                bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write( playlist.getCaminhoMusica()); 

                bufferedWriter.newLine();   
            } catch (FileNotFoundException e) {
               
                JOptionPane.showMessageDialog(null, "" + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "" + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "" + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, " Erro ao finalizar " + e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
                }
            }
        return null;
    }
    
   
    
    public File getFile() {
        return file;
    }   
}   

