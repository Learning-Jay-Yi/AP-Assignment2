/**
 * Sample Skeleton for 'View.fxml' Controller Class
 */

package MVC.Control;

import MVC.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;

import java.util.ArrayList;

import static MVC.Model.DataStructure.participantArrayList;

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
    private TableView athleteTable; // Value injected by FXMLLoader

    @FXML // fx:id="athleteTableAthleteIDCol"
    private TableColumn<Athlete, String> athleteTableAthleteIDCol; // Value injected by FXMLLoader

    @FXML // fx:id="athleteTableAthleteNameCol"
    private TableColumn<Athlete, String> athleteTableAthleteNameCol; // Value injected by FXMLLoader

    @FXML // fx:id="athleteTableAthleteAgeCol"
    private TableColumn<Athlete, Integer> athleteTableAthleteAgeCol; // Value injected by FXMLLoader

    @FXML // fx:id="athleteTableAthleteStateCol"
    private TableColumn<Athlete, String> athleteTableAthleteStateCol; // Value injected by FXMLLoader

    @FXML // fx:id="athleteTableAthleteTypeCol"
    private TableColumn<Athlete, String > athleteTableAthleteTypeCol; // Value injected by FXMLLoader

    @FXML // fx:id="athleteTableSelectedCol"
    private TableColumn<Athlete, Boolean> athleteTableSelectedCol; // Value injected by FXMLLoader

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
    private TableView officialTable; // Value injected by FXMLLoader

    @FXML // fx:id="officialTableGameIDCol"
    private TableColumn<Game, String> officialTableGameIDCol; // Value injected by FXMLLoader

    @FXML // fx:id="officialTableOfficialIDCol"
    private TableColumn<Official, String > officialTableOfficialIDCol; // Value injected by FXMLLoader

    @FXML // fx:id="officialTableGameTypeCol"
    private TableColumn<Game, String > officialTableGameTypeCol; // Value injected by FXMLLoader

    @FXML // fx:id="officialTableFirstPlaceCol"
    private TableColumn<Results, String> officialTableFirstPlaceCol; // Value injected by FXMLLoader

    @FXML // fx:id="officialTableSecondPlaceCol"
    private TableColumn<Results, String> officialTableSecondPlaceCol; // Value injected by FXMLLoader

    @FXML // fx:id="officialTableThirdPlaceCol"
    private TableColumn<Results, String> officialTableThirdPlaceCol; // Value injected by FXMLLoader

    @FXML // fx:id="resultTable"
    private TableView resultTable; // Value injected by FXMLLoader

    @FXML // fx:id="resultTableGameIDCol"
    private TableColumn<Game, String> resultTableGameIDCol; // Value injected by FXMLLoader

    @FXML // fx:id="resultTableAthleteIDCol"
    private TableColumn<Athlete, String> resultTableAthleteIDCol; // Value injected by FXMLLoader

    @FXML // fx:id="resultTableAthleteNameCol"
    private TableColumn<Athlete, String> resultTableAthleteNameCol; // Value injected by FXMLLoader

    @FXML // fx:id="resultTableAthleteTypeCol"
    private TableColumn<Athlete, String> resultTableAthleteTypeCol; // Value injected by FXMLLoader

    @FXML // fx:id="resultTableAthleteResultCol"
    private TableColumn<Athlete, Integer> resultTableAthleteResultCol; // Value injected by FXMLLoader

    @FXML // fx:id="btResultNewGame"
    private Button btResultNewGame; // Value injected by FXMLLoader

    @FXML // fx:id="btPlayAgain"
    private Button btPlayAgain; // Value injected by FXMLLoader

    @FXML // fx:id="lbResultInfo"
    private Label lbResultInfo; // Value injected by FXMLLoader

    @FXML // fx:id="tabScores"
    private Tab tabScores; // Value injected by FXMLLoader

    @FXML // fx:id="scoreTable"
    private TableView scoreTable; // Value injected by FXMLLoader

    @FXML // fx:id="scoreTableAthleteIDCol"
    private TableColumn<Athlete, String> scoreTableAthleteIDCol; // Value injected by FXMLLoader

    @FXML // fx:id="scoreTableAthleteNameCol"
    private TableColumn<Athlete, String> scoreTableAthleteNameCol; // Value injected by FXMLLoader

    @FXML // fx:id="scoreTableAthleteAgeCol"
    private TableColumn<Athlete, Integer> scoreTableAthleteAgeCol; // Value injected by FXMLLoader

    @FXML // fx:id="scoreTableAthleteStateCol"
    private TableColumn<Athlete, String> scoreTableAthleteStateCol; // Value injected by FXMLLoader

    @FXML // fx:id="scoreTableAthleteTypeCol"
    private TableColumn<Athlete, String> scoreTableAthleteTypeCol; // Value injected by FXMLLoader

    @FXML // fx:id="scoreTableAthleteScoreCol"
    private TableColumn<Athlete, Integer> scoreTableAthleteScoreCol; // Value injected by FXMLLoader

    @FXML // fx:id="lbSoresInfo"
    private Label lbSoresInfo; // Value injected by FXMLLoader

    @FXML // fx:id="btScoreNewGame"
    private Button btScoreNewGame; // Value injected by FXMLLoader

    @FXML // fx:id="btQuitGame"
    private Button btQuitGame; // Value injected by FXMLLoader

    @FXML
    void btCyclingClick(ActionEvent event) {

    }

    @FXML
    void btGameExitClick(ActionEvent event) {

    }

    @FXML
    void btPlayAgainClick(ActionEvent event) {

    }

    @FXML
    void btQuitGameClick(ActionEvent event) {

    }

    @FXML
    void btResetClick(ActionEvent event) {

    }

    @FXML
    void btResultNewGameClick(ActionEvent event) {

    }

    @FXML
    void btRunClick(ActionEvent event) {

    }

    @FXML
    void btRunningClick(ActionEvent event) {

    }

    @FXML
    void btScoreNewGameClick(ActionEvent event) {

    }

    @FXML
    void btSwimmingClick(ActionEvent event) {

    }


    /**
     * new functions
     *
     */


    // load
    @FXML
    public void initialize()
    {
        athleteTableAthleteIDCol.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        athleteTableAthleteNameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        athleteTableAthleteAgeCol.setCellValueFactory(cellDate -> cellDate.getValue().ageProperty().asObject());
        athleteTableAthleteStateCol.setCellValueFactory(cellDate -> cellDate.getValue().stateProperty());
        athleteTableAthleteTypeCol.setCellValueFactory(cellData -> cellData.getValue().abilityProperty());


        athleteTableSelectedCol.setCellFactory(column -> new CheckBoxTableCell());
        athleteTableSelectedCol.setCellValueFactory(cellData -> cellData.getValue().checkProperty());

        athleteTable.setItems(athleteData);
        athleteTable.setEditable(true);
    }

    ObservableList<Athlete> athleteData = getAthlete(participantArrayList);

    ObservableList<Athlete> getAthlete(ArrayList<Athlete> participantArrayList){
        ObservableList<Athlete> athleteData = FXCollections.observableArrayList();
        athleteData.add(new Cyclist("C01","Cyc01",25,"VIC",25));
        athleteData.add(new Cyclist("C02","Cyc02",25,"VIC",36));
        athleteData.add(new Cyclist("C03","Cyc03",25,"VIC",27));
        athleteData.add(new Cyclist("C04","Cyc04",25,"VIC",32));
        athleteData.add(new Cyclist("C05","Cyc05",25,"VIC",31));
        athleteData.add(new Cyclist("C06","Cyc06",25,"VIC",22));
        athleteData.add(new Cyclist("C07","Cyc07",25,"VIC",26));
        return athleteData;
    }





}
