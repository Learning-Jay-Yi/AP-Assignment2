/**
 * Sample Skeleton for 'View.fxml' Controller Class
 */

package MVC.Control;

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

    @FXML // fx:id = "athleteStateCol"
    private TableColumn<Athlete,String> athleteStateCol; // Value injected by FXMLLoader

    @FXML // fx:id="athleteTypeCol"
    private TableColumn<Athlete, String> athleteTypeCol; // Value injected by FXMLLoader

    @FXML // fx:id="selectedCol"
    private TableColumn<Athlete, Boolean> selectedCol; // Value injected by FXMLLoader

    @FXML // fx:id="lbGameInfo"
    private Label lbGameInfo; // Value injected by FXMLLoader

    @FXML // fx:id="btGameExit"
    private Button btGameExit; // Value injected by FXMLLoader

    @FXML // fx:id="btRun"
    private Button btRun; // Value injected by FXMLLoader

    @FXML // fx:id="btReset"
    private Button btReset; // Value injected by FXMLLoader

    @FXML // fx:id="tabResult"
    private Tab tabResult; // Value injected by FXMLLoader

    @FXML // fx:id="officialTable"
    private TableView<?> officialTable; // Value injected by FXMLLoader

    @FXML // fx:id="athleteResultTable"
    private TableView<?> athleteResultTable; // Value injected by FXMLLoader

    @FXML // fx:id="btResultNewGame"
    private Button btResultNewGame; // Value injected by FXMLLoader

    @FXML // fx:id="btPlayAgain"
    private Button btPlayAgain; // Value injected by FXMLLoader

    @FXML // fx:id="lbResultInfo"
    private Label lbResultInfo; // Value injected by FXMLLoader

    @FXML // fx:id="tabScores"
    private Tab tabScores; // Value injected by FXMLLoader

    @FXML // fx:id="lbSoresInfo"
    private Label lbSoresInfo; // Value injected by FXMLLoader

    @FXML // fx:id="btScoreNewGame"
    private Button btScoreNewGame; // Value injected by FXMLLoader

    @FXML // fx:id="btQuitGame"
    private Button btQuitGame; // Value injected by FXMLLoader

    @FXML
    void btCyclingClick(ActionEvent event) {
        lbGameInfo.setText("This is Cycling game.\nPleas select athlete to run this game.");
        athleteTable.setDisable(false);
        btRun.setDisable(false);
        btReset.setDisable(false);

    }

    @FXML
    public void btGameExitClick(ActionEvent event) {
        Stage stage = (Stage) btGameExit.getScene().getWindow();
        stage.close();
    }


    @FXML
    void btPlayAgainClick(ActionEvent event) {

    }

    @FXML
    void btQuitGameClick(ActionEvent event) {

    }

    @FXML
    void btResetClick(ActionEvent event) {
        lbGameInfo.setText("Select a game above to start the game");
        athleteTable.setDisable(true);

    }

    @FXML
    void btResultNewGameClick(ActionEvent event) {

    }

    @FXML
    void btRunClick(ActionEvent event) {
        // TODO: 2017/10/8 load data and put it into a temporary arrayList
        System.out.println("im working");

    }

    @FXML
    void btRunningClick(ActionEvent event) {
        lbGameInfo.setText("This is Running game.\nPleas select athlete to run this game.");
        athleteTable.setDisable(false);
        btRun.setDisable(false);
        btReset.setDisable(false);

    }

    @FXML
    void btScoreNewGameClick(ActionEvent event) {

    }

    @FXML
    void btSwimmingClick(ActionEvent event) {
        /**
         *
         */
        lbGameInfo.setText("This is Swimming game.\nPleas select athlete to run this game.");
        athleteTable.setDisable(false);
        btRun.setDisable(false);
        btReset.setDisable(false);

    }

    @FXML
    public void initialize() {
        athleteIDCol.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        athleteNameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        athleteAgeCol.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        athleteStateCol.setCellValueFactory(cellData -> cellData.getValue().stateProperty());
        athleteTypeCol.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        selectedCol.setCellFactory(column -> new CheckBoxTableCell());
        selectedCol.setCellValueFactory(cellData -> cellData.getValue().checkProperty());
        athleteTable.setItems(getAthlete());
        athleteTable.setEditable(true);
        athleteTable.setDisable(true);
    }

    ObservableList<Athlete> getAthlete(){
        ObservableList<Athlete> athleteData = FXCollections.observableArrayList();
        athleteData.add(new Athlete("0","Tim", 35, "VIC","swimming", 2));
        athleteData.add(new Athlete("1", "Jane", 23, "VIC","super", 3));
        return athleteData;
    }




}
