package mp.sound;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * Execução do áudio usando a biblioteca JLayer
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 18 de junho de 2018
 */
public class MediaPlayer {

    private final File music;
    private Player jlayer;

    /**
     * Constrói um MediaPlayer com o caminho de uma música especificada
     *
     * @param music Arquivo de música que vai ser executada
     */
    public MediaPlayer(File music) {
        this.music = music;
    }

    /**
     * Prepara arquivo de música e a reproduz
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
        } catch (FileNotFoundException | JavaLayerException e) {
            System.out.println("Erro!");
        }
    }

}
