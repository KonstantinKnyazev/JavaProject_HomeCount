/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.exception;

/**
 *
 * @author Konstantin_Knyazev
 */
public class ModelException extends Exception {

    public static final int TITLE_EMPTY = 1;
    public static final int IS_EXISTS = 2;
    public static final int DATE_FORMAT = 3;
    public static final int CODE_EMPTY = 4;
    public static final int CURRENCY_EMPTY = 5;
    public static final int ARTICLE_EMPTY = 6;
    public static final int ACCOUNT_EMPTY = 7;
    public static final int RATE_INCORRECT = 8;
    public static final int AMOUNT_FORMAT = 9;
    public static final int NO_BASE_CURRENCY = 10;
    public static final int IS_BASE_CURRENCY = 11;
    public static final int IS_JOINED_CURRENCY = 12;
    public static final int IS_JOINED_ACCOUNT = 13;
    public static final int IS_JOINED_ARTICLE = 14;
    public static final int LINE_NOT_SELECTED = 15;

    private final int code;
    private String info;
    
    public ModelException(int code, String info) {
        this.code = code;
        this.info = info;
    }
    
    public ModelException(int code) {
        this(code,"");
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String getMessage() {
        switch (code) {
            case TITLE_EMPTY:
//             return Text.get("ERROR_TITLE_EMPTY");
                return "ERROR_TITLE_EMPTY";
            case IS_EXISTS:
//             return Text.get("ERROR_IS_EXISTS");
                return "ERROR_IS_EXISTS";
            case DATE_FORMAT:
//             return Text.get("ERROR_DATE_FORMAT");
                return "ERROR_DATE_FORMAT";
            case CODE_EMPTY:
//             return Text.get("ERROR_CODE_EMPTY");
                return "ERROR_CODE_EMPTY";
            case CURRENCY_EMPTY:
//             return Text.get("ERROR_CURRENCY_EMPTY");
                return "ERROR_CURRENCY_EMPTY";
            case ARTICLE_EMPTY:
//             return Text.get("ERROR_ARTICLE_EMPTY");
                return "ERROR_ARTICLE_EMPTY";
            case ACCOUNT_EMPTY:
//             return Text.get("ERROR_ACCOUNT_EMPTY");
                return "ERROR_ACCOUNT_EMPTY";
            case RATE_INCORRECT:
//             return Text.get("ERROR_RATE_INCORRECT");
                return "ERROR_RATE_INCORRECT";
            case AMOUNT_FORMAT:
//             return Text.get("ERROR_AMOUNT_FORMAT");
                return "ERROR_AMOUNT_FORMAT";
            case NO_BASE_CURRENCY:
//             return Text.get("ERROR_NO_BASE_CURRENCY");
                return "ERROR_NO_BASE_CURRENCY";
            case IS_BASE_CURRENCY:
//             return Text.get("ERROR_NO_BASE_CURRENCY");
                return "ERROR_IS_BASE_CURRENCY";
            case IS_JOINED_CURRENCY:             
                return "ERROR_IS_JOINED_CURRENCY";
            case IS_JOINED_ACCOUNT:             
                return "ERROR_IS_JOINED_ACCOUNT";
            case IS_JOINED_ARTICLE:             
                return "ERROR_IS_JOINED_ARTICLE";
            case LINE_NOT_SELECTED:             
                return "ERROR_LINE_NOT_SELECTED";

        }
        return "";
    }
}
