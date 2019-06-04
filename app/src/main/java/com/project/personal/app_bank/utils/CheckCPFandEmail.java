package com.project.personal.app_bank.utils;

public class CheckCPFandEmail {

    public boolean checkEmail(String s) {
        boolean email = s.matches("\\w+@\\w+\\.\\w{2,3}\\.\\w{2,3}");
        return email;
    }


//    public boolean checkCPF(String s) {
//
//        return false;
//    }
}
