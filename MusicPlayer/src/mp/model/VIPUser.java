package mp.model;

import java.util.ArrayList;

/**
 * Representa um Usuário VIP do player
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 20 de junho de 2018
 */
public class VIPUser extends User {

    ArrayList<Playlist> playlists;

    /* USER DEFAULT*/
    /**
     * Cria um usuário padrão vip e inicializa a playlist
     *
     * @
     */
    public VIPUser() {
        super();
        playlists = new ArrayList<>();
    }

    /**
     * Cria um usuário vip com atributos específicos e inicializa a playlist
     *
     * @param name O nome do usuário
     * @param username O pseudonome que o usuário usará para se autenticar
     * @param password A senha que o usuário usará para se autenticar
     */
    public VIPUser(String name, String username, String password) {
        super(name, username, password, "VIP");
        playlists = new ArrayList<>();
    }

    /**
     * Modifica a playlist do usuário vip
     *
     * @param playlists A nova playlist
     */
    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    /**
     * Recupera a playlist do usuário vip
     *
     * @return O atual arranjo de playlists do usuário
     */
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }
}
