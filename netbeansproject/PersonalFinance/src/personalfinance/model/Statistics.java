/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.model;

import java.util.HashMap;
import java.util.List;
import personalfinance.saveload.SaveData;

/**
 *
 * @author Konstantin_Knyazev
 */
public class Statistics {
    
    //сумма счетов для одной валюты
    public static double getBalanceCurrency(Currency currency) {
        SaveData sd = SaveData.getInstance();
        double amount = 0;
        for (Account account : sd.getAccounts()) {
            if (currency.equals(account.getCurrency())) {
                amount += account.getAmount();
            }
        }
        return amount;
    }
    
    //сумма счетов в разных валютах на базе одной
    public static  double getBalance(Currency currency){
     SaveData sd = SaveData.getInstance();
        double amount = 0;
        for (Account account : sd.getAccounts()) {
            amount +=account.getAmount() * account.getCurrency().getRateByCurrency(currency);
        }
        return amount;
    }
    
    //для гистограмм по доходным статьям
    public static HashMap<String, Double> getDataForChartOnIncomeArticles() {
        return getDataForChartOnArticles(true);
    }

    //для гистограмм по расходным статьям
    public static HashMap<String, Double> getDataForChartOnEpxArticles() {
        return getDataForChartOnArticles(false);
    }
    
    //для гистограммы по статьям
    private static HashMap<String, Double> getDataForChartOnArticles(boolean income) {
//        List<Transaction> transactions = SaveData.getInstance().getTransactions();
        List<Transaction> transactions = SaveData.getInstance().getFilterTransactions();
        HashMap<String, Double> data = new HashMap();

        for (Transaction t : transactions) {
            if ((income && t.getAmount() > 0) || (!income && t.getAmount() < 0)) {

                String key_article_title = t.getArcticle().getTitle();
                double summa = 0;
                double amount = t.getAmount();
                if (!income) {
                    amount *= -1;
                }
                if (data.containsKey(key_article_title)) {
                    summa = data.get(key_article_title);
                }
                summa += amount * t.getAccount().getCurrency().getRateByCurrency(SaveData.getInstance().getBaseCurrency());
                data.put(key_article_title, round(summa));
            }
        }
        return data;
    }

    //округление до двух знаков
    private static Double round(double value) {
        return (double) Math.round(value * 100) / 100;
    }
    
}//class
