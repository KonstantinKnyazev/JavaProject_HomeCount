/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
//import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import personalfinance.exception.ModelException;
import personalfinance.gui.MainFrame;
import personalfinance.model.*;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Settings;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public class PersonalFinance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        init();
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        
        Style.setToolTip();
        
//        Locale currentLocale = Locale.getDefault();
//        ResourceBundle bundle = ResourceBundle.getBundle("Translate", currentLocale);  
        
        SaveData sd = SaveData.getInstance();
//        sd.updateCurrencies();
//        sd.save();
//        System.out.println(sd.getCurrencies());//проверяли валюту
        System.out.println(sd);

//        testModel();
        //System.out.println(Format.dateMonth(new Date()));
        //System.out.println(Text.get("PROGRAMM_NAME"));
        //System.out.println(Arrays.toString(Text.getMonths()));
    }//main 
    
    private static void init(){
       
        Settings.init();
        Settings.save();
        
        
        
        //инициализация текстовых констант
        
        Text.init();
        //инициализация шрифта из папки fonts
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Settings.FONT_ROBOTO_LIGHT));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(PersonalFinance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void testModel() throws ModelException {
        Currency c1 = new Currency("Ruble", "RUB", 1, true, true);
        Currency c2 = new Currency("Dollar", "USD", 65, true, false);
        Currency c3 = new Currency("Euro", "EUR", 75, false , false);
        Currency c4 = new Currency("Grivna", "UAH", 2.5, false , false);
        
        Account ac1 = new Account("Portemonet", c1, 1000);
        Account ac2 = new Account("Visa-cart", c1, 0);
        Account ac3 = new Account("Bank-deposit(RUB)", c1, 100000);
        Account ac4 = new Account("Bank-deposit(USD)", c2, 0);
        
        Article article1 =  new Article("Foods");
        Article article2 =  new Article("Home");
        Article article3 =  new Article("Salary");
        Article article4 =  new Article("Resto");
        Article article5 =  new Article("Deposits %");
        
        ArrayList<Currency>currencies = new ArrayList();
        currencies.add(c1);
        currencies.add(c2);
        currencies.add(c3);
        currencies.add(c4);
        
        ArrayList<Account>accounts = new ArrayList();
        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);
        accounts.add(ac4);
        
        ArrayList<Article>articles = new ArrayList();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);
        
        ArrayList<Transaction>transactions = new ArrayList();
        transactions.add(new Transaction(ac2, article3, 30000));//зарплата
        transactions.add(new Transaction(ac2, article1, -1500,"for weekend"));
        transactions.add(new Transaction(ac1, article2, -5500,"first home payment "));
        transactions.add(new Transaction(ac1, article2, -4000,"second home payment "));
        transactions.add(new Transaction(ac3, article5, 1000));//проценты по депозиту
        transactions.add(new Transaction(ac2, article3, 25000, new Date((new Date()).getTime()-(long)86400000*30)));//зарплата месяц назад
        transactions.add(new Transaction(ac3, article5, 1000, new Date((new Date()).getTime()-(long)86400000*30)));//проценты по депозиту месяц назад. 86 400 000 кол-во милисекунд в сутках
        
        //добавляем случайные транзакции
        for (int i = 0; i < 50; i++) {//организуем цикл
            //инициализируем переменные для конструктора
            Article     tempArticle;
            Account     tempAccount;
            double      tempAmount;
            Date        tempDate;
            //случайный выбор между article1="Foods" и article4="Resto"
            if (Math.random() < 0.5) {
                tempArticle = article1;
            } else {
                tempArticle = article4;
            }
            //случайный выбор между ac1="Portemonet" и ac2="Visa-cart"
            if (Math.random() < 0.5) {
                tempAccount = ac1;
            } else {
                tempAccount = ac2;
            }
            //случайный выбор суммы от 0 до 1000
            tempAmount = Math.round(Math.random() * (-1000));
            //случайный выбор даты от сегоднешнего дня до месячной давности
            tempDate = new Date((long) (new Date().getTime() - (long) 86400000 * 30 * Math.random()));
            //конструктор случайной транзакции
            transactions.add(new Transaction(tempAccount, tempArticle, tempAmount, tempDate));
        }

        ArrayList<Transfer>transfers= new ArrayList();
        transfers.add(new Transfer(ac2, ac1, 25000, 25000));
        transfers.add(new Transfer(ac2, ac3, 3000, 3000));
        transfers.add(new Transfer(ac2, ac4, 6000, 90));
        
        
        for(Account a: accounts){
            a.setAmountFromTransactionsAndTransfers(transactions, transfers);
        }
        
        SaveData sd = SaveData.getInstance();
        sd.setArticles(articles);
        sd.setAccounts(accounts);
        sd.setCurrencies(currencies);
        sd.setTransactions(transactions);
        sd.setTransfers(transfers);
        sd.save();
        //sd.load();        
        System.out.println(sd);
    }//test model method
    
}//class
