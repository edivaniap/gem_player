
import mp.view.JFLogin;

/**
 * Executa o Gem Music Player
 * 
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 29 de junho de 2018
 */
public class RunGem {

    /**
     * Método principal
     * 
     * @param args
     */
    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JFLogin().setVisible(true);
        });
    }
}
