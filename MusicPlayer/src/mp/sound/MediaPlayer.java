/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.sound;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

/**
 *
 * @author Anne
 */
public class MediaPlayer {

    private File music;
    private Player jlayer;

    public MediaPlayer(File music) {
        this.music = music;
    }

    public void play() {

        try {
            FileInputStream stream = new FileInputStream(music);
            BufferedInputStream buffer = new BufferedInputStream(stream);
            jlayer = new Player(buffer);
            System.out.println("Executando...");
            jlayer.play();
            jlayer.close();
            System.out.println("Terminado");
        } catch (Exception e) {
            System.out.println("Erro!");
            e.printStackTrace();
        }
    }

    public void parar() {
        jlayer.close();
        System.out.println("Terminado");
    }

}
