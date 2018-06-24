package mp.model;

/**
 *
 * @author Anne
 */
public class Playlist {
    
    private String nome;
    private String nomeMusica;
    private String caminhoMusica;
    
     
    public Playlist(String nome) {
        this.nome = nome;
    }

    //public Playlist(String selectedValue, String item) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      //  this.selectedValue = selectedValue;
        
    
    //}
    
    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public String getCaminhoMusica() {
        return caminhoMusica;
    }

    public void setCaminhoMusica(String caminhoMusica) {
        this.caminhoMusica = caminhoMusica;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
