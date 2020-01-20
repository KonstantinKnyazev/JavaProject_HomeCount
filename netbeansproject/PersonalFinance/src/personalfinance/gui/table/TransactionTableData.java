/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.table;

import javax.swing.ImageIcon;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.model.TransactionTableModel;
import personalfinance.gui.table.renderer.TableCellAmountRenderer;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public class TransactionTableData extends TableData {
    
    private static final String[] columns = new String[]{"DATE", "ACCOUNT", "ARTICLE", "AMOUNT", "NOTICE"};
    
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_PANEL_CALENDAR, Style.ICON_PANEL_ACCOUNT, Style.ICON_PANEL_ARTICLE, Style.ICON_PANEL_AMOUNT, Style.ICON_PANEL_NOTICE};
    
    private static final String[] tooltips = new String[]{"TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_DATE","TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_ACCOUNT",
                                                          "TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_ARTICLE","TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_AMOUNT",
                                                          "TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_NOTICE"};
    
    
    public TransactionTableData(FunctionsHandler handler) {
        super(new TransactionTableModel(columns), 
                handler,
                columns, 
                icons,
                tooltips
        );
        init();
    }
    
    public TransactionTableData(FunctionsHandler handler,int count) {
        super(new TransactionTableModel(columns, count), 
                handler,
                columns, 
                icons,
                tooltips
        );
        init();
    }
        

//    опеделим визуальную разницу для доходов и расходов
    @Override
    protected final void init() {
        getColumn(Text.get("AMOUNT")).setCellRenderer(new  TableCellAmountRenderer());        
    }
    
    
}
