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
 * Classe de acesso e persitência dos dados de Playlists
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

    /**
     * Cria uma playlist vinculada a um usuário
     *
     * @param playlist A playlist a ser criada
     * @param ownersUsername Identifica o usuário que criou a playlist
     */
    public void criar(Playlist playlist, String ownersUsername) {
        file = new File("data/" + "playlist_" + ownersUsername + "_" + playlist.getTitle() + ".txt");

        if (!file.exists()) {
            try {
                boolean createNewFile = file.createNewFile();

                filePlaylists = new File("data/playlists.txt");

                try (FileWriter fw = new FileWriter(filePlaylists, true); BufferedWriter bw = new BufferedWriter(fw)) {
                    
                    bw.write(ownersUsername + ";" + playlist.getTitle());
                    
                    bw.newLine();
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Playlist já inserida");
        }
    }

    /**
     * Adiciona uma música no arquivo de uma playlist específica
     *
     * @param playlist A playlist que vai receber a música
     * @param ownersUsername Identifica o usuário dono da playlist
     */
    public void addMusic(Playlist playlist, String ownersUsername) {
        if (this.alreadyExist(ownersUsername, playlist.getTitle(), playlist.getMusics().get(0).getTitle())) {
            JOptionPane.showMessageDialog(null, playlist.getMusics().get(0).getTitle() + "\n\nMusica já está adicionada nesta playlist", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String path = "data/" + "playlist_" + ownersUsername + "_" + playlist.getTitle() + ".txt";

            try {
                file = new File(path);

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
     * Lista todas as playlists pertencentes a um usuário específico
     *
     * @param ownersUsername O usuário chave da busca de playlists
     * @return Lista com playlists criadas por usuário
     */
    public ArrayList<Playlist> listPlaylistsByUser(String ownersUsername) {
        ArrayList<Playlist> playlists = new ArrayList<>();
        Playlist usersPlaylist = null;

        try {
            filePlaylists = new File("data/playlists.txt");
            fileReader = new FileReader(filePlaylists);
            bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();

                String fields[] = line.split(";");

                if (ownersUsername.equals(fields[0])) {
                    usersPlaylist = new Playlist(fields[1]);
                }

                playlists.add(usersPlaylist);
            }

            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("[PlaylistDAO - listar()]: FileNotFoundException - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("[PlaylistDAO - listar()]: IOException - " + e.getMessage());
        }

        return playlists;
    }

    /**
     * Lista todas as músicas referentes a uma playlist de um usuário específico
     *
     * @param ownersUsername O usuário chave da busca
     * @param playlistName O nome da playlist chave da busca
     * @return Lista com as músicas da playlist buscada
     */
    public ArrayList<Music> listMusicsByPlaylist(String ownersUsername, String playlistName) {
        ArrayList<Music> musics = new ArrayList<>();

        try {
            String path = "data/" + "playlist_" + ownersUsername + "_" + playlistName + ".txt";
            file = new File(path);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();

                String fields[] = line.split(";");

                Music music = new Music(fields[0], fields[1]);
                musics.add(music);
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

        return musics;
    }

    /**
     * Verifica se uma música já existe na playlist de um usuário
     *
     * @param ownersUsername O usuário dono da playlist criada
     * @param playlistName Nome da playlist buscada
     * @param musicKey Música que será verificada a existência
     * @return false se a música não existir e true caso contrário
     */
    public boolean alreadyExist(String ownersUsername, String playlistName, String musicKey) {
        ArrayList<Music> currentMusics = this.listMusicsByPlaylist(ownersUsername, playlistName);

        return currentMusics.stream().anyMatch((music) -> (music.getTitle().equals(musicKey)));
    }

    /**
     * Recupera o arquivo de playlists
     *
     * @return Arquivo de playlists
     */
    public File getFile() {
        return file;
    }
}
