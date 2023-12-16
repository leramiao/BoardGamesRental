package com.example.boardgamesrental.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Rental {

    private static final String GAME_DATA_FILE = "games_data.txt";
    private static final String LOGIN_DATA_FILE = "login_data.txt";

    private List<User> userList;
    private User activeUser;
    private List<BoardGame> gameList;

    public Rental() {
        userList = new ArrayList<>();
        loadUserData();
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
    public int addCustomer(String username){
        User user = new Customer(username);
        userList.add(user);
        return user.getId();
    }

    public boolean signUp(String username, String password){ //tylko customer ofc
        try {
            BufferedReader reader = new BufferedReader(new FileReader(LOGIN_DATA_FILE));
            List<String> lines = reader.lines().toList();
            for (String line : lines){
                if (line.split(":")[1].equals(username)){ //is username taken
                    return false; //trzeba bedzie dodac custom exceptions
                }
            }
            reader.close();

            int userID = addCustomer(username);
            BufferedWriter writer = new BufferedWriter(new FileWriter(LOGIN_DATA_FILE, true));
            String userData = userID + ":" + username + ":" + password + ":" + "0\n"; //0 - customer perms
            writer.write(userData);
            writer.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public User login(String username, String password){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(LOGIN_DATA_FILE));
            List<String> lines = reader.lines().toList();
            String[] userData;
            for (String line : lines){
                userData = line.split(":");//id:username:password:perms
                if (userData[1].equals(username) && userData[2].equals(password)){
                    if (userData[3].equals("1")){
                        activeUser = new Admin(username, Integer.parseInt(userData[0]));
                    }
                    else if (userData[3].equals("0")){
                        activeUser = new Customer(username, Integer.parseInt(userData[0]));
                    }
                    else {
                        return null; //cant read perms, throw smth
                    }
                    return activeUser;
                }
            }
            reader.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }
    public void logout(){
        activeUser = null;
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

    public User getActiveUser() { //w celach testowania
        return activeUser;
    }

    public boolean loadUserData(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(LOGIN_DATA_FILE));
            List<String> lines = reader.lines().toList();
            String[] userData;
            User iterUser;
            for (String line : lines){
                userData = line.split(":");//id:username:password:perms
                if (userData[3].equals("1")){
                    iterUser = new Admin(userData[1], Integer.parseInt(userData[0]));
                }
                else if (userData[3].equals("0")){
                    iterUser = new Customer(userData[1], Integer.parseInt(userData[0]));
                }
                else {
                    return false; //cant read perms, throw smth
                }
                userList.add(iterUser);

            }
            reader.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean saveUserData(){
        /*
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(LOGIN_DATA_FILE, true));
            String userData;
            for (User user : userList){
                userData = user.getId() + ":" + user.getUsername() + ":" + password + ":" + "0\n"; //0 - customer perms
            }
            writer.write(userData);
            writer.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }*/
        return false;
    }
}
