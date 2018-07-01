package mp.view;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import mp.dao.MusicDAO;
import mp.model.Music;
import mp.model.VIPUser;
import mp.sound.MediaPlayer;
import mp.dao.PlaylistDAO;
import mp.model.Playlist;

/**
 * Tela de um usuário VIP autenticado
 *
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 18 de junho de 2018
 */
public class JFVIPPlayer extends javax.swing.JFrame {

    private DefaultListModel<String> listModel;

    private DefaultListModel listMP = new DefaultListModel();

    private MediaPlayer mediaplayer = null;
    private String strPath = null;
    private String strName = null;
    private String strPlaylist = null;
    private MusicDAO musicDAO = null;
    private PlaylistDAO playlistDAO = null;

    private VIPUser userLoggedIn = null;

    /**
     * Creates new form JFPlayer
     * @throws java.io.IOException
     */
    public JFVIPPlayer() throws IOException {

        initComponents();
        setImage();
        loadMusicsOnJlist();
        musicDAO = new MusicDAO();
        playlistDAO = new PlaylistDAO();
        autoCompleteSearch();
    }

    /**
     * Creates new form JFVIPPlayer
     *
     * @param user Usuário VIP autenticado
     * @throws java.io.IOException
     */
    public JFVIPPlayer(VIPUser user) throws IOException {
        initComponents();
        setImage();
        pesquisar.addItem("");
        autoCompleteSearch();

        pesquisar.setVisible(true);

        JTextField text = (JTextField) pesquisar.getEditor().getEditorComponent();
        text.addKeyListener(new ComboKeyHandler(pesquisar));

        loadMusicsOnJlist();
        musicDAO = new MusicDAO();
        playlistDAO = new PlaylistDAO();
        userLoggedIn = user;
        loadPlaylistsOnJlist();
        jLabelUserLogado.setText(userLoggedIn.getName() + " | " + userLoggedIn.getType());
    }

