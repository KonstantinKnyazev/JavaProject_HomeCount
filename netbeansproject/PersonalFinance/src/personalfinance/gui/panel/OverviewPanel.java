/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.TransactionAddEditDialog;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.TransactionTableData;
import personalfinance.settings.Settings;
import personalfinance.settings.Style;

/**
 *
 * @author Konstantin_Knyazev
 */
public class OverviewPanel extends RightPanel{
 
    public OverviewPanel(MainFrame  frame){
        super(frame, 
                new TransactionTableData(new FunctionsHandler(frame, new TransactionAddEditDialog(frame)), Settings.COUNT_OVERVIEW_ROWS), 
                "LAST_TRANSACTIONS", 
                "TOOL_TIP_RIGHT_PANEL_LAST_TRANSACTIONS_HEADER",
                Style.ICON_PANEL_HEADER_OVERVIEW
        );
    }

    @Override
    public void setEnableEditDelete(boolean enable) {
    }
}
