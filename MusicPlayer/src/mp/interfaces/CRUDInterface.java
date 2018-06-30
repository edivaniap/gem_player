
package mp.interfaces;

import java.util.ArrayList;
import mp.model.User;

/**
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 20 de junho de 2018
 */
public interface CRUDInterface {
    
    /**
     *
     * @param user
     */
    public void insert(User user);
    
    /**
     *
     * @param newUser
     * @param currentUserKey
     */
    public void edit(User newUser, String currentUserKey);
    
    /**
     *
     * @return
     */
    public ArrayList<User> list();
    
    /**
     *
     * @param userKey
     * @return
     */
    public boolean alreadyExist(String userKey);
    
    /**
     *
     * @param lineToRemove
     */
    public void delete(int lineToRemove);
}
