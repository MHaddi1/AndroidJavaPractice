package com.example.recylerviewpractice;

public class Lang {
    private  String title;
    private String shortdesc;
    private int image;

    public Lang(String title, String shortdesc,int image) {
    this.image=image;
    this.shortdesc=shortdesc;
    this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public int getImage() {
        return image;
    }
}
