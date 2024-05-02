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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project.courses.Course;
import project.courses.CourseMark;
import project.courses.Student;

public class TeacherController implements Initializable {

    @FXML
    private TableColumn<CourseMark, Integer> ActivitiesColumn;

    @FXML
    private Label ChangingUsername;

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
    private ChoiceBox<String> combo;

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
       /* CourseMark StudentMarkSet=tableview.getSelectionModel().getSelectedItem();
        //StudentMarkSet.setActivitiesGrade(Integer.valueOf( ActivitiesFld.getText()));
        StudentMarkSet.setFinalGrade(Integer.valueOf(FinalFld.getText()));
        StudentMarkSet.setMidtermGrade(Integer.valueOf(MidtermFld.getText()));
        System.out.println(StudentMarkSet.toString());*/
    }

    @FXML
    void Closewind(ActionEvent event) {
        close.getScene().getWindow().hide();
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo.setValue(FXMLDocumentController.LoggedInTeacher.getCourseStrings()[0]);
        combo.getItems().addAll(FXMLDocumentController.LoggedInTeacher.getCourseStrings());
        StudentNameColumn.setCellValueFactory(new PropertyValueFactory<CourseMark, String>("StudentName"));
        ActivitiesColumn.setCellValueFactory(new PropertyValueFactory<CourseMark, Integer>("activitiesGrade"));
        MidtermColumn.setCellValueFactory(new PropertyValueFactory<CourseMark, Integer>("midtermGrade"));
        FinalColumn.setCellValueFactory(new PropertyValueFactory<CourseMark, Integer>("finalGrade"));
        for(int i=0;i<FXMLDocumentController.LoggedInTeacher.getCourses().size();i++){
        if (combo.getValue().equals(FXMLDocumentController.LoggedInTeacher.getCourses().get(i))){
        tableview.getItems().addAll(FXMLDocumentController.LoggedInTeacher.getCourses().get(i).getCourseMarks());
        }
    }
    }

}
