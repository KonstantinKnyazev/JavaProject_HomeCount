/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.dialog;

import java.util.Date;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePickerImpl;
import personalfinance.exception.ModelException;
import personalfinance.gui.MainDatePicker;
import personalfinance.gui.MainFrame;
import personalfinance.model.Account;
import personalfinance.model.Common;
import personalfinance.model.Transfer;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Format;
import personalfinance.settings.Style;

/**
 *
 * @author Konstantin_Knyazev
 */
public class TransferAddEditDialog extends AddEditDialog{

    public TransferAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        //добавляем начальные параметры , необходимые для каждой новой транзакции 
        components.put("LABEL_DATE", new MainDatePicker().getDatePicker());
        components.put("LABEL_FROM_ACCOUNT", new CommonComboBox(SaveData.getInstance().getAccounts().toArray()));
        components.put("LABEL_FROM_AMOUNT", new JTextField());
        components.put("LABEL_TO_ACCOUNT", new CommonComboBox(SaveData.getInstance().getAccounts().toArray()));
        
        components.put("LABEL_TO_AMOUNT", new JTextField());
        components.put("LABEL_NOTICE", new JTextField());
        
        //указываем хэш-мап с иконками
        icons.put("LABEL_DATE", Style.ICON_LABEL_DATE);
        icons.put("LABEL_FROM_ACCOUNT", Style.ICON_LABEL_FROM_ACCOUNT);
        icons.put("LABEL_FROM_AMOUNT", Style.ICON_LABEL_FROM_AMOUNT);
        icons.put("LABEL_TO_ACCOUNT", Style.ICON_LABEL_TO_ACCOUNT);
        icons.put("LABEL_TO_AMOUNT", Style.ICON_LABEL_TO_AMOUNT);
        icons.put("LABEL_NOTICE", Style.ICON_LABEL_NOTICE);
        
        values.put("LABEL_DATE", new Date());
        values.put("LABEL_FROM_AMOUNT", Format.amount(0)); //значение по умолчанию
        values.put("LABEL_TO_AMOUNT", Format.amount(0)); //значение по умолчанию
    }

    @Override
    protected void setValues() {
        Transfer transfer = (Transfer) c;
        values.put("LABEL_DATE", transfer.getDate());
        values.put("LABEL_FROM_ACCOUNT", transfer.getFromAccount());
        values.put("LABEL_TO_ACCOUNT", transfer.getToAccount());
        values.put("LABEL_FROM_AMOUNT", transfer.getFromAmount());
        values.put("LABEL_TO_AMOUNT", transfer.getToAmount());
        values.put("LABEL_NOTICE", transfer.getNotice());
    }

    @Override
    public Common getCommonFromForm() throws ModelException {
        try {
            Account fromAccount = (Account) ((CommonComboBox) components.get("LABEL_FROM_ACCOUNT")).getSelectedItem();
            Account toAccount = (Account) ((CommonComboBox) components.get("LABEL_TO_ACCOUNT")).getSelectedItem();
            String notice = ((JTextField) components.get("LABEL_NOTICE")).getText();            
            String fromAmount =  ((JTextField) components.get("LABEL_FROM_AMOUNT")).getText();
            String toAmount =  ((JTextField) components.get("LABEL_TO_AMOUNT")).getText();
            Date  date = (Date) ((JDatePickerImpl) components.get("LABEL_DATE")).getModel().getValue();
            
            return new Transfer(fromAccount, toAccount, Format.fromAmountToNumber(fromAmount), Format.fromAmountToNumber(toAmount), notice, date);//здесь возможна ошибка
        } catch (NumberFormatException ex) {
            throw new ModelException(ModelException.AMOUNT_FORMAT);
        }
    }
    
}
