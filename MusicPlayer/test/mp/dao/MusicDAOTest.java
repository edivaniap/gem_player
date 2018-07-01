package mp.dao;

import java.io.File;
import java.util.ArrayList;
import mp.model.Music;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes da Classe MusicDAO
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 30 de junho de 2018
 */
public class MusicDAOTest {
    
    MusicDAO instance;
    
    public MusicDAOTest() {
        instance = new MusicDAO();
    }
    
    /**
     * Test of insert method, of class MusicDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Music music = new  Music("musica", "C:\\musica.pm3");        
        instance.insert(music);        
    }

    /**
     * Test of list method, of class MusicDAO.
     */
    @Test
    public void testList() {
        System.out.println("list");
        Music music = new  Music("musica", "C:\\musica.mp3");   
        ArrayList<Music> expResult = new ArrayList<>();
        expResult.add(music);
        instance.insert(music);
        ArrayList<Music> result = instance.list();
        
        assertEquals(expResult.get(0).getTitle(), result.get(0).getTitle());
        assertEquals(expResult.get(0).getPath(), result.get(0).getPath());
    }

    /**
     * Test of alreadyExist method, of class MusicDAO.
     */
    @Test
    public void testAlreadyExist() {
        System.out.println("alreadyExist");
        
        Music musicKey = new  Music("musica", "C:\\musica.mp3");  
        instance.insert(musicKey);  
        
        boolean result = instance.alreadyExist(musicKey);
        
        assertTrue(result);
    }

    /**
     * Test of remove method, of class MusicDAO.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        
        int lineToRemove = 1;
        instance.remove(lineToRemove);
        
        assertEquals(1, instance.list().size());
    }

    /**
     * Test of clear method, of class MusicDAO.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        
        instance.clear();
        
        assertEquals(0, instance.list().size());
    }

    /**
     * Test of getFile method, of class MusicDAO.
     */
    @Test
    public void testGetFile() {
        System.out.println("getFile");
        File expResult = new File("data/musicas.txt");
        File result = instance.getFile();
        assertEquals(expResult, result);
    }
    
}
