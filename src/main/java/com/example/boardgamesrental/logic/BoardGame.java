package com.example.boardgamesrental.logic;

public class BoardGame {
    private String name;
    private int id;
    private static int maxID = 0;
    private int price; //??????
    private int stocked; //??????
    private String description;

    public BoardGame(String name, int price, int stocked, String description) {
        this.id = ++maxID;
        this.name = name;
        this.price = price;
        this.stocked = stocked;
        this.description = description;
    }

    public BoardGame(String line){
        //id + ":" + name + ":" + price + ":" + stocked + ":" + description ;
        String[] elements = line.split(":");
        this.id = Integer.parseInt(elements[0]);
        if (maxID < this.id) maxID = this.id;
        this.name = elements[1];
        this.price = Integer.parseInt(elements[2]);
        this.stocked = Integer.parseInt(elements[3]);
        this.description = elements[4];
        //1:monopoly:2:10:wesola gra monopolia!!!!!!
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStocked() {
        return stocked;
    }

    public void setStocked(int stocked) {
        this.stocked = stocked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return id + ":" + name + ":" + price + ":" + stocked + ":" + description ;
    }
}
