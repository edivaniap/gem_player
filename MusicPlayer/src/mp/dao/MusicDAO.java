package mp.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mp.model.Music;

/**
 * Classe de acesso e persitência dos dados de Música
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 20 de junho de 2018
 */
public class MusicDAO {

    private File file = null;
    private FileReader fileReader = null;
    private BufferedReader bufferedReader = null;
    private FileWriter fileWriter = null;
    private BufferedWriter bufferedWriter = null;

    public MusicDAO() {
        file = new File("data/musicas.txt");
    }

    /**
     * Insere uma música no arquivo de texto separando seus atributos por ";"
     * Caso a música já exista no arquivo, apenas mostra um aviso
     *
     * @param music Música a ser inserida
     */
    public void insert(Music music) {
        if (alreadyExist(music)) {
            JOptionPane.showMessageDialog(null, music.getTitle() + "\n\nMusica já está adicionada no player", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                fileWriter = new FileWriter(file, true);
                bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(music.getTitle() + ";" + music.getPath());

                bufferedWriter.newLine();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "[MusicaDAO - inserir()]: " + e.getMessage(), "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "[MusicaDAO - inserir()]: " + e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "[MusicaDAO - inserir()]: " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "[MusicaDAO - inserir()]: Erro ao finalizar; " + e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * Percorre o arquivo de músicas, dividindo seus atributos que estão entre
     * ";" e carregando um arranjo de música
     *
     * @return Lista com as músicas
     */
    public ArrayList<Music> list() {

        ArrayList<Music> musics = new ArrayList<>();
        Music music;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                music = new Music(null, null);

                String fields[] = line.split(";");

                music.setTitle(fields[0]);
                music.setPath(fields[1]);

                musics.add(music);
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "[MusicaDAO - listar()]: " + e.getMessage(), "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "[MusicaDAO - listar()]: " + e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "[MusicaDAO - listar()]: " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "[MusicaDAO - listar()]: Erro ao finalizar; " + e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
            }
        }

        return musics;
    }

    /**
     * Verifica se a música já existe no arquivo
     *
     * @param musicKey Música que será verificada
     * @return false se a música não existir e true caso contrário
     */
    public boolean alreadyExist(Music musicKey) {
        ArrayList<Music> currentMusics = this.list();

        for (Music music : currentMusics) {
            if (music.isEqual(musicKey)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Remove uma música do arquivo apagando a linha que contém seus dados
     *
     * @param lineToRemove Indica a linha a ser removida
     */
    public void remove(int lineToRemove) {
        ArrayList<Music> currentMusics = this.list();
        this.clear();

        try {
            currentMusics.remove(lineToRemove - 1);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        }

        for (Music music : currentMusics) {
            this.insert(music);
        }
    }

    /**
     * Limpa o arquivo com os dados das músicas apagando todo texto
     */
    public void clear() {
        try {
            Writer out = new FileWriter(file.getPath());
            System.out.println(file.getPath());

            out.write("");
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "[MusicaDAO - clear()]: " + e.getMessage(), "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "[MusicaDAO - clear()]: " + e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "[MusicaDAO - clear()]: " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Recupera o arquivo de músicas
     *
     * @return Arquivo de músicas
     */
    public File getFile() {
        return file;
    }
}
