package coursemanagementsystem;

import static coursemanagementsystem.DashboardController.AvailableCourses;
import coursemanagementsystem.courses.Course;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    private TableColumn<Course, String> StudentNameColumn;

    @FXML
    private Label TotalStudentsLabel;

    @FXML
    private Label WeeklyHoursLabel;

    @FXML
    private Button addBtn;

    @FXML
    private Button close;

    @FXML
    private ChoiceBox<String> combo2;

    @FXML
    private Button dropBtn;

    @FXML
    private Button home;

    @FXML
    private Button outBtn;

    @FXML
    private Button register;

    @FXML
    private TableView<Course> tableview;

    static List<Course> AvailableCourses = FXMLDocumentController.LoggedInStudent.getAvailableCourses();
    static List<CourseMark> FinishedCourses = FXMLDocumentController.LoggedInStudent.getCourseMarks();
    
    @FXML
    void AddCourse(ActionEvent event) {
        for (int i = 0; i < AvailableCourses.size(); i++) {
            if (combo2.getValue().equals(AvailableCourses.get(i).getCourseName())) {
                tableview.getItems().add(AvailableCourses.get(i));
                combo2.getItems().remove(combo2.getValue());
            }
        }
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

}
