
package mp.view;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * Referente a manipulação de chaves de busca em uma pesquisa
 * 
 * @author Edivânia Pontes (edivaniap@ufrn.edu.br)
 * @author Anne Ílary (ilarymoraes@hotmail.com)
 * @since 25 de junho de 2018
 */
class ComboKeyHandler extends KeyAdapter {
    
        private final JComboBox<String> comboBox;
        private final List<String> list = new ArrayList<>();
        private boolean shouldHide;
        
        
        
   /**
     *  Adiciona elementos da caixa de pesquisa na lista
     * 
     * @param combo Corresponde ao conteudo da caixa de pesquisa
     */
        
     public ComboKeyHandler(JComboBox<String> combo) {
          super();
          this.comboBox = combo;
          for (int i = 0; i < comboBox.getModel().getSize(); i++) {
          list.add((String) comboBox.getItemAt(i));
        }
     }
     
   /**
     *  Verifica se palavra está na lista filtrada 
     * 
     * @param e Entrada   
     */
     
      @Override 
      public void keyTyped(final KeyEvent e) {
            EventQueue.invokeLater(() -> {
                String text = ((JTextField) e.getComponent()).getText();
                ComboBoxModel<String> m;

                if (text.isEmpty()) {
                    String[] array = list.toArray(new String[list.size()]);
                    m = new DefaultComboBoxModel<>(array);
                    setSuggestionModel(comboBox, m, "");
                    comboBox.hidePopup();
                }else{
                    m = getSuggestedModel(list, text);
                    if (m.getSize() == 0 || shouldHide) {
                        comboBox.hidePopup();
                    } else {
                        setSuggestionModel(comboBox, m, text);
                        comboBox.showPopup();
                    }
                }
            });
      }
      
    /**
     *  Adiciona palavras com caractere correspondente na caixa de pesquisa
     * 
     * @param e Entrada 
     */
      @Override 
      public void keyPressed(KeyEvent e) {
            
            JTextField textField = (JTextField) e.getComponent();
            String text = textField.getText();
            shouldHide = false;
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                  for (String s : list) {
                    if (s.startsWith(text)) {
                      textField.setText(s);
                      return;
                    }
                  }
                  break;
                case KeyEvent.VK_ENTER:
                  if (!list.contains(text)) {
                    Collections.sort(list);
                    setSuggestionModel(comboBox, getSuggestedModel(list, text), text);
                  }
                  shouldHide = true;
                  break;
                case KeyEvent.VK_ESCAPE:
                  shouldHide = true;
                  break;
                default:
                  break;
            }
      }
      
   /**
     * Define as palavras que serão sugeridas de acordo com o filtro 
     * 
     * @param comboBox Corresponde a caixa de pesquisa
     * @param mdl Conteudo caixa de pesquisa
     * @param str Texto a ser sugerido
     */
      private static void setSuggestionModel(JComboBox<String> comboBox, ComboBoxModel<String> mdl, String str) {

        comboBox.setModel(mdl);
        comboBox.setSelectedIndex(-1);
        ((JTextField) comboBox.getEditor().getEditorComponent()).setText(str);

      }
    /**
     * Sugere palavras filtradas de acordo com a entrada do usuario 
     *  
     * @param list Lista com as entradas 
     * @param text Texto de comparação
     * @return Sugestão de palavra de acordo com entradas correspondentes
     */
   
 
      private static ComboBoxModel<String> getSuggestedModel(List<String> list, String text) {

          DefaultComboBoxModel<String> m = new DefaultComboBoxModel<>();

          list.stream().filter((s) -> (s.startsWith(text))).forEachOrdered((s) -> {
              m.addElement(s);
            });
        return m;
      }
}