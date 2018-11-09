package com.example.kein_gold.menutest.utils;

public class NotNull {

    public static boolean validation(String... arr) {
        for (String anArr : arr) {
            if (anArr == null || anArr.trim() == "") {
                return false;
            }
        }
        return true;
    }
}
