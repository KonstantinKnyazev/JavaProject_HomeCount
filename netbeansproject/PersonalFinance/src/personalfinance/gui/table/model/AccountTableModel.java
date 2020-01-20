/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.table.model;

import personalfinance.model.Account;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Format;

/**
 *
 * @author Konstantin_Knyazev
 */
public class AccountTableModel extends MainTableModel {

    private static final int TITLE = 0;
    private static final int AMOUNT = 1;

    public AccountTableModel(String[] columns) {
        super(SaveData.getInstance().getAccounts(),columns);
//        this.columns = new ArrayList(Arrays.asList(columns));
    }

    @Override
    protected void updateData() {
        data = SaveData.getInstance().getAccounts();

    }

    //  вернуть значение ячейки
    @Override
    public Object getValueAt(int row, int column) {
        //если данных в принципе нет - нуль
        if (data.isEmpty()) {//data from MainTableModel
            return null;
        }
        Account account = (Account) data.get(row);
        switch (column) {
            case TITLE:
                return account.getTitle();
            case AMOUNT:
//                return account.getAmount();
                return Format.amount(account.getAmount(), account.getCurrency());
        }
        return null;
    }

}
