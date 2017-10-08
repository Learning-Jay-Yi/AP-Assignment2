package MVC.Control;

/**
 * Sample Skeleton for 'View.fxml' Controller Class
 */

import MVC.Model.Athlete;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameController {



    @FXML // fx:id="tabGame"
    private Tab tabGame; // Value injected by FXMLLoader

    @FXML // fx:id="btSwimming"
    private Button btSwimming; // Value injected by FXMLLoader

    @FXML // fx:id="btCycling"
    private Button btCycling; // Value injected by FXMLLoader

    @FXML // fx:id="btRunning"
    private Button btRunning; // Value injected by FXMLLoader

    @FXML // fx:id="athleteTable"
    private TableView athleteTable;
    // Value injected by FXMLLoader

    @FXML // fx:id="athleteIDCol"
    private TableColumn<Athlete, String> athleteIDCol; // Value injected by FXMLLoader

    @FXML // fx:id="athleteNameCol"
    private TableColumn<Athlete, String> athleteNameCol; // Value injected by FXMLLoader

    @FXML // fx:id="athleteAgeCol"
    private TableColumn<Athlete, Integer> athleteAgeCol; // Value injected by FXMLLoader

    @FXML // fx:id="athleteTypeCol"
    private TableColumn<Athlete, String> athleteTypeCol; // Value injected by FXMLLoader

    @FXML // fx:id="selectedCol"
    private TableColumn<Athlete, Boolean> selectedCol; // Value injected by FXMLLoader

    @FXML // fx:id="lbGameInfo"
    private Label lbGameInfo; // Value injected by FXMLLoader

    @FXML // fx:id="btExit"
    private Button btExit; // Value injected by FXMLLoader

    @FXML // fx:id="btRun"
    private Button btRun; // Value injected by FXMLLoader

    @FXML // fx:id="btReset"
    private Button btReset; // Value injected by FXMLLoader

    @FXML // fx:id="tabResult"
    private Tab tabResult; // Value injected by FXMLLoader

    @FXML // fx:id="tabScores"
    private Tab tabScores; // Value injected by FXMLLoader




    @FXML
    void btExitClick(ActionEvent event) {
        Stage stage = (Stage) btExit.getScene().getWindow();
        stage.close();

    }

    @FXML
    void btSwimmingClick(ActionEvent event) {
        /**
         *
         */
        btRun.setDisable(false);
        btReset.setDisable(false);
    }




    @FXML
    void initialize() {
        athleteIDCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        athleteNameCol.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        athleteAgeCol.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());

        athleteTypeCol.setCellValueFactory(cellData -> cellData.getValue().typeProperty());

        selectedCol.setCellFactory(column -> new CheckBoxTableCell());
        selectedCol.setCellValueFactory(cellData -> cellData.getValue().checkProperty());

        athleteTable.setItems(getAthlete());
        athleteTable.setEditable(true);
    }


    ObservableList<Athlete> getAthlete(){
        ObservableList<Athlete> athleteData = FXCollections.observableArrayList();
        athleteData.add(new Athlete("0","Tim", 35, "swimming", 2));
        athleteData.add(new Athlete("1", "Jane", 23, "super", 3));
        return athleteData;
    }
    
    
//    private static ObservableList<Object> athleteData = FXCollections.observableArrayList();


}
