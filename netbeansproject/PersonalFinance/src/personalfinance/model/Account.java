/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.model;

import java.util.List;
import java.util.Objects;
import personalfinance.exception.ModelException;
import personalfinance.saveload.SaveData;

/**
 *
 * @author Konstantin_Knyazev
 */
public class Account extends Common{
    
    private String title;
    private Currency currency;
    private double startAmount;//стартовая сумма для начала ведения счета
    //начальные параметры которые должен указать пользователь при открытии новогго счета
    private double amount;//конечная сумма на счете в данный момент с учетом транзакций

    public Account() {
    }

    public Account(String title, Currency currency, double startAmount) throws ModelException {
        if (title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        if (currency == null) throw new ModelException(ModelException.CURRENCY_EMPTY);        
        this.title = title;
        this.currency = currency;
        this.startAmount = startAmount;
    }   

    public double getAmount(){
    return amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(double startAmount) {
        this.startAmount = startAmount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account{" + "title=" + title + ", currency=" + currency + ", startAmount=" + startAmount + ", amount=" + amount + '}';
    }
    
    
    
    @Override
    public String getValueForComboBox() {
        return title + " ("+ amount+")";
    }
    
    //утановление конечной суммы счета 
    public void setAmountFromTransactionsAndTransfers(List<Transaction> transactions, List<Transfer> transfers) {
        this.amount = startAmount;
        for (Transaction transaction : transactions) {//перебираем все транзакции
            if (transaction.getAccount().equals(this)) {//проверяем относятся ли транзакции к этому счету
                this.amount += transaction.getAmount();//добавляем сумму транзакции к счету
            }
        }

        for (Transfer transfer : transfers) {//перебираем все переводы
            if (transfer.getFromAccount().equals(this)) {//проверяем имеет ли отношение к этому счету. Для снятия с этого счета
                this.amount -= transfer.getFromAmount();//отнимаем сумму перевода со счета
            }
            if (transfer.getToAccount().equals(this)) {//проверяем имеет ли отношение к этому счету. Для добавления на этот счет
                this.amount += transfer.getToAmount();//добавляем сумму перевода на счет
            }
        }
    }
    
    @Override
    public void postAdd(SaveData sd){
        
        setAmountFromTransactionsAndTransfers(sd.getTransactions(), sd.getTransfers());//пересчитываем счет
    }

    @Override
    public void postEdit(SaveData sd) {
        
        for (Transaction t : sd.getTransactions())//перебираем транзакции
        {
            if (t.getAccount().equals(sd.getOldCommon())) {
                t.setAccount(this);//если счет был эквивалентен "старому" счету заменяем его на новый
            }
        }
        for (Transfer t : sd.getTransfers()) {//перебираем все переводы
            if (t.getFromAccount().equals(sd.getOldCommon())) {//если счет(FromAccount) был эквивалентен "старому" счету заменяем его на новый
                t.setFromAccount(this);
            }
            if (t.getToAccount().equals(sd.getOldCommon())) {//если счет(ToAccount) был эквивалентен "старому" счету заменяем его на новый
                t.setToAccount(this);
            }
        }
        setAmountFromTransactionsAndTransfers(sd.getTransactions(), sd.getTransfers());//пересчитываем счет
    }

    
}//class
