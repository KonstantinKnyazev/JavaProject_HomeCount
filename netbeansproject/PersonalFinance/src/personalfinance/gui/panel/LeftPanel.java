/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.panel;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import personalfinance.gui.MainFrame;
import personalfinance.model.Currency;
import personalfinance.model.Statistics;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Format;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public final class LeftPanel extends AbstractPanel {

    public LeftPanel(MainFrame frame) {
        super(frame);
        init();
    }

    @Override
    protected void init() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));//BoxLayout с веритикальным выравниванием
        setBorder(Style.BORDER_LEFT_PANEL);
        //заголовок
        JLabel headerBC = new JLabel(Text.get("BALANCE_CURRENCIES"));//balance currencies
        headerBC.setFont(Style.FONT_LABEL_HEADER);
        headerBC.setIcon(Style.ICON_LEFT_PANEL_BALANCE_CURRENCIES);
        headerBC.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        headerBC.setBorder(Style.BORDER_LABEL);
        add(headerBC);
        //добавляем баланс
        addBalanceCurrency();
        //отступ
        add(Box.createVerticalStrut(Style.PADDING_BIG_BALANCE));
        //итого по валютам
        JLabel headerB = new JLabel(Text.get("BALANCE"));
        headerB.setFont(Style.FONT_LABEL_HEADER);
        headerB.setIcon(Style.ICON_LEFT_PANEL_BALANCE);
        headerB.setAlignmentX(JComponent.CENTER_ALIGNMENT);        
        headerB.setToolTipText(Text.get("TOOL_TIP_BALANCE_IN_ONE_CURRENCY"));        
        add(headerB);
        //добавляем баланс
        addBalance();

    }

    private void addBalanceCurrency() {
        SaveData sd = SaveData.getInstance();
        List<Currency> currencies = sd.getEnablesCurrencies();

        for (Currency currency : currencies) {
            add(Box.createVerticalStrut(Style.PADDING_BALANCE));//черточка между каждой валютой
            add(new PanelBalanceCurrency(currency, Statistics.getBalanceCurrency(currency)));
        }

    }

    private void addBalance() {
        SaveData sd = SaveData.getInstance();
        List<Currency> currencies = sd.getEnablesCurrencies();

        for (Currency currency : currencies) {
            add(Box.createVerticalStrut(Style.PADDING_BALANCE));//черточка между каждой валютой
            add(new PanelBalanceCurrency(currency, Statistics.getBalance(currency)));
        }

    }

    @Override
    public void setEnableEditDelete(boolean enable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class PanelBalanceCurrency extends JPanel {

        public PanelBalanceCurrency(Currency currency, double amount) {
            super();
            setLayout(new BorderLayout());
            setBackground(Style.COLOR_LEFTPANEL_BALANCE);
            setBorder(Style.BORDER_PANEL);
            //метка с валютой
            JLabel currencyLabel = new JLabel(currency.getTitle());
            currencyLabel.setFont(Style.FONT_LABEL_LEFTPANEL_CURRENCY);
            //метка с суммой
            JLabel amountJLabel = new JLabel(Format.amount(amount, currency));
            amountJLabel.setFont(Style.FONT_LABEL_LEFTPANEL_AMOUNT);

            add(currencyLabel, BorderLayout.WEST);
            add(Box.createRigidArea(Style.DIMENSION_PADDING_LEFTPANEL_BALANCE));//пробел между
            add(amountJLabel, BorderLayout.EAST);

        }
    }

}
