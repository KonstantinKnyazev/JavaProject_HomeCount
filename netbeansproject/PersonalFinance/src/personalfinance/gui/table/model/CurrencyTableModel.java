/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.table.model;

import personalfinance.model.Currency;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Format;

/**
 *
 * @author Konstantin Knyazev
 */
public class CurrencyTableModel extends MainTableModel {

    private static final int TITLE = 0;    
    private static final int CODE = 1;    
    private static final int RATE = 2;    
    private static final int ON = 3;    
    private static final int BASE = 4;    

    public CurrencyTableModel(String[] columns) {
        super(SaveData.getInstance().getCurrencies(),columns);
//        this.columns = new ArrayList(Arrays.asList(columns));
    }

    @Override
    protected void updateData() {
        data = SaveData.getInstance().getCurrencies();

    }

    //  вернуть значение ячейки
    @Override
    public Object getValueAt(int row, int column) {
        //если данных в принципе нет - нуль
        if (data.isEmpty()) {//data from MainTableModel
            return null;
        }
        Currency currency = (Currency) data.get(row);
        switch (column) {
            case TITLE:
                return currency.getTitle();            
            case CODE:
                return currency.getCode();            
            case RATE:
                return Format.rate(currency.getRate(),SaveData.getInstance().getBaseCurrency());            
            case ON:
                return Format.yesNo(currency.isOn());
            case BASE:
                return Format.yesNo(currency.isBase());          
        }
        return null;
    }

}
