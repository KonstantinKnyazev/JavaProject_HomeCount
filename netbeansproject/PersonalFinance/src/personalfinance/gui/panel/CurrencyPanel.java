/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.panel;

import javax.swing.JPanel;
import personalfinance.gui.EnableEditDelete;
import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.CurrencyAddEditDialog;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.CurrencyTableData;
import personalfinance.gui.toolbar.FunctionsToolBar;
import personalfinance.settings.Style;

/**
 *
 * @author Konstantin Knyazev
 */
public class CurrencyPanel extends RightPanel{
 
    public CurrencyPanel(MainFrame  frame){
        super(frame, 
                new CurrencyTableData(new FunctionsHandler(frame, new CurrencyAddEditDialog(frame) )), //FunctionsHandler - listener of events that will call dialog
                "CURRENCIES",                               //title of table
                "TOOL_TIP_RIGHT_PANEL_CURRENCIES_HEADER",   //tool tip for title of table  
                Style.ICON_PANEL_HEADER_CURRENCIES,         //image for title of table
                new JPanel[]{
                    new FunctionsToolBar(new FunctionsHandler(frame, new CurrencyAddEditDialog(frame) )),//function tool bar - is set of buttons (add, edit, delete)
                                                                                                        //FunctionsHandler - listener of events that will call dialog
                    new UpdateCurrencyPanel(frame, "MENU_FILE_UPDATE_CURRENCIES")}                                                                                   
                
        );
    }

    @Override
    public void setEnableEditDelete(boolean enable) {
    
    }
}


/*
new JPanel[]{                               //can content few toolbars or panels
                    new FunctionsToolBar(new FunctionsHandler(frame, new TransactionAddEditDialog(frame) )),//function tool bar - is set of buttons (add, edit, delete)
                                                                                                            //FunctionsHandler - listener of events that will call dialog
                    new FilterPanel(frame)}    

*/
                                                                                                   