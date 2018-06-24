/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.model;

import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class UsuarioVIP extends Usuario {
    ArrayList<Playlist> playlists;

    /* USER DEFAULT*/
    public UsuarioVIP() {
        super();
        playlists = new ArrayList<>();
    }

    public UsuarioVIP(String nome, String usuario, String senha, String tipo) {
        super(nome, usuario, senha, tipo);
        playlists = new ArrayList<>();
    }
    
    
    
}
