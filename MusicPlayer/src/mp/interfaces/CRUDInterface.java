
package mp.interfaces;

import java.util.ArrayList;
import mp.model.Usuario;

/**
 *
 * @author Edivania
 */
public interface CRUDInterface {
    
    public void inserir(Usuario usuario);
    
    public ArrayList<Usuario> listar();
    
    public boolean alreadyExist(String userKey);
    
    public void remove(int lineToRemove);
}
