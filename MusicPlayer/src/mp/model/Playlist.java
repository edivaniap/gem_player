package mp.model;

import java.util.ArrayList;

/**
 *
 * @author Anne
 */
public class Playlist {
    
    private String nome;
    private ArrayList<Musica> musicas;
    
     
    public Playlist(String nome) {
        this.nome = nome;
        musicas = new ArrayList<>();
    }    
    
    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(ArrayList<Musica> musicas) {
        this.musicas = musicas;
    }

    public void addMusica(Musica musica) {
        musicas.add(musica);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