    private void autoCompleteSearch() {
        try {

            FileReader fr = new FileReader("data/musicas.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp;

            while ((temp = br.readLine()) != null) {
                String[] t = temp.split(";");
                temp = t[0];
                pesquisar.addItem(temp);
            }
        } catch (FileNotFoundException el) {
            System.out.println("Arquivo não Encontrado!");
        } catch (IOException e) {
        }
    }

    private void removeSearch() {

        try {

            FileReader fr = new FileReader("data/musicas.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp;

            while ((temp = br.readLine()) != null) {
                String[] t = temp.split(";");
                temp = t[0];
                pesquisar.removeItem(temp);
            }
        } catch (FileNotFoundException el) {
            System.out.println("Arquivo não Encontrado!");
        } catch (IOException e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanelCentral = new javax.swing.JPanel();
        jLabelPlay = new javax.swing.JLabel();
        jPanelLeft = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelPlaylists = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListPlaylists = new javax.swing.JList<>();
        jButtonAddPlaylist = new javax.swing.JButton();
        jButtonUsuarios = new javax.swing.JButton();
        jLabelUserLogado = new javax.swing.JLabel();
        jLabelBack = new javax.swing.JLabel();
        jLabelStop = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabelPlaylistSelecionada = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListMusicsOfPlaylist = new javax.swing.JList<>();
        jButtonAddMusicaPlaylist = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListMusics = new javax.swing.JList<>();
        jLabelMusicas = new javax.swing.JLabel();
        jButtonRemover = new javax.swing.JButton();
        jButtonAddDiretorio = new javax.swing.JButton();
        jButtonAddMusica = new javax.swing.JButton();
        jLabelNext2 = new javax.swing.JLabel();
        pesquisar = new javax.swing.JComboBox<>();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gem Music Player");
        setBackground(new java.awt.Color(102, 102, 102));
        setFont(new java.awt.Font("Arial Narrow", 0, 10)); // NOI18N
        setResizable(false);

        jPanelCentral.setBackground(new java.awt.Color(102, 153, 0));

        jLabelPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp/view/icons/if_play.png"))); // NOI18N
        jLabelPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPlayMouseClicked(evt);
            }
        });

        jPanelLeft.setBackground(new java.awt.Color(51, 51, 51));
        jPanelLeft.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp/view/icons/if_gem_big.png"))); // NOI18N

        jLabelPlaylists.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabelPlaylists.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPlaylists.setText("Playlists");

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 51));

        jListPlaylists.setBackground(new java.awt.Color(51, 51, 51));
        jListPlaylists.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jListPlaylists.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jListPlaylists.setForeground(new java.awt.Color(255, 255, 255));
        jListPlaylists.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListPlaylistsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListPlaylists);

        jButtonAddPlaylist.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAddPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp/view/icons/if_plus.png"))); // NOI18N
        jButtonAddPlaylist.setToolTipText("Adicionar nova playlist");
        jButtonAddPlaylist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAddPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPlaylistActionPerformed(evt);
            }
        });

        jButtonUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jButtonUsuarios.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButtonUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp/view/icons/if_cloud_users.png"))); // NOI18N
        jButtonUsuarios.setText("Usuários");
        jButtonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuariosActionPerformed(evt);
            }
        });

        jLabelUserLogado.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabelUserLogado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUserLogado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp/view/icons/if_turn_off.png"))); // NOI18N
        jLabelUserLogado.setText("Usuario");
        jLabelUserLogado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelUserLogado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelUserLogadoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelLeftLayout = new javax.swing.GroupLayout(jPanelLeft);
        jPanelLeft.setLayout(jPanelLeftLayout);
        jPanelLeftLayout.setHorizontalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLeftLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelLogo)
                .addGap(87, 87, 87))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLeftLayout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelUserLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonAddPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPlaylists, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButtonUsuarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );
        jPanelLeftLayout.setVerticalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelLogo)
                .addGap(27, 27, 27)
                .addComponent(jLabelPlaylists)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddPlaylist)
                .addGap(43, 43, 43)
                .addComponent(jButtonUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabelUserLogado)
                .addGap(20, 20, 20))
        );

        jLabelBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp/view/icons/if_back.png"))); // NOI18N
        jLabelBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp/view/icons/if_stop.png"))); // NOI18N
        jLabelStop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStopMouseClicked(evt);
            }
        });

        jLabelPlaylistSelecionada.setBackground(new java.awt.Color(51, 0, 51));
        jLabelPlaylistSelecionada.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabelPlaylistSelecionada.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPlaylistSelecionada.setText("[ Playlist ]");

        jScrollPane3.setBackground(new java.awt.Color(0, 0, 51));

        jListMusicsOfPlaylist.setBackground(new java.awt.Color(102, 153, 0));
        jListMusicsOfPlaylist.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jListMusicsOfPlaylist.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jListMusicsOfPlaylist.setForeground(new java.awt.Color(255, 255, 255));
        jListMusicsOfPlaylist.setPreferredSize(new java.awt.Dimension(20, 40));
        jListMusicsOfPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListMusicsOfPlaylistMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListMusicsOfPlaylist);

        jButtonAddMusicaPlaylist.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAddMusicaPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp/view/icons/if_plus.png"))); // NOI18N
        jButtonAddMusicaPlaylist.setToolTipText("Adicionar música à playlist");
        jButtonAddMusicaPlaylist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAddMusicaPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddMusicaPlaylistActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 51));

        jListMusics.setBackground(new java.awt.Color(102, 153, 0));
        jListMusics.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jListMusics.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jListMusics.setForeground(new java.awt.Color(255, 255, 255));
        jListMusics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListMusicsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListMusics);

        jLabelMusicas.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabelMusicas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMusicas.setText("Músicas");

        jButtonRemover.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp/view/icons/if_minus.png"))); // NOI18N
        jButtonRemover.setToolTipText("Remover música selecionada");
        jButtonRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jButtonAddDiretorio.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAddDiretorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp/view/icons/if_add_folder.png"))); // NOI18N
        jButtonAddDiretorio.setToolTipText("Adicionar diretório de músicas");
        jButtonAddDiretorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAddDiretorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddDiretorioActionPerformed(evt);
            }
        });

        jButtonAddMusica.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAddMusica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp/view/icons/if_plus.png"))); // NOI18N
        jButtonAddMusica.setToolTipText("Adicionar nova música");
        jButtonAddMusica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAddMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddMusicaActionPerformed(evt);
            }
        });

        jLabelNext2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp/view/icons/if_next.png"))); // NOI18N
        jLabelNext2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        pesquisar.setEditable(true);

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addComponent(jPanelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCentralLayout.createSequentialGroup()
                        .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelCentralLayout.createSequentialGroup()
                                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonAddDiretorio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonAddMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelCentralLayout.createSequentialGroup()
                                        .addGap(78, 78, 78)
                                        .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pesquisar, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addGroup(jPanelCentralLayout.createSequentialGroup()
                                                .addComponent(jLabelMusicas)
                                                .addGap(0, 165, Short.MAX_VALUE)))))
                                .addGap(59, 59, 59)
                                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPlaylistSelecionada)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelCentralLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAddMusicaPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                                .addComponent(jLabelBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPlay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelStop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNext2)
                                .addGap(98, 98, 98))
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96))))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPlaylistSelecionada, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMusicas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRemover, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAddMusica, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAddDiretorio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAddMusicaPlaylist, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(71, 71, 71)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNext2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPlay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
            .addComponent(jPanelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    MediaPlayer music;

    private void jListMusicsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListMusicsMouseClicked

        if (evt.getClickCount() == 2) {
            String path = musicPath(jListMusics.getSelectedValue());
            String[] t = path.split(";");

            path = t[1];
            System.out.println(path);

            File musicaFile = new File(path);
            MediaPlayer music = new MediaPlayer(musicaFile);

            music.play();

        }
    }//GEN-LAST:event_jListMusicsMouseClicked

    private void jLabelPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPlayMouseClicked
        String caminho = musicPath(jListMusics.getSelectedValue());
        String[] t = caminho.split(";");

        caminho = t[1];
        System.out.println(caminho);

        File musicaFile = new File(caminho);
        music = new MediaPlayer(musicaFile);

        music.play();
    }//GEN-LAST:event_jLabelPlayMouseClicked

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        //o index vai indicar o numero da linha que deve ser exluida
        int index = jListMusics.getSelectedIndex();
        musicDAO.remove(index);
        System.out.println("index sel: " + index);
        loadMusicsOnJlist();
        removeSearch();
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonAddDiretorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddDiretorioActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        // restringe a amostra a diretorios apenas
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int resposta = fileChooser.showOpenDialog(null);

        if (resposta == JFileChooser.APPROVE_OPTION) {
            File diretorio = fileChooser.getSelectedFile();

            for (File arquivo : diretorio.listFiles()) {
                strName = arquivo.getName();

                //verificar se é arquivo .mp3
                String finalStr = strName.substring(strName.length() - 4, strName.length());

                if (finalStr.equals(".mp3")) {
                    strPath = (fileChooser.getSelectedFile().getAbsolutePath() + "\\" + strName);
                    Music musica = new Music(strName, strPath);
                    musicDAO.insert(musica);
                    pesquisar.addItem(strName);
                    JTextField text = (JTextField) pesquisar.getEditor().getEditorComponent();
                    text.addKeyListener(new ComboKeyHandler(pesquisar));

                }
            }

            loadMusicsOnJlist();
        }
    }//GEN-LAST:event_jButtonAddDiretorioActionPerformed

    private void jButtonAddMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddMusicaActionPerformed

        JFileChooser open = new JFileChooser();
        int resposta = open.showOpenDialog(null);

        if (resposta == JFileChooser.APPROVE_OPTION) {
            strPath = open.getSelectedFile().getAbsolutePath();
        }

        strName = strPath.substring(strPath.lastIndexOf(System.getProperty("file.separator")) + 1, strPath.length());

        String finalStr = strName.substring(strName.length() - 4, strName.length());

        if (finalStr.equals(".mp3")) {

            Music musica = new Music(strName, strPath);
            musicDAO.insert(musica);
            pesquisar.addItem(strName);
            JTextField text = (JTextField) pesquisar.getEditor().getEditorComponent();
            text.addKeyListener(new ComboKeyHandler(pesquisar));

        }

        loadMusicsOnJlist();
    }//GEN-LAST:event_jButtonAddMusicaActionPerformed

    private void jButtonAddPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPlaylistActionPerformed
        int contem = 0;

        strPlaylist = JOptionPane.showInputDialog("Nomear Playlist");

        for (int i = 0; i < jListPlaylists.getModel().getSize(); i++) {

            if (jListPlaylists.getModel().getElementAt(i).equals(strPlaylist)) {
                contem = 1;
            }
        }

        if (contem == 0) {
            Playlist playlist = new Playlist(strPlaylist);
            playlistDAO.criar(playlist, userLoggedIn.getUsername());
        }
        loadPlaylistsOnJlist();
    }//GEN-LAST:event_jButtonAddPlaylistActionPerformed

    private void jListPlaylistsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPlaylistsMouseClicked
        jLabelPlaylistSelecionada.setText(jListPlaylists.getSelectedValue());
        loadPlaylistMusicsOnJlist(jListPlaylists.getSelectedValue());
    }//GEN-LAST:event_jListPlaylistsMouseClicked

    private void jButtonAddMusicaPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddMusicaPlaylistActionPerformed

        int size = jListMusics.getModel().getSize();
        int flag = 0;

        String selecionarPlaylist = jListPlaylists.getSelectedValue();

        Object[] opcoes = new Object[size];

        if (selecionarPlaylist == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma Playlist");
        } else {

            for (int i = 0; i < jListMusics.getModel().getSize(); i++) {
                opcoes[i] = jListMusics.getModel().getElementAt(i);
            }

            Object selecionado = JOptionPane.showInputDialog(null, "Adicionar musica",
                    "Gem Player", JOptionPane.QUESTION_MESSAGE, null, opcoes, null);

            String item = (String) selecionado;

            String path = musicPath(item);

            path = path.replaceAll(" ", "");

            Music music = new Music(item, path);

            Playlist playlist = new Playlist(jListPlaylists.getSelectedValue());
            playlist.addMusic(music);

            playlistDAO.addMusic(playlist, userLoggedIn.getUsername());
            loadPlaylistMusicsOnJlist(selecionarPlaylist);
        }
    }//GEN-LAST:event_jButtonAddMusicaPlaylistActionPerformed

    private void jListMusicsOfPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListMusicsOfPlaylistMouseClicked

        String caminho = musicPath(jListMusicsOfPlaylist.getSelectedValue());
        String[] t = caminho.split(";");

        caminho = t[1];
        System.out.println(caminho);

        File musicaFile = new File(caminho);
        MediaPlayer music = new MediaPlayer(musicaFile);

        music.play();
    }//GEN-LAST:event_jListMusicsOfPlaylistMouseClicked

    private void jButtonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuariosActionPerformed
        JFUsers tela = new JFUsers(userLoggedIn);
        tela.setVisible(true);
    }//GEN-LAST:event_jButtonUsuariosActionPerformed

    private void jLabelUserLogadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelUserLogadoMouseClicked
        Runtime.getRuntime().exit(0);
    }//GEN-LAST:event_jLabelUserLogadoMouseClicked

    private void jLabelStopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStopMouseClicked
     
    }//GEN-LAST:event_jLabelStopMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFVIPPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new JFVIPPlayer().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(JFVIPPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddDiretorio;
    private javax.swing.JButton jButtonAddMusica;
    private javax.swing.JButton jButtonAddMusicaPlaylist;
    private javax.swing.JButton jButtonAddPlaylist;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonUsuarios;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelMusicas;
    private javax.swing.JLabel jLabelNext2;
    private javax.swing.JLabel jLabelPlay;
    private javax.swing.JLabel jLabelPlaylistSelecionada;
    private javax.swing.JLabel jLabelPlaylists;
    private javax.swing.JLabel jLabelStop;
    private javax.swing.JLabel jLabelUserLogado;
    private javax.swing.JList<String> jListMusics;
    private javax.swing.JList<String> jListMusicsOfPlaylist;
    private javax.swing.JList<String> jListPlaylists;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox<String> pesquisar;
    // End of variables declaration//GEN-END:variables

    private void setImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/if_gem.png")));
    }

    private void loadMusicsOnJlist() {
        musicDAO = new MusicDAO();
        ArrayList<Music> musicas = musicDAO.list();
        listModel = new DefaultListModel<>();
        if (!musicas.isEmpty()) {
            musicas.forEach((m) -> {
                listModel.addElement(m.getTitle());
            });
        }
        jListMusics.setModel(listModel);
    }

    private void loadPlaylistsOnJlist() {
        playlistDAO = new PlaylistDAO();

        ArrayList<Playlist> playlists = playlistDAO.listPlaylistsByUser(userLoggedIn.getUsername());
        listModel = new DefaultListModel<>();

        if (!playlists.isEmpty()) {
            playlists.forEach((p) -> {
                try {
                    listModel.addElement(p.getTitle());
                } catch (Exception e) {
                    System.err.println("PlayerVIP loadPlaylistsOnJlist() - exception - " + e);
                }
            });
        }
        jListPlaylists.setModel(listModel);
    }

    private void loadPlaylistMusicsOnJlist(String nomePlaylist) {
        playlistDAO = new PlaylistDAO();
        ArrayList<Music> musicas = playlistDAO.listMusicsByPlaylist(userLoggedIn.getUsername(), nomePlaylist);
        listModel = new DefaultListModel<>();
        if (!musicas.isEmpty()) {
            musicas.forEach((m) -> {
                try {
                    listModel.addElement(m.getTitle());
                } catch (Exception e) {
                    System.err.println("PlayerVIP loadPlaylistMusicsOnJlist() - Exception - " + e);
                }
            });
        }

        jListMusicsOfPlaylist.setModel(listModel);
    }

    /**
     *
     * @param item
     * @return null
     */
    
    public String musicPath(String item) {
        try {

            FileReader fr = new FileReader("data/musicas.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp;

            while ((temp = br.readLine()) != null) {

                if (temp.contains(item)) {
                    return temp;
                }
            }
        } catch (FileNotFoundException el) {
            System.out.println("Arquivo não Encontrado!");
        } catch (IOException | NullPointerException e) {
        }
        return null;
    }

}