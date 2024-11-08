module org.example.opt2_wk3_inclassex {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.opt2_wk3_inclassex to javafx.fxml;
    exports org.example.opt2_wk3_inclassex;
}