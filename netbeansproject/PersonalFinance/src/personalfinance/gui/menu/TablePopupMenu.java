/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.menu;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import personalfinance.gui.Refresh;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public class TablePopupMenu extends JPopupMenu implements Refresh{

    private final FunctionsHandler handler;

    public TablePopupMenu(FunctionsHandler handler) {
        super();
        this.handler = handler;
        init();
    }

    
    
    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void init() {
        JMenuItem editItem =  new JMenuItem(Text.get("EDIT"));
        JMenuItem deleteItem =  new JMenuItem(Text.get("DELETE"));
        
        editItem.setActionCommand(HandlerCode.EDIT);
        deleteItem.setActionCommand(HandlerCode.DELETE);
        
        editItem.addActionListener(handler);
        deleteItem.addActionListener(handler);
        
        editItem.setIcon(Style.ICON_MENU_POPUP_EDIT);
        deleteItem.setIcon(Style.ICON_MENU_POPUP_DELETE);
        
        add(editItem);
        add(deleteItem);
        
    }
    
    
}
