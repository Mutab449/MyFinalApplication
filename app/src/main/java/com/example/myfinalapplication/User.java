package com.example.myfinalapplication;

public class User {


    String id;
    String name;
    String phone;
    String email;


    public User(){

    }

    public User(String id, String name, String phone, String email){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email =  email;
    }


    public String getID(){
        return this.id;
    }


    public void setID(String id){
        this.id = id;
    }

    public String getName(){ return this.name; }

    public void setName(String name){
        this.name = name;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }



}
