package mp.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mp.model.Musica;

/**
 *
 * @author Edivania
 */
public class MusicaDAO {

    private File file;

    public void inserir(Musica musica) {
        if (alreadyExist(musica)) {
            JOptionPane.showMessageDialog(null, "Musica já está adicionada no player", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                file = new File("data/musicas.txt");

                FileWriter fw = new FileWriter(file, true); //segundo parametro indica que o conteúdo sera acrescentado e nao substituido
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write(musica.getNome() + ";" + musica.getCaminho());

                bw.newLine(); //quebra de linha    

                bw.close();
                fw.close();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public ArrayList<Musica> listar() {
        ArrayList<Musica> musicas = new ArrayList<Musica>();
        Musica musica;

        try {
            file = new File("data/musicas.txt");

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            //enquanto houver linhas...
            while (br.ready()) {
                String line = br.readLine(); //le proxima linha
                musica = new Musica(null, null);

                String fields[] = line.split(";"); //preenche vetor com valores separados por ;

                musica.setNome(fields[0]);
                musica.setCaminho(fields[1]);

                musicas.add(musica);
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }

        return musicas;
    }

    public boolean alreadyExist(Musica musica) {
        ArrayList<Musica> musicas = this.listar();

        for (Musica m : musicas) {
            if (musica.getNome().equals(m.getNome()) && musica.getCaminho().equals(m.getCaminho())) {
                return true;
            }
        }

        return false;
    }
}
