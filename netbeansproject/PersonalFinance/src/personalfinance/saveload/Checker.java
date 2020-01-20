/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.saveload;

import java.util.List;
import javax.swing.JOptionPane;
import personalfinance.exception.ModelException;
import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.ConfirmDialog;
import personalfinance.model.Account;
import personalfinance.model.Article;
import personalfinance.model.Common;
import personalfinance.model.Currency;
import personalfinance.model.Transaction;
import personalfinance.model.Transfer;
import personalfinance.settings.Text;

/**
 *
 * @author Kanstontin_
 */
public class Checker {
    
    //---------------------------------------------------------------------------------------------------------------------
    public static boolean canBeDeleted(Common commonForDeleting) throws ModelException {
        boolean result = true;
        int jointsCounter = 0;

        if (commonForDeleting instanceof Currency) {
            int jointsForCurrencyInAccounts = countJoinedAccounts(commonForDeleting, SaveData.getInstance().getAccounts(),true);
            jointsCounter = +jointsForCurrencyInAccounts;
        }
        
        if (commonForDeleting instanceof Account){
            int [] jointsForAccountInTransactions = countJoinedTransactionsAndTranfers(commonForDeleting,SaveData.getInstance().getTransactions(),SaveData.getInstance().getTransfers(),true);
            jointsCounter=+jointsForAccountInTransactions[0]+jointsForAccountInTransactions[1];
        }
        if (commonForDeleting instanceof Article){
            int jointsForArticleInTransactions = countJoinedTransactions(commonForDeleting, SaveData.getInstance().getTransactions(),true);
            jointsCounter=+jointsForArticleInTransactions;
        }
        

        if (jointsCounter != 0) {
            result = false;
        }
//        System.out.println("personalfinance.saveload.SaveData.isNotJoinedCommom()  joints = " + jointsCounter + "; result = " + result);

        return result;
    }
    
    //-------------------------------------------------------------------------------------------------------------------

    private static int countJoinedAccounts(Common commonForDeleting, List<Account> accounts,boolean deletingMode) throws ModelException {
        int result = 0;
        StringBuilder listOfJoinedAccounts = new StringBuilder();

        for (Account account : accounts) {
            //account.getCurrency().setRate(rates.get(account.getCurrency().getCode()));
            if (account.getCurrency().equals(commonForDeleting)) {
                result++;
//                System.out.println("personalfinance.saveload.SaveData.countJoints()" + account.toString());
                listOfJoinedAccounts.append("</center><br><left>").
                        append(Text.get("LABEL_ACCOUNT")).append(" #").append(result).append(".").
                        append(account.getTitle()).
                        append("(").append(account.getAmount()).append(" ").
                        append(account.getCurrency().getTitle()).append("); </left><center>");
            }

        }
        String finalInfo = listOfJoinedAccounts.toString();
//        System.out.println("personalfinance.saveload.SaveData.countJoints() accounts:" + finalInfo);
        if (result != 0 && deletingMode) {
            throw new ModelException(ModelException.IS_JOINED_CURRENCY,finalInfo);            
        }
        return result;
    }
//----------------------------------------------------------------------------------------------------------------------------------
    private static int []countJoinedTransactionsAndTranfers(Common commonForDeleting, List<Transaction> transactions,List<Transfer> transfers,boolean deletingMode) throws ModelException {
        int result = 0;
        int countJointTransaction =0;
        int countJointTransfers =0;
        
        StringBuilder listOfJoinedTransactions = new StringBuilder();

        for (Transaction transaction : transactions) {
            //account.getCurrency().setRate(rates.get(account.getCurrency().getCode()));
            if (transaction.getAccount().equals(commonForDeleting)) {
               countJointTransaction++;
                result++;
//                System.out.println("personalfinance.saveload.SaveData.countJoints()" + transaction.toString());                
            }
        } 
        if(countJointTransaction != 0) {
            listOfJoinedTransactions.append("</center><br><left>").
                    append(Text.get("ERROR_IS_JOINED_QTY_TRANSACTIONS")).append(" #").append(countJointTransaction).
                    append("</left><center>");
        }        
        
        for (Transfer transfer : transfers) {
            //account.getCurrency().setRate(rates.get(account.getCurrency().getCode()));
            if (transfer.getFromAccount().equals(commonForDeleting) || transfer.getToAccount().equals(commonForDeleting) ) {
               countJointTransfers++;
                result++;
//                System.out.println("personalfinance.saveload.SaveData.countJoints()" + transfer.toString());                
            }
        }  
        
        if(countJointTransfers!=0){
            listOfJoinedTransactions.append("</center><br><left>").
                        append(Text.get("ERROR_IS_JOINED_QTY_TRANSFERS")).append(" #").append(countJointTransfers).
                        append("</left><center>");
        }       
        
        String finalInfo = listOfJoinedTransactions.toString();
//        System.out.println("personalfinance.saveload.SaveData.countJoints() accounts:" + finalInfo);
        if (result != 0 && deletingMode) {            
            throw new ModelException(ModelException.IS_JOINED_ACCOUNT, finalInfo);
        }
        return new int []{countJointTransaction,countJointTransfers};
    }
    //----------------------------------------------------------------------------------------------------------------------------------
    private static int countJoinedTransactions(Common commonForDeleting, List<Transaction> transactions,boolean deletingMode) throws ModelException {
        int result = 0;
        int countJointTransaction = 0;

        StringBuilder listOfJoinedTransactions = new StringBuilder();

        for (Transaction transaction : transactions) {
            //account.getCurrency().setRate(rates.get(account.getCurrency().getCode()));
            if (transaction.getArcticle().equals(commonForDeleting)) {
                countJointTransaction++;
                result++;
//                System.out.println("personalfinance.saveload.SaveData.countJoints()" + transaction.toString());                
            }
        }
        if (countJointTransaction != 0) {
            listOfJoinedTransactions.append("</center><br><left>").
                    append(Text.get("ERROR_IS_JOINED_QTY_TRANSACTIONS")).append(" #").append(countJointTransaction).
                    append("</left><center>");
        }

        String finalInfo = listOfJoinedTransactions.toString();
//        System.out.println("personalfinance.saveload.SaveData.countJoints() accounts:" + finalInfo);
        if (result != 0 && deletingMode) {
            throw new ModelException(ModelException.IS_JOINED_ARTICLE, finalInfo);
        }
        return result;
    }
//----------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean canBeEdited(Common commonForEdit, MainFrame frame) throws ModelException {
        boolean result = true;
        int jointsCounter = 0;

