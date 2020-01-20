/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.toolbar;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import personalfinance.gui.MainButton;
import personalfinance.gui.Refresh;
import personalfinance.gui.handler.Handler;

/**
 *
 * @author Konstantin Knyazev
 */
abstract public class AbstractToolbar extends JPanel implements Refresh {

    private final Handler handler;

    public AbstractToolbar(EmptyBorder border, Handler handler) {
        super();
        this.handler = handler;
        setBorder(border);
    }

    abstract protected void init();

    protected MainButton addButton(String title, ImageIcon icon, String action, boolean topIcon) {
        MainButton button = new MainButton(title, icon, handler, action);
        if (topIcon) {
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
        } else {
            button.setHorizontalTextPosition(SwingConstants.RIGHT);
            button.setVerticalTextPosition(SwingConstants.CENTER);
        }
        add(button);
        return button;
    }

    protected MainButton addButtonWithDimension(String title, ImageIcon icon, String action, boolean topIcon, Dimension dimension) {
        MainButton button = new MainButton(title, icon, handler, action);
        if (topIcon) {
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
        } else {
            button.setHorizontalTextPosition(SwingConstants.RIGHT);
            button.setVerticalTextPosition(SwingConstants.CENTER);
        }
        button.setPreferredSize(dimension);
        add(button);
        return button;
    }

    protected MainButton addButtonWithDimensionAndBorder(String title, ImageIcon icon, String action, boolean topIcon, Dimension dimension, Border border) {
        MainButton button = new MainButton(title, icon, handler, action);
        if (topIcon) {
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
        } else {
            button.setHorizontalTextPosition(SwingConstants.RIGHT);
            button.setVerticalTextPosition(SwingConstants.CENTER);
        }
        button.setPreferredSize(dimension);
        button.setBorder(border);
        add(button);
        return button;
    }
    
    protected MainButton addButtonWithDimensionAndBorderAndToolTips(String title, ImageIcon icon, String action, boolean topIcon, Dimension dimension, Border border, String toolTipsText) {
        MainButton button = new MainButton(title, icon, handler, action);
        if (topIcon) {
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
        } else {
            button.setHorizontalTextPosition(SwingConstants.RIGHT);
            button.setVerticalTextPosition(SwingConstants.CENTER);
        }
        button.setPreferredSize(dimension);
        button.setBorder(border);
        button.setToolTipText(toolTipsText);
        add(button);
        return button;
    }
    

    @Override
    public void refresh() {
        removeAll();
        init();
    }

}
