/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui;


import java.util.Date;
import java.util.Properties;
import javax.swing.JButton;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin Knyazev
 */
public class MainDatePicker {
    
    private final JDatePickerImpl datePicker;
    
    public MainDatePicker(){
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();//настройки
        p.put("text.today", Text.get("TODAY"));//заменяем стандартный техт на свою языковую константу
        
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);              
        
        datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        model.setValue(new Date());
        
        //картинка на кнопку календаря
        JButton button = (JButton)datePicker.getComponent(1);//номер компонента (Нужной кнопки)
        button.setIcon(Style.ICON_CALENDAR);
        button.setText("");
    }
    
    public JDatePickerImpl getDatePicker(){
        return datePicker;
    }
    
    public void setValue(Date date){
        ((UtilDateModel)datePicker.getModel()).setValue(date);
    }
}
