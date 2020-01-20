/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.dialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import personalfinance.exception.ModelException;
import personalfinance.gui.MainButton;
import personalfinance.gui.MainFrame;
import personalfinance.gui.handler.AddEditDialogHandler;
import personalfinance.model.Common;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public abstract class AddEditDialog extends JDialog {

    protected LinkedHashMap<String, JComponent> components = new LinkedHashMap();//
    protected LinkedHashMap<String, ImageIcon> icons = new LinkedHashMap();//иконки к метки
    protected LinkedHashMap<String, Object> values = new LinkedHashMap();//значение текстового поля
    protected Common c;
    private final MainFrame frame;

    public AddEditDialog(MainFrame frame) {

        super(frame, Text.get("ADD"), true);//true означает что окно модальное, т.е. пока оно открыто поверх другого окна, в этом другом окне ничего нельзя сделать
        this.frame = frame;
        addWindowListener(new AddEditDialogHandler(frame, this));
        setResizable(false);
    }

    public Common getCommon() {
        return c;
    }

    public void setCommon(Common c) {
        this.c = c;
    }

    public final void showDialog() {
        setDialog();
        setVisible(true);
    }

    public final void closeDialog() {
        setVisible(false);
        this.c = null;
        components.clear();
        icons.clear();
        values.clear();
        dispose();// очищаем оперативную память

    }

    public boolean isAdd() {
        return c == null; //если объект не null то isAdd=false и мы будем изменять существующий объект, если объект = null то isAdd=true и мы добавляем новый объект
    }

    //абстрактные методы, которые дочерние классы будут обязаны реализовать
    abstract protected void init();//инициализация здась будут заполняться components и icons

    abstract protected void setValues();///будут заполняться values

    //возвращает конкретный объект на основании заполненной формы
    public abstract Common getCommonFromForm() throws ModelException;//когда все поля заполненны и жмем ок. все поля считываются и создается объект Common и т.к. возможны ошибки при вводе данных - throws ModelException

    private void setDialog() {
        init();
        if (isAdd()) {
            setTitle(Text.get("ADD"));
            setIconImage(Style.ICON_ADD.getImage());
        } else {
            setValues();
            setTitle(Text.get("EDIT"));
            setIconImage(Style.ICON_EDIT.getImage());
        }
        getContentPane().removeAll();//если пользователь закрыл-открыл интерфейс стереть всё, получаем панель данного диалога и стираем всё с нее
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));//установить Layout,т.е как будут располагаться элементы
        ((JPanel) getContentPane()).setBorder(Style.BORDER_DIALOG);//рамочка
        //перебирать массив с компонентами
        for (Map.Entry<String, JComponent> entry : components.entrySet()) {
            String key = entry.getKey();
            JLabel label = new JLabel(Text.get(key));
            label.setIcon(icons.get(key));
            label.setFont(Style.FONT_DIALOG_LABEL);

            JComponent component = entry.getValue();
            //нужно понять что за элемент: комбо бокс, текст филд, дате пикер и т.п. и у них у всех разные способы ввода-вывода данных
            //перебираем все
            //еси текстовое поле
            if (component instanceof JTextField) {
                component.setPreferredSize(Style.DIMENSION_DIALOG_TEXTFIELD_SIZE);
                //если у компонента есть значение,т.е. массив values содержит элемент с таким же ключом, вписываем его значение в поле
                if (values.containsKey(key)) {
//                    ((JTextField) component).setText((String) values.get(key));//возникает ошибка Exception in thread "main" java.lang.ClassCastException: java.lang.Double cannot be cast to java.lang.String
                      ((JTextField) component).setText(String.valueOf( values.get(key)));
                }
            } //если комбо-бокс
            else if (component instanceof JComboBox) {
                if (values.containsKey(key)) {
                    ((JComboBox) component).setSelectedItem(values.get(key));
                }
            } //если дата-пикер
            else if (component instanceof JDatePickerImpl) {
                if (values.containsKey(key)) {
                    ((UtilDateModel) ((JDatePickerImpl) component).getModel()).setValue((Date) values.get(key));
                }
            }
            //add listener for hot keys (enter)
            component.addKeyListener(new AddEditDialogHandler(frame, this));
            //выравнивание меток к левому краю
            component.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            add(label);//добавим метку
            add(Box.createVerticalStrut(Style.PADDING_DIALOG));//add(Box.createVerticalBox());//отступ
            add(component);//компонент
            add(Box.createVerticalStrut(Style.PADDING_DIALOG));//add(Box.createVerticalBox());//отступ
        }//конец цикла перебирать массив с компонентами
        
        //кнопки
        MainButton ok = new MainButton(Text.get("ADD"), Style.ICON_OK, new AddEditDialogHandler(frame, this), HandlerCode.ADD);
        if (!isAdd()) {
            ok.setActionCommand(HandlerCode.EDIT);
            ok.setText(Text.get("EDIT"));
        }
        MainButton cancel = new MainButton(Text.get("CANCEL"), Style.ICON_CANCEL, new AddEditDialogHandler(frame, this), HandlerCode.CANCEL);
        //размещаем кнопки горизонтально        
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new BorderLayout());
        panelButtons.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        panelButtons.add(ok, BorderLayout.WEST);
        panelButtons.add(Box.createRigidArea(Style.DIMENSION_DIALOG_PADDING_BUTTON),BorderLayout.CENTER);//по центру добавим бокс-расстояние
        panelButtons.add(cancel, BorderLayout.EAST);
        //размещаем панель с кнопками
        add(panelButtons);
        pack();//подгоняем размер окна минимально достаточно для всех элементов в нем
        setLocationRelativeTo(null);//по центру

    }//setDialog() конец метода

    /*внутренний класс
    для того чтобы элементы комбо-бокса - объекты не выводились в виде toString, а только неободимые параметры из объекта
    будет собственный элемент комбо-бокс который будет выводить то что нужно     
     */
    protected class CommonComboBox extends JComboBox {

        public CommonComboBox(Object[] objs) {
            super(objs);
            //переопределяем рендеринг, который есть по умолчанию
            setRenderer(new DefaultListCellRenderer() {
                @Override
                /*методо твечает за то как выглядит соответсвующий элемент списка                
                JList list - сам список, 
                Object value - значение текущее в этом элементе, 
                int index - индекс данного элемента(0,1,2), 
                boolean isSelected выделен/невыделен данный элемент, 
                boolean cellHasFocus     находится ли данный элемент в фокусе    */
                public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    //берем дефолтный рендерер и вызываем родительский тот же самый метод
                    DefaultListCellRenderer renderer = (DefaultListCellRenderer) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    //Object value это наш Common
                    Common c = (Common) value;
                    //для ка
                    if (c != null) {
                        // renderer.setText(c.toString())); так работает по умолчанию
                        renderer.setText(c.getValueForComboBox());//когда мы выделяем объект это будет весь "счёт", например, со всеми его propertis,
                    }                    //но для комбо бокса мы используем только некоторые propertis которые мы определили для каждого класса с помощью метода getValueForComboBox()
                    return renderer;
                }
            });
        }
    }//protected class CommonComboBox extends JComboBox

}
