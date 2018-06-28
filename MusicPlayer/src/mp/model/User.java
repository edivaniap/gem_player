package mp.model;

/**
 * Representa um Usuário do player
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 18 de junho de 2018
 */
public abstract class User {

    private String name = null;
    private String username = null;
    private String password = null;
    private String type = null; //! comum ou vip

    /* USER DEFAULT*/
    /**
     * Cria um usuário padrão vip
     * @
     */
    public User() {
        name = "VIP Default";
        username = "admin";
        password = "gemvip";
        type = "VIP";
    }

    /**
     * Cria um usuário com atributos específicos
     *
     * @param name O nome do usuário
     * @param username O pseudonome que o usuário usará para se autenticar
     * @param password A senha que o usuário usará para se autenticar
     * @param type O tipo do usuário que está sendo criado (VIP ou Comum)
     */
    public User(String name, String username, String password, String type) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    /**
     * Recupera o nome do usuário
     *
     * @return O nome do usuário
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o nome do usuário
     *
     * @param name O novo nome do usuário
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Recupera o pseudonome do usuário
     *
     * @return O pseudonome do usuário
     */
    public String getUsername() {
        return username;
    }

    /**
     * Modifica o pseudonome do usuário
     *
     * @param username O novo pseudonome do usuário
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Recupera a senha do usuário
     *
     * @return A senha do usuário
     */
    public String getPassword() {
        return password;
    }

    /**
     * Modifica a senha do usuário
     *
     * @param password A nova senha do usuário
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Recupera o tipo do usuário
     *
     * @return O tipo do usuário
     */
    public String getType() {
        return type;
    }

    /**
     * Modifica o tipo do usuário
     *
     * @param type O tipo do usuário
     */
    public void setType(String type) {
        this.type = type;
    }
}
