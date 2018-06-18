package mp.model;

/**
 *
 * @author Edivania
 */
public class Usuario {
    private int codigo;
    private String nome;
    private String usuario;
    private String senha;
    private String tipo; //! comum ou vip

    public Usuario() {
        codigo = 0;
        nome = "VIP Default";
        usuario = "admin";
        senha = "gemvip";
        tipo = "vip";
    }
    
    public Usuario(int codigo, String nome, String usuario, String senha, String tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
