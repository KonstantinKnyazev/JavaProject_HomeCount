/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.dialog;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public class AboutDialog extends JDialog{
    
    public AboutDialog(){
        super();
        init();
        setTitle(Text.get("DIALOG_ABOUT_TITLE"));
        setIconImage(Style.ICON_ABOUT.getImage());
        
        
        setResizable(false);
    }

    private void init() {
        JEditorPane pane = new JEditorPane("text/html", Text.get("ABOUT"));
        
        pane.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        pane.setFont(Style.FONT_BUTTON_FILTER);
        
        pane.setEditable(false);//
        pane.setOpaque(false);//фон отлючаем
        
        //чтобы ссылка работала
        pane.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent he) {
                if(HyperlinkEvent.EventType.ACTIVATED.equals(he.getEventType())){//означает что пользователь кликнулпо ссылке
                    try {                    
                    Desktop.getDesktop().browse(he.getURL().toURI());
                    } catch (IOException | URISyntaxException ex) {                        
                    }
                }
            }
        });              
                
        add(pane);//добавить в диалоговое окно
        pack();//размер достаточный для всех компонентов
        setLocationRelativeTo(null);//по центру рабочего стола
    }
}
