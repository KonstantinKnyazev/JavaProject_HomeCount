/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.model;

import personalfinance.saveload.SaveData;

/**
 *
 * @author Konstantin_Knyazev
 */
abstract public class Common {

    public Common() {
    }
            
    public String getValueForComboBox() {
        return null;
    }
    
    public void postAdd(SaveData sd){}
    public void postEdit(SaveData sd){}
    public void postRemouve(SaveData sd){}
    
}
