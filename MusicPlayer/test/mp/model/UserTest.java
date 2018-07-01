package mp.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes da Classe User
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 29 de junho de 2018
 */
public class UserTest {

    User instance;

    public UserTest() {
        instance = new UserAux("Random Guy", "random", "some321pass", "VIP");
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");

        String expResult = "Random Guy";
        String result = instance.getName();

        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");

        String name = "Junior";
        instance.setName(name);

        String expResult = name;
        String result = instance.getName();

        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");

        String expResult = "random";
        String result = instance.getUsername();

        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");

        String username = "jrrr";
        instance.setUsername(username);

        String expResult = username;
        String result = instance.getUsername();

        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");

        String expResult = "some321pass";
        String result = instance.getPassword();

        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");

        String password = "new567pass";
        instance.setPassword(password);

        String expResult = password;
        String result = instance.getPassword();

        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class User.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");

        String expResult = "VIP";
        String result = instance.getType();

        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class User.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "Comum";
        instance.setType(type);

        String expResult = type;
        String result = instance.getType();

        assertEquals(expResult, result);
    }

    /**
     * Classe filha de User para auxiliar a construção de objeto do tipo User,
     * já que User é uma classe abstrata.
     */
    public class UserAux extends User {

        public UserAux(String name, String username, String password, String type) {
            super(name, username, password, type);
        }
    }

}
