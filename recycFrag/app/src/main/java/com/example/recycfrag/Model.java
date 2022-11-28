package com.example.recycfrag;

public class Model {
    String name;
    int image;
    String desc;
    public Model(String name,int img,String desc) {
        this.image=img;
        this.name=name;
        this.desc=desc;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
    public String getDesc(){
        return desc;
    }
}
