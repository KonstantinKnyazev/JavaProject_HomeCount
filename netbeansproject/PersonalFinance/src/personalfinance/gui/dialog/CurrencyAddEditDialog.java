/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.dialog;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import personalfinance.exception.ModelException;
import personalfinance.gui.MainFrame;
import personalfinance.model.Common;
import personalfinance.model.Currency;
import personalfinance.settings.Format;
import personalfinance.settings.Settings;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public class CurrencyAddEditDialog extends AddEditDialog {

    public CurrencyAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        
        JComboBox combo = new JComboBox(Settings.CURRENCY_CODES);
        combo.setRenderer(new MyComboBoxRenderer());

    

        components.put("LABEL_TITLE", new JTextField());
//        components.put("LABEL_CODE", new JComboBox(Settings.CURRENCY_CODES));
        components.put("LABEL_CODE", combo);
        components.put("LABEL_RATE", new JTextField());
        components.put("LABEL_ON", new JComboBox(new String[]{Text.get("YES"), Text.get("NO")}));
        components.put("LABEL_BASE", new JComboBox(new String[]{Text.get("YES"), Text.get("NO")}));

        //указываем хэш-мап с иконками
        icons.put("LABEL_TITLE", Style.ICON_LABEL_TITLE);
        icons.put("LABEL_CODE", Style.ICON_LABEL_CODE);
        icons.put("LABEL_RATE", Style.ICON_LABEL_RATE);
        icons.put("LABEL_ON", Style.ICON_LABEL_ON);
        icons.put("LABEL_BASE", Style.ICON_LABEL_BASE);

        values.put("LABEL_RATE", Format.amount(1)); //значение по умолчанию
    }

    @Override
    protected void setValues() {
        Currency currency = (Currency) c;
        values.put("LABEL_TITLE", currency.getTitle());
        values.put("LABEL_CODE", currency.getCode());
        values.put("LABEL_RATE", currency.getRate());
        //on
        if (currency.isOn()) {
            values.put("LABEL_ON", Text.get("YES"));
        } else {
            values.put("LABEL_ON", Text.get("NO"));
        }
        //base
        if (currency.isBase()) {
            values.put("LABEL_BASE", Text.get("YES"));
        } else {
            values.put("LABEL_BASE", Text.get("NO"));
        }
        
        //как вариант для невозможности редактировать статус "базовый" у базовой валюты
//        if(currency.isBase()) components.remove("LABEL_BASE");
          if(currency.isBase()) ((JComboBox)components.get("LABEL_BASE")).setEnabled(false);
    }

    @Override
    public Common getCommonFromForm() throws ModelException {
        try {
            String title = ((JTextField) components.get("LABEL_TITLE")).getText();
            String code = (String) ((JComboBox) components.get("LABEL_CODE")).getSelectedItem();
            String rate = ((JTextField) components.get("LABEL_RATE")).getText();
            //on
            boolean isOn = false;
            if (((JComboBox) components.get("LABEL_ON")).getSelectedItem().equals(Text.get("YES"))) {
                isOn = true;
            }
            //base
            boolean isBase = false;
            if (((JComboBox) components.get("LABEL_BASE")).getSelectedItem().equals(Text.get("YES"))) {
                isBase = true;
            }
            //если мы не создаем новую валюту, а редактируем имеющуюся то необходима проверка:
            //если выбрана как небазовая И объект ненулевой, т.е. валюта не новая, а уже имеющаяся И имеющаяся валюта была базовой
            //выдаем ошибку, сообщаем что сначала надо присвоить статус базовой другой валюте, что автоматически приведет к отмене статуса базовой у текущей (метод clearBase()
            if (!isBase && c != null && ((Currency) c).isBase()) {
                throw new ModelException(ModelException.NO_BASE_CURRENCY);
            }

            
            return new Currency(title, code,Format.fromAmountToNumber(rate), isOn, isBase);//здесь возможна ошибка
        } catch (NumberFormatException ex) {
            throw new ModelException(ModelException.AMOUNT_FORMAT);
        }
    }

     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    class MyComboBoxRenderer extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
                if (-1 < index) {
                    //list.setToolTipText(tooltips[index]);
                    list.setToolTipText(Text.get((String) value));
                }
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            setFont(list.getFont());
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }//class MyComboBoxRenderer extends BasicComboBoxRenderer 
}
