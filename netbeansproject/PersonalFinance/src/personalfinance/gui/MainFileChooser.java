/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import personalfinance.settings.Settings;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public class MainFileChooser extends JFileChooser {

    private final MainFrame frame;

    public MainFileChooser(MainFrame frame) {
        this.frame = frame;
        //filter
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Konstantin Knyazev Files", Settings.SAVE_FILE_EXT); //open only files with my extention
        setFileFilter(filter);//set this filter to FileChooser
        setAcceptAllFileFilterUsed(false);//forbid to change extention of file to open for user
        setCurrentDirectory(Settings.SAVE_DIR);//to open our directory
        
        UIManager.put("FileChooser.openDialogTitleText",Text.get("FC_OPEN"));
        UIManager.put("FileChooser.saveDialogTitleText",Text.get("FC_SAVE"));
        UIManager.put("FileChooser.lookInLabelText",Text.get("FC_LOOK"));
        UIManager.put("FileChooser.saveInLabelText",Text.get("FC_LOOK"));
        
        
        UIManager.put("FileChooser.openButtonText",Text.get("FC_OPEN"));
        UIManager.put("FileChooser.openButtonToolTipText",Text.get("FC_OPEN"));
        
        UIManager.put("FileChooser.saveButtonText",Text.get("FC_SAVE"));
        UIManager.put("FileChooser.saveButtonToolTipText",Text.get("FC_SAVE"));
        
        UIManager.put("FileChooser.cancelButtonText",Text.get("FC_CANCEL"));
        UIManager.put("FileChooser.cancelButtonToolTipText",Text.get("FC_CANCEL"));
        
        
        UIManager.put("FileChooser.fileNameLabelText",Text.get("FC_NAME_FILE"));
        UIManager.put("FileChooser.filesOfTypeLabelText",Text.get("FC_TYPE_FILE"));
        
        UIManager.put("FileChooser.upFolderToolTipText",Text.get("FC_UP"));        
        UIManager.put("FileChooser.homeFolderToolTipText",Text.get("FC_HOME"));//not worked
        UIManager.put("FileChooser.newFolderToolTipText",Text.get("FC_NEW_DIRECTORY"));        
        UIManager.put("FileChooser.listViewButtonToolTipText",Text.get("FC_LIST"));
        UIManager.put("FileChooser.detailsViewButtonToolTipText",Text.get("FC_TABLE"));
        
//        UIManager.put("FileChooser.fileNameHeaderText","TEST");//not worked
        UIManager.put("FileChooser.fileNameHeaderText",Text.get("FC_NAME"));//not worked
        UIManager.put("FileChooser.fileSizeHeaderText",Text.get("FC_SIZE"));//not worked
        UIManager.put("FileChooser.fileTypeHeaderText",Text.get("FC_TYPE"));//not worked
        UIManager.put("FileChooser.fileDateHeaderText",Text.get("FC_DATE"));//not worked
        UIManager.put("FileChooser.fileAttrHeaderText",Text.get("FC_ATTR"));//not worked
        
        UIManager.put("FileChooser.acceptAllFileFilterText",Text.get("FC_ALL_FILTER"));
        
        updateUI();//чтобы изменения вступили в силу
        
    }

    public int openFileChooserDialog() {
        return super.showOpenDialog(frame);
    }
    
    public int saveFileChooserDialog() {
        return super.showSaveDialog(frame);
    }
    
    
}
