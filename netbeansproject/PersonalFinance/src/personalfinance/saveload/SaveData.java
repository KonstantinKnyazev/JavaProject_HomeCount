/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.saveload;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import personalfinance.exception.ModelException;
import personalfinance.model.*;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public class SaveData {

    private static SaveData instance;

    private List<Article> articles = new ArrayList();
    private List<Currency> currencies = new ArrayList();
    private List<Account> accounts = new ArrayList();
    private List<Transaction> transactions = new ArrayList();
    private List<Transfer> transfers = new ArrayList();

    private final Filter filter;
    private Common oldCommon; //для сохранения старого варианта объекта
    private boolean saved = true;  //обновлялись ли данные после сохранения: true -  если данные не обновлялиь; false - если данные обновлялись

    private SaveData() {
        load();
        this.filter = new Filter();
    }

    public void load() {
        SaveLoad.load(this);
        sort();
        //done for test
        for (Account a : accounts) {
            a.setAmountFromTransactionsAndTransfers(transactions, transfers);
        }
    }

    public void clear() {
        accounts.clear();
        articles.clear();
        transactions.clear();
        transfers.clear();
        currencies.clear();
    }

    private void sort() {
        //сортируем статьи и счета по алфавиту с помощью лямбда-выражений ингнорируя большие и маленькие буквы(регистр)
        this.articles.sort((Article a, Article a1) -> a.getTitle().compareToIgnoreCase(a1.getTitle()));
        this.accounts.sort((Account a, Account a1) -> a.getTitle().compareToIgnoreCase(a1.getTitle()));
        //сортируем транзакции и переводыпо дате, самые последние транзакции будут в самом верху (по убыванию)
        this.transactions.sort((Transaction t, Transaction t1) -> (int) (t1.getDate().compareTo(t.getDate())));// int добавил для избежиния ощибки при сортировке, совет Мих. Р.

        this.transfers.sort((Transfer t, Transfer t1) -> (int) (t1.getDate().compareTo(t.getDate())));         // int добавил для избежиния ощибки при сортировке, совет Мих. Р.
        //сортируем валюты по 1. если она базовая, 2. если валюта влючена, 3 по алфавиту
        //не используем лямбда выражения, вместо этого создаём компаратор
        this.currencies.sort(new Comparator<Currency>() {
            @Override
            public int compare(Currency c, Currency c1) {
                if (c.isBase()) {
                    return -1;
                }
                if (c1.isBase()) {
                    return 1;
                }
                if (c.isOn() ^ c1.isOn()) {//Бинарный оператор XOR(^) копирует бит, если он установлен в одном операнде, но не в обоих.
                    if (c1.isOn()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                return c.getTitle().compareToIgnoreCase(c1.getTitle());
            }
        });

    }

    public void save() {
        SaveLoad.save(this);
        saved = true;
    }

    public boolean isSaved() {
        return saved;
    }

    //sigleton
    public static SaveData getInstance() {
        if (instance == null) {
            instance = new SaveData();
        }
        return instance;
    }

    public Filter getFilter() {
        return filter;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setArticles(List<Article> articles) {
        if (articles != null) {
            this.articles = articles;
        }
    }

    public void setCurrencies(List<Currency> currencies) {
        if (currencies != null) {
            this.currencies = currencies;
        }
    }

    public void setAccounts(List<Account> accounts) {
        if (accounts != null) {
            this.accounts = accounts;
        }
    }

    public void setTransactions(List<Transaction> transactions) {
        if (transactions != null) {
            this.transactions = transactions;
        }
    }

    public void setTransfers(List<Transfer> transfers) {
        if (transfers != null) {
            this.transfers = transfers;
        }
    }

    public Currency getBaseCurrency() {
        for (Currency c : currencies) {
            if (c.isBase()) {
                return c;
            }
        }
        return new Currency();
    }

    //возвращает список используемых валют
    public ArrayList<Currency> getEnablesCurrencies() {
        ArrayList<Currency> list = new ArrayList();
        for (Currency c : currencies) {
            if (c.isOn()) {
                list.add(c);
            }
        }
        return list;
    }

    //возвращает отфильтрованные по дате транзакции
    public ArrayList<Transaction> getFilterTransactions() {
        ArrayList<Transaction> list = new ArrayList();
//        System.out.println("personalfinance.saveload.SaveData.getFilterTransactions() transactions.size() = " + transactions.size());
        int i = 0;
        for (Transaction tr : transactions) {
//            System.out.println("personalfinance.saveload.SaveData.getFilterTransactions() counter i = " + (i));
//            System.out.println("personalfinance.saveload.SaveData.getFilterTransactions() data = " + tr.getDate());

            if (filter.check(tr.getDate())) {
//                System.out.println("personalfinance.saveload.SaveData.getFilterTransactions() data = " + tr.getDate());
                list.add(tr);
//                System.out.println("personalfinance.saveload.SaveData.getFilterTransactions() list.size() in for  = " +list.size());
            }
            i++;
        }

//        System.out.println("personalfinance.saveload.SaveData.getFilterTransactions() list.size() = " +list.size());
        return list;
    }

    //возвращает отфильтрованные по дате трансферы/переводы
    public ArrayList<Transfer> getFilterTransfers() {
        ArrayList<Transfer> list = new ArrayList();
        for (Transfer tr : transfers) {
            if (filter.check(tr.getDate())) {
                list.add(tr);
            }
        }
        return list;
    }

    //возвращает последние транзакции
    public ArrayList<Transaction> getTransactionsOnCount(int count) {
        return new ArrayList(transactions.subList(0, Math.min(count, transactions.size())));//выбираем что меньше: заданное кол-во(count) или число транзакций в листе
    }

    public Common getOldCommon() {
        return oldCommon;
    }

    //добавление объекта в массив
    public void add(Common c) throws ModelException {
        List ref = getRef(c);
        if (ref.contains(c)) {
            throw new ModelException(ModelException.IS_EXISTS);
        }
        ref.add(c);//добавляем в массив объект
        c.postAdd(this);
        sort();//заново сортировка
        saved = false;
    }

    //редактирование данных, передаем старое значение объекта и новое значение объекта
    public void edit(Common oldC, Common newC) throws ModelException {
        List ref = getRef(oldC);
        if (ref.contains(newC) && oldC != ref.get(ref.indexOf(newC))) {
            throw new ModelException(ModelException.IS_EXISTS);
        }
        /*
       Проверить: если содержится ли уже такой объект в массиве И старый объект НЕ РАВЕН объекту с индексом как у нового ==> тогда сообщение, что такой объект существует
       Т.е. такой объект есть в массиве, но это не объект который мы будем редактировать.
         */
        ref.set(ref.indexOf(oldC), newC);//получаем индекс старого объекта: ref.indexOf(oldC) и заменяем на новый
        oldCommon = oldC;//инициализируем объект oldCommom который сохранит не измененные данные объекта
        newC.postEdit(this);
        sort();
        saved = false;
    }

    //удаление данных
    public void remove(Common c) {
        getRef(c).remove(c);//получаем лист и сразу удаляем
        c.postRemouve(this);
        saved = false;
    }

    //обновление курсов валют
    public void updateCurrencies() throws Exception {
        HashMap<String, Double> rates = RateCurrency.getRates(getBaseCurrency());
        for (Currency currency : currencies) {
            currency.setRate(rates.get(currency.getCode()));//из массива rates берём курс текущей валюты по ключу currency.getCode(). Этот курс присваиваем текущей валюте
//                System.out.println(currency);
        }
        for (Account account : accounts) {
            account.getCurrency().setRate(rates.get(account.getCurrency().getCode()));
        }
        saved = false;
    }

    //возвращает лист соответствующий типу объекта - аргумента
    private List getRef(Common c) {
        if (c instanceof Account) {
            return accounts;
        } else if (c instanceof Article) {
            return articles;
        } else if (c instanceof Currency) {
            return currencies;
        } else if (c instanceof Transaction) {
            return transactions;
        } else if (c instanceof Transfer) {
            return transfers;
        }
        return null;
    }

    @Override
    public String toString() {
        return "SaveData{" + "articles=" + articles + ", currencies=" + currencies + ", accounts=" + accounts + ", transactions=" + transactions + ", transfers=" + transfers + '}';
    }
    

}//class
