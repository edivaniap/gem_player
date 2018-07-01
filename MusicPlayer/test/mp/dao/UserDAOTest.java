package mp.dao;

import mp.model.CommonUser;
import mp.model.User;
import mp.model.VIPUser;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes da Classe UserDAO
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 30 de junho de 2018
 */
public class UserDAOTest {

    UserDAO instance;

    public UserDAOTest() {
        instance = new UserDAO();
    }

    /**
     * Test of authenticate method, of class UserDAO.
     */
    @Test
    public void testAuthenticate() {
        System.out.println("authenticate");

        String name = "Kelly Lourenço";
        String username = "kelly";
        String password = "8908";

        User user = new VIPUser(name, username, password);

        instance.insert(user);

        User result = instance.authenticate(username, password);
        assertEquals(user.getName(), result.getName());
        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getType(), result.getType());

        instance.clear();
    }

    /**
     * Test of insert method, of class UserDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");

        String name = "Kelly Lourenço";
        String username = "kelly";
        String password = "8908";

        User user = new VIPUser(name, username, password);

        instance.insert(user);

        User result = instance.list().get(0);

        assertEquals(user.getName(), result.getName());
        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getType(), result.getType());

        instance.clear();
    }

    /**
     * Test of list method, of class UserDAO.
     */
    @Test
    public void testList() {
        System.out.println("list");

        User user1 = new VIPUser("Ana", "ana", "123");
        User user2 = new CommonUser("José", "zé", "321");

        instance.insert(user1);
        instance.insert(user2);

        assertEquals(2, instance.list().size());
        assertEquals(user1.getName(), instance.list().get(0).getName());
        assertEquals(user2.getPassword(), instance.list().get(1).getPassword());

        instance.clear();
    }

    /**
     * Test of delete method, of class UserDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        
        User user = new CommonUser("José", "zé", "321");
        instance.insert(user);
        
        assertEquals(1, instance.list().size());
        
        int lineToRemove = 0;        
        instance.delete(lineToRemove);         
        
        assertEquals(0, instance.list().size());

        instance.clear();
    }

    /**
     * Test of alreadyExist method, of class UserDAO.
     */
    @Test
    public void testAlreadyExist() {
        System.out.println("alreadyExist");

        User user = new CommonUser("José", "zé", "321");
        instance.insert(user);
        
        boolean result = instance.alreadyExist(user.getUsername());

        assertTrue(result);

        instance.clear();
    }

    /**
     * Test of getPassword method, of class UserDAO.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");

        User user = new VIPUser("Amora", "amora", "zkiw");

        instance.insert(user);

        String expResult = user.getPassword();
        String result = instance.getPassword(user.getUsername());
        assertEquals(expResult, result);

        instance.clear();
    }

    /**
     * Test of clear method, of class UserDAO.
     */
    @Test
    public void testClear() {
        System.out.println("clear");

        instance.clear();

        assertEquals(0, instance.list().size());
    }

}
