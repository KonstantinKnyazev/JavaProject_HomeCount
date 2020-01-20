/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.handler;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import personalfinance.exception.ModelException;
import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.AddEditDialog;
import personalfinance.gui.dialog.ConfirmDialog;
import personalfinance.gui.dialog.ErrorDialog;
import personalfinance.gui.table.TableData;
import personalfinance.gui.table.model.MainTableModel;
import personalfinance.model.Common;
import personalfinance.model.Currency;
import personalfinance.saveload.Checker;
import personalfinance.saveload.SaveData;
import personalfinance.settings.HandlerCode;

/**
 *
 * @author Konstantin_Knyazev
 */
public class FunctionsHandler extends Handler implements MouseListener, KeyListener {

    //удалять строки
    //выводить диалоговые окна
    private final AddEditDialog dialog;

    public FunctionsHandler(MainFrame frame, AddEditDialog dialog) {
        super(frame);
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {//analise of event
            case HandlerCode.ADD:
                add();
                break;
            case HandlerCode.EDIT: {
                try {
                    edit();
                } catch (ModelException ex) {
                    ErrorDialog.show(frame, ex.getMessage(), ex.getInfo());
                }
            }
            break;
            case HandlerCode.DELETE: {
                try {
                    delete();
                } catch (ModelException ex) {
                    ErrorDialog.show(frame, ex.getMessage(), ex.getInfo());
                }
            }
            break;
        }
        super.actionPerformed(ae);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() instanceof TableData) {//if we clicked on the space of table
            if (me.getClickCount() == 2 && me.getButton() == MouseEvent.BUTTON1) {
                try {
                    //double left click
//                showAddEditDialog(getSelectedCommon());//edit dialog
                    edit();
                } catch (ModelException ex) {
                    ErrorDialog.show(frame, ex.getMessage(), ex.getInfo());
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() instanceof TableData) {//if we clicked on the space of table
            if (me.getButton() == MouseEvent.BUTTON3)//right button pressed
            {
                TableData td = frame.getRightPanel().getTableData();
                int row = td.rowAtPoint(me.getPoint());
                td.setRowSelectionInterval(row, row);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}

    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                delete();
            } catch (ModelException ex) {
                 ErrorDialog.show(frame, ex.getMessage(),ex.getInfo());
            }
            frame.refresh();
//            //to return focus to table
//            frame.getRightPanel().getTableData().requestFocus();
        }
    }

    public void add() {
        //show dialog
        showAddEditDialog(null);
    }

    public void edit() throws ModelException {
        
        if (Checker.canBeEdited(getSelectedCommon(),frame)) {
            showAddEditDialog(getSelectedCommon());
        }
        //show dialog
        //we need to determine whith line, object, record was selected. We will recieve Common to sent like parameter for method showAddEditDialog(Common c)
        
    }

    public void delete() throws ModelException {
        //we need to determine whith line, object, record was selected. 
        Common commonForDeleting = getSelectedCommon();
        if (commonForDeleting != null) {
            if (Checker.canBeDeleted(commonForDeleting)) {
                //check if common for delete is base Currency
//            if (commonForDeleting.getClass() == SaveData.getInstance().getCurrencies().get(0).getClass()   ) {//if is currency
//                if (((Currency) commonForDeleting).isBase()) {//if is base currency
                if (commonForDeleting.getClass() == SaveData.getInstance().getCurrencies().get(0).getClass() && ((Currency) commonForDeleting).isBase()) {//if is currencyif && is base currency

                    throw new ModelException(ModelException.IS_BASE_CURRENCY);//base Currency we can't to delete
//                }
                } else {//is not base currency
                    int result = ConfirmDialog.show(frame, "CONFIRM_DELETE_TEXT", "CONFIRM_DELETE_TITLE");
                    if (result == JOptionPane.YES_OPTION) {
                        SaveData.getInstance().remove(commonForDeleting);
                    }
                }
            }

        }
    }

    //to recieve seleted entity
    private Common getSelectedCommon() throws ModelException{
        TableData td = frame.getRightPanel().getTableData();
        int selectedRow = td.getSelectedRow();        
        Common c = ((MainTableModel)td.getModel()).getCommonByRow(selectedRow);
        return c;
    }
    
    //Common c - object that we will edit, if Common c == null, we will add a new object Common
    private void showAddEditDialog(Common c) {
        dialog.setCommon(c);
        dialog.showDialog();
    }

    
    
    

}
