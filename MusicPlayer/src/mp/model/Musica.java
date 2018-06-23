
package mp.model;

/**
 *
 * @author Edivania Pontes
 */
public class Musica {
    private String nome;
    private String caminho;

    public Musica(String nome, String caminho) {
        this.nome = nome;
        this.caminho = caminho;
    }
    
    public boolean isEqual(Musica musica) {
        return (nome.equals(musica.getNome()) && caminho.equals(musica.getCaminho()));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
}
