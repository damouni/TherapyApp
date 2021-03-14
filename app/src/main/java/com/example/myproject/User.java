package com.example.myproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class User {
    private long id;
    private String name;
    private String phone;
    private String passWord;


    public User() {
    }

    public User(String name, String phone, String passWord) {
        this.id=0;
        this.name = name;
        this.phone = phone;
        this.passWord=passWord;

    }

    public User(long id, String name, String phone, String passWord) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.passWord = passWord;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}

