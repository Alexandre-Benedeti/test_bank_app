package com.project.personal.app_bank.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("bankAccont")
    @Expose
    private String bankAccount;

    @SerializedName("userId")
    @Expose
    private int userId;

    @SerializedName("balance")
    @Expose
    private float balance;

//
//    public User(String name, String bankAccount, int userId, float balance, String text) {
//        this.name = name;
//        this.bankAccount = bankAccount;
//        this.userId = userId;
//        this.balance = balance;
//    }

    public String getName() {
        return name;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public int getUserId() {
        return userId;
    }

    public float getBalance() {
        return balance;
    }
}
