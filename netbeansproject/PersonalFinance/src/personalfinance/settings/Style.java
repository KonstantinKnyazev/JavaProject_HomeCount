/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.settings;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Konstantin_Knyazev
 */
final public class Style {

    public static final Color COLOR_BUTTON_BG_NORMAL = new Color(240, 240, 240);
    public static final Color COLOR_BUTTON_BG_HOVER = Color.GRAY;
    public static final Color COLOR_LEFTPANEL_BALANCE = Color.LIGHT_GRAY;
    public static final Color COLOR_TOOL_TIP_BACKGROUND = Color.DARK_GRAY;
    public static final Color COLOR_TOOL_TIP_FOREGROUNG = Color.WHITE;
    public static final Color COLOR_TOOL_TIP_BORDER = Color.BLACK;
    public static final Color COLOR_EXP = new Color(200, 0, 0);//red, green. blue -RED
    public static final Color COLOR_INCOME = new Color(0, 100, 0);//red, green. blue -GREEN;
    public static final Color COLOR_ON = Color.BLACK;
    public static final Color COLOR_OFF = new Color(170, 170, 170);//red, green. blue -GREY;;
    public static final Color COLOR_BASE = Color.RED;

    public static final Font FONT_BUTTON_TOOLBAR = new Font("Roboto-Light", Font.BOLD, 12);
    public static final Font FONT_MAIN_BUTTON = new Font("Roboto-Light", Font.BOLD, 14);
    public static final Font FONT_MAIN_TOOLBAR = new Font("Roboto-Light", Font.BOLD, 14);
    public static final Font FONT_DIALOG_LABEL = new Font("Roboto-Light", Font.BOLD, 12);
    public static final Font FONT_LABEL_HEADER = new Font("Roboto-Light", Font.BOLD, 16);
    public static final Font FONT_LABEL_LEFTPANEL_CURRENCY = new Font("Roboto-Light", Font.BOLD, 14);
    public static final Font FONT_LABEL_LEFTPANEL_AMOUNT = new Font("Roboto-Light", Font.PLAIN, 14);
    public static final Font FONT_TOOL_TIP = new Font("Roboto-Light", Font.PLAIN, 12);
    public static final Font FONT_TABLE_HEADER = new Font("Roboto-Light", Font.BOLD, 16);
    public static final Font FONT_TABLE = new Font("Roboto-Light", Font.PLAIN, 14);
      public static Font FONT_BUTTON_FILTER = new Font("Roboto-Light", Font.PLAIN, 12);

    public static final EmptyBorder BORDER_PANEL = new EmptyBorder(10, 10, 10, 10);
    public static final EmptyBorder BORDER_LEFT_PANEL = new EmptyBorder(0, 10, 10, 10);
    public static final EmptyBorder BORDER_LABEL = new EmptyBorder(0, 10, 0, 10);
    public static final EmptyBorder BORDER_MAIN_TOOLBAR = new EmptyBorder(10, 10, 10, 10);
    public static final EmptyBorder BORDER_FUNCTIONS_TOOLBAR = new EmptyBorder(5, 5, 5, 5);
    public static final EmptyBorder BORDER_DIALOG = new EmptyBorder(10, 10, 10, 10);
    public static final RoundedBorder BORDER_MAIN_TOOLBAR_BUTTON = new RoundedBorder(10);
    public static final Border BORDER_TOOL_TIP = BorderFactory.createLineBorder(COLOR_TOOL_TIP_BORDER);
    public static final EmptyBorder BORDER_FILTER_PANEL = new EmptyBorder(5, 0, 7, 0);

    public static final Dimension DIMENSION_MAIN_TOOLBAR_BUTTON_SIZE = new Dimension(120, 70);

    public static final Dimension DIMENSION_DIALOG_TEXTFIELD_SIZE = new Dimension(200, 25);
    public static final Dimension DIMENSION_DIALOG_PADDING_BUTTON = new Dimension(10, 0);
    public static final Dimension DIMENSION_PADDING_LEFTPANEL_BALANCE = new Dimension(10, 0);
    public static final Dimension DIMENSION_TABLE_SHOW_SIZE = new Dimension(850, 450);
    public static final Dimension DIMENSION_CHART = new Dimension(868, 550);//opytnym putem podobrano

