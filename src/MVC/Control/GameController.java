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
    Game game;
//    Driver driver;
//    GameProcess gameProcess;

    String gameID;

    String gameType;

    CompeteResult competeResult;

//    private DataStructure dataStructure; // = new DataStructure();


    private ObservableList<Athlete> athleteData = DataStructure.getAthleteArrayList(); //FXCollections.observableArrayList();

    private ObservableList<Game> gamesData = DataStructure.getGameArrayList();

    private ObservableList<Official> officialsData = DataStructure.getOfficialArrayList();

    private ObservableList<Results> resultsData = DataStructure.getResultArrayList();


    private ObservableList<Athlete> preAthleteData = FXCollections.observableArrayList();

    private ObservableList<Athlete> participantData = FXCollections.observableArrayList();

    private ObservableList<CompeteResult> competeResultsData = DataStructure.getCompeteResultArrayList();








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

    @FXML // fx:id="resultHistoryTable"
    private TableView resultHistoryTable; // Value injected by FXMLLoader

    @FXML // fx:id="resultHistoryTableGameIDCol"
    private TableColumn<Results, String> resultHistoryTableGameIDCol; // Value injected by FXMLLoader

    @FXML // fx:id="resultHistoryTableOfficialIDCol"
    private TableColumn<Results, String > resultHistoryTableOfficialIDCol; // Value injected by FXMLLoader

    @FXML // fx:id="resultHistoryTableGameTypeCol"
    private TableColumn<Results, String > resultHistoryTableGameTypeCol; // Value injected by FXMLLoader

    @FXML // fx:id="resultHistoryTableFirstPlaceCol"
    private TableColumn<Results, String> resultHistoryTableFirstPlaceCol; // Value injected by FXMLLoader

    @FXML // fx:id="resultHistoryTableSecondPlaceCol"
    private TableColumn<Results, String> resultHistoryTableSecondPlaceCol; // Value injected by FXMLLoader

    @FXML // fx:id="resultHistoryTableThirdPlaceCol"
    private TableColumn<Results, String> resultHistoryTableThirdPlaceCol; // Value injected by FXMLLoader

    @FXML // fx:id="resultTable"
    private TableView competeResultTable; // Value injected by FXMLLoader

    @FXML // fx:id="resultTableGameIDCol"
    private TableColumn<CompeteResult, String> resultTableGameIDCol; // Value injected by FXMLLoader

    @FXML // fx:id="resultTableAthleteIDCol"
    private TableColumn<CompeteResult, String> resultTableAthleteIDCol; // Value injected by FXMLLoader

    @FXML // fx:id="resultTableAthleteNameCol"
    private TableColumn<CompeteResult, String> resultTableAthleteNameCol; // Value injected by FXMLLoader

    @FXML // fx:id="resultTableAthleteTypeCol"
    private TableColumn<CompeteResult, String> resultTableAthleteTypeCol; // Value injected by FXMLLoader

    @FXML // fx:id="resultTableAthleteResultCol"
    private TableColumn<CompeteResult, Integer> resultTableAthleteResultCol; // Value injected by FXMLLoader

    @FXML // fx:id="btResultNewGame"
    private Button btResultNewGame; // Value injected by FXMLLoader

    @FXML // fx:id="btCompete"
    private Button btCompeteClick; // Value injected by FXMLLoader

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
        preAthleteData.clear();
        gameType = "Cycling";
        preAthlete(athleteData);
        displayAthlete();
        enable();
    }

    @FXML
    void btGameExitClick(ActionEvent event) throws Exception {
        saveData();
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Data will save to files!\nEasy mark, thank you.", ButtonType.OK);
        alert.showAndWait();
        Stage stage = (Stage) btGameExit.getScene().getWindow();
        stage.close();
    }



    @FXML
    void btCompeteClick(ActionEvent event) {

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
    void btRunClick(ActionEvent event) throws Exception {
        // load selected Athletes
        selectedAthletes();
        int numOfParticipant = participantData.size();
        // check number of participants
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
        }
        else if (numOfParticipant< 4){
            Alert alert = new Alert(Alert.AlertType.WARNING,"Game can not hold within 4 participants\nNow we have "
                    + numOfParticipant + " participants"
                    + "\nPlease select more participants.",
                    ButtonType.OK);
            alert.showAndWait();
        }
        else {
            competeResultsData.clear();
            setGame();
            startGame();
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Results collected",ButtonType.OK);
            alert.showAndWait();
            btRun.setDisable(true);
            btReset.setDisable(true);
            displayCompeteResultTable();
            DataStructure.saveCompeteResults(competeResultsData);
            displayScore();

        }
    }

    private void setGame() {
        int size = gamesData.size();
        if (size<10)
            gameID = "G0"+size;
        else
            gameID = "G"+size;

        game = new Game(gameID,gameType);
        gamesData.add(game);
    }


    /**
     * here may have problems
     */
    private void startGame() {
        competeResult = new CompeteResult(game,participantData);
        competeResult.getCompeteResults();

        competeResultsData = competeResult.getCompeteResultObservableList();
    }

    @FXML
    void btRunningClick(ActionEvent event) {
        preAthleteData.clear();
        gameType = "Running";
        preAthlete(athleteData);
        displayAthlete();
        enable();

    }

    @FXML
    void btScoreNewGameClick(ActionEvent event) {

    }

    @FXML
    void btSwimmingClick(ActionEvent event) {
        preAthleteData.clear();
        gameType = "Swimming";
        preAthlete(athleteData);
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

        resultTableGameIDCol.setCellValueFactory(cellData -> cellData.getValue().resultGameIDProperty());
        resultTableAthleteIDCol.setCellValueFactory(cellData -> cellData.getValue().resultAthleteIDProperty());
        resultTableAthleteNameCol.setCellValueFactory(cellData -> cellData.getValue().resultAthleteNameProperty());
        resultTableAthleteTypeCol.setCellValueFactory(cellData -> cellData.getValue().resultAthleteTypeProperty());
        resultTableAthleteResultCol.setCellValueFactory(cellData -> cellData.getValue().resultAthleteResultProperty().asObject());

        competeResultTable.setItems(competeResultsData);


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

    @FXML
    public void displayCompeteResultTable(){
        resultTableGameIDCol.setCellValueFactory(cellData -> cellData.getValue().resultGameIDProperty());
        resultTableAthleteIDCol.setCellValueFactory(cellData -> cellData.getValue().resultAthleteIDProperty());
        resultTableAthleteNameCol.setCellValueFactory(cellData -> cellData.getValue().resultAthleteNameProperty());
        resultTableAthleteTypeCol.setCellValueFactory(cellData -> cellData.getValue().resultAthleteTypeProperty());
        resultTableAthleteResultCol.setCellValueFactory(cellData -> cellData.getValue().resultAthleteResultProperty().asObject());

        competeResultTable.setItems(competeResultsData);
    }

    @FXML
    public void displayScore(){

        scoreTableAthleteIDCol.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        scoreTableAthleteNameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        scoreTableAthleteAgeCol.setCellValueFactory(cellDate -> cellDate.getValue().ageProperty().asObject());
        scoreTableAthleteStateCol.setCellValueFactory(cellDate -> cellDate.getValue().stateProperty());
        scoreTableAthleteTypeCol.setCellValueFactory(cellData -> cellData.getValue().abilityProperty());
        scoreTableAthleteScoreCol.setCellValueFactory(cellData -> cellData.getValue().scoreProperty().asObject());

        scoreTable.setItems(athleteData);

    }


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





//    private ObservableList<Game> getGame(ArrayList<Game> gameArrayList) {
//        int size = gameArrayList.size();
//        ObservableList<Game> gameData = FXCollections.observableArrayList();
//        return gameData;
//    }



//    private ObservableList<Official> getOfficial(ArrayList<Official> officialArrayList) {
//        return null;
//    }






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


    /**
     * save data
     */

    private void saveData() throws Exception {
        DataStructure.saveAthleteData(athleteData);
        DataStructure.saveCompeteResults(competeResultsData);
        DataStructure.saveResultData(resultsData);
        DataStructure.saveGame(gamesData);
    }
}
