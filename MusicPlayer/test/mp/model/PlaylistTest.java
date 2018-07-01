/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes da Classe Playlist
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 29 de junho de 2018
 */
public class PlaylistTest {

    Playlist instance;

    public PlaylistTest() {
        instance = new Playlist("Summer Hits");
    }

    /**
     * Test of addMusic method, of class Playlist.
     */
    @Test
    public void testAddMusic() {
        System.out.println("addMusic");
        Music music = new Music("Musica.mp3", "C:\\Musica.mp3");

        instance.addMusic(music);

        assertEquals(1, instance.getMusics().size());
        assertEquals("Musica.mp3", instance.getMusics().get(0).getTitle());
        assertEquals("C:\\Musica.mp3", instance.getMusics().get(0).getPath());

    }

    /**
     * Test of getMusics method, of class Playlist.
     */
    @Test
    public void testGetMusics() {
        System.out.println("getMusics");

        ArrayList<Music> expResult = new ArrayList<>();

        Music music = new Music("Musica.mp3", "C:\\Musica.mp3");
        instance.addMusic(music);
        expResult.add(music);

        ArrayList<Music> result = instance.getMusics();

        assertEquals(1, result.size());
        assertEquals("Musica.mp3", result.get(0).getTitle());
        assertEquals("C:\\Musica.mp3", result.get(0).getPath());
        assertEquals(expResult.get(0).getTitle(), result.get(0).getTitle());
    }

    /**
     * Test of setMusics method, of class Playlist.
     */
    @Test (expected = NullPointerException.class)
    public void testSetMusics() {
        System.out.println("setMusics");
        ArrayList<Music> musics = null;
        Playlist instance = null;
        instance.setMusics(musics);
    }

    /**
     * Test of getTitle method, of class Playlist.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");

        String expResult = "Summer Hits";
        String result = instance.getTitle();

        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class Playlist.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");

        String title = "Eletronic";
        instance.setTitle(title);

        String expResult = title;
        String result = instance.getTitle();

        assertEquals(expResult, result);
    }

}
