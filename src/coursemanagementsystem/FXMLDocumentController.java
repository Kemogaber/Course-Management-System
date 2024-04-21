package coursemanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLDocumentController implements Initializable{
    private String[] Modes={"Student","Teacher"};
    private String Studentname="Teacher";private String Studentpass="123";
    private String Teachername="Student";private String  Teacherpass="12345";
    
 @FXML
    private Button close;

    @FXML
    private ChoiceBox<String> label;

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField password;

    @FXML
    private Label title;

    @FXML
    private TextField username;



    @FXML
    void CloseWindow(ActionEvent event) {
        close.getScene().getWindow().hide();
    }
  
    @FXML
   public void SwitchScene(ActionEvent event) throws IOException {
       Alert alert;
if (label.getValue().equals((Object) Modes[1]) && (username.getText().equals((Object)Studentname) && (password.getText().equals((Object)Studentpass)))){
    alert=new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information Message");
    alert.setHeaderText(null);
    alert.setContentText("Successfully Login");
    alert.showAndWait();
    
    loginBtn.getScene().getWindow().hide();
    Parent root=FXMLLoader.load(getClass().getResource("Teacherdashboard.fxml"));
    Stage stage=new Stage();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
   }
else if (label.getValue().equals((Object) Modes[0]) && (username.getText().equals((Object)Teachername) && (password.getText().equals((Object)Teacherpass)))){
    alert=new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information Message");
    alert.setHeaderText(null);
    alert.setContentText("Successfully Login");
    alert.showAndWait();
    
    loginBtn.getScene().getWindow().hide();
    Parent root=FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
    Stage stage=new Stage();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
   }
else if (username.getText().isEmpty() || password.getText().isEmpty()) {
       alert=new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error Message");
    alert.setHeaderText(null);
    alert.setContentText("Please fill all blank fields");
    alert.showAndWait();
   }
else {
 alert=new Alert(Alert.AlertType.ERROR);
     alert.setTitle("Error Message");
    alert.setHeaderText(null);
    alert.setContentText("Wrong Username/Password");
    alert.showAndWait();
}
   }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       label.setValue(Modes[0]);
       label.getItems().addAll(Modes);
       label.setOnAction(this::getMode);
    }
   public void getMode(ActionEvent event){
   String Name=label.getValue();
   title.setText(Name+" Login");
   }
}