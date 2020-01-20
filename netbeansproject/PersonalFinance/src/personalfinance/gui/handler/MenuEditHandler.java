/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.handler;

import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import personalfinance.exception.ModelException;
import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.ErrorDialog;
import personalfinance.settings.HandlerCode;

/**
 *
 * @author Konstantin_Knyazev
 */
public class MenuEditHandler extends Handler {

    

    public MenuEditHandler(MainFrame frame) {
        super(frame);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        FunctionsHandler handler = frame.getRightPanel().getTableData().getFunctionsHadler();
        
        switch (ae.getActionCommand()) {
            case HandlerCode.MENU_EDIT_ADD: {
                handler.add();

                break;
            }
            case HandlerCode.MENU_EDIT_EDIT: {
            try {
                handler.edit();
            } catch (ModelException ex) {
                ErrorDialog.show(frame, ex.getMessage());
            }
                break;
            }

            case HandlerCode.MENU_EDIT_DELETE: {
            try {
                handler.delete();
            } catch (ModelException ex) {
                ErrorDialog.show(frame, ex.getMessage());
            }
            }
            
        }
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
