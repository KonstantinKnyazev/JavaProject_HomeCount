/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.table.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import personalfinance.exception.ModelException;
import personalfinance.gui.Refresh;
import personalfinance.model.Common;
import personalfinance.settings.Text;

/**
 *
 * @author Admin
 */
abstract public class MainTableModel extends AbstractTableModel implements Refresh {

    //не можем указать конкретный тип тк. разные классы
    protected List<? extends Common> data;//все что является наследником Common
    protected List<String> columns = new ArrayList();

    public MainTableModel(List data, String[] columns) {
        this.data = data;
        this.columns = new ArrayList(Arrays.asList(columns));
    }

//    public MainTableModel(List data) {
//        this.data = data;
//    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    //получить значение в конкретном столце и конкр строке
    //не можем здесь определить метод, для каждого класса свой метод
    //т.к. класс абстрактный мы не обязаны его реализовывать здесь, а дочерний класс - обязан
//    @Override
//    abstract public Object getValueAt(int row, int column);
    @Override
    public String getColumnName(int columnIndex) {
        return Text.get(columns.get(columnIndex));//используем текстовые константы
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Object obj = getValueAt(0, columnIndex);//первый элемент в столбце
        if (obj == null) {
            return Object.class;//защита от ошибки если данных нет (напр. первый запуск)
        }
        return obj.getClass();
    }

    @Override
    public void refresh() {
        updateData();
        //перерисовываем таблицу
        fireTableStructureChanged();
        fireTableDataChanged();
    }

    public Common getCommonByRow(int row) throws ModelException {
        if(row>-1) 
            return data.get(row);
        else
            throw new ModelException(ModelException.LINE_NOT_SELECTED);
        
    }

    abstract protected void updateData();//разный для каждого дочернего класса, будем испльзовать saveData
    
    public Common getCommonObjectByRow(int row){       
//indexOf Returns:
//the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
//        if (data.indexOf(row) == -1)return null;
        return  data.get(row);
    }

}
