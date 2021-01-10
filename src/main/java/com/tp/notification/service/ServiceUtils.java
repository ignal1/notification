package com.tp.notification.service;

class ServiceUtils {

    static String threeDigitCheck(String field){
        if(field == null){
            return null;
        } else{
            String tmp = "";
            if(field.length() == 1){
                return "00" + field;
            } else if(field.length() == 2){
                return "0" + field;
            } else if (field.length() == 3){
                return field;
            } else{
                return tmp;
            }
        }
    }

    static String twoDigitCheck(String field){
        if(field == null){
            return null;
        } else{
            String tmp = "";
            if(field.length() == 1){
                return "0" + field;
            } else if (field.length() == 2){
                return field;
            } else{
                return tmp;
            }
        }
    }
}
