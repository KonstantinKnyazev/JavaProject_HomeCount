/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.model;

import java.util.Date;
import personalfinance.exception.ModelException;
import personalfinance.saveload.SaveData;

/**
 *
 * @author Konstantin_Knyazev
 */
public class Transfer extends Common{
    
    private Account fromAccount;//с какого счета переводим деньги
    private Account toAccount;//на какой счет переводим деньги
    private double fromAmount;//сколько ушло
    private double toAmount;//сколько пришло
    private String notice;
    private Date date;

    public Transfer() {
    }

    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount, String notice, Date date) throws ModelException {
        if (fromAccount == null) {
            throw new ModelException(ModelException.ACCOUNT_EMPTY);
        }
        if (toAccount == null) {
            throw new ModelException(ModelException.ACCOUNT_EMPTY);
        }
        if (fromAmount < 0 || toAmount < 0) {
            throw new ModelException(ModelException.AMOUNT_FORMAT);
        }
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
        this.notice = notice;
        this.date = date;
    }

    //конструктор без даты
    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount, String notice) throws ModelException {
        this(fromAccount, toAccount, fromAmount, toAmount, notice, new Date());
    }

    //конструктор без примечания
    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount, Date date) throws ModelException {
        this(fromAccount, toAccount, fromAmount, toAmount, "", date);
    }

    //конструктор без даты и примечания
    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount) throws ModelException {
        this(fromAccount, toAccount, fromAmount, toAmount, "", new Date());
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public double getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(double fromAmount) {
        this.fromAmount = fromAmount;
    }

    public double getToAmount() {
        return toAmount;
    }

    public void setToAmount(double toAmount) {
        this.toAmount = toAmount;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transfer{" + "fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", fromAmount=" + fromAmount + ", toAmount=" + toAmount + ", notice=" + notice + ", date=" + date + '}';
    }
    
    @Override
    public void postAdd(SaveData sd) {
        resetAmounts(sd);
    }    
    
    @Override
    public void postEdit(SaveData sd) {
        resetAmounts(sd);
    }    
    
    @Override
    public void postRemouve(SaveData sd) {
        resetAmounts(sd);
    }   
        
    private void resetAmounts(SaveData sd){
        for(Account a:sd.getAccounts()){
            a.setAmountFromTransactionsAndTransfers(sd.getTransactions(), sd.getTransfers());
        }
    }
    
}//class
