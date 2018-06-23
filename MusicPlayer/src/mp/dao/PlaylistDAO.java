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
     */
    public PlaylistDAO() throws IOException {
        file = new File("data/playlist.txt");
         
        if (!file.exists()) {
            file.createNewFile();
        }
    }    
    
    public File getFile() {
        return file;
    }   
}   

