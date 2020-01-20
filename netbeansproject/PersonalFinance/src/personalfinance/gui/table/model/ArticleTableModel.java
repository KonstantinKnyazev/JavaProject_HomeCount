/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.table.model;

import personalfinance.model.Article;
import personalfinance.saveload.SaveData;

/**
 *
 * @author Konstantin_Knyazev
 */
public class ArticleTableModel extends MainTableModel {

    private static final int TITLE = 0;    

    public ArticleTableModel(String[] columns) {
        super(SaveData.getInstance().getArticles(),columns);
//        this.columns = new ArrayList(Arrays.asList(columns));
    }

    @Override
    protected void updateData() {
        data = SaveData.getInstance().getArticles();

    }

    //  вернуть значение ячейки
    @Override
    public Object getValueAt(int row, int column) {
        //если данных в принципе нет - нуль
        if (data.isEmpty()) {//data from MainTableModel
            return null;
        }
        Article article = (Article) data.get(row);
        switch (column) {
            case TITLE:
                return article.getTitle();            
        }
        return null;
    }

}
