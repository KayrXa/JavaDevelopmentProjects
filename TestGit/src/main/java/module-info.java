module com.example.testgit {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testgit to javafx.fxml;
    exports com.example.testgit;
}