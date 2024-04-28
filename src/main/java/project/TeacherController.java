package project;


import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TeacherController implements Initializable {

    @FXML
    private TableColumn<?, ?> ActivitiesColumn;

    @FXML
    private TextField ActivitiesFld;

    @FXML
    private Label DepartmentLabel;

    @FXML
    private TableColumn<?, ?> FinalColumn;

    @FXML
    private TextField FinalFld;

    @FXML
    private AnchorPane HomePane;

    @FXML
    private TableColumn<?, ?> MidtermColumn;

    @FXML
    private TextField MidtermFld;

    @FXML
    private AnchorPane RegisterPane;

    @FXML
    private Label SalaryLabel;

    @FXML
    private TableColumn<?, ?> StudentNameColumn;

    @FXML
    private Label TotalStudentsLabel;

    @FXML
    private Label WeeklyHoursLabel;

    @FXML
    private Button addBtn;

    @FXML
    private Button close;

    @FXML
    private ChoiceBox<String> combo;

    @FXML
    private Button dropBtn;

    @FXML
    private Button home;

    @FXML
    private Button outBtn;

    @FXML
    private Button register;

    @FXML
    private TableView<?> tableview;

    @FXML
    void AddCourse(ActionEvent event) {

    }

    @FXML
    void Closewind(ActionEvent event) {
        close.getScene().getWindow().hide();
    }

    @FXML
    void DropCourse(ActionEvent event) {

    }

    @FXML
    void LogOut(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get().equals(ButtonType.OK)) {
            outBtn.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void Switchform(ActionEvent event) {
        if (event.getSource() == home) {
            HomePane.setVisible(true);
            RegisterPane.setVisible(false);
        } else if (event.getSource() == register) {
            HomePane.setVisible(false);
            RegisterPane.setVisible(true);
        } else {
            HomePane.setVisible(false);
            RegisterPane.setVisible(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Student LoggedInStudent = Storage.said;

        //List<Course> AvailableCourses = LoggedInStudent.getAvailableCourses();
        //List<CourseMark> FinishedCourses = LoggedInStudent.getCourseMarks();
        combo.setValue(Storage.said.getName());

    }

}
