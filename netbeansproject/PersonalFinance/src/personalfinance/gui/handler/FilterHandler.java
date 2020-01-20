/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.handler;

import java.awt.event.ActionEvent;
import personalfinance.gui.MainFrame;
import personalfinance.saveload.SaveData;
import personalfinance.settings.HandlerCode;

/**
 *
 * @author Konstantin_Knyazev
 */
public class FilterHandler extends Handler {

    

    public FilterHandler(MainFrame frame) {
        super(frame);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        
        switch (ae.getActionCommand()) {
            case HandlerCode.LEFT: {
                //get filter from saveData and use method prev()
                SaveData.getInstance().getFilter().prev();

                break;
            }
            case HandlerCode.RIGHT: {
                SaveData.getInstance().getFilter().next();
                break;
            }

            case HandlerCode.STEP: {
               SaveData.getInstance().getFilter().nextPeriod();
            }
            
        }
        super.actionPerformed(ae);
    }

    

    
}
