/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.table;

import javax.swing.ImageIcon;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.model.AccountTableModel;
import personalfinance.gui.table.renderer.TableCellAmountRenderer;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public class AccountTableData extends TableData {
    
    private static final String[] columns = new String[]{"TITLE", "AMOUNT"};
    
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_PANEL_TITLE, Style.ICON_PANEL_AMOUNT};
    
    private static final String[] tooltips = new String[]{"TOOL_TIP_RIGHT_PANEL_ACCOUNTS_CH_TITLE", "TOOL_TIP_RIGHT_PANEL_ACCOUNTS_CH_AMOUNT"};
    
    public AccountTableData(FunctionsHandler handler) {
        super(new AccountTableModel(columns),
                handler,
                columns,
                icons,
                tooltips
        );
        init();
    }
    
    
    
//    опеделим визуальную разницу для положительного и отрицательного баланса счета
    @Override
    protected final void init() {
        getColumn(Text.get("AMOUNT")).setCellRenderer(new  TableCellAmountRenderer());        
    }
    
    
}
