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
 * Representa dados de uma musica
 * 
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 20 de junho de 2018
 */


public class MusicaDAO {

    private File file = null;
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;
    FileWriter fileWriter = null;
    BufferedWriter bufferedWriter = null;
    
    public MusicaDAO() {
        file = new File("data/musicas.txt");
    }

    /**
     * Insere uma música em um arquivo caso ainda não exista nele 
     * 
     * @param musica Musica a ser inserida
     */
    public void inserir(Music musica) {
        if (alreadyExist(musica)) {
            JOptionPane.showMessageDialog(null, musica.getTitle() + "\n\nMusica já está adicionada no player", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                fileWriter = new FileWriter(file, true); 
                bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(musica.getTitle() + ";" + musica.getPath());

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
     * 
     * 
     * @return Lista com as musicas 
     */
    public ArrayList<Music> listar() {
        
        ArrayList<Music> musicas = new ArrayList<Music>();
        Music musica;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine(); 
                musica = new Music(null, null);

                String fields[] = line.split(";"); 

                musica.setTitle(fields[0]);
                musica.setPath(fields[1]);

                musicas.add(musica);
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

        return musicas;
    }

    /**
     * Verifica se a musica já existe na lista
     * 
     * @param musicKey Musica que será verificada/
     * @return Falso se a musica não existir e verdadeiro caso contrário
     */
    public boolean alreadyExist(Music musicKey) {
        ArrayList<Music> currentMusics = this.listar();

        for (Music musica : currentMusics) {
            if (musica.isEqual(musicKey)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Remove uma musica da lista
     * 
     * @param lineToRemove Indica a linha a ser removida 
     */
    public void remove(int lineToRemove) {
        ArrayList<Music> currentMusics = this.listar();
        this.clear();

        try {
            currentMusics.remove(lineToRemove - 1);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        }

        for (Music musica : currentMusics) {
            this.inserir(musica);
        }
    }

    /**
     *  
     * 
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
    
    public File getFile() {
        return file;
    }

    
    public static void main(String[] args) {
        MusicaDAO mdao = new MusicaDAO();
        //System.out.println(mdao.getFile().getPath());
        //System.out.println(mdao.getFile().getAbsolutePath());
        //mdao.clear(); //OK
        //mdao.remove(40); //OK
    }
}
