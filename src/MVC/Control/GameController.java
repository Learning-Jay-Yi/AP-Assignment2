/**
 * Sample Skeleton for 'View.fxml' Controller Class
 */

package MVC.Control;

import MVC.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class GameController {
//    Game game;
//    Driver driver;
//    GameProcess gameProcess;

    String gameID;

    String gameType;

//    private DataStructure dataStructure; // = new DataStructure();


    private ObservableList<Athlete> athleteData = DataStructure.getAthleteArrayList(); //FXCollections.observableArrayList();

    private ObservableList<Athlete> preAthleteData = FXCollections.observableArrayList();

    private ObservableList<Athlete> participantData = FXCollections.observableArrayList();








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
    void btGameExitClick(ActionEvent event) throws IOException {
        DataStructure.savefiles();
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

    }

    @FXML
    void btResultNewGameClick(ActionEvent event) {

    }

    @FXML
    void btRunClick(ActionEvent event) {
//        ObservableList<Athlete> participant =
        selectedAthletes();
        int numOfParticipant = participantData.size();
        if (numOfParticipant>8){
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Number of participants should between 4 and 8\nNow we have " + numOfParticipant + " participants"
                    +"\nPlease select again.",
                    ButtonType.OK);
            alert.showAndWait();
            for(Athlete a: preAthleteData){
                if (a.isChecked()){
                    participantData.remove(a);
                    System.out.println(a.getAthleteID()+ "is quit game.");
                    a.checkProperty().set(false);
                }
            }
//            selectedAthletes(preAthleteData);
            // TODO: 2017/10/11 follow
        }
    }

    @FXML
    void btRunningClick(ActionEvent event) {

    }

    @FXML
    void btScoreNewGameClick(ActionEvent event) {

    }

    @FXML
    void btSwimmingClick(ActionEvent event) {
        gameType = "Swimming";
        preAthlete(athleteData);
        System.out.println(preAthleteData.size());
        displayAthlete();
        enable();
    }

    private void enable() {
        athleteTable.setDisable(false);
        btRun.setDisable(false);
        btReset.setDisable(false);
    }



    /**
     * new functions
     *
     */




    // initialize data from files or data structure
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
        athleteTable.setDisable(true);
        athleteTable.setEditable(false);
    }

//    private ObservableList athleteData() {
//        ObservableList<Athlete> athleteObservableList = FXCollections.observableArrayList();
//        for (Athlete a: dataStructure.getAthleteArrayList())
//            athleteObservableList.add(a);
//        return athleteObservableList;
//    }


    /**
     * new function to load data to table
     *
     */

    // display athletes depend on game type
    @FXML
    public void displayAthlete() {

        athleteTableAthleteIDCol.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        athleteTableAthleteNameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        athleteTableAthleteAgeCol.setCellValueFactory(cellDate -> cellDate.getValue().ageProperty().asObject());
        athleteTableAthleteStateCol.setCellValueFactory(cellDate -> cellDate.getValue().stateProperty());
        athleteTableAthleteTypeCol.setCellValueFactory(cellData -> cellData.getValue().abilityProperty());

        athleteTableSelectedCol.setCellFactory(column -> new CheckBoxTableCell());
        athleteTableSelectedCol.setCellValueFactory(cellData -> cellData.getValue().checkProperty());

        athleteTable.setItems(preAthleteData);
        athleteTable.setDisable(false);
        athleteTable.setEditable(true);

    }

    /**
     * data part
     */


    /**
     * below part may not useful
     */
//    private ObservableList<Athlete> prepAthletes;
//
//    public ObservableList<Athlete> getAthlete(ArrayList<Athlete> athleteArrayList){
//        ObservableList<Athlete> athleteData = FXCollections.observableArrayList();
//        for (Athlete a : athleteArrayList)
//            athleteData.add(a);
//        return athleteData;
//    }



    private ObservableList<Game> games = DataStructure.getGameArrayList();

//    private ObservableList<Game> getGame(ArrayList<Game> gameArrayList) {
//        int size = gameArrayList.size();
//        ObservableList<Game> gameData = FXCollections.observableArrayList();
//        return gameData;
//    }

    private ObservableList<Official> officials = DataStructure.getOfficialArrayList();

//    private ObservableList<Official> getOfficial(ArrayList<Official> officialArrayList) {
//        return null;
//    }

    private ObservableList<Results> results = DataStructure.getResultArrayList();

//    private ObservableList<Results> geResult(ArrayList<Results> resultsArrayList) {
//        return null;
//    }









    /**
     *
     * @return return suitable athletes to controller
     *
     */




    @FXML
    private ObservableList<Athlete> preAthlete(ObservableList<Athlete> athleteData) {
//        ObservableList<Athlete> preAthleteData = FXCollections.observableArrayList();
        if (gameType == "Swimming"){
            for (Athlete a : athleteData){
                if (a instanceof Swimmer || a instanceof SuperAthlete ){
                    preAthleteData.add(a);
                }
            }
        }

        if (gameType == "Cycling"){
            for (Athlete a : athleteData){
                if (a instanceof Cyclist || a instanceof SuperAthlete){
                    preAthleteData.add(a);
                }
            }
        }

        if (gameType == "Running"){
            for (Athlete a : athleteData){
                if (a instanceof Runner || a instanceof SuperAthlete){
                    preAthleteData.add(a);
                }
            }
        }
        return preAthleteData;
    }


    /**
     * selected athletes
     */
    @FXML
    public ObservableList<Athlete> selectedAthletes() {
        for (Athlete a : preAthleteData)
        {
            if (a.isChecked()){
                participantData.add(a);
                System.out.println(a.getAthleteID() + " is ready for game.");
            }
        }
        return participantData;
    }
}
