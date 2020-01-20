/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.toolbar;

import personalfinance.gui.handler.MainToolBarHandler;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public class MainToolBar extends AbstractToolbar {

    public MainToolBar(MainToolBarHandler handler) {
        super(Style.BORDER_MAIN_TOOLBAR,handler);
//        super();
//        setBorder(Style.BORDER_MAIN_TOOLBAR);
        init();
    }

    @Override
    protected void init() {
//        addButton(Text.get("TOOLBAR_OVERVIEW"), Style.ICON_TOOLBAR_OVERVIEW, HandlerCode.TOOLBAR_OVERVIEW, true);
//        addButton(Text.get("TOOLBAR_ACCOUNTS"), Style.ICON_TOOLBAR_ACCOUNTS, HandlerCode.TOOLBAR_ACCOUNTS, true);
//        addButton(Text.get("TOOLBAR_ARTICLES"), Style.ICON_TOOLBAR_ARTICLES, HandlerCode.TOOLBAR_ARTICLES, true);
//        addButton(Text.get("TOOLBAR_TRANSACTIONS"), Style.ICON_TOOLBAR_TRANSACTIONES, HandlerCode.TOOLBAR_TRANSACTIONS, true);
//        addButton(Text.get("TOOLBAR_TRANSFERS"), Style.ICON_TOOLBAR_TRANSFERS, HandlerCode.TOOLBAR_TRANSFERS, true);
//        addButton(Text.get("TOOLBAR_CURRENCIES"), Style.ICON_TOOLBAR_CURRENCIES, HandlerCode.TOOLBAR_CURRENCIES, true);
//        addButton(Text.get("TOOLBAR_STATISTICS"), Style.ICON_TOOLBAR_STATISTICS, HandlerCode.TOOLBAR_STATISTICS, true);   

//        addButtonWithDimension(Text.get("TOOLBAR_OVERVIEW"), Style.ICON_TOOLBAR_OVERVIEW, HandlerCode.TOOLBAR_OVERVIEW, true,Style.DIMENSION_MAIN_TOOLBAR_BUTTON_SIZE);
//        addButtonWithDimension(Text.get("TOOLBAR_ACCOUNTS"), Style.ICON_TOOLBAR_ACCOUNTS, HandlerCode.TOOLBAR_ACCOUNTS, true,Style.DIMENSION_MAIN_TOOLBAR_BUTTON_SIZE);
//        addButtonWithDimension(Text.get("TOOLBAR_ARTICLES"), Style.ICON_TOOLBAR_ARTICLES, HandlerCode.TOOLBAR_ARTICLES, true,Style.DIMENSION_MAIN_TOOLBAR_BUTTON_SIZE);
//        addButtonWithDimension(Text.get("TOOLBAR_TRANSACTIONS"), Style.ICON_TOOLBAR_TRANSACTIONES, HandlerCode.TOOLBAR_TRANSACTIONS, true,Style.DIMENSION_MAIN_TOOLBAR_BUTTON_SIZE);
//        addButtonWithDimension(Text.get("TOOLBAR_TRANSFERS"), Style.ICON_TOOLBAR_TRANSFERS, HandlerCode.TOOLBAR_TRANSFERS, true,Style.DIMENSION_MAIN_TOOLBAR_BUTTON_SIZE);
//        addButtonWithDimension(Text.get("TOOLBAR_CURRENCIES"), Style.ICON_TOOLBAR_CURRENCIES, HandlerCode.TOOLBAR_CURRENCIES, true,Style.DIMENSION_MAIN_TOOLBAR_BUTTON_SIZE);
//        addButtonWithDimension(Text.get("TOOLBAR_STATISTICS"), Style.ICON_TOOLBAR_STATISTICS, HandlerCode.TOOLBAR_STATISTICS, true,Style.DIMENSION_MAIN_TOOLBAR_BUTTON_SIZE);        

        addButtonWithDimensionAndBorderAndToolTips(
                Text.get("TOOLBAR_OVERVIEW"), Style.ICON_TOOLBAR_OVERVIEW, HandlerCode.TOOLBAR_OVERVIEW, true,
                Style.DIMENSION_MAIN_TOOLBAR_BUTTON_SIZE, Style.BORDER_MAIN_TOOLBAR_BUTTON, Text.get("TOOLBAR_OVERVIEW_TOOLTIP"));        
        addButtonWithDimensionAndBorderAndToolTips(
                Text.get("TOOLBAR_ACCOUNTS"), Style.ICON_TOOLBAR_ACCOUNTS, HandlerCode.TOOLBAR_ACCOUNTS, true, 
                Style.DIMENSION_MAIN_TOOLBAR_BUTTON_SIZE, Style.BORDER_MAIN_TOOLBAR_BUTTON,Text.get("TOOLBAR_ACCOUNTS_TOOLTIP"));
        addButtonWithDimensionAndBorderAndToolTips(
                Text.get("TOOLBAR_ARTICLES"), Style.ICON_TOOLBAR_ARTICLES, HandlerCode.TOOLBAR_ARTICLES, true, 
                Style.DIMENSION_MAIN_TOOLBAR_BUTTON_SIZE, Style.BORDER_MAIN_TOOLBAR_BUTTON,Text.get("TOOLBAR_ARTICLES_TOOLTIP"));
        addButtonWithDimensionAndBorderAndToolTips(
                Text.get("TOOLBAR_TRANSACTIONS"), Style.ICON_TOOLBAR_TRANSACTIONES, HandlerCode.TOOLBAR_TRANSACTIONS, true, 
                Style.DIMENSION_MAIN_TOOLBAR_BUTTON_SIZE, Style.BORDER_MAIN_TOOLBAR_BUTTON,Text.get("TOOLBAR_TRANSACTIONS_TOOLTIP"));
        addButtonWithDimensionAndBorderAndToolTips(
                Text.get("TOOLBAR_TRANSFERS"), Style.ICON_TOOLBAR_TRANSFERS, HandlerCode.TOOLBAR_TRANSFERS, true, 
                Style.DIMENSION_MAIN_TOOLBAR_BUTTON_SIZE, Style.BORDER_MAIN_TOOLBAR_BUTTON,Text.get("TOOLBAR_TRANSFERS_TOOLTIP"));
        addButtonWithDimensionAndBorderAndToolTips(
                Text.get("TOOLBAR_CURRENCIES"), Style.ICON_TOOLBAR_CURRENCIES, HandlerCode.TOOLBAR_CURRENCIES, true, 
                Style.DIMENSION_MAIN_TOOLBAR_BUTTON_SIZE, Style.BORDER_MAIN_TOOLBAR_BUTTON,Text.get("TOOLBAR_CURRENCIES_TOOLTIP"));
        addButtonWithDimensionAndBorderAndToolTips(
                Text.get("TOOLBAR_STATISTICS"), Style.ICON_TOOLBAR_STATISTICS, HandlerCode.TOOLBAR_STATISTICS, true, 
                Style.DIMENSION_MAIN_TOOLBAR_BUTTON_SIZE, Style.BORDER_MAIN_TOOLBAR_BUTTON,Text.get("TOOLBAR_STATISTICS_TOOLTIP"));

    }

}
