/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.panel;

import javax.swing.JPanel;
import personalfinance.gui.EnableEditDelete;
import personalfinance.gui.MainFrame;
import personalfinance.gui.Refresh;

/**
 *
 * @author Konstantin_Knyazev
 */
abstract public class AbstractPanel extends JPanel implements Refresh,EnableEditDelete{

    protected final MainFrame frame;

    public AbstractPanel(MainFrame frame) {
        this.frame =  frame;
    }
    
    /**
     *
     */
    @Override
    public void refresh() {
        removeAll();
        init();
    }

    abstract  protected void init();

    @Override
    public void setEnableEditDelete(boolean enable) {        
    }
    
}
