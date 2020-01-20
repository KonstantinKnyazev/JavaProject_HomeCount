/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.handler;

import java.awt.event.ActionEvent;
import personalfinance.gui.MainFrame;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Settings;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public class MenuSettingsHandler extends Handler {

    

    public MenuSettingsHandler(MainFrame frame) {
        super(frame);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {       
        
        
        switch (ae.getActionCommand()) {
            case HandlerCode.MENU_SETTINGS_LANGUAGE_RUSSIAN: {
                Settings.setLanguage("ru");
                break;
            }
            case HandlerCode.MENU_SETTINGS_LANGUAGE_ENGLISH: {
                Settings.setLanguage("en");
                break;
            }
            case HandlerCode.MENU_SETTINGS_LANGUAGE_FRENCH: {
                Settings.setLanguage("fr");
                 break;
            }
            
        }
        Text.init();
        frame.setTitle(Text.get("PROGRAMM_NAME"));
        super.actionPerformed(ae);
    }

    

    
}

/*
public void delete() throws ModelException {
        //we need to determine whith line, object, record was selected. 
        Common commonForDeleting = getSelectedCommon();
        if (commonForDeleting != null) {

            //check if common for delete is base Currency
            if (commonForDeleting.getClass() == SaveData.getInstance().getCurrencies().get(0).getClass()) {//if is currency
                if (((Currency) commonForDeleting).isBase()) {//if is base currency
                    throw new ModelException(ModelException.IS_BASE_CURRENCY);//base Currency we can't to delete
                }
            } else {//is not base currency
                int result = ConfirmDialog.show(frame, "CONFIRM_DELETE_TEXT", "CONFIRM_DELETE_TITLE");
                if (result == JOptionPane.YES_OPTION) {
                    SaveData.getInstance().remove(commonForDeleting);
                }
            }
        }        
    }
*/
