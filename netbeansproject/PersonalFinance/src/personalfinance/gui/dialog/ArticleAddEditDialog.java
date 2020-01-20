/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.dialog;

import javax.swing.JTextField;
import personalfinance.exception.ModelException;
import personalfinance.gui.MainFrame;
import personalfinance.model.Article;
import personalfinance.model.Common;
import personalfinance.settings.Style;

/**
 *
 * @author Konstantin_Knyazev
 */
public class ArticleAddEditDialog extends AddEditDialog{

    public ArticleAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        //добавляем начальные параметры статьи, необходимые для каждого нового счёта
        components.put("LABEL_TITLE", new JTextField());       
        
        //указываем хэш-мап с иконками
        icons.put("LABEL_TITLE", Style.ICON_LABEL_TITLE);
    }

    @Override
    protected void setValues() {
       Article article = (Article) c;
       values.put("LABEL_TITLE", article.getTitle());       
    }

    @Override
    public Common getCommonFromForm() throws ModelException {     
            String title = ((JTextField) components.get("LABEL_TITLE")).getText();            
            return new Article(title);        
    }
    
}
