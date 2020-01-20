/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.settings;

import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author Konstantin_Knyazev
 */
final public class Text {
    
//    private static  ResourceBundle bundle;

    private static final HashMap<String, String> data = new HashMap();

//    private static ResourceBundle bundle; 
//
//    public Text(ResourceBundle bundle) {
//        this.bundle = bundle;
//    }
     
     
     
    public static String get(String key) {
        if (data.containsKey(key)) {
            return data.get(key);
        }
        System.err.println("Внимание! Запрошен ключ " + key + ". Такого ключа не существует!");//для отладки
        return "";
    }

    public static String[] getMonths() {
        String[] months = new String[12];
        months[0] = get("JANUARY");
        months[1] = get("FEBRUARY");
        months[2] = get("MARCH");
        months[3] = get("APRIL");
        months[4] = get("MAY");
        months[5] = get("JUNE");
        months[6] = get("JULY");
        months[7] = get("AUGUST");
        months[8] = get("SEPTEMBER");
        months[9] = get("OCTOBER");
        months[10] = get("NOVEMBER");
        months[11] = get("DECEMBER");

        return months;
    }
    

      
    

    public static void init() {
        
        
        
        switch (Settings.getLanguage()) {
            case "ru":
                data.put("PROGRAMM_NAME", "Домашняя бухгалтерия");
                data.put("MENU_FILE", "Файл");
                data.put("MENU_EDIT", "Правка");
                data.put("MENU_VIEW", "Вид");
                data.put("MENU_SETTINGS", "Настройки");
                data.put("MENU_HELP", "Помощь");
                data.put("MENU_FILE_NEW", "Новый");
                data.put("MENU_FILE_OPEN", "Открыть");
                data.put("MENU_FILE_SAVE", "Сохранить");
                data.put("MENU_FILE_UPDATE_CURRENCIES", "Обновить валюту");
                data.put("MENU_FILE_EXIT", "Выход");
                data.put("MENU_EDIT_ADD", "Добавить");
                data.put("MENU_EDIT_EDIT", "Изменить");
                data.put("MENU_EDIT_DELETE", "Удалить");
                data.put("MENU_VIEW_OVERVIEW", "Обзор");
                data.put("MENU_VIEW_ACCOUNTS", "Счета");
                data.put("MENU_VIEW_ARTICLES", "Статьи");
                data.put("MENU_VIEW_TRANSACTIONS", "Транзакции");
                data.put("MENU_VIEW_TRANSFERS", "Переводы");
                data.put("MENU_VIEW_CURRENCIES", "Валюты");
                data.put("MENU_VIEW_STATISTICS", "Статистика");
                data.put("MENU_SETTINGS_LANGUAGE", "Язык");
                data.put("MENU_SETTINGS_LANGUAGE_RUSSIAN", "Русский язык");
                data.put("MENU_SETTINGS_LANGUAGE_ENGLISH", "Английский язык");
                data.put("MENU_SETTINGS_LANGUAGE_FRENCH", "Французский язык");
                data.put("MENU_HELP_ABOUT", "О программе");
                data.put("TOOLBAR_OVERVIEW", "Обзор");
                data.put("TOOLBAR_ACCOUNTS", "Счета");
                data.put("TOOLBAR_ARTICLES", "Статьи");
                data.put("TOOLBAR_TRANSACTIONS", "Операции");
                data.put("TOOLBAR_TRANSFERS", "Переводы");
                data.put("TOOLBAR_CURRENCIES", "Валюты");
                data.put("TOOLBAR_STATISTICS", "Статистика");
                data.put("TOOLBAR_OVERVIEW_TOOLTIP", "Обзор последних операций");
                data.put("TOOLBAR_ACCOUNTS_TOOLTIP", "<html><center>"
                        +"Места где вы держите деньги<br>"
                        +"(банк-А, банк-Б, наличные в кошельке и т.п.)"
                        +"</center></html>");
                data.put("TOOLBAR_ARTICLES_TOOLTIP", "<html><center>"
                        +"Отдельные позиции, которые описывают ваши<br>"
                        +"доходы и расходы"
                        +"</center></html>");
                data.put("TOOLBAR_TRANSACTIONS_TOOLTIP", "<html><center>"
                        +"Записи о приходе денег<br>"
                        +"и о расходе денег"
                        +"</center></html>");
                data.put("TOOLBAR_TRANSFERS_TOOLTIP", "Движение денег по счетам");
                data.put("TOOLBAR_CURRENCIES_TOOLTIP", "<html><center>"
                        +"Различные виды валют, которые<br>"
                        +"могут быть вами использованы"
                        +"</center></html>");
                data.put("TOOLBAR_STATISTICS_TOOLTIP", "<html><center>"
                        +"График ваших расходов или доходов<br>"
                        +"по различным статьям"
                        +"</center></html>");
                data.put("JANUARY", "Январь");
                data.put("FEBRUARY", "Февраль");
                data.put("MARCH", "Март");
                data.put("APRIL", "Апрель");
                data.put("MAY", "Май");
                data.put("JUNE", "Июнь");
                data.put("JULY", "Июль");
                data.put("AUGUST", "Август");
                data.put("SEPTEMBER", "Сентябрь");
                data.put("OCTOBER", "Октябрь");
                data.put("NOVEMBER", "Ноябрь");
                data.put("DECEMBER", "Декабрь");
                data.put("TODAY", "Сегодня");
                data.put("ERROR", "Ошибка");
                data.put("ERROR_TITLE_EMPTY", "Вы не ввели название");
                data.put("ERROR_IS_EXISTS", "Такая запись уже существует");
                data.put("ERROR_DATE_FORMAT", "Некоректный формат даты");
                data.put("ERROR_CODE_EMPTY", "Вы не указали код");
                data.put("ERROR_CURRENCY_EMPTY", "Вы не выбрали валюту");
                data.put("ERROR_ARTICLE_EMPTY", "Вы не выбрали статью");
                data.put("ERROR_ACCOUNT_EMPTY", "Вы не выбрали счёт");
                data.put("ERROR_RATE_INCORRECT", "Некорректное значение курса");
                data.put("ERROR_AMOUNT_FORMAT", "Некорректный формат суммы");
                data.put("ERROR_NO_BASE_CURRENCY", "<html><center>"
                        + "Необходима базовая валюта!<br> "
                        + "Установите сначала этот параметр в другой валюте, потом он снимется в этой автоматически."
                        + "</center></html>");
                data.put("ERROR_IS_BASE_CURRENCY", "<html><center>"
                        +"Базовая валюта не может быть удалена!<br>"
                        +"Установите сначала этот параметр в другой валюте."
                        + "</center></html>");
                data.put("ERROR_IS_JOINED_CURRENCY", "<html><center>"
                        +"Текущая валюта не может быть удалена!<br>"
                        +"Валюта связана с другими данными!<br>"
                        +"Удаление этой валюты повредит структуру данных.<br>"
                        +"Для удаления валюты необходимо сначала удалить связанные данные!"
                        + "</center></html>");
                data.put("ERROR_IS_JOINED_ACCOUNT", "<html><center>"
                        +"Текущий счёт не может быть удален!<br>"
                        +"Счет связан с другими данными!<br>"
                        +"Удаление этого счёта повредит структуру данных.<br>"
                        +"Для удаления счёта необходимо сначала удалить связанные данные!"
                        + "</center></html>");
                data.put("ERROR_IS_JOINED_ARTICLE", "<html><center>"
                        +"Текущая статья не может быть удалена!<br>"
                        +"Статья связана с другими данными!<br>"
                        +"Удаление этой статьи повредит структуру данных.<br>"
                        +"Для удаления статьи необходимо сначала удалить связанные данные!"
                        + "</center></html>");
                data.put("ERROR_IS_JOINED_QTY_TRANSACTIONS", "Количество связанных операций: ");
                data.put("ERROR_IS_JOINED_QTY_TRANSFERS", "Количество связанных переводов: ");
                data.put("ERROR_UPDATE_CURRENCIES", "Ошибка обновления курсов валют");
                data.put("ERROR_LINE_NOT_SELECTED", "Объект не выбран!");
                data.put("DIALOG_ABOUT_TITLE", "О программе");
                data.put("ABOUT", 
                        "<body style='font-size: 110%; text-align: center; width: 350px;'>"
                                + "<h1>Домашняя бухгалтерия</h1>"
                                + "<p><img src='file:images/main.png'></p>"
                                + "<p>Данная программа предназначена для домашнего использования"
                                + "<br/>Программа была сделана с помощью видеокурса"
                                + "<br/>\"Создание крупного проекта на Java\""
                                + "<p>С уважением, Константин Князев</p>"
                                + "<br/><a style='font-weight:bold;' href='https://www.linkedin.com/in/konstantin-knyazev-b748b9132/'>www.linkedin.com/konstantin-knyazev</a></p>"
                                + "<p>Copyright "+Calendar.getInstance().get(Calendar.YEAR)+"</p>"
                                + "</body>");
                data.put("YES", "Да");
                data.put("NO", "Нет");
                data.put("ADD", "Добавить");
                data.put("EDIT", "Изменить");
                data.put("DELETE", "Удалить");
                data.put("OK", "Ок");
                data.put("CANCEL", "Отмена");
                data.put("LABEL_TITLE", "Название");
                data.put("LABEL_CURRENCY", "Валюта");
                data.put("LABEL_START_AMOUNT", "Начальный баланс");
                data.put("LABEL_DATE", "Дата");
                data.put("LABEL_ACCOUNT", "Счет");
                data.put("LABEL_ARTICLE", "Статья");
                data.put("LABEL_AMOUNT", "Доступно");
                data.put("LABEL_NOTICE", "Примечание");
                data.put("LABEL_FROM_ACCOUNT", "Со счёта");
                data.put("LABEL_TO_ACCOUNT", "На счёт");
                data.put("LABEL_FROM_AMOUNT", "Сумма со счёта");
                data.put("LABEL_TO_AMOUNT", "Сумма на счёт");
                data.put("LABEL_CODE", "Код");
                data.put("LABEL_RATE", "Курс");
                data.put("LABEL_ON", "Включено");
                data.put("LABEL_BASE","Базовая");
                data.put("LABEL_TYPE","Тип операции");
                data.put("LABEL_INCOME","Доходы");
                data.put("LABEL_EXP","Расходы");
                data.put("BALANCE_CURRENCIES","Баланс по валютам");
                data.put("BALANCE","Итоговый баланс в ");
                data.put("TOOL_TIP_BALANCE_IN_ONE_CURRENCY","Итоговый баланс всех счетов в одной валюте");
                data.put("TOOL_TIP_RIGHT_PANEL_ACCOUNTS_HEADER","Выписка всех счетов пользователя");
                data.put("TOOL_TIP_RIGHT_PANEL_LAST_TRANSACTIONS_HEADER","Выписка последних транзакций пользователя");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_HEADER","Выписка транзакций пользователя за период");
                data.put("TOOL_TIP_RIGHT_PANEL_ARTICLES_HEADER","Список статей расходов пользователя");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_HEADER","Список переводов пользователя");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCIES_HEADER","Список валют пользователя");
                data.put("TOOL_TIP_RIGHT_PANEL_COMMON_CH","Сортировка при нажатии");
                data.put("TOOL_TIP_RIGHT_PANEL_ACCOUNTS_CH_TITLE","Название счетов пользователя");//CH - COLUMN HEADER
                data.put("TOOL_TIP_RIGHT_PANEL_ACCOUNTS_CH_AMOUNT","Сумма остатка на каждом счете");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_DATE","Дата совершения операции");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_ACCOUNT","Счет с которого были потрачены деньги <br> или на который поступили деньги");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_ARTICLE","Статья расхода определенная пользователем");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_AMOUNT","Сумма операции");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_NOTICE","Дополнительные сведения об операции");
                data.put("TOOL_TIP_RIGHT_PANEL_ARTICLES_CH_TITLE","Название статей расходов пользователя");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_DATE","Дата совершения перевода");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_FROM_ACCOUNT","Счет с которого были переведены деньги");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_TO_ACCOUNT","Счет на который были переведены деньги");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_FROM_AMOUNT","Сумма списанная со счета");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_TO_AMOUNT","Сумма поступившая на счет");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_NOTICE","Дополнительные сведения об переводе");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_TITLE","Название валюты");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_CODE","Универсальный международный код валюты");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_RATE","Курс валюты по отношению к настоящей базовой валюте");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_ON","Включена ли валюта для использования ");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_BASE","Является ли валюта базовой для расчета");
                data.put("FC_OPEN", "Открыть");//FC - File Chooser
                data.put("FC_SAVE", "Сохранить");
                data.put("FC_CANCEL", "Отмена");
                data.put("FC_LOOK", "Папка:");
                data.put("FC_NAME_FILE", "Имя файла:");
                data.put("FC_TYPE_FILE", "Тип файла:");
                data.put("FC_UP", "Вверх");
                data.put("FC_HOME", "Домашняя страница");
                data.put("FC_NEW_DIRECTORY", "Новая папка");
                data.put("FC_LIST", "Список");
                data.put("FC_TABLE", "Таблица");
                data.put("FC_NAME", "Имя");
                data.put("FC_SIZE", "Размер");
                data.put("FC_TYPE", "Тип");
                data.put("FC_DATE", "Дата");
                data.put("FC_ATTR", "Аттрибуты");
                data.put("FC_ALL_FILTER", "Все файлы");
                data.put("DATE", "Дата");
                data.put("ACCOUNT", "Счёт");
                data.put("FROM_ACCOUNT", "Откуда");
                data.put("TO_ACCOUNT", "Куда");
                data.put("ARTICLE", "Статья");
                data.put("AMOUNT", "Сумма");
                data.put("FROM_AMOUNT", "Снято");
                data.put("TO_AMOUNT", "Получено");
                data.put("NOTICE", "Примечание");
                data.put("TITLE", "Название");
                data.put("CODE", "Код");
                data.put("RATE", "Курс");
                data.put("ON", "Включена");
                data.put("BASE", "Базовая");
                data.put("ACCOUNTS", "Счета");
                data.put("ARTICLES", "Статьи");
                data.put("CURRENCIES", "Валюты");
                data.put("TRANSACTIONS", "Транзакции");
                data.put("TRANSFERS", "Переводы");
                data.put("LAST_TRANSACTIONS", "Последние транзакции");
                data.put("STATISTICS", "Статистика");
                data.put("CHART_NO_DATA", "Нет данных за выбранный период");
                data.put("CHART_INCOME", "Доходы по статьям");
                data.put("CHART_EXP", "Расходы по статьям");
                data.put("CONFIRM_EXIT_TEXT", "<html><center>"
                        + "Данные не сохранены.<br>"
                        + "Вы действительно хотите выйти без сохранения изменений?<br>"
                        + "Все несохраненные данные будут потерянны!"
                        + "</center></html>");
                data.put("CONFIRM_EXIT_TITLE", "Подтверждение выхода");
                data.put("CONFIRM_OVERLOAD_TEXT", "<html><center>"
                        + "Данные не сохранены.<br>"
                        + "Вы действительно хотите загрузить новые данные<br>"
                        + "без сохранения изменений?<br>"
                        + "Все несохраненные данные будут потерянны!"
                        + "</center></html>");
                data.put("CONFIRM_OVERLOAD_TITLE", "Подтверждение загрузки данных");
                data.put("CONFIRM_DELETE_TITLE", "Подтверждение удаления");
                data.put("CONFIRM_DELETE_TEXT", "Вы уверены, что хотите удалить данную запись?");
                
                data.put("CONFIRM_EDIT_TITLE", "Подтверждение внесения изменений");
                
                data.put("CONFIRM_EDIT_JOINED_QTY_ACCOUNTS", "Количество связанных счетов: ");
                data.put("CONFIRM_EDIT_JOINED_QTY_TRANSACTIONS", "Количество связанных операций: ");
                data.put("CONFIRM_EDIT_JOINED_QTY_TRANSFERS", "Количество связанных переводов: ");
                
                data.put("CONFIRM_EDIT_CURRENCY_TEXT", "<html><center>"
                        + "ВНИМАНИЕ!<br>"                        
                        +"Текущая валюта связана с другими данными!<br>"
                        +"Изменение этой курса валюты изменит другие данные.<br>"
                        +"Вы можете изменить название, это не изменит другие данные.<br>"
                        +"Хотите продолжить?"                        
                        + "</center></html>");                
                data.put("CONFIRM_EDIT_ACCOUNT_TEXT", "<html><center>"  
                        +"ВНИМАНИЕ!<br>" 
                        +"Текущий счёт связан с другими данными!<br>"
                        +"Изменение остатка на счёте вручную изменит другие данные.<br>"
                        +"Вы можете изменить название, это не изменит другие данные.<br>"
                        +"Хотите продолжить?"                        
                        + "</center></html>");                
                data.put("CONFIRM_EDIT_ARTICLE_TEXT", "<html><center>"                        
                        +"Текущая статья связана с другими данными!<br>"                        
                        +"Вы можете изменить название, это не изменит другие данные.<br>"
                        +"Хотите продолжить?"                        
                        + "</center></html>");                
                
                
                
                data.put("CAD","Канадский доллар");
                data.put("USD","Доллар США");
                data.put("EUR","Евро");
                data.put("GBR","Британский фунт");
                data.put("CNY","Китайская йена");
                data.put("BYN","Белорусский рубль");
                data.put("RUB","Российский рубль");
                data.put("KZT","Казахстанский тенге");
                data.put("UAH","Украинская гривна");
                data.put("VEF","Венесуэльский боливар");
                data.put("MAD","Марокканский дирхам");
                data.put("PHP","Филиппинское песо");
                data.put("COP","Колумбийское песо");
                data.put("CUP","Кубинский песо");
                data.put("MXN","Мексиканское песо");
                data.put("ILS","Израильский шекель");
                data.put("JPY","Японская йена");
                break;
            case "en":
                data.put("PROGRAMM_NAME", "Home accounting");
                data.put("MENU_FILE", "File");
                data.put("MENU_EDIT", "Edit");
                data.put("MENU_VIEW", "View");
                data.put("MENU_SETTINGS", "Settings");
                data.put("MENU_HELP", "Help");
                data.put("MENU_FILE_NEW", "New");
                data.put("MENU_FILE_OPEN", "Open");
                data.put("MENU_FILE_SAVE", "Save");
                data.put("MENU_FILE_UPDATE_CURRENCIES", "Update currencies");
                data.put("MENU_FILE_EXIT", "Exit");
                data.put("MENU_EDIT_ADD", "Add");
                data.put("MENU_EDIT_EDIT", "Edit");
                data.put("MENU_EDIT_DELETE", "Delete");
                data.put("MENU_VIEW_OVERVIEW", "Overview");
                data.put("MENU_VIEW_ACCOUNTS", "Accounts");
                data.put("MENU_VIEW_ARTICLES", "Categories");
                data.put("MENU_VIEW_TRANSACTIONS", "Operations");
                data.put("MENU_VIEW_TRANSFERS", "Transfers");
                data.put("MENU_VIEW_CURRENCIES", "Currencies");
                data.put("MENU_VIEW_STATISTICS", "Statistics");
                data.put("MENU_SETTINGS_LANGUAGE", "Language");
                data.put("MENU_SETTINGS_LANGUAGE_RUSSIAN", "Russian");
                data.put("MENU_SETTINGS_LANGUAGE_ENGLISH", "English");
                data.put("MENU_SETTINGS_LANGUAGE_FRENCH", "French");
                data.put("MENU_HELP_ABOUT", "About program");
                data.put("TOOLBAR_OVERVIEW", "Overview");
                data.put("TOOLBAR_ACCOUNTS", "Accounts");
                data.put("TOOLBAR_ARTICLES", "Categories");
                data.put("TOOLBAR_TRANSACTIONS", "Operations");
                data.put("TOOLBAR_TRANSFERS", "Transfers");
                data.put("TOOLBAR_CURRENCIES", "Currencies");
                data.put("TOOLBAR_STATISTICS", "Statistics");
                data.put("TOOLBAR_OVERVIEW_TOOLTIP", "Recent operations overview");
                data.put("TOOLBAR_ACCOUNTS_TOOLTIP", "<html><center>"
                        +"Places where you keep money<br>"
                        +"(bank-A, bank-B, cash in wallet, etc.)"
                        +"</center></html>");
                data.put("TOOLBAR_ARTICLES_TOOLTIP", "<html><center>"
                        +"Line items that describe your<br>"
                        +"income and expenses"
                        +"</center></html>");
                data.put("TOOLBAR_TRANSACTIONS_TOOLTIP", "<html><center>"
                        +"Records of the arrival of money<br>"
                        +"and the expenditure of money"
                        +"</center></html>");
                data.put("TOOLBAR_TRANSFERS_TOOLTIP", "Money flow on accounts");
                data.put("TOOLBAR_CURRENCIES_TOOLTIP", "<html><center>"
                        +"Different types of currencies<br>"
                        +"that can be used by you"
                        +"</center></html>");
                data.put("TOOLBAR_STATISTICS_TOOLTIP", "<html><center>"
                        +"Graph of your expenses or income<br>"
                        +"on various items"
                        +"</center></html>");
                data.put("JANUARY", "January");
                data.put("FEBRUARY", "February");
                data.put("MARCH", "Merch");
                data.put("APRIL", "April");
                data.put("MAY", "May");
                data.put("JUNE", "June");
                data.put("JULY", "July");
                data.put("AUGUST", "August");
                data.put("SEPTEMBER", "September");
                data.put("OCTOBER", "October");
                data.put("NOVEMBER", "November");
                data.put("DECEMBER", "December");
                data.put("TODAY", "Today");
                data.put("ERROR", "Error");
                data.put("ERROR_TITLE_EMPTY", "You did not enter a title");
                data.put("ERROR_IS_EXISTS", "This record already exists");
                data.put("ERROR_DATE_FORMAT", "Invalid date format");
                data.put("ERROR_CODE_EMPTY", "You did not specify a code");
                data.put("ERROR_CURRENCY_EMPTY", "You have not selected a currency");
                data.put("ERROR_ARTICLE_EMPTY", "You have not selected a category");
                data.put("ERROR_ACCOUNT_EMPTY", "You have not selected an account");
                data.put("ERROR_RATE_INCORRECT", "Invalid exchange rate value");
                data.put("ERROR_AMOUNT_FORMAT", "Invalid amount format");
                data.put("ERROR_NO_BASE_CURRENCY", "<html><center>"
                        + "Required primary currency!<br> "
                        + "Set this parameter first in a different currency, then it will be removed in this automatically."
                        + "</center></html>");
                data.put("ERROR_IS_BASE_CURRENCY", "<html><center>"
                        +"Primary currency cannot be deleted!<br>"
                        +"Set this parameter first in a different currency."
                        + "</center></html>");
                data.put("ERROR_IS_JOINED_CURRENCY", "<html><center>"
                        +"This currency cannot be deleted!<br>"
                        +"Currency linked to other data!<br>"
                        +"Deleting this currency will damage the data structure.<br>"
                        +"To delete a currency, you must first delete the associated data!"
                        + "</center></html>");
                data.put("ERROR_IS_JOINED_ACCOUNT", "<html><center>"
                        +"This account cannot be deleted!<br>"
                        +"Account linked to other data!<br>"
                        +"Deleting this account will damage the data structure. <br>"
                        +"To delete an account, you must first delete the associated data!"
                        + "</center></html>"); 
                data.put("ERROR_IS_JOINED_ARTICLE", "<html><center>"
                        +"This category cannot be deleted! <br>"
                        +"Category related to other data! <br>"
                        +"Deleting this category will damage the data structure.<br>"
                        +"To delete a category, you must first delete the associated data!"
                        + "</center></html>");
                data.put("ERROR_IS_JOINED_QTY_TRANSACTIONS", "Number of related transactions: ");
                data.put("ERROR_IS_JOINED_QTY_TRANSFERS", "Number of related transfers: ");
                data.put("ERROR_UPDATE_CURRENCIES", "Error of updating exchange rates");
                data.put("ERROR_LINE_NOT_SELECTED", "Object is not selected!");
                data.put("DIALOG_ABOUT_TITLE", "About the program");
                data.put("ABOUT", 
                        "<body style='font-size: 110%; text-align: center; width: 350px;'>"
                                + "<h1>Home Accounting</h1>"
                                + "<p><img src='file:images/main.png'></p>"
                                + "<p>This program is intended for home use"
                                + "<br/>Program was made using the video course"
                                + "<br/>\"Creating a large Java project\""
                                + "<p>Regards, Konstantin Knyazev</p>"
                                + "<br/><a style='font-weight:bold;' href='https://www.linkedin.com/in/konstantin-knyazev-b748b9132/'>www.linkedin.com/konstantin-knyazev</a></p>"
                                + "<p>Copyright "+Calendar.getInstance().get(Calendar.YEAR)+"</p>"
                                + "</body>");
                data.put("YES", "Yes");
                data.put("NO", "No");
                data.put("ADD", "Add");
                data.put("EDIT", "Edit");
                data.put("DELETE", "Delete");
                data.put("OK", "Ok");
                data.put("CANCEL", "Cancel");
                data.put("LABEL_TITLE", "Title");
                data.put("LABEL_CURRENCY", "Currency");
                data.put("LABEL_START_AMOUNT", "Start amount");
                data.put("LABEL_DATE", "Date");
                data.put("LABEL_ACCOUNT", "Account");
                data.put("LABEL_ARTICLE", "Category");
                data.put("LABEL_AMOUNT", "Available");
                data.put("LABEL_NOTICE", "Notice");
                data.put("LABEL_FROM_ACCOUNT", "From account");
                data.put("LABEL_TO_ACCOUNT", "To account");
                data.put("LABEL_FROM_AMOUNT", "From amount");
                data.put("LABEL_TO_AMOUNT", "To amount");
                data.put("LABEL_CODE", "Code");
                data.put("LABEL_RATE", "Exchange rate");
                data.put("LABEL_ON", "On");
                data.put("LABEL_BASE","Primary");
                data.put("LABEL_TYPE","Type of transaction");
                data.put("LABEL_INCOME","Income");
                data.put("LABEL_EXP","Expenses");
                data.put("BALANCE_CURRENCIES","Balance by currency");
                data.put("BALANCE","Total balance if in");
                data.put("TOOL_TIP_BALANCE_IN_ONE_CURRENCY","Total balance of all accounts in one currency");
                data.put("TOOL_TIP_RIGHT_PANEL_ACCOUNTS_HEADER","List of all user accounts");
                data.put("TOOL_TIP_RIGHT_PANEL_LAST_TRANSACTIONS_HEADER","List of recent user transactions");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_HEADER","User transaction record for the period");
                data.put("TOOL_TIP_RIGHT_PANEL_ARTICLES_HEADER","List of user expense items");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_HEADER","User money transfer list");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCIES_HEADER","User currency list");
                data.put("TOOL_TIP_RIGHT_PANEL_COMMON_CH","Sort on click");
                data.put("TOOL_TIP_RIGHT_PANEL_ACCOUNTS_CH_TITLE","Name of user accounts");//CH - COLUMN HEADER
                data.put("TOOL_TIP_RIGHT_PANEL_ACCOUNTS_CH_AMOUNT","Balance of each account");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_DATE","Transaction date");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_ACCOUNT","Account from which money was spent <br> or to which money was received");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_ARTICLE","User defined item");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_AMOUNT","Transaction amount");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_NOTICE","Additional operation details");
                data.put("TOOL_TIP_RIGHT_PANEL_ARTICLES_CH_TITLE","Name of the items of expenses-income");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_DATE","Date of transfer");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_FROM_ACCOUNT","Account from which the money was transferred");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_TO_ACCOUNT","Account to which money was transferred");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_FROM_AMOUNT","Amount debited from the account");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_TO_AMOUNT","Amount credited to the account");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_NOTICE","Additional information about money transfer");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_TITLE","Currency name");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_CODE","Universal international currency code");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_RATE","Exchange rate to the the currency set as the primary");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_ON","Is the currency available for use");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_BASE","Is the base(primary) currency for calculation");
                data.put("FC_OPEN", "Open");//FC - File Chooser
                data.put("FC_SAVE", "Save");
                data.put("FC_CANCEL", "Cancel");
                data.put("FC_LOOK", "Folder:");
                data.put("FC_NAME_FILE", "File name:");
                data.put("FC_TYPE_FILE", "File type:");
                data.put("FC_UP", "Up");
                data.put("FC_HOME", "Home");
                data.put("FC_NEW_DIRECTORY", "New directory");
                data.put("FC_LIST", "List");
                data.put("FC_TABLE", "Table");
                data.put("FC_NAME", "Name");
                data.put("FC_SIZE", "Size");
                data.put("FC_TYPE", "Type");
                data.put("FC_DATE", "Date");
                data.put("FC_ATTR", "Attributes");
                data.put("FC_ALL_FILTER", "All files");
                data.put("DATE", "Date");
                data.put("ACCOUNT", "Account");
                data.put("FROM_ACCOUNT", "From");
                data.put("TO_ACCOUNT", "To");
                data.put("ARTICLE", "Category");
                data.put("AMOUNT", "Amount");
                data.put("FROM_AMOUNT", "Money withdrawn");//Снятые деньги со счета - Money withdrawn from the account
                data.put("TO_AMOUNT", "Received");
                data.put("NOTICE", "Note");
                data.put("TITLE", "Title");
                data.put("CODE", "Code");
                data.put("RATE", "Exchange rate");
                data.put("ON", "On");
                data.put("BASE", "Primary");
                data.put("ACCOUNTS", "Accounts");
                data.put("ARTICLES", "Categories");
                data.put("CURRENCIES", "Currencies");
                data.put("TRANSACTIONS", "Transactions");
                data.put("TRANSFERS", "Money transfers");
                data.put("LAST_TRANSACTIONS", "Recent transactions");
                data.put("STATISTICS", "Statistics");
                data.put("CHART_NO_DATA", "No data for the selected period");
                data.put("CHART_INCOME", "Revenues");
                data.put("CHART_EXP", "Expenses for items");
                data.put("CONFIRM_EXIT_TEXT", "<html><center>"
                        + "Data not saved.<br>"
                        + "Are you sure you want to exit without saving changes?<br>"
                        + "All unsaved data will be lost! "
                        + "</center></html>");
                data.put("CONFIRM_EXIT_TITLE", "Exit confirmation");
                data.put("CONFIRM_OVERLOAD_TEXT", "<html><center>"
                        + "Data not saved.<br>"
                        + "Are you sure you want to upload new data<br>"
                        + "without saving changes?<br>"
                        + "All unsaved data will be lost!"
                        + "</center></html>");
                data.put("CONFIRM_OVERLOAD_TITLE", "Data Upload Confirmation");
                data.put("CONFIRM_DELETE_TITLE", "Deletion Confirmation");
                data.put("CONFIRM_DELETE_TEXT", "Are you sure you want to delete this entry?");
                data.put("CONFIRM_EDIT_TITLE", "Change confirmation");
                
                data.put("CONFIRM_EDIT_JOINED_QTY_ACCOUNTS", "Number of linked accounts: ");
                data.put("CONFIRM_EDIT_JOINED_QTY_TRANSACTIONS", "Number of linked transactions: ");
                data.put("CONFIRM_EDIT_JOINED_QTY_TRANSFERS", "Number of linked transfers: ");
                
                data.put("CONFIRM_EDIT_CURRENCY_TEXT", "<html><center>"
                        + "ATTENTION!<br>"                        
                        +"This currency is linked to other data!<br>"
                        +"Changing this exchange rate will change other data.<br>"
                        +"You can change the name, it will not change other data.<br>"
                        +"Want to continue?"                        
                        + "</center></html>");                
                data.put("CONFIRM_EDIT_ACCOUNT_TEXT", "<html><center>"  
                        +"ATTENTION!<br>" 
                        +"This account is linked to other data!<br>"
                        +"Changing the account balance manually will change other data.<br>"
                        +"You can change the name, it will not change other data.<br>"
                        +"Want to continue?"                        
                        + "</center></html>");                
                data.put("CONFIRM_EDIT_ARTICLE_TEXT", "<html><center>"                        
                        +"This categorie is linked to other data!<br>"                        
                        +"You can change the name, it will not change other data.<br>"
                        +"Want to continue?"                        
                        + "</center></html>");      
                data.put("CAD","Canadian dollar");
                data.put("USD","US Dollar");
                data.put("EUR","Euro");
                data.put("GBR","British Pound");
                data.put("CNY","Chinese yen");
                data.put("BYN","Belarusian ruble");
                data.put("RUB","Russian ruble");
                data.put("KZT","Kazakhstan tenge");
                data.put("UAH","Ukrainian hryvnia");
                data.put("VEF","Venezuelan Bolivar");
                data.put("MAD","Moroccan Dirham");
                data.put("PHP","Philippine Peso");
                data.put("COP","Colombian Peso");
                data.put("CUP","Cuban Peso");
                data.put("MXN","Mexican Peso");
                data.put("ILS","Israeli Shekel");
                data.put("JPY","Japanese Yen");
                break;
            case "fr":
                data.put("PROGRAMM_NAME", "Comptabilité à domicile");
                data.put("MENU_FILE", "Fichier");
                data.put("MENU_EDIT", "Modifier");
                data.put("MENU_VIEW", "Vue");
                data.put("MENU_SETTINGS", "Paramètres");
                data.put("MENU_HELP", "Aide");
                data.put("MENU_FILE_NEW", "Nouveau");
                data.put("MENU_FILE_OPEN", "Ouvrir");
                data.put("MENU_FILE_SAVE", "Enregistrer");
                data.put("MENU_FILE_UPDATE_CURRENCIES", "Mise à jour de la monnaie");
                data.put("MENU_FILE_EXIT", "Quitter");
                data.put("MENU_EDIT_ADD", "Ajouter");
                data.put("MENU_EDIT_EDIT", "Modifier");
                data.put("MENU_EDIT_DELETE", "Supprimer");
                data.put("MENU_VIEW_OVERVIEW", "Vue d'ensemble");
                data.put("MENU_VIEW_ACCOUNTS", "Comptes");
                data.put("MENU_VIEW_ARTICLES", "Catégories");
                data.put("MENU_VIEW_TRANSACTIONS", "Operations");
                data.put("MENU_VIEW_TRANSFERS", "Virements");
                data.put("MENU_VIEW_CURRENCIES", "Monnaies");
                data.put("MENU_VIEW_STATISTICS", "Statistiques");
                data.put("MENU_SETTINGS_LANGUAGE", "Langue");
                data.put("MENU_SETTINGS_LANGUAGE_RUSSIAN", "Langue Russe");
                data.put("MENU_SETTINGS_LANGUAGE_ENGLISH", "Langue Anglais");
                data.put("MENU_SETTINGS_LANGUAGE_FRENCH", "Français");
                data.put("MENU_HELP_ABOUT", "À propos de");
                data.put("TOOLBAR_OVERVIEW", "Vue d'ensemble");
                data.put("TOOLBAR_ACCOUNTS", "Comptes");
                data.put("TOOLBAR_ARTICLES", "Catégories");
                data.put("TOOLBAR_TRANSACTIONS", "Operations");
                data.put("TOOLBAR_TRANSFERS", "Virements");
                data.put("TOOLBAR_CURRENCIES", "Monnaies");
                data.put("TOOLBAR_STATISTICS", "Statistiques");
                data.put("TOOLBAR_OVERVIEW_TOOLTIP", "Présentation des opérations récentes");
                data.put("TOOLBAR_ACCOUNTS_TOOLTIP", "<html><center>"
                        +"Les endroits où vous gardez de l'argent<br>"
                        +"(banque-A, banque-B, argent dans le portefeuille, etc."
                        +"</center></html>");
                data.put("TOOLBAR_ARTICLES_TOOLTIP", "<html><center>"
                        +"Des enregistrements séparés décrivant<br>"
                        +"vos revenus et vos dépenses"
                        +"</center></html>");
                data.put("TOOLBAR_TRANSACTIONS_TOOLTIP", "<html><center>"
                        +"Registres de l'arrivée d'argent<br>"
                        +"et de la dépense d'argent "
                        +"</center></html>");
                data.put("TOOLBAR_TRANSFERS_TOOLTIP", "Le mouvement de l'argent aux comptes");
                data.put("TOOLBAR_CURRENCIES_TOOLTIP", "<html><center>"
                        +"Différents types de monnaies<br>"
                        +"que vous pouvez utiliser"
                        +"</center></html>");
                data.put("TOOLBAR_STATISTICS_TOOLTIP", "<html><center>"
                        +"Image graphique de vos dépenses ou revenus<br>"
                        +"sous divers catégories"
                        +"</center></html>");
                data.put("JANUARY", "Janvier");
                data.put("FEBRUARY", "Février");
                data.put("MARCH", "Mars");
                data.put("APRIL", "Avril");
                data.put("MAY", "May");
                data.put("JUNE", "Juin");
                data.put("JULY", "Juillet");
                data.put("AUGUST", "Août");
                data.put("SEPTEMBER", "Septembre");
                data.put("OCTOBER", "Octobre");
                data.put("NOVEMBER", "Novembre");
                data.put("DECEMBER", "Décembre");
                data.put("TODAY", "Aujourd'hui");
                data.put("ERROR", "Erreur");
                data.put("ERROR_TITLE_EMPTY", "Vous n'avez pas entré de nom");
                data.put("ERROR_IS_EXISTS", "Cet enregistrement existe déjà");
                data.put("ERROR_DATE_FORMAT", "Format de date invalide ");
                data.put("ERROR_CODE_EMPTY", "Vous n'avez pas entré le code");
                data.put("ERROR_CURRENCY_EMPTY", "Vous n'avez pas sélectionné de monnaie");
                data.put("ERROR_ARTICLE_EMPTY", "Vous n'avez pas sélectionné la catégorie");
                data.put("ERROR_ACCOUNT_EMPTY", "Vous n'avez pas sélectionné de compte");
                data.put("ERROR_RATE_INCORRECT", "Taux d'echange invalide");
                data.put("ERROR_AMOUNT_FORMAT", "Format de montant non valide ");
                data.put("ERROR_NO_BASE_CURRENCY", "<html><center>"
                        + "Monnaie par default requise!<br> "
                        + "Réglez d’abord ce paramètre dans une monnaie différente, puis il sera automatiquement supprimé. "
                        + "</center></html>");
                data.put("ERROR_IS_BASE_CURRENCY", "<html><center>"
                        +"La monnaie par default ne peut pas être supprimée!<br>"
                        +"Définissez cette option d'abord dans une autre monnaie. "
                        + "</center></html>");
                data.put("ERROR_IS_JOINED_CURRENCY", "<html><center>"
                        +"Monnaie actuelle ne peut pas être supprimée!<br>"
                        +"Monnaie liée à d'autres données!<br>"
                        +"La suppression de cette monnaie endommagera la structure des données.<br>"
                        +"Pour supprimer une monnaie, vous devez d'abord supprimer les données associées!"
                        + "</center></html>");
                data.put("ERROR_IS_JOINED_ACCOUNT", "<html><center>"
                        +"Le compte actuel ne peut pas être supprimé!<br>"
                        +"Le compte est lié à d'autres données!<br>"
                        +"La suppression de ce compte endommagera la structure des données.<br>"
                        +"Pour supprimer un compte, vous devez d'abord supprimer les données associées!"
                        + "</center></html>");
                data.put("ERROR_IS_JOINED_ARTICLE", "<html><center>"
                        +"La catégorie actuelle ne peut pas être supprimée!<br>"
                        +"Catégorie liée à d'autres données!<br>"
                        +"La suppression de cette catégorie endommagera la structure des données.<br>"
                        +"Pour supprimer une catégorie, vous devez d'abord supprimer les données associées!"
                        + "</center></html>");
                data.put("ERROR_IS_JOINED_QTY_TRANSACTIONS", "Nombre de transactions liées: ");
                data.put("ERROR_IS_JOINED_QTY_TRANSFERS", "Nombre de virements liés: ");
                data.put("ERROR_UPDATE_CURRENCIES", "Erreur lors de la mise à jour des taux de change ");
                data.put("ERROR_LINE_NOT_SELECTED", "Objet n'est pas choisi");
                data.put("DIALOG_ABOUT_TITLE", "A propos du programme");
                data.put("ABOUT", 
                        "<body style='font-size: 110%; text-align: center; width: 350px;'>"
                                + "<h1>Comptabilité à domicile</h1>"
                                + "<p><img src='file:images/main.png'></p>"
                                + "<p>Ce programme est destiné à un usage domestique."
                                + "<br/>Le programme a été réalisé en utilisant le cours vidéo"
                                + "<br/>\"Création d'un grand projet Java\""
                                + "<p>Cordialement, Konstantin Knyazev</p>"
                                + "<br/><a style='font-weight:bold;' href='https://www.linkedin.com/in/konstantin-knyazev-b748b9132/'>www.linkedin.com/konstantin-knyazev</a></p>"
                                + "<p>Copyright "+Calendar.getInstance().get(Calendar.YEAR)+"</p>"
                                + "</body>");
                data.put("YES", "Oui ");
                data.put("NO", "Non");
                data.put("ADD", "Ajouter");
                data.put("EDIT", "Modifier");
                data.put("DELETE", "Supprimer");
                data.put("OK", "Ok");
                data.put("CANCEL", " Annuler");
                data.put("LABEL_TITLE", "Titre");
                data.put("LABEL_CURRENCY", "Monnaie");
                data.put("LABEL_START_AMOUNT", "Solde initial");
                data.put("LABEL_DATE", "Date");
                data.put("LABEL_ACCOUNT", "Compte");
                data.put("LABEL_ARTICLE", "Catégorie");
                data.put("LABEL_AMOUNT", "Disponible");
                data.put("LABEL_NOTICE", "Notice");
                data.put("LABEL_FROM_ACCOUNT", "Du compte");
                data.put("LABEL_TO_ACCOUNT", "Au compte");
                data.put("LABEL_FROM_AMOUNT", "Montant sortie");
                data.put("LABEL_TO_AMOUNT", "Montant entree");
                data.put("LABEL_CODE", "Code");
                data.put("LABEL_RATE", "Taux d'echange");
                data.put("LABEL_ON", "Active");
                data.put("LABEL_BASE","Par default");
                data.put("LABEL_TYPE","Type de transaction");
                data.put("LABEL_INCOME","Revenu");
                data.put("LABEL_EXP","Dépenses");
                data.put("BALANCE_CURRENCIES","Solde par monnaie");
                data.put("BALANCE","Solde total si en");
                data.put("TOOL_TIP_BALANCE_IN_ONE_CURRENCY","Solde total de tous les comptes dans une monnaie");
                data.put("TOOL_TIP_RIGHT_PANEL_ACCOUNTS_HEADER","Liste de tous les comptes d'utilisateur");
                data.put("TOOL_TIP_RIGHT_PANEL_LAST_TRANSACTIONS_HEADER","Liste des transactions récentes d'utilisateur");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_HEADER","Enregistrement de transaction utilisateur pour la période");
                data.put("TOOL_TIP_RIGHT_PANEL_ARTICLES_HEADER","Liste des dépenses d'utilisateur");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_HEADER","Liste des virements d'argent d'utilisateur");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCIES_HEADER","Liste des monnaies d'utilisateur");
                data.put("TOOL_TIP_RIGHT_PANEL_COMMON_CH","Trier sur clic");
                data.put("TOOL_TIP_RIGHT_PANEL_ACCOUNTS_CH_TITLE","Nom des comptes d'utilisateur");//CH - COLUMN HEADER
                data.put("TOOL_TIP_RIGHT_PANEL_ACCOUNTS_CH_AMOUNT","Solde de chaque compte");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_DATE","Date de la transaction");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_ACCOUNT","Compte à partir duquel l'argent a été dépensé <br> ou vers lequel l'argent a été reçu");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_ARTICLE","Élément défini par l'utilisateur");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_AMOUNT","Montant de la transaction");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_NOTICE","Détails d'operation supplémentaires");
                data.put("TOOL_TIP_RIGHT_PANEL_ARTICLES_CH_TITLE","Nom des postes de dépenses-revenus");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_DATE","Date du virement");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_FROM_ACCOUNT","Compte à partir duquel l'argent a été transféré");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_TO_ACCOUNT","Compte sur lequel l'argent a été transféré");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_FROM_AMOUNT","Montant débité du compte");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_TO_AMOUNT","Montant crédité sur le compte");
                data.put("TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_NOTICE","Informations supplémentaires sur le virement d'argent");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_TITLE","Nom de la monnaie");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_CODE","Code de la monnaie international universel");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_RATE","Taux d'echange par rapport à la monnaie par default actuelle");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_ON","Monnaie est-elle disponible pour utilisation");
                data.put("TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_BASE","Est la monnaie par default pour le calcul");
                data.put("FC_OPEN", "Ouvrir");//FC - File Chooser
                data.put("FC_SAVE", "Sauvegarder");
                data.put("FC_CANCEL", "Annuler");
                data.put("FC_LOOK", "Dossier:");
                data.put("FC_NAME_FILE", "Nom de fichier:");
                data.put("FC_TYPE_FILE", "Type de fichier:");
                data.put("FC_UP", "Up");
                data.put("FC_HOME", "Accueil");
                data.put("FC_NEW_DIRECTORY", "Nouveau dossier");
                data.put("FC_LIST", "Liste");
                data.put("FC_TABLE", "Table");
                data.put("FC_NAME", "Nom");
                data.put("FC_SIZE", "Taille");
                data.put("FC_TYPE", "Type");
                data.put("FC_DATE", "Date");
                data.put("FC_ATTR", "Attributs");
                data.put("FC_ALL_FILTER", "Tous les fichiers");
                data.put("DATE", "Date");
                data.put("ACCOUNT", "Compte");
                data.put("FROM_ACCOUNT", "De");
                data.put("TO_ACCOUNT", "À");
                data.put("ARTICLE", "Catégorie");
                data.put("AMOUNT", "Montant");
                data.put("FROM_AMOUNT", "Montant retiré");//Снятые деньги со счета - Money withdrawn from the account
                data.put("TO_AMOUNT", "Montant reçu ");
                data.put("NOTICE", "Remarque");
                data.put("TITLE", "Title");
                data.put("CODE", "Code");
                data.put("RATE", "Taux d'echange");
                data.put("ON", "Active");
                data.put("BASE", "Par default");
                data.put("ACCOUNTS", "Comptes");
                data.put("ARTICLES", "Catégories");
                data.put("CURRENCIES", "Monnaies");
                data.put("TRANSACTIONS", "Transactions");
                data.put("TRANSFERS", "Virements d'argent");
                data.put("LAST_TRANSACTIONS", "Transactions récentes");
                data.put("STATISTICS", "Statistiques");
                data.put("CHART_NO_DATA", "Aucune donnée pour la période sélectionnée");
                data.put("CHART_INCOME", "Revenus");
                data.put("CHART_EXP", "Dépenses par les catégories");
                data.put("CONFIRM_EXIT_TEXT", "<html><center>"
                        + "Données non enregistrées.<br>"
                        + "Voulez-vous vraiment quitter sans enregistrer les modifications?<br>"
                        + "Toutes les données non enregistrées seront perdues! "
                        + "</center></html>");
                data.put("CONFIRM_EXIT_TITLE", "Confirmation de sortie");
                data.put("CONFIRM_OVERLOAD_TEXT", "<html><center>"
                        + "Données non enregistrées.<br>"
                        + "Voulez-vous vraiment télécharger de nouvelles données<br>"
                        + "sans enregistrer les modificationssans enregistrer les modifications?<br>"
                        + "Toutes les données non enregistrées seront perdues!"
                        + "</center></html>");
                data.put("CONFIRM_OVERLOAD_TITLE", "Confirmation de téléchargement des données");
                data.put("CONFIRM_DELETE_TITLE", "Confirmation de suppression");
                data.put("CONFIRM_DELETE_TEXT", "Voulez-vous vraiment supprimer cette entrée?");
                data.put("CONFIRM_EDIT_TITLE", "Confirmation de modification");
                
                data.put("CONFIRM_EDIT_JOINED_QTY_ACCOUNTS", "Nombre de comptes liés: ");
                data.put("CONFIRM_EDIT_JOINED_QTY_TRANSACTIONS", "Nombre de transactions liées: ");
                data.put("CONFIRM_EDIT_JOINED_QTY_TRANSFERS", "Nombre de virements liés: ");
                
                data.put("CONFIRM_EDIT_CURRENCY_TEXT", "<html><center>"
                        + "ATTENTION!<br>"                        
                        +"Cette monnaie est associée à d'autres données!<br>"
                        +"La modification du taux de cette monnaie modifiera d'autres données.<br>"
                        +"Vous pouvez changer le nom, cela ne changera pas les autres données.<br>"
                        +"Voulez-vous continuer?"                        
                        + "</center></html>");                
                data.put("CONFIRM_EDIT_ACCOUNT_TEXT", "<html><center>"  
                        +"ATTENTION!<br>" 
                        +"Ce compte est associé à d'autres données!<br>"
                        +"La modification manuelle du solde du compte modifiera d'autres données.<br>"
                        +"Vous pouvez changer le nom, cela ne changera pas les autres données.<br>"
                        +"Voulez-vous continuer?"                        
                        + "</center></html>");                
                data.put("CONFIRM_EDIT_ARTICLE_TEXT", "<html><center>"                        
                        +"Cette catégorie est liée à d'autres données<br>"                        
                        +"Vous pouvez changer le nom, cela ne changera pas les autres données.<br>"
                        +"Voulez-vous continuer?"                        
                        + "</center></html>");      
                data.put("CAD","Dollar canadien");
                data.put("USD","Dollar américain");
                data.put("EUR","Euro");
                data.put("GBR","Livre sterling");
                data.put("CNY","Yen chinois");
                data.put("BYN","Rouble biélorusse");
                data.put("RUB","Rouble russe");
                data.put("KZT","Tenge du Kazakhstan");
                data.put("UAH","Hryvnia ukrainienne");
                data.put("VEF","Bolivar vénézuélien");
                data.put("MAD","Dirham marocain");
                data.put("PHP","Peso philippin");
                data.put("COP","Peso colombien");
                data.put("CUP","Peso cubain");
                data.put("MXN","Peso mexicain");
                data.put("ILS","Shekel israélien");
                data.put("JPY","Yen japonais");
                break;
            default:
                break;
        }
        
        
    }

}//class
