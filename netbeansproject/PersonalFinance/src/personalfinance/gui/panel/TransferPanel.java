/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.panel;

import javax.swing.JPanel;
import personalfinance.gui.EnableEditDelete;
import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.TransferAddEditDialog;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.TransferTableData;
import personalfinance.gui.toolbar.FunctionsToolBar;
import personalfinance.settings.Style;

/**
 *
 * @author Konstantin_Knyazev
 */
public class TransferPanel extends RightPanel{
 
    public TransferPanel(MainFrame  frame){
        super(frame, 
                new TransferTableData(new FunctionsHandler(frame, new TransferAddEditDialog(frame) )), //FunctionsHandler - listener of events that will call dialog
                "TRANSFERS",                                //title of table
                "TOOL_TIP_RIGHT_PANEL_TRANSFERS_HEADER",    //tool tip for title of table
                Style.ICON_PANEL_HEADER_TRANSFERS,          //image for title of table
                new JPanel[]{                               //can content few toolbars or panels
                    new FunctionsToolBar(new FunctionsHandler(frame, new TransferAddEditDialog(frame) )),   //function tool bar - is set of buttons (add, edit, delete)
                                                                                                            //FunctionsHandler - listener of events that will call dialog
                    new FilterPanel(frame)});               //panel for set filter of date
    }

    @Override
    public void setEnableEditDelete(boolean enable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
   
