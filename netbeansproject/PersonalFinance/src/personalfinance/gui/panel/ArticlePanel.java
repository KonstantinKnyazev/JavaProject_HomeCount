/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.panel;

import javax.swing.JPanel;
import personalfinance.gui.EnableEditDelete;
import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.ArticleAddEditDialog;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.ArticleTableData;
import personalfinance.gui.toolbar.FunctionsToolBar;
import personalfinance.settings.Style;

/**
 *
 * @author Konstantin_Knyazev
 */
public class ArticlePanel extends RightPanel{
 
    public ArticlePanel(MainFrame  frame){
        super(frame, 
                new ArticleTableData(new FunctionsHandler(frame, new ArticleAddEditDialog(frame) )), //FunctionsHandler - listener of events that will call dialog
                "ARTICLES", //title of table
                "TOOL_TIP_RIGHT_PANEL_ARTICLES_HEADER", //tool tip for title of table 
                Style.ICON_PANEL_HEADER_ARTICLES,//image for title of table
                new FunctionsToolBar(new FunctionsHandler(frame, new ArticleAddEditDialog(frame) ))//function tool bar - is set of buttons (add, edit, delete)
                                                                                                   //FunctionsHandler - listener of events that will call dialog
        );
    }

    @Override
    public void setEnableEditDelete(boolean enable) {
    }
}

                
                                                                                                    