        if (commonForEdit instanceof Currency) {
            int jointsForCurrencyInAccounts = countJoinedAccounts(commonForEdit, SaveData.getInstance().getAccounts(),false);
            jointsCounter = +jointsForCurrencyInAccounts;
            int resulCurrency = ConfirmDialog.show(frame, 
                                                   "CONFIRM_EDIT_CURRENCY_TEXT",
                                                   "CONFIRM_EDIT_TITLE",                    
                                                    createInfo("CONFIRM_EDIT_JOINED_QTY_ACCOUNTS",jointsForCurrencyInAccounts));
                    if (resulCurrency == JOptionPane.YES_OPTION) {
                        result = true;
                    }else{
                        result =false;
                    }
        }
        
        if (commonForEdit instanceof Account){
            int [] jointsForAccountInTransactions = countJoinedTransactionsAndTranfers(commonForEdit,SaveData.getInstance().getTransactions(),SaveData.getInstance().getTransfers(),false);
            jointsCounter=+jointsForAccountInTransactions[0]+jointsForAccountInTransactions[1];
            int resulAccount = ConfirmDialog.show(frame, 
                                                "CONFIRM_EDIT_ACCOUNT_TEXT",
                                                "CONFIRM_EDIT_TITLE",
                                                 createInfoTwoInfo("CONFIRM_EDIT_JOINED_QTY_TRANSACTIONS",jointsForAccountInTransactions[0],
                                                                    "CONFIRM_EDIT_JOINED_QTY_TRANSFERS",jointsForAccountInTransactions[1]));
                    if (resulAccount== JOptionPane.YES_OPTION) {
                        result = true;
                    }else{
                        result =false;
                    }
            
        }
        
        if (commonForEdit instanceof Article){
            int jointsForArticleInTransactions = countJoinedTransactions(commonForEdit, SaveData.getInstance().getTransactions(),false);
            jointsCounter=+jointsForArticleInTransactions;
            int resulArticle = ConfirmDialog.show(frame, 
                                                "CONFIRM_EDIT_ARTICLE_TEXT",
                                                "CONFIRM_EDIT_TITLE",                                                    
                                                createInfo("CONFIRM_EDIT_JOINED_QTY_TRANSACTIONS",jointsForArticleInTransactions));
                    if (resulArticle == JOptionPane.YES_OPTION) {
                        result = true;
                    }else{
                        result =false;
                    }
        }
        

//        if (jointsCounter != 0) {
//            result = false;
//        }
//        System.out.println("personalfinance.saveload.SaveData.isNotJoinedCommom()  joints = " + jointsCounter + "; result = " + result);

        return result;
    }

    private static String createInfo(String infoText, int numberOfJoints) {
        
        StringBuilder stringBuilder = new StringBuilder();        
         
        String append2 = "</center><br><left>";
        String append3 = Text.get(infoText);
        String append4 = " #"+numberOfJoints+"</left><center>";
             
        stringBuilder.append(append2).append(append3).append(append4);        
        String dialodText = stringBuilder.toString();
        
        return dialodText;
    }
    
    private static String createInfoTwoInfo( String infoText1, int numberOfJoints1,String infoText2, int numberOfJoints2) {
        
        StringBuilder stringBuilder = new StringBuilder();        
        
        String append2 = "</center><br><left>";
        String append3 = Text.get(infoText1);
        String append4 = " #"+numberOfJoints1+"</left><center>";
        String append5 = "</center><br><left>";
        String append6 = Text.get(infoText2);
        String append7 = " #"+numberOfJoints2+"</left><center>";             
           
        stringBuilder.append(append2).append(append3).append(append4).append(append5).append(append6).append(append7);        
        
        
        
        
        
        String dialodText = stringBuilder.toString();
        
        return dialodText;
    }
    
}


////here we add add text info into the text recieved from  Text.get(text)
//        
//                 
//        String append2 = info;      //adding text of info  
//        stringBuilder.append(append1).append(append2).append("</center></html>");   //we put back </center></html> at the end on buildet text
//        
//        String messageText = stringBuilder.toString();        