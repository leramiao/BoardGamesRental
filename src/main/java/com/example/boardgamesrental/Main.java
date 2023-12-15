package com.example.boardgamesrental;

import com.example.boardgamesrental.logic.BoardGame;
import com.example.boardgamesrental.logic.Rental;

import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static Rental rental;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        rental = new Rental();
        //rental.getGameList().add(new BoardGame("monopoly", 2,10, "wesola gra monopolia!!!!!!"));
        //rental.getGameList().add(new BoardGame("monopoly2", 200,10, "mega wesola gra monopolia 2!"));
        System.out.println(rental.saveGameData());
    }

    public static void loginDialog(){
        String username, password;
        System.out.print("username: ");
        username = scanner.nextLine();
        System.out.print("password: ");
        password = scanner.nextLine();
        rental.login(username, password);
    }
    public static void signupDialog(){
        String username, password;
        System.out.print("username: ");
        username = scanner.nextLine();
        System.out.print("password: ");
        password = scanner.nextLine();
        boolean success = rental.signUp(username, password);
    }

}
