package com.example.boardgamesrental;

import com.example.boardgamesrental.logic.Rental;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Scanner;

import static javafx.application.Application.launch;

public class Main extends Application {
    private static Scanner scanner;
    private static Rental rental;
    public static void main(String[] args) {
        //scanner = new Scanner(System.in);
        rental = new Rental();
        launch(args);
        //juz wpisane
        //rental.getGameList().add(new BoardGame("monopoly", 2,10, "wesola gra monopolia!!!!!!"));
        //rental.getGameList().add(new BoardGame("monopoly2", 200,10, "mega wesola gra monopolia 2!"));
        System.out.println(rental.saveGameData());

        System.out.println(rental.getActiveUser().getUsername() + " is active");
        rental.logout();
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

    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Label user_id=new Label("User ID");
        Label password = new Label("Password");
        TextField tf=new TextField();
        PasswordField pf=new PasswordField();
        pf.setPromptText("Enter Password");
        Button b = new Button("Submit");
        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                rental.login(tf.getText(), pf.getText());
                primaryStage.close();

            }
        } );
        GridPane root = new GridPane();
        root.addRow(0, user_id, tf);
        root.addRow(1, password, pf);
        root.addRow(5, b);
        Scene scene=new Scene(root,300,200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("PasswordField Example");
        primaryStage.show();
    }

}
