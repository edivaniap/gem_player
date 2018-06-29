
package mp.sound;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

/**
 * Execução do audio  
 * 
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 18 de junho de 2018
 */

public class MediaPlayer {

    private File music;
    private Player jlayer;

    public MediaPlayer(File music) {
        this.music = music;
    }
	
/**
  * Prepara arquivo de musica para ser tocado usando a biblioteca JLayer  
  * 
  */
    
			
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
