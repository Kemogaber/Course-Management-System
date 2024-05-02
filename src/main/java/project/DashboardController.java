package project;

import project.courses.Course;
import project.courses.CourseMark;
import project.courses.Student;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    private Label ChangingUsername;

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

    static List<Course> AvailableCourses;
    static List<CourseMark> FinishedCourses;

    // TODO: REMOVE THIS.
    //static Student LoggedInStudent;

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
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML.fxml"));
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
        combo2.setValue(selecteditem.getCourseName());
        FXMLDocumentController.LoggedInStudent.dropCourse(selecteditem);
        combo1.getItems().remove(selecteditem.getCourseName());
        combo1.setValue("");
    }

    @FXML
    void AddCourse(ActionEvent event) throws Exception {

        for (int i = 0; i < FXMLDocumentController.LoggedInStudent.getAvailableCourses().size(); i++) {
            if (combo2.getValue().equals(FXMLDocumentController.LoggedInStudent.getAvailableCourses().get(i).getCourseName())) {
                combo1.getItems().add(FXMLDocumentController.LoggedInStudent.getAvailableCourses().get(i).getCourseName());
                tableview1.getItems().add(FXMLDocumentController.LoggedInStudent.getAvailableCourses().get(i));
                FXMLDocumentController.LoggedInStudent.addCourse(FXMLDocumentController.LoggedInStudent.getAvailableCourses().get(i));
                combo2.getItems().remove(combo2.getValue());
                combo2.setValue("");
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChangingUsername.setText(FXMLDocumentController.LoggedInTeacher.getName());
        AvailableCourses = FXMLDocumentController.LoggedInStudent.getAvailableCourses();
        FinishedCourses = FXMLDocumentController.LoggedInStudent.getCourseMarks(); 
        
        // Initialize available courses and empty courses.
        AvailableCourses = FXMLDocumentController.LoggedInStudent.getAvailableCourses();
        FinishedCourses = FXMLDocumentController.LoggedInStudent.getCourseMarks();
        
        if (FinishedCourses.size() == 0) {  // If no finished courses 
            combo1.setValue("");            // Initialize the combo box to an empty string.
        }
        else {
            combo1.setValue(FinishedCourses.get(0).getCourse().getCourseName());
            combo1.getItems().addAll(FXMLDocumentController.LoggedInStudent.getFinishedCourseStrings());
        }
        

        if (AvailableCourses.size() == 0) {  // If no finished courses 
            combo2.setValue("");             // Initialize the combo box to an empty string.
        }
        else {
            combo2.setValue(AvailableCourses.get(0).getCourseName());
            combo2.getItems().addAll(FXMLDocumentController.LoggedInStudent.getAvailableCourseStrings());
        }
        for(int i=0;i<FXMLDocumentController.LoggedInTeacher.getCourses().size();i++){
            if (combo1.getValue().equals(FXMLDocumentController.LoggedInStudent.getCourseMarks().get(i).getCourse().getCourseName())){
                CHBtn.setText(String.valueOf(FXMLDocumentController.LoggedInStudent.getCourseMarks().get(i).getCourse().getCH()));
                GpaBtn.setText(String.valueOf(FXMLDocumentController.LoggedInStudent.getCourseMarks().get(i).getGradePoints()));
                TotalGpaBtn.setText(String.valueOf(FXMLDocumentController.LoggedInStudent.getGPA()));
            } 
           



        CourseNameColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
        CHColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("CH"));
        CodeColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("code"));

        CHview.setText("0");
        combo1.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                for (int i = 0; i < combo1.getItems().size(); i++) {
                    if ((newValue).equals((Object)  FXMLDocumentController.LoggedInStudent.getCourseMarks().get(i).getCourse().getCourseName())) {
                        GpaBtn.setText(String.format("%.2f", FXMLDocumentController.LoggedInStudent.getCourseMarks().get(i).getGradePoints()));
                        CHBtn.setText(String.valueOf( FXMLDocumentController.LoggedInStudent.getCourseMarks().get(i).getCourse().getCH()));
                    }
                }
            }
        });

    }
}
