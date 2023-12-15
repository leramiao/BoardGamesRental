package com.example.boardgamesrental.logic;

public class Admin extends User{

    public Admin(String username) {
        super(username);
    }

    public boolean addGame(String gameName, int price, int stocked, String desc){
        return false;
    }
    public boolean removeGame(int gameID){
        return false;
    }public boolean editGame(int gameID){
        return false;
    }
}
