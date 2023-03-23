package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainSceneController {

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnEmployees;

    @FXML
    private Button btnStudent;

    @FXML
    private Button btnTeachers;

    @FXML
    void btnCustomersOnAction(ActionEvent event) {

    }

    @FXML
    void btnEmployeesOnAction(ActionEvent event) {

    }

    @FXML
    void btnStudentOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/ManageStudents.fxml"))));
        stage.setTitle("Student Management System");
        stage.show();
        stage.setResizable(false);
        stage.centerOnScreen();

    }

    @FXML
    void btnTeachersOnAction(ActionEvent event) {

    }

}
