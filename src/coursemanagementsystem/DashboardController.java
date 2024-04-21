package coursemanagementsystem;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
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
    private TableColumn<Course, Integer> CHColumn;

    @FXML
    private TableColumn<Course, String> CodeColumn;

    @FXML
    private TableColumn<Course, String> CourseNameColumn;

    @FXML
    private AnchorPane HomePane;

    @FXML
    private AnchorPane RegisterPane;
    
    @FXML
    private Label CHBtn;

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
    private Label GpaBtn;
    
    @FXML
    private TableView<Course> tableview1;
    
    @FXML
    private Label CHview;
    
        @FXML
    private Label TotalGpaBtn;
    
    String[] Courses={"Digital","Embedded","Programming"};
    ObservableList<Course> list= FXCollections.observableArrayList(new Course());    
    Course[] courses= {new Course("Digital",3,"ECE212",2.7),
            new Course("Embedded",3,"CSE224",3.3),
            new Course("Programming",2,"CSE231",3.7)};
    double total=0;double num;double  totGpa;

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
     Optional<ButtonType> option=alert.showAndWait();
     if(option.get().equals(ButtonType.OK)){
         outBtn.getScene().getWindow().hide();
    Parent root=FXMLLoader.load(getClass().getResource("FXML.fxml"));
    Stage stage=new Stage();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
     }
    }
    @FXML
    void Switchform(ActionEvent event)
    {
     if(event.getSource()==home){
         HomePane.setVisible(true);
         RegisterPane.setVisible(false);
     }
     else if (event.getSource()==register){
          HomePane.setVisible(false);
         RegisterPane.setVisible(true);
     }
     else{
       HomePane.setVisible(false);
         RegisterPane.setVisible(false);
     }
     }
      @FXML
    void DropCourse(ActionEvent event) {
    Course selecteditem=tableview1.getSelectionModel().getSelectedItem();
    total-=selecteditem.getCH();
     for (int i=0;i<courses.length;i++){
         if (tableview1.getItems().size()!=0){
         if (tableview1.getSelectionModel().getSelectedItem().getCoursename().equals( courses[i].getCoursename())){
       num=num-(courses[i].getCH()*courses[i].getGpa());
       double totGpa=num/total;
       totGpa=(total==0 ? 0.00 : totGpa );
       TotalGpaBtn.setText(String.format("%.2f",totGpa));
         }
      } 
    }
    combo2.getItems().add(tableview1.getSelectionModel().getSelectedItem().getCoursename());
    tableview1.getItems().remove(selecteditem);
    CHview.setText(String.valueOf(total));

    }
    
     @FXML
    void AddCourse(ActionEvent event) {
      for (int i=0;i<courses.length;i++){
      if (combo2.getValue().equals( courses[i].getCoursename())){
        tableview1.getItems().add(courses[i]);
        combo2.getItems().remove(combo2.getValue());
        
      total+=courses[i].getCH();
      CHview.setText(String.valueOf(total));
       num+=(courses[i].getCH()*courses[i].getGpa());
       double totGpa=num/total;
       TotalGpaBtn.setText(String.format("%.2f",totGpa));
      } 
    }
      
      
     
      
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo1.setValue(Courses[0]);
       combo1.getItems().addAll(Courses);
       combo2.setValue(Courses[0]);
       combo2.getItems().addAll(Courses);
       CourseNameColumn.setCellValueFactory(new PropertyValueFactory<Course,String>("coursename"));
       CHColumn.setCellValueFactory(new PropertyValueFactory<Course,Integer>("CH"));
       CodeColumn.setCellValueFactory(new PropertyValueFactory<Course,String>("code"));
       CHview.setText("0");
       combo1.getSelectionModel().selectedItemProperty().addListener(
               new ChangeListener(){
                   @Override
                   public void changed(ObservableValue observable,Object oldValue, Object newValue)
                       {
         for (int i=0;i<combo1.getItems().size();i++){
      if ((newValue).equals( (Object) courses[i].getCoursename())){
       GpaBtn.setText(String.format("%.2f",courses[i].getGpa()));
       CHBtn.setText(String.valueOf(courses[i].getCH()));
            }
       }
    }});
  
    }
    
     }