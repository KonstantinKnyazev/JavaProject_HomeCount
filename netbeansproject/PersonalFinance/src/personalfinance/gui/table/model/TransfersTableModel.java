/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.table.model;

import personalfinance.model.Transfer;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Format;

/**
 *
 * @author Konstantin_Knyazev
 */
public class TransfersTableModel extends MainTableModel {

    private static final int DATE = 0;
    private static final int FROM_ACCOUNT = 1;
    private static final int TO_ACCOUNT = 2;
    private static final int FROM_AMOUNT = 3;
    private static final int TO_AMOUNT = 4;
    private static final int NOTICE = 5;

   

    //конструктор использующий фильтрованные transfers
    public TransfersTableModel(String[] columns) {
        super(SaveData.getInstance().getFilterTransfers(),columns);
//        this.columns = new ArrayList(Arrays.asList(columns));
    }

    

    @Override
    protected void updateData() {
        
            data = SaveData.getInstance().getFilterTransfers();
        
    }

    //  вернуть значение ячейки
    @Override
    public Object getValueAt(int row, int column) {
        //если данных в принципе нет - нуль
        if (data.isEmpty()) {//data from MainTableModel
            return null;
        }
        Transfer transfer = (Transfer) data.get(row);
        switch (column) {
            case DATE:
                return Format.date(transfer.getDate());
            case FROM_ACCOUNT:
                return transfer.getFromAccount().getTitle();
            case TO_ACCOUNT:
                return transfer.getToAccount().getTitle();            
            case FROM_AMOUNT:
                return Format.amount(transfer.getFromAmount(),transfer.getFromAccount().getCurrency());                
            case TO_AMOUNT:
                return Format.amount(transfer.getToAmount(),transfer.getToAccount().getCurrency());
            case NOTICE:
                return transfer.getNotice();
        }
        return null;
    }

}
