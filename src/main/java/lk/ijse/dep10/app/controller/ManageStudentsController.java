package lk.ijse.dep10.app.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep10.app.db.DBConnection;
import lk.ijse.dep10.app.model.Student;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.sql.*;

public class ManageStudentsController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNewStudent;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<Student> tblEmployee;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    public void initialize() {

        tblEmployee.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblEmployee.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblEmployee.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        loadAllStudents();

        tblEmployee.getSelectionModel().selectedItemProperty().addListener((observableValue, student, current) -> {

            btnDelete.setDisable(current == null);
            if (current == null) {
                return;
            }
            txtId.setText(current.getId() + "");
            txtName.setText(current.getName() + "");
            txtAddress.setText(current.getName() + "");

        });

        //Platform.runLater(btnNew::fire);


    }

    private void loadAllStudents() {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM Student");
            //PreparedStatement stm2 = connection.prepareStatement("SELECT * FROM Student WHERE id=?, name=?,");


            while (rst.next()) {
                String id = rst.getString("id");
                String name = rst.getString("name");
                String address = rst.getString("address");

                Student student = new Student(id, name, address);
                tblEmployee.getItems().add(student);
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "failed ").showAndWait();
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnNewStudentOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        //if (!isDataValid()) return;

        String id = txtId.getText();

        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement stmStudent = connection.prepareStatement("INSERT INTO Student (id, name,address) VALUES (?,?,?)");
            //PreparedStatement stmPicture = connection.prepareStatement("INSERT INTO Picture (student_id, picture) VALUES (?, ?)");

            stmStudent.setString(1, txtId.getText());
            stmStudent.setString(2, txtName.getText());
            stmStudent.setString(3, txtAddress.getText());
            stmStudent.executeUpdate();

            connection.commit();
            Student student = new Student(id, txtName.getText(), txtAddress.getText());
            tblEmployee.getItems().add(student);
            //btnNew.fire();
        } catch (Throwable e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to save the student").show();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