    public static final int PADDING_DIALOG = 10;
    public static final int PADDING_BALANCE = 3;
    public static final int PADDING_BIG_BALANCE = 20;
    public static final int PADDING_PANEL_BIG = 20;
    public static final int PADDING_PANEL_EMPTY = 5;
    public static final int PADDING_PANEL = 3;
    public static final int TABLE_ADD_ROW_HEIGHT = 18;
    public static  final int WIDTH_FILTER_BUTTON =200;

    public static final ImageIcon ICON_MAIN = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_OVERVIEW = new ImageIcon("images/overview.png");
//    public static final ImageIcon ICON_ACCOUNTS = new ImageIcon("images/accounts.png");
    public static final ImageIcon ICON_ACCOUNTS = new ImageIcon("images/binders.png");
    public static final ImageIcon ICON_ARTICLES = new ImageIcon("images/articles.png");
    public static final ImageIcon ICON_TRANSACTIONES = new ImageIcon("images/transactiones.png");
    public static final ImageIcon ICON_TRANSFERS = new ImageIcon("images/transfers.png");
    public static final ImageIcon ICON_CURRENCIES = new ImageIcon("images/currencies.png");
    public static final ImageIcon ICON_STATISTICS = new ImageIcon("images/statistics.png");
    public static final ImageIcon ICON_AMOUNT = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_NOTICE = new ImageIcon("images/main.png");

    public static final ImageIcon ICON_MENU_FILE = new ImageIcon("images/menu_file.png");
    public static final ImageIcon ICON_MENU_EDIT = new ImageIcon("images/menu_edit.png");
    public static final ImageIcon ICON_MENU_VIEW = new ImageIcon("images/menu_view.png");
    public static final ImageIcon ICON_MENU_SETTINGS = new ImageIcon("images/menu_settings.png");
    public static final ImageIcon ICON_MENU_HELP = new ImageIcon("images/menu_help.png");

    public static final ImageIcon ICON_MENU_FILE_NEW = new ImageIcon("images/menu_file_new.png");
    public static final ImageIcon ICON_MENU_FILE_OPEN = new ImageIcon("images/menu_file_open.png");
    public static final ImageIcon ICON_MENU_FILE_SAVE = new ImageIcon("images/menu_file_save.png");
    public static final ImageIcon ICON_MENU_FILE_UPDATE_CURRENCIES = new ImageIcon("images/menu_file_update_currencies.png");
    public static final ImageIcon ICON_MENU_FILE_EXIT = new ImageIcon("images/menu_exit.png");

    public static final ImageIcon ICON_MENU_EDIT_ADD = new ImageIcon("images/menu_edit_add.png");
    public static final ImageIcon ICON_MENU_EDIT_EDIT = new ImageIcon("images/menu_edit_edit.png");
    public static final ImageIcon ICON_MENU_EDIT_DELETE = new ImageIcon("images/menu_edit_delete.png");

    public static final ImageIcon ICON_MENU_VIEW_OVERVIEW = new ImageIcon("images/menu_view_overview.png");
    public static final ImageIcon ICON_MENU_VIEW_ACCOUNTS = new ImageIcon("images/menu_view_accounts.png");
    public static final ImageIcon ICON_MENU_VIEW_ARTICLES = new ImageIcon("images/menu_view_articles.png");
    public static final ImageIcon ICON_MENU_VIEW_TRANSACTIONS = new ImageIcon("images/menu_view_transactions.png");
    public static final ImageIcon ICON_MENU_VIEW_TRANSFERS = new ImageIcon("images/menu_view_transfers.png");
    public static final ImageIcon ICON_MENU_VIEW_CURRENCIES = new ImageIcon("images/menu_view_currencies.png");
    public static final ImageIcon ICON_MENU_VIEW_STATISTICS = new ImageIcon("images/menu_view_statistics.png");
    
