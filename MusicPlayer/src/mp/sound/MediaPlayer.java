/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.sound;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javazoom.jl.player.Player;

/**
 *
 * @author Anne
 */
public class MediaPlayer {
    
    private File music;
    private Player player;
 
    public MediaPlayer(File music){
        this.music = music;
    }
    
    public void play(){    
        
        try{
            FileInputStream stream = new FileInputStream(music);
            BufferedInputStream buffer = new BufferedInputStream(stream);
            this.player = new Player (buffer);
            System.out.println("Executando...");
            this.player.play();
            System.out.println("Terminado");
        }
        catch (Exception e) {
            System.out.println("Erro!");
            e.printStackTrace();
        }
    }
    
    
    // ********* USAR CLASSE MUSICA PARA ISSO
//    public void save( String str, String strName ){
//         
//        try{
//
//            FileWriter fw = new FileWriter("data/musicas.txt", true); 
//            BufferedWriter bw = new BufferedWriter(fw);
//
//            bw.write(strName + ";" + str);
//            bw.newLine(); 
//            
//            bw.close();
//            fw.close();
//        
//        }catch(IOException e){
//            System.out.println("Erro");
//
//        }
//    }

//    public void remove( String strName, String str ){
//    
//    }
}

