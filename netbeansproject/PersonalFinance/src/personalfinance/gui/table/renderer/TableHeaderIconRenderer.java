/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.table.renderer;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin Knyazev 
 * Ре́ндеринг или отрисовка (англ. rendering —
 * «визуализация») — термин в компьютерной графике, обозначающий процесс
 * получения изображения
 */
public class TableHeaderIconRenderer extends DefaultTableCellRenderer {
    
    
   
    private final JLabel label;
    private String tooltip;

    public TableHeaderIconRenderer(ImageIcon icon, String tooltip) {
        super();            
        
        ImageIcon labelIcon = new CachedCompositeIcon( Style.ICON_PANEL_ABC_TRIAGE,icon  ).getIcon();
        label = new JLabel(labelIcon);
        
        
        this.tooltip = tooltip;
    }
//without tooltip
    public TableHeaderIconRenderer(ImageIcon icon) {
        this(icon,"");
    }

    //Возвращает тот Component (JLabel или Chekbox или любой другой) который будет использоваться для заголовка таблицы
    //используется в первую очередь для ячеек но м.б.использован для заголовков
    /**
     *
     * @param table сама таблица
     * @param value объект который будт выводить, м.б. строка или вообще что
     * угодно
     * @param isSelected выделен ли данный элемент или нет
     * @param hasFocus имеется ли фокус
     * @param row строка
     * @param column столбец
     * @return Возвращает тот Component (JLabel или Jbox или любой другой)
     * который будет использоваться для заголовка таблицы
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //получаем результат по умолчанию        
        TableCellRenderer tcr = table.getTableHeader().getDefaultRenderer(); //взяли таблицу - взяли заголовок - взяли его ренерер, который содержит элементы внешненго вида
        Component renderer = tcr.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);//renderer нам нужен чтобы получить настройки по умолчанию
        //переносим значения по умолчанию в нашу JLabel label которая уже содержит иконку
        label.setFont(renderer.getFont());
        label.setForeground(renderer.getForeground());
        label.setBorder(((JComponent) renderer).getBorder());
        label.setText("" + value);
        String tooltipText = !"".equals(tooltip) ? Text.get(tooltip)+"<br>" : "";
        label.setToolTipText("<html><center>"
                                + tooltipText
//                                + Text.get(tooltip)//line one
//                                + "<br>"
                                + Text.get("TOOL_TIP_RIGHT_PANEL_COMMON_CH")//line two
                                + "</center></html>");
//       label.setToolTipText(MultiLineToolTips.splitToolTip(Text.get(tooltip)+" "+Text.get("TOOL_TIP_RIGHT_PANEL_COMMON_CH")));

//        if(renderer.hasFocus()) {
//            System.out.println("personalfinance.gui.table.renderer.TableHeaderIconRenderer.getTableCellRendererComponent()  FOCUS");
//        }
//System.out.println("personalfinance.gui.table.renderer.TableHeaderIconRenderer.getTableCellRendererComponent()  WORKING" + tooltipText);
        return label;
    }

    

}

