package mp.model;

/**
 *
 * @author Edivania
 */
public abstract class Usuario {
    private String nome;
    private String usuario;
    private String senha;
    private String tipo; //! comum ou vip

    /* USER DEFAULT*/
    public Usuario() {
        nome = "VIP Default";
        usuario = "admin";
        senha = "gemvip";
        tipo = "VIP";
    }
    
    public Usuario(String nome, String usuario, String senha, String tipo) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
