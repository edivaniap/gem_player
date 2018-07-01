package mp.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes da Classe CommonUser
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 29 de junho de 2018
 */
public class CommonUserTest {

    CommonUser instance;

    public CommonUserTest() {
        instance = new CommonUser("Random Guy", "random", "some321pass");
    }

    /**
     * Test of getType method, of class CommonUser.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");

        String expResult = "Comum";
        String result = instance.getType();

        assertEquals(expResult, result);
    }
    
    //** OS OUTROS METODOS JA FORAM TESTADOS NO UserTest.java **//

}
