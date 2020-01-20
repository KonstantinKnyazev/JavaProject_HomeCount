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
public class ConfirmDialog {
    public static int show(MainFrame frame, String text, String title, String info){
        
        //here we add add text info into the text recieved from  Text.get(text)
        StringBuilder stringBuilder = new StringBuilder();
        String append1 = Text.get(text).replace("</center></html>", ""); //here we remouve    </center></html>            
        String append2 = info;      //adding text of info  
        stringBuilder.append(append1).append(append2).append("</center></html>");   //we put back </center></html> at the end on buildet text
        
        String messageText = stringBuilder.toString();
        
        
        String[] options ={Text.get("YES"),Text.get("NO")};
        int result = JOptionPane.showOptionDialog(frame, messageText, Text.get(title), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        return result;                
    }  
    
    
    public static int show(MainFrame frame, String text, String title){
        return show(frame, text, title,"");
    }
    
//    public static int show(MainFrame frame, String text, String title){
//        String[] options ={Text.get("YES"),Text.get("NO")};
//        int result = JOptionPane.showOptionDialog(frame, Text.get(text), Text.get(title), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
//        return result;                
//    }  
    
//    public static void show(MainFrame frame, String text, String info) {
//        
//        //here we add add text info into the text recieved from  Text.get(text)
//        StringBuilder stringBuilder = new StringBuilder();
//        String append1 = Text.get(text).replace("</center></html>", ""); //here we remouve    </center></html>            
//        String append2 = info;      //adding text of info  
//        stringBuilder.append(append1).append(append2).append("</center></html>");   //we put back </center></html> at the end on buildet text
//        
//        String messageText = stringBuilder.toString();        
//        
//        JOptionPane.showMessageDialog(frame, messageText, Text.get("ERROR"), JOptionPane.ERROR_MESSAGE);//frame, text,title,type
//    }
}
