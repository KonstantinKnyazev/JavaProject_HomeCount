/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.dialog;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.jdatepicker.impl.JDatePickerImpl;
import personalfinance.exception.ModelException;
import personalfinance.gui.MainDatePicker;
import personalfinance.gui.MainFrame;
import personalfinance.model.Account;
import personalfinance.model.Article;
import personalfinance.model.Common;
import personalfinance.model.Transaction;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Format;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public class TransactionAddEditDialog extends AddEditDialog{

    public TransactionAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        //добавляем начальные параметры , необходимые для каждой новой транзакции 
        
        components.put("LABEL_DATE", new MainDatePicker().getDatePicker());
        components.put("LABEL_ACCOUNT", new CommonComboBox(SaveData.getInstance().getAccounts().toArray()));
        components.put("LABEL_ARTICLE", new CommonComboBox(SaveData.getInstance().getArticles().toArray())); 
        components.put("LABEL_TYPE", new JComboBox(new String[]{Text.get("LABEL_EXP"), Text.get("LABEL_INCOME")}));
        components.put("LABEL_AMOUNT", new MyAmountJTextField(this));
        components.put("LABEL_NOTICE", new JTextField());
        
        //указываем хэш-мап с иконками
       
        icons.put("LABEL_DATE", Style.ICON_LABEL_DATE);
        icons.put("LABEL_ACCOUNT", Style.ICON_LABEL_ACCOUNT);
        icons.put("LABEL_ARTICLE", Style.ICON_LABEL_ARTICLE);
        icons.put("LABEL_TYPE", Style.ICON_LABEL_TYPE);
        icons.put("LABEL_AMOUNT", Style.ICON_LABEL_AMOUNT);
        icons.put("LABEL_NOTICE", Style.ICON_LABEL_NOTICE);
        
        values.put("LABEL_DATE", new Date());
        values.put("LABEL_AMOUNT", Format.amount(0)); //значение по умолчанию
    }

    @Override
    protected void setValues() {
        Transaction transaction = (Transaction) c;
                //exp/inc
        if (transaction.getAmount()<0) {
            values.put("LABEL_TYPE", Text.get("LABEL_EXP"));
        } else {
            values.put("LABEL_TYPE", Text.get("LABEL_INCOME"));
        }        
        values.put("LABEL_DATE", transaction.getDate());
        values.put("LABEL_ACCOUNT", transaction.getAccount());
        values.put("LABEL_ARTICLE", transaction.getArcticle());
        values.put("LABEL_AMOUNT", transaction.getAmount());
        values.put("LABEL_NOTICE", transaction.getNotice());
    }

    @Override
    public Common getCommonFromForm() throws ModelException {
        try {
            Account account = (Account) ((CommonComboBox) components.get("LABEL_ACCOUNT")).getSelectedItem();
            Article article = (Article) ((CommonComboBox) components.get("LABEL_ARTICLE")).getSelectedItem();
            String notice = ((JTextField) components.get("LABEL_NOTICE")).getText();            
                                       
                
            String amountText =  ((JTextField) components.get("LABEL_AMOUNT")).getText();
            String amountFirstSymbol = Character.toString(amountText.charAt(0));
            
            String amount = "";
            
            if(((JComboBox) components.get("LABEL_TYPE")).getSelectedItem().equals(Text.get("LABEL_EXP"))){                
                if(amountFirstSymbol.equals("-")){
                    amount = amountText;
                }else{
                    amount = new StringBuilder().append("-").append(amountText).toString();
                }
            }else if(((JComboBox) components.get("LABEL_TYPE")).getSelectedItem().equals(Text.get("LABEL_INCOME"))){
                if(amountFirstSymbol.equals("-")){
                    amount = amountText.substring(1);
                }else{
                    amount = amountText;
                }
            }
            
                
//                if (((JComboBox) components.get("LABEL_ON")).getSelectedItem().equals(Text.get("YES"))) {
//                isOn = true;
//            }
            
            Date  date = (Date) ((JDatePickerImpl) components.get("LABEL_DATE")).getModel().getValue();
            
            return new Transaction(account,article,Format.fromAmountToNumber(amount),notice,date);//здесь возможна ошибка
        } catch (NumberFormatException ex) {
            throw new ModelException(ModelException.AMOUNT_FORMAT);
        }
    }

    private static class MyAmountJTextField extends JTextField {

        private TransactionAddEditDialog dialog;

        private MyAmountJTextField(TransactionAddEditDialog dialog) {
            this.dialog = dialog;
        }
        
        public MyAmountJTextField() {
            this.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void changedUpdate(DocumentEvent e) {
                    System.out.println(".changedUpdate()");
                    coloring();
                }

                @Override
                public void insertUpdate(DocumentEvent de) {
                    System.out.println(".insertUpdate()");
                    coloring();
                }

                @Override
                public void removeUpdate(DocumentEvent de) {
                    System.out.println(".removeUpdate()");
//                    coloring();
                }
            });
        }        

        public void coloring() {

            String amountText = this.getText();
            String amountFirstSymbol = Character.toString(amountText.charAt(0));

            if (((JComboBox) dialog.components.get("LABEL_TYPE")).getSelectedItem().equals(Text.get("LABEL_EXP"))) {
                System.out.println("personalfinance.gui.dialog.TransactionAddEditDialog.MyAmountJTextField.coloring()    exp");
                if (amountFirstSymbol.equals("-")) {
                    this.setForeground(Style.COLOR_EXP);
                } else {
                    this.setForeground(Style.COLOR_EXP);
                }
            } else if (((JComboBox) dialog.components.get("LABEL_TYPE")).getSelectedItem().equals(Text.get("LABEL_INCOME"))) {
                System.out.println("personalfinance.gui.dialog.TransactionAddEditDialog.MyAmountJTextField.coloring()  inc");
                if (amountFirstSymbol.equals("-")) {
                    this.setForeground(Style.COLOR_EXP);
                } else {
                    this.setForeground(Style.COLOR_INCOME);
                }
            }
        }

    }//class
    
}//class
