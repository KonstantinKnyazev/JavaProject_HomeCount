/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.table;

import javax.swing.ImageIcon;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.model.ArticleTableModel;
import personalfinance.settings.Style;

/**
 *
 * @author Konstantin_Knyazev
 */
public class ArticleTableData extends TableData {
    
    private static final String[] columns = new String[]{"TITLE"};
    
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_PANEL_TITLE};
    
    private static final String[] tooltips = new String[]{"TOOL_TIP_RIGHT_PANEL_ARTICLES_CH_TITLE"};
    
    public ArticleTableData(FunctionsHandler handler) {
        super(new ArticleTableModel(columns),
                handler,
                columns,
                icons,
                tooltips
        );
    }
    
   
    

    
    
}
