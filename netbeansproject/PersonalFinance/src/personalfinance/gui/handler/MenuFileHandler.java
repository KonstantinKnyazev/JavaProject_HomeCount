/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.handler;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import personalfinance.gui.MainFileChooser;
import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.ConfirmDialog;
import personalfinance.gui.dialog.ErrorDialog;
import personalfinance.saveload.SaveData;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Settings;

/**
 *
 * @author Konstantin_Knyazev
 */
public class MenuFileHandler extends Handler {

    private final MainFileChooser fileChooser;

    public MenuFileHandler(MainFrame frame) {
        super(frame);
        fileChooser = new MainFileChooser(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        switch (ae.getActionCommand()) {
            case HandlerCode.MENU_FILE_NEW: {
                //файл который мы сохраняем должен стать не (personalfinance.settings.Settings) private static  File FILE_SAVE = new File("saves/default.kkv");
                //а нулевым по сути
                Settings.setFileSave(null);//абсолютно пустой файл которого даже ещё нет
                //очистить абсолютно все данные в SaveData
                SaveData.getInstance().clear();

                break;
            }
            case HandlerCode.MENU_FILE_OPEN: {
                int result = fileChooser.openFileChooserDialog();
                //проверить что пользователь выбрал
                if (result == JFileChooser.APPROVE_OPTION) {//если пользователь выбрал что-то, какой-то файл
                    //при загрузке несохраненные данные могут быть потеряны, поэтому проверяем сохранены ли данные
                    if (SaveData.getInstance().isSaved()) {//если сохранены
                        executeLoad();
//                        Settings.setFileSave(fileChooser.getSelectedFile());//отсюда будет загружаться SаveDаta
//                        SaveData.getInstance().clear();
//                        SaveData.getInstance().load();//загружаем выбранный файл в SаveDаta
                    } else {//если не сохранены
                        int resultOverLoad = ConfirmDialog.show(frame, "CONFIRM_OVERLOAD_TEXT", "CONFIRM_OVERLOAD_TITLE");
                        if (resultOverLoad == JOptionPane.YES_OPTION) {
                            executeLoad();
                        }
                    }
                }
                break;
            }

            case HandlerCode.MENU_FILE_SAVE: {
                //существует ли файл в настройках
                if (Settings.getFileSave() == null) {//файл для сохранения не существует
                    int result = fileChooser.saveFileChooserDialog();
                    if (result == JFileChooser.APPROVE_OPTION) {//пользователь набрал имя файла
                        //какое расширение указал пользователь
                        //имеем имя файла с расширением
                        String path = fileChooser.getSelectedFile().getAbsolutePath();
                        //выделяем расширение
                        String ext = path.substring(path.lastIndexOf(".") + 1);//we searsh last "." and we take all sings after, begining +1 after "." ex: rese.hrr.tgsa => ext= tgsa
                        if (ext.equals(Settings.SAVE_FILE_EXT)) {//расширение правильное
                            Settings.setFileSave(new File(path));//создаем файл для сохранения с именем и правильным расширением, которые выбрал пользователь
                        } else {                                //расширение неправильное или нет расширения
                            Settings.setFileSave(new File(path + "." + Settings.SAVE_FILE_EXT));//создаем файл для сохранения с именем и правильным расширением в добавление к пользовательскому имени
                        }
                    }
                }
                //если файл существует 
                if (Settings.getFileSave() != null) {//файл для сохранения существует
                    //сохранить SaveData
                    SaveData.getInstance().save();//важно чтобы эта процедура не выполнялась если пользователь не выбрал никакой файл
                }
                break;
            }
            case HandlerCode.MENU_FILE_UPDATE_CURRENCIES: {
                try {
                    SaveData.getInstance().updateCurrencies();
                } catch (Exception ex) {
                    ErrorDialog.show(frame, "ERROR_UPDATE_CURRENCIES");
                }
                break;
            }
            case HandlerCode.MENU_FILE_EXIT: {
                //если данные сохранены
                if (SaveData.getInstance().isSaved()) {
                    System.exit(0);
                } else {//если не сохранены
                    int result = ConfirmDialog.show(frame, "CONFIRM_EXIT_TEXT", "CONFIRM_EXIT_TITLE");
                    if (result == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
                break;
            }
        }
        super.actionPerformed(ae);
    }

    private void executeLoad() {
        Settings.setFileSave(fileChooser.getSelectedFile());//отсюда будет загружаться SаveDаta
        SaveData.getInstance().clear();
        SaveData.getInstance().load();//загружаем выбранный файл в SаveDаta
    }

    
}
