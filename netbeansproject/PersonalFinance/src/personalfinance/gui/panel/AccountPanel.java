/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.panel;

import javax.swing.JPanel;
import personalfinance.gui.EnableEditDelete;
import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.AccountAddEditDialog;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.AccountTableData;
import personalfinance.gui.toolbar.FunctionsToolBar;
import personalfinance.settings.Style;

/**
 *
 * @author Konstantin_Knyazev
 */
public class AccountPanel extends RightPanel{
 
    public AccountPanel(MainFrame  frame){
        super(frame, 
                new AccountTableData(new FunctionsHandler(frame, new AccountAddEditDialog(frame) )), //FunctionsHandler - listener of events that will call dialog
                "ACCOUNTS",                              //title of table
                "TOOL_TIP_RIGHT_PANEL_ACCOUNTS_HEADER",  //tool tip for title of table accounts
                Style.ICON_PANEL_HEADER_ACCOUNTS,        //image for title of table
                new FunctionsToolBar(new FunctionsHandler(frame, new AccountAddEditDialog(frame) ))//function tool bar - is set of buttons (add, edit, delete)
                                                                                                    //FunctionsHandler - listener of events that will call dialog
        );
    }

    @Override
    public void setEnableEditDelete(boolean enable) {
    }
}
