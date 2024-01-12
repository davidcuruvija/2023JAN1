module com.example._2023jan1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example._2023jan1 to javafx.fxml;
    exports com.example._2023jan1;
}