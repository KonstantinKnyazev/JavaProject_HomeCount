/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.table;

import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import personalfinance.gui.Refresh;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.menu.TablePopupMenu;
import personalfinance.gui.table.model.MainTableModel;
import personalfinance.gui.table.renderer.MainTableCellRenderer;
import personalfinance.gui.table.renderer.TableHeaderIconRenderer;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
abstract public class TableData extends JTable implements Refresh {

    private final TablePopupMenu popup;
    private final String[] columns;
    private final ImageIcon[] icons;
    private final String[] tooltips;
    private FunctionsHandler handler;

    public TableData(MainTableModel model, FunctionsHandler handler, String[] columns, ImageIcon[] icons, String[] tooltips) {
        super(model);
        this.handler = handler;
        this.popup = new TablePopupMenu(handler);
        this.columns = columns;
        this.icons = icons;
        this.tooltips = tooltips;

        getTableHeader().setFont(Style.FONT_TABLE_HEADER);//шрифт для заголовка
        setFont(Style.FONT_TABLE);//шрифт таблицы
        setRowHeight(getRowHeight() + Style.TABLE_ADD_ROW_HEIGHT);//добавляем ширину-высоту строки, т.к. по умолчанию слишком узкая строчка

        setAutoCreateRowSorter(true);//добавляем сортировку по алфавиту при нажатии на заголовок столбца
        setPreferredScrollableViewportSize(Style.DIMENSION_TABLE_SHOW_SIZE);//устанавливаем размер независимо от количесва отображаемых данных
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//можно выделить только одну строку

        addMouseListener(handler);
        addKeyListener(handler);
        
        //заголовки column       
        for (int i = 0; i < columns.length; i++) {
            //check tooltips
            if (tooltips.length > 0) {
                getColumn(Text.get(columns[i])).//обращаемся к столбцу через языковые константы
                        setHeaderRenderer(new TableHeaderIconRenderer(icons[i], tooltips[i]));//устанавливаем рендерер для ячейки - заголовка столбца, используя конструктор специально измененный для заголовка
            } else {
                getColumn(Text.get(columns[i])).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
            }
        }
        //содеримое
        MainTableCellRenderer renderer = new MainTableCellRenderer();
        setDefaultRenderer(String.class, renderer);
        setComponentPopupMenu(popup);
    }

    //without tooltips
    public TableData(MainTableModel model, FunctionsHandler handler, String[] columns, ImageIcon[] icons) {
        this(model, handler,columns, icons, new String[]{});
    }

    private TableData(MainTableModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JPopupMenu getComponentPopupMenu() {
        //определить строку
        Point p = getMousePosition();//определяем точку
        if (p != null) {
            int row = rowAtPoint(p);//если точка существует определяем какой строке она соответствует
            if (isRowSelected(row)) {
                return super.getComponentPopupMenu();
            } else {
                return null;
            }
        }
//------------------------------------------------------------------------------------
//this modification get a bug: we have allways a row selected after any actions, we don't select rows
//        if (p != null) {
//            int row = rowAtPoint(p);//если точка существует определяем какой строке она соответствует
//            if (row != -1) {
//                setRowSelectionInterval(row, row);
//            }
//
//        }
//--------------------------------------------------------------------------------------
//        if (p != null && row != -1) {
//            if (isRowSelected(row)) {
//                return super.getComponentPopupMenu();
//            } else {
//                return null;
//            }
//        }
//---------------------------------------------------------------------------------------
        return super.getComponentPopupMenu();
    }

    @Override
    public void refresh() {
        //сохранить выделенную строку
        int selectedRow = getSelectedRow();
        //обновляем модель и вся таблица перерисовывается
        ((MainTableModel) getModel()).refresh();
        //возможно понадобится для мультиязычности
        //each time when we add, edit or delete line in table we need to make rendering a new, if not we lost the images on the column headers
        for (int i = 0; i < columns.length; i++) {
            if (tooltips.length > 0) {
                getColumn(Text.get(columns[i])).//обращаемся к столбцу через языковые константы
                        setHeaderRenderer(new TableHeaderIconRenderer(icons[i], tooltips[i]));//устанавливаем рендерер для ячейки - заголовка столбца, используя конструктор специально измененный для заголовка
            } else {
                getColumn(Text.get(columns[i])).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
            }
        }
        //проверяем существует ли еще выделенная строка, если да  - выделяем ее
        if (selectedRow != -1 && selectedRow < getRowCount()) {
            setRowSelectionInterval(selectedRow, selectedRow);//указываем начало и конец RowSelectionInterval чтобы выделить одну нужную строку            
            requestFocus();//to return focus to table
        }
        init();
    }

    protected void init() {
    }

    public FunctionsHandler getFunctionsHadler() {
        return handler;
    }

}
