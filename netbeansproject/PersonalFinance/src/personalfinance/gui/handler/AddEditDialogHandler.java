/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.handler;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import personalfinance.exception.ModelException;
import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.AddEditDialog;
import personalfinance.gui.dialog.ErrorDialog;
import personalfinance.saveload.SaveData;
import personalfinance.settings.HandlerCode;

/**
 *
 * @author Konstantin_Knyazev
 */
public class AddEditDialogHandler extends Handler implements KeyListener, WindowListener {

    private final AddEditDialog dialog;

    public AddEditDialogHandler(MainFrame frame, AddEditDialog dialog) {
        super(frame);
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
            switch (ae.getActionCommand()) {//analise of event
                case HandlerCode.ADD:
                    addEdit(true);                    
                    break;
                case HandlerCode.EDIT:
                    addEdit(false);                    
                    break;
                case HandlerCode.CANCEL:
                    closeDialog();                 
            }            
            super.actionPerformed(ae);
        } 

    
    
    private void addEdit(boolean add) {
        try {
            if (add) {
                SaveData.getInstance().add(dialog.getCommonFromForm());
            } else {
                SaveData.getInstance().edit(dialog.getCommon(), dialog.getCommonFromForm());//old entity - dialog.getCommon() and new entity - dialog.getCommonFromForm()
            }
            closeDialog();
        } catch (ModelException ex) {
            ErrorDialog.show(frame, ex.getMessage());
        }

    }

//    private void add() throws ModelException {
//        SaveData.getInstance().add(dialog.getCommonFromForm());
//    }
//    
//    private void edit() throws ModelException {
//        SaveData.getInstance().edit(dialog.getCommon(), dialog.getCommonFromForm());//old entity - dialog.getCommon() and new entity - dialog.getCommonFromForm()
//    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
            addEdit(dialog.isAdd());
            
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

    private void closeDialog() {
        dialog.closeDialog();
    }

    

}
