package mp.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes da Classe Music
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 29 de junho de 2018
 */
public class MusicTest {

    Music instance;

    public MusicTest() {
        instance = new Music("Let There Be Love.mp3", "C:\\Users\\Edivania\\Desktop\\MUSICAS\\Let There Be Love.mp3");
    }

    /**
     * Test of isEqual method, of class Music.
     */
    @Test
    public void testIsEqual() {
        System.out.println("isEqual");
        Music music = new Music("Let There Be Love.mp3", "C:\\Users\\Edivania\\Desktop\\MUSICAS\\Let There Be Love.mp3");

        boolean expResult = false;
        boolean result = instance.isEqual(music);

        assertTrue(result);
    }

    /**
     * Test of getTitle method, of class Music.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");

        String expResult = "Let There Be Love.mp3";
        String result = instance.getTitle();

        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class Music.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");

        String title = "Let There Be Love";
        instance.setTitle(title);

        String expResult = title;
        String result = instance.getTitle();

        assertEquals(expResult, result);
    }

    /**
     * Test of getPath method, of class Music.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");

        String expResult = "C:\\Users\\Edivania\\Desktop\\MUSICAS\\Let There Be Love.mp3";
        String result = instance.getPath();

        assertEquals(expResult, result);
    }

    /**
     * Test of setPath method, of class Music.
     */
    @Test
    public void testSetPath() {
        System.out.println("setPath");
        String path = "C:\\Let There Be Love.mp3";
        instance.setPath(path);

        String expResult = path;
        String result = instance.getPath();

        assertEquals(expResult, result);
    }

}
