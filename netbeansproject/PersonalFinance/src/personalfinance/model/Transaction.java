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
public class Transaction extends  Common{
    
    private Account account;
    private Article arcticle;
    private double amount;
    private String notice;
    private Date date;

    public Transaction() {
    }

    public Transaction(Account account, Article arcticle, double amount, String notice, Date date) throws ModelException {
        if (account == null) {
            throw new ModelException(ModelException.ACCOUNT_EMPTY);
        }
        if (arcticle == null) {
            throw new ModelException(ModelException.ARTICLE_EMPTY);
        }
        this.account = account;
        this.arcticle = arcticle;
        this.amount = amount;
        this.notice = notice;
        this.date = date;
    }
    
    
    public Transaction(Account account, Article arcticle, double amount, String notice) throws ModelException {
     this(account,arcticle,amount,notice,new Date());
    } 
    
    public Transaction(Account account, Article arcticle, double amount, Date date) throws ModelException {
     this(account,arcticle,amount,"",date);
    } 
    
    public Transaction(Account account, Article arcticle, double amount) throws ModelException {
     this(account,arcticle,amount,"",new Date());
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Article getArcticle() {
        return arcticle;
    }

    public void setArcticle(Article arcticle) {
        this.arcticle = arcticle;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
        return "Transaction{" + "account=" + account + ", arcticle=" + arcticle + ", amount=" + amount + ", notice=" + notice + ", date=" + date + '}';
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
