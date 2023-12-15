module com.example.boardgamesrental {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.boardgamesrental to javafx.fxml;
    exports com.example.boardgamesrental;
}