package project.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import project.models.courses.InProgressCourseMark;

public class TeacherController implements Initializable {

    @FXML
    private TableColumn<InProgressCourseMark, Integer> ActivitiesColumn;

    @FXML
    private Label ChangingUsername;

    @FXML
    private TextField ActivitiesFld;

    @FXML
    private Label DepartmentLabel;

    @FXML
    private TableColumn<InProgressCourseMark, Integer> FinalColumn;

    @FXML
    private TextField FinalFld;

    @FXML
    private AnchorPane HomePane;

    @FXML
    private TableColumn<InProgressCourseMark, Integer> MidtermColumn;

    @FXML
    private TextField MidtermFld;

    @FXML
    private AnchorPane RegisterPane;

    @FXML
    private Label SalaryLabel;

    @FXML
    private TableColumn<InProgressCourseMark, String> StudentNameColumn;

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
    private TableView<InProgressCourseMark> tableview;

    @FXML
    void AddCourse(ActionEvent event) {
        tableview.getSelectionModel().getSelectedItem().setActivitiesGrade(Integer.valueOf(ActivitiesFld.getText()));
        tableview.getSelectionModel().getSelectedItem().setFinalGrade(Integer.valueOf(FinalFld.getText()));
        tableview.getSelectionModel().getSelectedItem().setMidtermGrade(Integer.valueOf(MidtermFld.getText()));
        System.out.println(tableview.getSelectionModel().getSelectedItem().getStudent().getName() + " "
                + tableview.getSelectionModel().getSelectedItem().getActivitiesGrade() + " "
                + tableview.getSelectionModel().getSelectedItem().getMidtermGrade() + " "
                + tableview.getSelectionModel().getSelectedItem().getFinalGrade());
        tableview.getItems().clear();
        for (int i = 0; i < FXMLDocumentController.LoggedInTeacher.getCourses().size(); i++) {
            if (combo.getValue().equals(FXMLDocumentController.LoggedInTeacher.getCourses().get(i).getCourseName())) {
                tableview.getItems()
                        .addAll(FXMLDocumentController.LoggedInTeacher.getCourses().get(i).getCourseMarks().stream()
                                .filter(p -> p instanceof InProgressCourseMark).map(p -> (InProgressCourseMark) p)
                                .collect(Collectors.toList()));
            }
        }
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
        SalaryLabel.setText(String.format("%.2f$", FXMLDocumentController.LoggedInTeacher.getSalary()));
        DepartmentLabel.setText(FXMLDocumentController.LoggedInTeacher.getDepartment().getDepartmentName());
        WeeklyHoursLabel.setText(String.valueOf(FXMLDocumentController.LoggedInTeacher.getWeeklyHours()));
        TotalStudentsLabel.setText(String.valueOf(FXMLDocumentController.LoggedInTeacher.getTotalStudents()));
        ChangingUsername.setText(FXMLDocumentController.LoggedInTeacher.getName());
        combo.setValue(FXMLDocumentController.LoggedInTeacher.getCourseStrings()[0]);
        combo.getItems().addAll(FXMLDocumentController.LoggedInTeacher.getCourseStrings());
        StudentNameColumn.setCellValueFactory(new PropertyValueFactory<InProgressCourseMark, String>("StudentName"));
        ActivitiesColumn
                .setCellValueFactory(new PropertyValueFactory<InProgressCourseMark, Integer>("activitiesGrade"));
        MidtermColumn.setCellValueFactory(new PropertyValueFactory<InProgressCourseMark, Integer>("midtermGrade"));
        FinalColumn.setCellValueFactory(new PropertyValueFactory<InProgressCourseMark, Integer>("finalGrade"));
        for (int i = 0; i < FXMLDocumentController.LoggedInTeacher.getCourses().size(); i++) {
            if (combo.getValue().equals(FXMLDocumentController.LoggedInTeacher.getCourses().get(i).getCourseName())) {
                tableview.getItems()
                        .addAll(FXMLDocumentController.LoggedInTeacher.getCourses().get(i).getCourseMarks().stream()
                                .filter(p -> p instanceof InProgressCourseMark).map(p -> (InProgressCourseMark) p)
                                .collect(Collectors.toList()));
            }
            combo.getSelectionModel().selectedItemProperty().addListener(
                    new ChangeListener() {
                        @Override
                        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                            for (int i = 0; i < combo.getItems().size(); i++) {
                                if ((newValue).equals((Object) FXMLDocumentController.LoggedInTeacher.getCourses()
                                        .get(i).getCourseName())) {
                                    tableview.getItems().clear();
                                    /*
                                     * TODO: only courses in progress will be shown in table view, if this is not
                                     * what
                                     * was intended either GUI or model has to be edited for that
                                     */
                                    tableview.getItems()
                                            .addAll(FXMLDocumentController.LoggedInTeacher.getCourses().get(i)
                                                    .getCourseMarks().stream()
                                                    .filter(p -> p instanceof InProgressCourseMark)
                                                    .map(p -> (InProgressCourseMark) p).collect(Collectors.toList()));
                                }
                            }
                        }
                    });
        }
    }

}
