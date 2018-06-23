package mp.model;

/**
 *
 * @author Anne
 */
public class Playlist {
    
    private String nome;

    public Playlist(String nome) {
        this.nome = nome;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
