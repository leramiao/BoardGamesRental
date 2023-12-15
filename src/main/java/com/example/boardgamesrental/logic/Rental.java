package com.example.boardgamesrental.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Rental {

    private static final String GAME_DATA_FILE = "games_data.txt";

    private List<User> userList;
    private List<BoardGame> gameList;

    public Rental() {
        userList = new ArrayList<>();
        gameList = new ArrayList<>();
        loadGameData();

    }



    private boolean isNameTaken(String gameName){
        for (BoardGame g : gameList){
            if (g.getName().equals(gameName)){
                return true;
            }
        }
        return false;
    }
    public boolean addGame(String gameName, int price, int stocked, String desc){
        if (isNameTaken(gameName)){
            return false;
        }
        BoardGame game = new BoardGame(gameName, price, stocked, desc);
        return gameList.add(game);
    }

    public boolean signUp(String username, String password){
        return false;
    }
    public User login(String username, String password){
        return null;
    }
    public void logout(){

    }
    public boolean saveGameData(){ //w celach testowania, ew. private
        System.out.println("saving mode.. " + gameList.size() + " games to save");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(GAME_DATA_FILE, false));
            for (BoardGame game : gameList){
                System.out.println("saving a game..."); //testt
                writer.write(game.toString());
                writer.write("\n");
            }
            writer.flush();
            writer.close();

        } catch (Exception e){
            return false;
        }
        return true;

    }
    private boolean loadGameData(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(GAME_DATA_FILE));
            List<String> lines = reader.lines().toList();
            System.out.println("loading mode.. " + lines.size() + " games to load");
            for (String line : lines){
                System.out.print("loading a game..."); //testt
                System.out.println(line);
                gameList.add(new BoardGame(line));
            }
            System.out.println("exiting loading mode.. " + gameList.size() + " games loaded");
            reader.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }


    public List<BoardGame> getGameList() { //w celach testowania, moze usune pozniej
        return gameList;
    }
}
