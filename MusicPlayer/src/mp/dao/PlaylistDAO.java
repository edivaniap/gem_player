/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        file = new File("data/" + "playlist_" + playlist.getNome() + ".txt");
        System.out.println("playlist.getNome()");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public File getFile() {
        return file;
    }   
}   

