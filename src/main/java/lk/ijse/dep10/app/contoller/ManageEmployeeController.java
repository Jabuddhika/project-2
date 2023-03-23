package lk.ijse.dep10.app.contoller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.dep10.app.contoller.mod.DBConnection;
import lk.ijse.dep10.app.contoller.util.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManageEmployeeController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNewEmployee;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<Employee> tblEmployee;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnNewEmployeeOnAction(ActionEvent event) {
        txtId.clear();
        txtName.clear();
        txtId.clear();
        generateNewId();

    }

    private void generateNewId() {
        if (tblEmployee.getItems().isEmpty()) {
            txtId.setText("S001");
            return;
        }
       String newId= (Integer.parseInt(tblEmployee.getItems().get(tblEmployee.
                getItems().size() - 1).getId().substring(1)) + 1)+"";
        txtId.setText("S00"+newId);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        Connection connection= DBConnection.getInstance().getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement
                    ("INSERT INTO Employee (id, name, address) VALUES (?,?,?)");
            pst.setString(1,txtId.getText());
            pst.setString(2,txtName.getText());
            pst.setString(3,txtAddress.getText());
            pst.executeUpdate();
            Employee employee = new Employee(txtId.getText(), txtName.getText(), txtAddress.getText());
            tblEmployee.getItems().add(employee);
        } catch (SQLException e) {
            System.out.println("save Error");
            throw new RuntimeException(e);
        }

    }


}
