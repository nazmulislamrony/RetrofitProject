package com.example.retrofitprayertime;

public class Post {
    private String name;
    private String realname;

    public Post(String name, String realname) {
        this.name = name;
        this.realname = realname;
    }

    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }
}
