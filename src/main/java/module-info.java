module com.example.jeux_6_qui_prend {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.jeux_6_qui_prend to javafx.fxml;
    exports com.example.jeux_6_qui_prend;
}