package com.example.recyclerview;

public class contact_model {
    int image;
    String number,name;
    public contact_model(int image,String name,String number){
        this.image=image;
        this.name=name;
        this.number=number;
    }
    public contact_model(String name,String number){
        this.name=name;
        this.number=number;
    }



}
