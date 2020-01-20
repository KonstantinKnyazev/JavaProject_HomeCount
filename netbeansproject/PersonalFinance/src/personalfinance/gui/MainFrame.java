/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import personalfinance.gui.handler.MainToolBarHandler;
import personalfinance.gui.handler.MainWindowHandler;
import personalfinance.gui.menu.MainMenu;
import personalfinance.gui.panel.LeftPanel;
import personalfinance.gui.panel.OverviewPanel;
import personalfinance.gui.panel.RightPanel;
import personalfinance.gui.toolbar.MainToolBar;
import personalfinance.settings.*;

/**
 *
 * @author Konstantin_Knyazev
 */
public class MainFrame extends JFrame implements Refresh {

    private GridBagConstraints constraints;
    private final MainMenu menuBar;
    private final LeftPanel leftPanel;
    private RightPanel rightPanel;
    
    private final MainToolBar toolBar;

    public MainFrame() {
        super(Text.get("PROGRAMM_NAME"));//заголовок окна

//       тестирование окна валют
//        CurrencyAddEditDialog temp =  new CurrencyAddEditDialog(this);
//        temp.setCommon(SaveData.getInstance().getBaseCurrency());
//          temp.showDialog();
//        new CurrencyAddEditDialog(this).showDialog();//test
//        new TransferAddEditDialog(this).showDialog();//test
//        new TransactionAddEditDialog(this).showDialog();//test
//         тестирование диалог-окна счёт
//        AccountAddEditDialog tempDialog = new AccountAddEditDialog(this);
//        try {
//            tempDialog.setCommon(new Account("count name", new Currency("Dollar US", "USD", 50, true, false), 100));
//        } catch (ModelException ex) {
//            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        tempDialog.showDialog();
//        new AccountAddEditDialog(this).showDialog();//тестирование диалог-окна счёт
//        new ArticleAddEditDialog(this).showDialog();//тестирование диалог-окна статья
//        new AboutDialog().setVisible(true);
//        ConfirmDialog.show(this, "TEXT_DIALOG", "TITLE");
//        System.out.println(ConfirmDialog.show(this, "TEXT_DIALOG", "TITLE"));//только для теста чтобы посмотреть какие константы возвращает функция saveFileChooserDialog()
//        ErrorDialog.show(this, "OOOOOOO!");
//        mainFileChooser test
//        MainFileChooser fc =  new MainFileChooser(this);
//        fc.saveFileChooserDialog();
//        System.out.println(fc.openFileChooserDialog());//только для теста чтобы посмотреть какие константы возвращает функция saveFileChooserDialog()
//       end mainFileChooser test 
        setResizable(false);//нельзя менять размер
        setIconImage(Style.ICON_MAIN.getImage());
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//временный вариант. при закрытии окна выход из программы
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        menuBar = new MainMenu(this);
        setJMenuBar(menuBar);

        setLayout(new GridBagLayout());//гибкая структура для дальнейшего размещения интерфейса

        constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;

        toolBar = new MainToolBar(new MainToolBarHandler(this));
        add(toolBar, constraints);

        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH;
        
        //add(new FunctionsToolBar(), constraints);//для теста
        //add(new MainDatePicker().getDatePicker(),constraints);//для теста

        leftPanel = new LeftPanel(this);
        add(leftPanel, constraints);
        
        setRightPanel(new OverviewPanel(this));
//        setRightPanel(new AccountPanel(this));
//        setRightPanel(new ArticlePanel(this));
//        setRightPanel(new TransactionPanel(this));
//        setRightPanel(new TransferPanel(this));
//        setRightPanel(new CurrencyPanel(this));
//        setRightPanel(new StatisticsPanel(this));
        
        
        pack();

        setLocationRelativeTo(null);
        
        //set handler for close button
        addWindowListener(new MainWindowHandler());

    }

    @Override
    public void refresh() {
        SwingUtilities.updateComponentTreeUI(this);//обновляем фрэйм при загрузке
        menuBar.refresh();
        leftPanel.refresh();
        rightPanel.refresh();
        toolBar.refresh();//07112019
        
        pack();
    }

    public MainMenu getMenu() {
        return menuBar;
    }

    public void setRightPanel(RightPanel panel) {
        if (rightPanel!=null)remove(rightPanel);
        constraints.gridy =1;
        constraints.gridx =1;
        rightPanel = panel;        
        //panel.setBorder(Style.BORDER_PANEL);
        rightPanel.setBorder(Style.BORDER_PANEL);
        add(rightPanel,constraints);
        pack();
        
    }

    public RightPanel getRightPanel() {
        return rightPanel;
    }

    

}//class
