package mp.model;

import java.util.ArrayList;

/**
 * Representa uma playlist de músicas
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 23 de junho de 2018
 */
public class Playlist {

    private String title;
    private ArrayList<Music> musics;

    /**
     * Cria uma playlist de músicas
     *
     * @param title O título da playlist
     */
    public Playlist(String title) {
        this.title = title;
        musics = new ArrayList<>();
    }

    /**
     * Adiciona uma música ao arranjo de músicas da playlist
     *
     * @param music A nova música a ser adicionada
     */
    public void addMusic(Music music) {
        musics.add(music);
    }

    /**
     * Recupera as músicas da playlist
     *
     * @return O atual arranjo de músicas da playlist
     */
    public ArrayList<Music> getMusics() {
        return musics;
    }

    /**
     * Modifica as músicas da playlist
     *
     * @param musics As novas músicas da playlist
     */
    public void setMusics(ArrayList<Music> musics) {
        this.musics = musics;
    }

   /**
     * Recupera o título da playlist
     *
     * @return O atual título da playlist
     */
    public String getTitle() {
        return title;
    }

   /**
     * Modifica o título da playlist
     *
     * @param title O novo título da playlist
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
