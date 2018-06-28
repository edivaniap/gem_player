package mp.model;

/**
 * Representa um Usuário Comum do player
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 20 de junho de 2018
 */
public class CommonUser extends User {

    /**
     * Cria um usuário comum com atributos específicos
     *
     * @param name O nome do usuário
     * @param username O pseudonome que o usuário usará para se autenticar
     * @param password A senha que o usuário usará para se autenticar
     */
    public CommonUser(String name, String username, String password) {
        super(name, username, password, "Comum");
    }
}
