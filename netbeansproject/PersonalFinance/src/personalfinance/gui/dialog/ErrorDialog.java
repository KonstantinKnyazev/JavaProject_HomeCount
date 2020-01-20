/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.dialog;

import javax.swing.JOptionPane;
import personalfinance.gui.MainFrame;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public class ErrorDialog {

    public static void show(MainFrame frame, String text, String info) {
        
        //here we add add text info into the text recieved from  Text.get(text)
        StringBuilder stringBuilder = new StringBuilder();      
        
        
        
        String append1 = Text.get(text).replace("</center></html>", ""); //here we remouve    </center></html>            
//        append1 = Text.get(append1).replace("<html><center>", "");
        String append2 = info;      //adding text of info  
        stringBuilder.append("<html><center>").append(append1).append(append2).append("</center></html>");   //we put back </center></html> at the end on buildet text
        
        String messageText = stringBuilder.toString();        
        
        JOptionPane.showMessageDialog(frame, messageText, Text.get("ERROR"), JOptionPane.ERROR_MESSAGE);//frame, text,title,type
    }

    public static void show(MainFrame frame, String text) {
        show(frame, text, "");
    }
//    public static void show(MainFrame frame, String text){
//        JOptionPane.showMessageDialog(frame, Text.get(text), Text.get("ERROR"), JOptionPane.ERROR_MESSAGE);//frame, text,title,type
//    }

}
