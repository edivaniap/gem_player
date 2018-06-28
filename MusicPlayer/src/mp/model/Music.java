package mp.model;

/**
 * Representa uma Música
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 20 de junho de 2018
 */
public class Music {

    private String title = null;
    private String path = null;

    /**
     * Cria uma música com título e caminho específicos
     *
     * @param title O titulo da musica
     * @param path O caminho onde a música está salva no computador
     */
    public Music(String title, String path) {
        this.title = title;
        this.path = path;
    }

    /**
     * Verifica se duas a música é igual a música passada por parâmetro
     *
     * @return true se as músicas são iguais, false caso contrário
     */
    public boolean isEqual(Music music) {
        return (title.equals(music.getTitle()) && path.equals(music.getPath()));
    }

    /**
     * Recupera o título da música
     *
     * @return O atual título da música
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o título da música
     *
     * @param title O título da música
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Recupera o caminho da música
     *
     * @return O atual caminho da música
     */
    public String getPath() {
        return path;
    }

    /**
     * Modifica o caminho da música
     *
     * @param path O caminho da música
     */
    public void setPath(String path) {
        this.path = path;
    }
}
