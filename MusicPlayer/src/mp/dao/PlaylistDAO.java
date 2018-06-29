package mp.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mp.model.Music;
import mp.model.Playlist;

/**
 * Representa dados de uma playlist
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 23 de junho de 2018
 */
public class PlaylistDAO {

    private File file = null;
    private File filePlaylists = null;
    private FileReader fileReader = null;
    private BufferedReader bufferedReader = null;
    private FileWriter fileWriter = null;
    private BufferedWriter bufferedWriter = null;

    
    public PlaylistDAO() {
    }

    /**
     * Cria uma playlist vinculada a um usuario
     * 
     * @param playlist Uma playlist 
     * @param usuario_criador Identifica o usuario que criou a playlist
     * @return 
     */
    public Playlist criar(Playlist playlist, String usuario_criador) {

        file = new File("data/" + "playlist_" + usuario_criador + "_" + playlist.getTitle() + ".txt");

        if (!file.exists()) {
            try {
                file.createNewFile();

                filePlaylists = new File("data/playlists.txt");
               
                FileWriter fw = new FileWriter(filePlaylists, true); 
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write(usuario_criador + ";" + playlist.getTitle());

                bw.newLine();    

                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Playlist já inserida");
        }

        return null;
    }

    /**
     * Adiciona uma musica na playlist selecionada
     * 
     * @param playlist Uma playlist
     * @param usuario_criador Identifica o usuario que criou a playlist
     */
    
    public void adicionarMusica(Playlist playlist, String usuario_criador) {
        if (this.jaExisteEstaMusica(usuario_criador, playlist.getTitle(), playlist.getMusics().get(0).getTitle())) {
            JOptionPane.showMessageDialog(null, playlist.getMusics().get(0).getTitle() + "\n\nMusica já está adicionada nesta playlist", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String caminho = "data/" + "playlist_" + usuario_criador + "_" + playlist.getTitle() + ".txt";

            try {
                file = new File(caminho);

                fileWriter = new FileWriter(file, true);
                bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(playlist.getMusics().get(0).getTitle() + ";" + playlist.getMusics().get(0).getPath());

                bufferedWriter.newLine();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "[PlaylistDAO - adicionarMusica()]: " + e.getMessage(), "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "[PlaylistDAO - adicionarMusica()]: " + e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "[PlaylistDAO - adicionarMusica()]: " + e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, " Erro ao finalizar " + e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * Lista todas as playlists referentes ao usuario 
     * 
     * @param usuario_criador Identifica o usuario que criou a playlist
     * @return Lista com playlist criada por usuario 
     */
    
    public ArrayList<Playlist> listarPlaylistPorUsuario(String usuario_criador) {
        ArrayList<Playlist> playlists = new ArrayList<>();
        Playlist playlistDoUsuario = null;

        try {
            filePlaylists = new File("data/playlists.txt");
            fileReader = new FileReader(filePlaylists);
            bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine(); 

                String fields[] = line.split(";"); 

                if (usuario_criador.equals(fields[0])) {
                    playlistDoUsuario = new Playlist(fields[1]);
                }

                playlists.add(playlistDoUsuario);
            }

            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("[PlaylistDAO - listar()]: FileNotFoundException - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("[PlaylistDAO - listar()]: IOException - " + e.getMessage());
        }

        //apos ler os nomes das playlists do usuario, carregar musicas
//        for (Playlist p : playlists) {
//            ArrayList<Musica> musicas = listarMusicasPorPL(usuario_criador, p.getNome());
//            p.setMusicas(musicas);
//        }

        return playlists;
    }

    /**
     * Lista todas as musicas referentes á uma playlist
     * 
     * @param usuario_criador Identifica o usuario que criou a playlist
     * @param nome_pl Nome da playlist
     * @return Lista com as musicas da playlist
     */
    public ArrayList<Music> listarMusicasPorPL(String usuario_criador, String nome_pl) {
        ArrayList<Music> musicas = new ArrayList<>();
        
        try {
            String caminho = "data/" + "playlist_" + usuario_criador + "_" + nome_pl + ".txt";
            file = new File(caminho);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine(); 

                String fields[] = line.split(";"); 

                Music musica = new Music(fields[0], fields[1]);
                musicas.add(musica);
            }

            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("[PlaylistDAO - listar()]: FileNotFoundException - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("[PlaylistDAO - listar()]: IOException - " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("[PlaylistDAO - listar()]: NullPointerException - " + e.getMessage());
        }

        return musicas;
    }

    /**
     * Verifica se uma musica já existe na playlist
     * 
     * @param usuario_criador Identifica o usuario que criou a playlist
     * @param nomePlaylist Nome da playlist 
     * @param musicaKey Musica que será verificada
     * @return Falso se a musica não existir e verdadeiro caso contrário
     */
  
    public boolean jaExisteEstaMusica(String usuario_criador, String nomePlaylist, String musicaKey) {
        ArrayList<Music> currentMusics = this.listarMusicasPorPL(usuario_criador, nomePlaylist);

        for (Music m : currentMusics) {
            if (m.getTitle().equals(musicaKey)) {
                return true;
            }
        }
        return false;
    }

    public File getFile() {
        return file;
    }
}
