
package mp.interfaces;

import java.util.ArrayList;
import mp.model.User;

/**
 *
 * @author Edivania
 */
public interface CRUDInterface {
    
    public void insert(User user);
    
    public void edit(User newUser, String currentUserKey);
    
    public ArrayList<User> list();
    
    public boolean alreadyExist(String userKey);
    
    public void delete(int lineToRemove);
}
