/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.panel;

import personalfinance.gui.MainButton;
import personalfinance.gui.MainFrame;
import personalfinance.gui.handler.ChartHandler;
import personalfinance.gui.handler.MenuFileHandler;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public class UpdateCurrencyPanel extends AbstractPanel{
    
    private final String title;

    public UpdateCurrencyPanel(MainFrame frame,String title){
        super(frame);
        this.title=Text.get(title);
        init();
    }
    
    @Override
    protected void init() {
        MainButton type = new MainButton(title, new MenuFileHandler(frame), HandlerCode.MENU_FILE_UPDATE_CURRENCIES);
        type.setIcon(Style.ICON_MENU_FILE_UPDATE_CURRENCIES);
        add(type);
    }

    @Override
    public void setEnableEditDelete(boolean enable) {
    }
    
}
