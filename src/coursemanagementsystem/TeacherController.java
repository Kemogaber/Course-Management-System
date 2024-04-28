package coursemanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class TeacherController {

    @FXML
    private TableColumn<CourseMark, Integer> ActivitiesColumn;

    @FXML
    private TextField ActivitiesFld;

    @FXML
    private Label DepartmentLabel;

    @FXML
    private TableColumn<CourseMark, Integer> FinalColumn;

    @FXML
    private TextField FinalFld;

    @FXML
    private AnchorPane HomePane;

    @FXML
    private TableColumn<CourseMark, Integer> MidtermColumn;

    @FXML
    private TextField MidtermFld;

    @FXML
    private AnchorPane RegisterPane;

    @FXML
    private Label SalaryLabel;

    @FXML
    private TableColumn<CourseMark, String> StudentNameColumn;

    @FXML
    private Label TotalStudentsLabel;

    @FXML
    private Label WeeklyHoursLabel;

    @FXML
    private Button addBtn;

    @FXML
    private Button close;

    @FXML
    private ChoiceBox<?> combo2;

    @FXML
    private Button dropBtn;

    @FXML
    private Button home;

    @FXML
    private Button outBtn;

    @FXML
    private Button register;

    @FXML
    private TableView<CourseMark> tableview;

    @FXML
    void AddCourse(ActionEvent event) {

    }

    @FXML
    void Closewind(ActionEvent event) {

    }

    @FXML
    void DropCourse(ActionEvent event) {

    }

    @FXML
    void LogOut(ActionEvent event) {

    }

    @FXML
    void Switchform(ActionEvent event) {

    }

}
