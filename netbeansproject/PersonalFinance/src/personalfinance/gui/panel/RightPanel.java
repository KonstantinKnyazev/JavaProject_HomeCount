/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.panel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import personalfinance.gui.EnableEditDelete;
import personalfinance.gui.MainFrame;
import personalfinance.gui.Refresh;
import personalfinance.gui.table.TableData;
import personalfinance.gui.toolbar.AbstractToolbar;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
abstract public class RightPanel extends AbstractPanel {

    protected TableData tableData;

    private String title;
    private ImageIcon icon;
    private JPanel[] panels;
    private String tooltip;

    public RightPanel(MainFrame frame, TableData tableData, String title, String tooltip, ImageIcon icon, JPanel[] panels) {
        super(frame);
        this.tableData = tableData;
        this.title = title;
        this.icon = icon;
        this.panels = panels;
        this.tooltip = tooltip;
        init();
    }

    //не содержит подсказок
    public RightPanel(MainFrame frame, TableData tableData, String title, ImageIcon icon, JPanel[] panels) {
        this(frame, tableData, title, "",icon, panels);
    }

    //содежит не массив панелей а один toolbar
    public RightPanel(MainFrame frame, TableData tableData, String title, ImageIcon icon, AbstractToolbar toolBar) {
        this(frame, tableData, title, "",icon, new JPanel[]{toolBar});//abstract public class AbstractToolbar extends JPanel implements Refresh
    }
    
    //содежит не массив панелей а один toolbar and tool tip
    public RightPanel(MainFrame frame, TableData tableData, String title, String tooltip,ImageIcon icon, AbstractToolbar toolBar) {
        this(frame, tableData, title, tooltip, icon, new JPanel[]{toolBar});//abstract public class AbstractToolbar extends JPanel implements Refresh
    }

    //не содержит никаких панелей
    public RightPanel(MainFrame frame, TableData tableData, String title, ImageIcon icon) {
        this(frame, tableData, title,"", icon, new JPanel[]{});//abstract public class AbstractToolbar extends JPanel implements Refresh
    }
    
    //не содержит никаких панелей
    public RightPanel(MainFrame frame, TableData tableData, String title, String tooltip,ImageIcon icon) {
        this(frame, tableData, title,tooltip, icon, new JPanel[]{});//abstract public class AbstractToolbar extends JPanel implements Refresh
    }

    public void setPanels(JPanel[] panels) {
        this.panels = panels;
    }  
    
    //refresh overrigt т.к. не отрисуются заново  тааблицы    
    @Override
    public void refresh() {
        super.refresh();
        if (tableData != null) {//если существует
            tableData.refresh();
        }
        for (JPanel panel : panels) {
            if (panel instanceof Refresh) {//если они поддрерживают интерфейс
                ((Refresh) panel).refresh();
            }
        }
    }

    //будет, в зависимости от того выделен или не выделен какой-то пункт,отвечать за вкл-выкл доступность пунктов меню
    private void enableEditDelete() {
        for (JPanel panel : panels) {//проверяем панели
            if (panel instanceof EnableEditDelete) {
                ((EnableEditDelete) panel).setEnableEditDelete(false);//нач инициализация если они поддрерживают интерфейс
            }
        }
        frame.getMenu().setEnableEditDelete(false);
        //проверить таблицу выделен там кюлю элемент или нет
        if (tableData != null) {
            if (tableData.getSelectedRow() != -1) {//возвращает номер выбранной строки, если -1 значит не выбрал никакой строки           
                for (JPanel panel : panels) {
                    if (panel instanceof EnableEditDelete) {
                        ((EnableEditDelete) panel).setEnableEditDelete(true);
                    }
                }
                frame.getMenu().setEnableEditDelete(true);
            }
        }
    }

    @Override
    protected void init() {
        enableEditDelete();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //заголовок панели
        JLabel header = new JLabel(Text.get(title));
//        System.out.println("Header title = "+title);
        header.setFont(Style.FONT_LABEL_HEADER);
        header.setIcon(icon);
        header.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        //tooltip
        if (tooltip != "") {
            header.setToolTipText(Text.get(tooltip));
        }
        add(header);
        //если вообще панелей не будет то ставим отступ между страницей и заголовком
        if (panels.length == 0) {
            add(Box.createVerticalStrut(Style.PADDING_PANEL_EMPTY));
        }
        //перебираем панели и добавляем отстпут после каждой
        for (JPanel panel : panels) {
            add(panel);
            add(Box.createVerticalStrut(Style.PADDING_PANEL));
        }

        //выводи таблицу
        if (tableData != null) {//выводим если таблица есть 
            //скрол
            JScrollPane scrollPane = new JScrollPane(tableData);
            add(scrollPane);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//показывать всегда

            //обработка выделения пункта
            ListSelectionModel selectionModel = tableData.getSelectionModel();
            selectionModel.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    enableEditDelete();
                }
            });

        }
    }

    public TableData getTableData() {
        return tableData;
    }

}