    public static final ImageIcon ICON_MENU_SETTINGS_LANGUAGE = new ImageIcon("images/menu_settings_languages.png");
    public static final ImageIcon ICON_MENU_SETTINGS_LANGUAGE_RUSSIAN = new ImageIcon("images/menu_settings_language_rus.png");
    public static final ImageIcon ICON_MENU_SETTINGS_LANGUAGE_ENGLISH= new ImageIcon("images/menu_settings_language_eng.png");
    public static final ImageIcon ICON_MENU_SETTINGS_LANGUAGE_FRENCH= new ImageIcon("images/menu_settings_language_fr.png");
    

    public static final ImageIcon ICON_MENU_HELP_ABOUT = new ImageIcon("images/menu_help_about.png");

    public static final ImageIcon ICON_TOOLBAR_OVERVIEW = new ImageIcon("images/overview.png");
    public static final ImageIcon ICON_TOOLBAR_ACCOUNTS = new ImageIcon("images/accounts.png");
    public static final ImageIcon ICON_TOOLBAR_ARTICLES = new ImageIcon("images/articles.png");
    public static final ImageIcon ICON_TOOLBAR_TRANSACTIONES = new ImageIcon("images/transactiones.png");
    public static final ImageIcon ICON_TOOLBAR_TRANSFERS = new ImageIcon("images/transfers.png");
    public static final ImageIcon ICON_TOOLBAR_CURRENCIES = new ImageIcon("images/currencies.png");
    public static final ImageIcon ICON_TOOLBAR_STATISTICS = new ImageIcon("images/statistics.png");

    public static final ImageIcon ICON_ADD = new ImageIcon("images/add_mid.png");
    public static final ImageIcon ICON_EDIT = new ImageIcon("images/edit_mid.png");
    public static final ImageIcon ICON_DELETE = new ImageIcon("images/delete_mid.png");

    public static final ImageIcon ICON_CALENDAR = new ImageIcon("images/calendar_mid.png");
    public static final ImageIcon ICON_ABOUT = new ImageIcon("images/menu_help_about.png");

    public static final ImageIcon ICON_OK = new ImageIcon("images/ok.png");
    public static final ImageIcon ICON_CANCEL = new ImageIcon("images/cancel.png");

    public static final ImageIcon ICON_LABEL_TITLE = new ImageIcon("images/label_title.png");//
    public static final ImageIcon ICON_LABEL_CURRENCY = new ImageIcon("images/currencies.png");//
     

    public static final ImageIcon ICON_LABEL_TYPE = new ImageIcon("images/label_amount.png");//
    public static final ImageIcon ICON_LABEL_AMOUNT = new ImageIcon("images/label_amount.png");//
    public static final ImageIcon ICON_LABEL_FROM_AMOUNT = new ImageIcon("images/label_from_amount.png");//
    public static final ImageIcon ICON_LABEL_TO_AMOUNT = new ImageIcon("images/label_to_amount.png");//

    public static final ImageIcon ICON_LABEL_ACCOUNT = new ImageIcon("images/accounts.png");//
    public static final ImageIcon ICON_LABEL_FROM_ACCOUNT = new ImageIcon("images/label_from_account.png");//
    public static final ImageIcon ICON_LABEL_TO_ACCOUNT = new ImageIcon("images/label_to_account.png");//

    public static final ImageIcon ICON_LABEL_ARTICLE = new ImageIcon("images/articles.png");//    
    public static final ImageIcon ICON_LABEL_NOTICE = new ImageIcon("images/label_notice.png");//
    public static final ImageIcon ICON_LABEL_DATE = new ImageIcon("images/calendar.png");//

    public static final ImageIcon ICON_LABEL_CODE = new ImageIcon("images/label_code.png");//
    public static final ImageIcon ICON_LABEL_RATE = new ImageIcon("images/label_rate.png");//
    public static final ImageIcon ICON_LABEL_ON = new ImageIcon("images/label_on.png");//
    public static final ImageIcon ICON_LABEL_BASE = new ImageIcon("images/label_base.png");//

