package com.example.the_spring_cinema_lab.models;

public class Reply {

    private String message;

    public Reply(String message){
        this.message = message;
    }

    public Reply(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
