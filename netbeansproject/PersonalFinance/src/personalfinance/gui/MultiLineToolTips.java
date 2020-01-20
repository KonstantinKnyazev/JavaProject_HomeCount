/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolTip;

/**
 *
 * @author Konstantin_Knyazev
 */
public class MultiLineToolTips extends JToolTip {
    
    private JLabel m_label;
        private JButton m_button;
        private JPanel m_panel;
        
        public MultiLineToolTips() {
            super();
            m_label = new JLabel();
            m_button = new JButton("See, I am a button!");
            m_panel = new JPanel(new BorderLayout());
            m_panel.add(BorderLayout.CENTER, m_label);
            m_panel.add(BorderLayout.SOUTH, m_button);
            setLayout(new BorderLayout());
            add(m_panel);
        }

        @Override public Dimension getPreferredSize() {
            return m_panel.getPreferredSize();
        }

        @Override public void setTipText(String tipText) {
            if (tipText != null && !tipText.isEmpty()) {
                m_label.setText(tipText);
            } else {
                super.setTipText(tipText);
            }
        }
    
    
    
    private static int DIALOG_TOOLTIP_MAX_SIZE = 22;
    private static final int SPACE_BUFFER = 10;

    public static String splitToolTip(String tip)
    {
        return splitToolTip(tip,DIALOG_TOOLTIP_MAX_SIZE);
    }
    public static String splitToolTip(String tip,int length)
    {
        if(tip.length()<=length + SPACE_BUFFER )
        {
            return tip;
        }

        List<String>  parts = new ArrayList<>();

        int maxLength = 0;
        String overLong = tip.substring(0, length + SPACE_BUFFER);
        int lastSpace = overLong.lastIndexOf(' ');
        if(lastSpace >= length)
        {
            parts.add(tip.substring(0,lastSpace));
            maxLength = lastSpace;
        }
        else
        {
            parts.add(tip.substring(0,length));
            maxLength = length;
        }

        while(maxLength < tip.length())
        {
            if(maxLength + length < tip.length())
            {
                parts.add(tip.substring(maxLength, maxLength + length));
                maxLength+=maxLength+length;
            }
            else
            {
                parts.add(tip.substring(maxLength));
                break;
            }
        }

        StringBuilder  sb = new StringBuilder("<html>");
        for(int i=0;i<parts.size() - 1;i++)
        {
            sb.append(parts.get(i)+"<br>");
        }
        sb.append(parts.get(parts.size() - 1));
        sb.append(("</html>"));
        return sb.toString();
    }
    
    
}
