/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.table.model;

import personalfinance.model.Transaction;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Format;

/**
 *
 * @author Konstantin_Knyazev
 */
public class TransactionTableModel extends MainTableModel {

    private static final int DATE = 0;
    private static final int ACCOUNT = 1;
    private static final int ARTICLE = 2;
    private static final int AMOUNT = 3;
    private static final int NOTICE = 4;

    private int count = -1;//индикатор который будет показывать какой тип конструктора используется

    //конструктор использующий фильтрованные транзакции
    public TransactionTableModel(String[] columns) {
        super(SaveData.getInstance().getFilterTransactions(),columns);
//        this.columns = new ArrayList(Arrays.asList(columns));
    }

    //конструктор использующий посление транзакции транзакции
    public TransactionTableModel(String[] columns, int count) {
        super(SaveData.getInstance().getTransactionsOnCount(count),columns);
//        this.columns = new ArrayList(Arrays.asList(columns));
        this.count = count;
    }

    @Override
    protected void updateData() {
        if (count == -1) {
            data = SaveData.getInstance().getFilterTransactions();
        } else {
            data = SaveData.getInstance().getTransactionsOnCount(count);
        }
    }

    //  вернуть значение ячейки
    @Override
    public Object getValueAt(int row, int column) {
        //если данных в принципе нет - нуль
        if (data.isEmpty()) {//data from MainTableModel
            return null;
        }
        Transaction transaction = (Transaction) data.get(row);
        switch (column) {
            case DATE:
                return Format.date(transaction.getDate());
            case ACCOUNT:
                return transaction.getAccount().getTitle();
            case ARTICLE:
                return transaction.getArcticle().getTitle();
            case AMOUNT:
                return Format.amount(transaction.getAmount(),transaction.getAccount().getCurrency());              
            case NOTICE:
                return transaction.getNotice();
        }
        return null;
    }

}