    public static final ImageIcon ICON_LEFT_PANEL_BALANCE_CURRENCIES = new ImageIcon("images/balance_currencies.png");
    public static final ImageIcon ICON_LEFT_PANEL_BALANCE = new ImageIcon("images/total_currencies.png");

    public static final ImageIcon ICON_PANEL_HEADER_TRANSACTIONS = new ImageIcon("images/transactiones_mid.png");
    public static final ImageIcon ICON_PANEL_HEADER_CURRENCIES = new ImageIcon("images/currencies_mid.png");
    public static final ImageIcon ICON_PANEL_HEADER_OVERVIEW = new ImageIcon("images/overview_mid.png");
    public static final ImageIcon ICON_PANEL_HEADER_ACCOUNTS = new ImageIcon("images/binder_mid.png");
    public static final ImageIcon ICON_PANEL_HEADER_ARTICLES = new ImageIcon("images/articles_mid.png");
    public static final ImageIcon ICON_PANEL_HEADER_TRANSFERS = new ImageIcon("images/transfers_mid.png");    
    public static final ImageIcon ICON_PANEL_HEADER_STATISTICS= new ImageIcon("images/statistics_mid.png");

    public static final ImageIcon ICON_PANEL_TRANSACTION = new ImageIcon("images/transactiones.png");
    public static final ImageIcon ICON_PANEL_CURRENCY = new ImageIcon("images/currencies_mid.png");
    public static final ImageIcon ICON_PANEL_OVERVIEW = new ImageIcon("images/overview_mid.png");
    public static final ImageIcon ICON_PANEL_CALENDAR = new ImageIcon("images/calendar_sm.png");
    public static final ImageIcon ICON_PANEL_ACCOUNT = new ImageIcon("images/binder_sm.png");
    public static final ImageIcon ICON_PANEL_AMOUNT = new ImageIcon("images/amount_sm.png");
    public static final ImageIcon ICON_PANEL_ARTICLE = new ImageIcon("images/articles_sm.png");
    public static final ImageIcon ICON_PANEL_NOTICE = new ImageIcon("images/notice_sm.png");
    public static final ImageIcon ICON_PANEL_TITLE = new ImageIcon("images/title_sm.png");
    public static final ImageIcon ICON_PANEL_TRANSFER = new ImageIcon("images/transfers_sm.png");
    public static final ImageIcon ICON_PANEL_BASE = new ImageIcon("images/base_sm.png");
    public static final ImageIcon ICON_PANEL_CODE = new ImageIcon("images/code_sm.png");
    public static final ImageIcon ICON_PANEL_ON = new ImageIcon("images/on_sm.png");
    public static final ImageIcon ICON_PANEL_RATE = new ImageIcon("images/rate_sm.png");
    public static final ImageIcon ICON_PANEL_TRIAGE = new ImageIcon("images/triage.png");
    public static final ImageIcon ICON_PANEL_ABC_TRIAGE = new ImageIcon("images/abc_triage.png");
    

    public static final ImageIcon ICON_MENU_POPUP_EDIT = new ImageIcon("images/edit_sm.png");
    public static final ImageIcon ICON_MENU_POPUP_DELETE = new ImageIcon("images/delete_sm.png");

    public static final ImageIcon ICON_LEFT = new ImageIcon("images/arrow_left_sm.png");
    public static final ImageIcon ICON_RIGHT = new ImageIcon("images/arrow_right_sm.png");
    public static final ImageIcon ICON_DOWN = new ImageIcon("images/arrow_down_sm.png");
    
    
    
  
    

    public static void setToolTip() {
        UIManager.put("ToolTip.foreground", COLOR_TOOL_TIP_FOREGROUNG);
        UIManager.put("ToolTip.background", COLOR_TOOL_TIP_BACKGROUND);
        UIManager.put("ToolTip.font", FONT_TOOL_TIP);
        UIManager.put("ToolTip.border", BORDER_TOOL_TIP);
        ToolTipManager.sharedInstance().setDismissDelay(5000); // 5 second delay
    }

    private static class RoundedBorder implements Border {

        private final int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

    }

}
