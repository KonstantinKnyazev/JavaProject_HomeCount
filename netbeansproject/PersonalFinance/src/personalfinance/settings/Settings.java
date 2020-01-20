/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.settings;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import org.ini4j.Ini;
import org.ini4j.IniPreferences;
import org.ini4j.Wini;

/**
 *
 * @author Konstantin_Knyazev
 */
final public class Settings {

    public static final File FONT_ROBOTO_LIGHT = new File("fonts/Roboto-Light.ttf");
    public static final File SAVE_DIR = new File("saves/");
    public static final String SAVE_FILE_EXT = "kkv";

    public static final String FORMAT_AMOUNT = "%.2f";
    public static final String FORMAT_RATE = "%.4f";
    public static final String FORMAT_DATE = "dd.MM.yyyy";
    public static final String FORMAT_DATE_MONTH = "MMMM yyyy";
    public static final String FORMAT_DATE_YEAR = "yyyy";

    public static final int COUNT_OVERVIEW_ROWS = 10;

    public static final String[] CURRENCY_CODES = new String[]{ "CAD", "USD", "EUR","GBR", "CNY", "BYN", "RUB", "KZT", "UAH", "VEF", "MAD","PHP","COP","CUP", "MXN","ILS","JPY"};  


    private static final File FILE_SETTINGS = new File("saves/settings.ini");
    private static File FILE_SAVE = new File("saves/default.kkv");

    private static String LANGUAGE = "en";
   
    
    public static void init() {
        try {
            Ini ini = new Ini(FILE_SETTINGS);
            Preferences prefs = new IniPreferences(ini);
            String file = prefs.node("Settings").get("FILE_SAVE", null);
            if (file != null) {
                FILE_SAVE = new File(file);
            }
            //here we take LANGUAGE from ini file
            String language = prefs.node("Settings").get("LANGUAGE", null);
            if (language != null) {
                LANGUAGE = language;
//                System.out.println("personalfinance.settings.Settings.init()" + " language = "+language);
            }
//            System.out.println(FILE_SAVE.getAbsolutePath());

            setLocale();
        } catch (IOException ex) {
            save();
//            System.out.println("Вот эта ошибка" + ex.getMessage());
//            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
//            save();
        }
    }

    public static File getFileSave() {
        return FILE_SAVE;
    }

    public static void setFileSave(File file) {
        Settings.FILE_SAVE = file;
        save();
    }    
    
    public static String getLanguage() {
        return LANGUAGE;
    }

    public static void setLanguage(String language) {
        LANGUAGE = language;
        setLocale();
        save();
    }   

    private static void setLocale() {
//        Locale.setDefault(new Locale("ru"));
//        if (LANGUAGE.equals("ru")) {
//            Locale.setDefault(new Locale("ru"));
//        } else {
//            Locale.setDefault(new Locale("en"));
//        }
        String lang = "";
        String countr = "";
        switch (LANGUAGE) {
            case "ru":
                lang = "ru";
                countr = "RU";
                System.out.println("personalfinance.settings.Settings.setLocale()" + " lang = " +lang +", countr = " +countr);
                break;
            case "en":
                lang = "en";
                countr = "CA";
                System.out.println("personalfinance.settings.Settings.setLocale()" + " lang = " +lang +", countr = " +countr);
                break;
            case "fr":
                lang = "fr";
                countr = "CA";
                System.out.println("personalfinance.settings.Settings.setLocale()" + " lang = " +lang +", countr = " +countr);
                break;
        }
        Locale.setDefault(new Locale(lang, countr));
        System.out.println("personalfinance.settings.Settings.setLocale()" + " lang = " +lang +", countr = " +countr +", locale = " + Locale.getDefault());
    }

    public static void save() {
        try {
            Wini ini = new Wini(FILE_SETTINGS);
            if (FILE_SAVE != null) {
                ini.put("Settings", "FILE_SAVE", FILE_SAVE.getAbsolutePath().replace("\\", "\\\\"));
            }
            ini.store();
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}//class
