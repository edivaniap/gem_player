package mp.model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes da Classe VIPUser
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 29 de junho de 2018
 */
public class VIPUserTest {

    VIPUser instance;

    public VIPUserTest() {
        instance = new VIPUser("Random Guy", "random", "some321pass");
    }

    /**
     * Test of setPlaylists method, of class VIPUser.
     */
    @Test (expected = NullPointerException.class)
    public void testSetPlaylists() {
        System.out.println("setPlaylists");
        ArrayList<Playlist> playlists = null;

        Playlist p1 = new Playlist("love songs");
        Playlist p2 = new Playlist("pop hits");

        playlists.add(p1);
        playlists.add(p2);
        instance.setPlaylists(playlists);

        assertEquals(playlists, instance.getPlaylists());
    }

    /**
     * Test of getPlaylists method, of class VIPUser.
     */
    @Test
    public void testGetPlaylists() {
        System.out.println("getPlaylists");
        
        Playlist p1 = new Playlist("love songs");
        Playlist p2 = new Playlist("pop hits");

        instance.getPlaylists().add(p1);
        instance.getPlaylists().add(p2);

        assertEquals(2, instance.getPlaylists().size());
        assertEquals("love songs", instance.getPlaylists().get(0).getTitle());
        assertEquals("pop hits", instance.getPlaylists().get(1).getTitle());
    }

    /**
     * Test of getType method, of class VIPUser.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");

        String expResult = "VIP";
        String result = instance.getType();

        assertEquals(expResult, result);
    }

}
