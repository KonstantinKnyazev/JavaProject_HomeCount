/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.model;

import java.util.Objects;
import personalfinance.exception.ModelException;
import personalfinance.saveload.SaveData;

/**
 *
 * @author Konstantin_Knyazev
 */
public class Currency extends Common{
    
    private String title;
    private String code;
    private double rate;//курс
    private boolean on;//включена или нет
    private boolean  base;//базовая или нет

    public Currency() {
    }

    public Currency(String title, String code, double rate, boolean on, boolean base) throws ModelException {
        
        if (title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        if (code.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        if (rate <= 0) throw new ModelException(ModelException.RATE_INCORRECT);
        
        this.title = title;
        this.code = code;
        this.rate = rate;
        this.on = on;
        this.base = base;        
        if (this.base)this.on= true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public boolean isBase() {
        return base;
    }

    public void setBase(boolean base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "Currency{" + "title=" + title + ", code=" + code + ", rate=" + rate + ", isOn=" + on + ", isBase=" + base + '}';
    }

    //валюта сравнивается по коду валюты, если код совпадает значит валюта одна и та же
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.code);
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
        final Currency other = (Currency) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String getValueForComboBox() {
        return title;
    }
     
    //получения курса этой валюты к курсу валюты - аргумента метода
    public double getRateByCurrency(Currency currency) {
        return rate / currency.rate;
    }       

    @Override
    public void postAdd(SaveData sd) {
        clearBase(sd);
    }
    
    @Override
    public void postEdit(SaveData sd) {
        clearBase(sd);
        for (Currency c : sd.getCurrencies()) {
            for (Account a : sd.getAccounts()) {
                if (a.getCurrency().equals(c)) {
                    a.setCurrency(c);//заменяем старую валюту на новую
                }
                //---------------
                for (Transaction t : sd.getTransactions())//перебираем транзакции
                {
                    if (t.getAccount().getCurrency().equals(c)) {//from transaction we take currency and check equals, after we change for  new currency
                        t.getAccount().setCurrency(c);//если счет был эквивалентен "старому" счету заменяем его на новый
                    }
                }
                for (Transfer t : sd.getTransfers()) {//перебираем все переводы
                    if (t.getFromAccount().getCurrency().equals(c)) {//если currency (FromAccount) был эквивалентен "старому"  currency заменяем его на новый
                        t.getFromAccount().setCurrency(c);
                    }
                    if (t.getToAccount().getCurrency().equals(c)) {//если currency(ToAccount) был эквивалентен "старому" currency заменяем его на новый
                        t.getToAccount().setCurrency(c);
                    }
                }

            }
        }
    }

    //если мы ставим у данной валюты параметр base = true, то мы должны стереть его у другой валюты, которая была базовой
    private void clearBase(SaveData sd) {
        if (base) {                                         //проверяем является ли эта валюта базовой
            rate = 1;                                       //ставим её курс = 1 т.к. расчёты будут совершаться в базовой валюте
            Currency old = (Currency) sd.getOldCommon();    //получаем старую валюту
            for (Currency c : sd.getCurrencies()) {         //перебираем все валюты в списке валют
                if (!this.equals(c)) {                      //если выбранная валюта (с) не эквивалентна этой (this) мы будем ее обновлять
                    c.setBase(false);                       //выбранная валюта (с)не является базовой т.к. базовая валюта это (this)
                    if (old != null) {                      //ситуация возможна если мы в самом начале работы программы и никаких других значений не было
                        c.setRate(c.rate / old.rate);       //пересчитываем коэффицэнт выбранной валюты (с) используя старый курс текущей валюты (old.rate)
                    }
                }
            }
        }
    }
    
    
    
    
}//class

