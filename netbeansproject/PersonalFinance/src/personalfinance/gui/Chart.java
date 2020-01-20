/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui;
//for gistogramme

import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public class Chart {

    private DefaultPieDataset dataset;
    private final String title;
    private final String currencyTitle;

    public Chart(HashMap<String, Double> data, String title, String currencyTitle) {
        setData(data);
        this.title = Text.get(title);
        this.currencyTitle = currencyTitle;
    }

    private void setData(HashMap<String, Double> data) {
        dataset = new DefaultPieDataset();
        for (Map.Entry<String, Double> entry : data.entrySet()) {            
            String key = entry.getKey();
            Double value = entry.getValue();            
            dataset.setValue(key, value);
        }
    }
    
    public JPanel getPanel(){
        JFreeChart chart= ChartFactory.createPieChart3D(title, dataset, true, true, false);//true (legende), true (tooltip), false (url)
        //data of graphik, settings of view of tooltip
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setToolTipGenerator(new StandardPieToolTipGenerator("{0}): {1} "+currencyTitle+" ({2})"));//output view: Foods: 400 RUB (55%)     {Foods}: {400} RUB ({55}%) 
        JPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(Style.DIMENSION_CHART);
        //no data
        if(dataset.getItemCount()==0){
            panel.setLayout(new GridBagLayout());
            JLabel label = new JLabel(Text.get("CHART_NO_DATA"));
            label.setFont(Style.FONT_LABEL_HEADER);
            panel.add(label);
        }
        return panel;
    }

}
