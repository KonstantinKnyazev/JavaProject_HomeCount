/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.saveload;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import personalfinance.model.Currency;

/**
 *
 * @author Konstantin_Knyazev
 */
public class RateCurrency {
    
    
    public static HashMap<String,Double> getRates(Currency base) throws Exception{
        
        //результирующий массив который мы будем возвращать
        HashMap<String,Double> rates = new HashMap();       
                
        HashMap<String, NodeList> firstResult = new HashMap();
        //обращаемся к документу в интрнете по url
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");        
        String url = "http://www.cbr.ru/scripts/xml_daily.asp?date_reg=" + dateFormat.format(new Date()) ;
        //загружаем документ        
        //создаем DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //возвращаем объект документ 
        Document doc = factory.newDocumentBuilder().parse(new URL(url).openStream());//возможен Exception
        // теперь можем работать в xml документом, он распарсен    
        /*
        Структура
        <Valute ID="R01010">                    | Node   
            <NumCode>036</NumCode>              |       ||Child
            <CharCode>AUD</CharCode>            |       ||
            <Nominal>1</Nominal>                |       ||
            <Name>Австралийский доллар</Name>   |       ||
            <Value>44,6360</Value>              |       ||
        </Valute>                               |
        <Valute ID="R01060">
            <NumCode>051</NumCode>
            <CharCode>AMD</CharCode>
            <Nominal>100</Nominal>
            <Name>Армянских драмов</Name>
            <Value>13,3297</Value>
        </Valute>                
         */
        NodeList nodeList = doc.getElementsByTagName("Valute");                     //получаем NodeList который содержит все валюты из файла в интернете
        for (int i = 0; i < nodeList.getLength(); i++) {                            //перебираем весь NodeList
            Node node = nodeList.item(i);                                           //создаём отдельный узел для каждой валюты
            NodeList nodeListChilds = node.getChildNodes();                         //создаем NodeList содержащий подэлементы-Child узла Node
            for (int j = 0; j < nodeListChilds.getLength(); j++) {                  //перебираем все подэлементы-Child узла Node
                if (nodeListChilds.item(j).getNodeName().equals("CharCode"))        //если подэлемент-Child имеет имя <CharCode>, добавляем его в HashMap
                {
                    firstResult.put(nodeListChilds.item(j).getTextContent(), nodeListChilds);//получаем HashMap где ключом сейчас будет подэлемент-Child <CharCode> 
                }                                                                       //а значениями ВСЕ подэлементы-Child узла Node
            }
        }               
        
        for (Map.Entry<String, NodeList> entry : firstResult.entrySet()) {   //перебираем HashMap firstResult
            NodeList temp = entry.getValue();                               //NodeList содержащий подэлементы-Child узла Node
            double value = 0;
            int nominal = 0;
            for (int i = 0; i < temp.getLength(); i++) {
                if (temp.item(i).getNodeName().equals("Value")) //Если имя узла подэлементы-Child = "Value" то берем значение этого узла для переменной value
                {
                    value = Double.parseDouble(temp.item(i).getTextContent().replace(",", "."));//изначатьльно значение в виде текста. Заменяем запятые на точки и парсим в Double
                } else if (temp.item(i).getNodeName().equals("Nominal"))//Если имя узла подэлементы-Child = "Nominal" то берем значение этого узла для переменной nominal
                {
                    nominal = Integer.parseInt(temp.item(i).getTextContent());
                }
            }
            //считаем стоимость валюты относительно рубля, т.к. интернет ресурс российский
            //double amountCurrency = value/nominal;
            double amountCurrency = ((double) Math.round((value / nominal) * 10000)) / 10000; //округляем до   4х знаков после запятой        
            //rates.put(entry.getKey(), (((double)Math.round(amountCurrency*10000))/10000));//            
            rates.put(entry.getKey(), amountCurrency);//добавляем в массив. Получае список всех валют с их кодами и курсом
        }
        rates.put("RUB", 1.0);//добавляем его т.к. его нет в списке
//        System.out.println(rates);

        //создаем коэффициент пересчета. т.к. в программе базовая валюта не обязательно рубль
        double div = rates.get(base.getCode());//получаем из массива текущий курс базовой валюты по её ключу - base.getCode()

        for (Map.Entry<String, Double> entry : rates.entrySet()) {//перебираем массив rates для пересчета курсов
            entry.setValue(entry.getValue() / div);//пересчитываем курс каждой валюты
        }          
        return  rates;
    }
    
}
