package com.example.boardgamesrental.logic;

public class User {
    private String username;
    private int id;
    private static int maxID = 0;

    public User(String username) {
        this.id = ++maxID;
        this.username = username;
    }
    public User(String username, int id) {
        this.id = id;
        if (maxID < id) maxID = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }
}
