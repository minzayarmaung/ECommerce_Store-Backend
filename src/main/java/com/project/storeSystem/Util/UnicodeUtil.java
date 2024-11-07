package com.project.storeSystem.Util;

public class UnicodeUtil {

    // Check if the Character is Burmese Character Or Not
    public static boolean checkMyanmarCharacter(String text){
        if(text == null || text.isEmpty()){
            return false;
        }
        for (char c : text.toCharArray()){
            if (c >= '\u1000' && c <= '\u109f'){
                return true;
            }
        }
        return false;
    }
}
