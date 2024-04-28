package coursemanagementsystem;

import coursemanagementsystem.courses.Course;
import coursemanagementsystem.courses.Student;
import coursemanagementsystem.courses.Department;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DashboardController implements Initializable {

    @FXML
    private Label CHBtn;

    @FXML
    private TableColumn<Course, Integer> CHColumn;

    @FXML
    private Label CHview;

    @FXML
    private TableColumn<Course, String> CodeColumn;

    @FXML
    private TableColumn<Course, String> CourseNameColumn;

    @FXML
    private Label GpaBtn;

    @FXML
    private AnchorPane HomePane;

    @FXML
    private AnchorPane RegisterPane;

    @FXML
    private Label TotalGpaBtn;

    @FXML
    private Button addBtn;

    @FXML
    private Button close;

    @FXML
    private ChoiceBox<String> combo1;

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
    private TableView<Course> tableview1;

    static List<Course> AvailableCourses = FXMLDocumentController.LoggedInStudent.getAvailableCourses();
    static List<CourseMark> FinishedCourses = FXMLDocumentController.LoggedInStudent.getCourseMarks();

    @FXML
    void Closewind(ActionEvent event) {
        close.getScene().getWindow().hide();
    }

    @FXML
    public void LogOut(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
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

    @FXML
    void DropCourse(ActionEvent event) throws Exception {
        Course selecteditem = tableview1.getSelectionModel().getSelectedItem();
        combo2.getItems().add(tableview1.getSelectionModel().getSelectedItem().getCourseName());
        tableview1.getItems().remove(selecteditem);
        FXMLDocumentController.LoggedInStudent.dropCourse(selecteditem);

    }

    @FXML
    void AddCourse(ActionEvent event) {

        for (int i = 0; i < AvailableCourses.size(); i++) {
            if (combo2.getValue().equals(AvailableCourses.get(i).getCourseName())) {
                tableview1.getItems().add(AvailableCourses.get(i));
                combo2.getItems().remove(combo2.getValue());
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        combo1.setValue(FinishedCourses.get(0).getCourse().getCourseName());
        combo1.getItems().addAll(FXMLDocumentController.LoggedInStudent.getFinishedCourseStrings());
        combo2.setValue(AvailableCourses.get(0).getCourseName());
        combo2.getItems().addAll(FXMLDocumentController.LoggedInStudent.getAvailableCourseStrings());

        CourseNameColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
        CHColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("CH"));
        CodeColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("code"));

        CHview.setText("0");
        combo1.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                for (int i = 0; i < combo1.getItems().size(); i++) {
                    if ((newValue).equals((Object) FinishedCourses.get(i).getCourse().getCourseName())) {
                        GpaBtn.setText(String.format("%.2f", FinishedCourses.get(i).getGradePoints()));
                        CHBtn.setText(String.valueOf(FinishedCourses.get(i).getCourse().getCH()));
                    }
                }
            }
        });

    }
}
