
package mp.interfaces;

import java.util.ArrayList;
import mp.model.Usuario;

/**
 *
 * @author Edivania
 */
public interface CRUDInterface {
    
    public void insert(Usuario user);
    
    public void edit(Usuario newUser, String currentUserKey);
    
    public ArrayList<Usuario> list();
    
    public boolean alreadyExist(String userKey);
    
    public void delete(int lineToRemove);
}
