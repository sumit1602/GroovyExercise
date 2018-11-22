package com.ttn.linksharing.enums;

public enum Visibilitynew {
    PUBLIC, PRIVATE;
    public static Visibility convertVisibility(String str){
        if("PUBLIC" == str.toUpperCase()){
            return Visibility.PUBLIC;
        }else{
            return Visibility.PRIVATE;
        }
    }
}
