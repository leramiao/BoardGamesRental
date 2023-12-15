package com.example.boardgamesrental.logic;

public class User {
    private String username;
    private int id;
    private static int maxID = 0;

    public User(String username) {
        this.id = ++maxID;
        this.username = username;
    }
}
