/**********************************************************************************************************************
 * Author: JIE YI
 * Purpose: Controller for whole program
 * Create Date: 08/10/2017
 * Version: 2.05
 * Update Date: 12/10/2017
 **********************************************************************************************************************/

package MVC.Control;

import MVC.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.File;
import java.util.Random;



public class GameController {
    Game game;

    String gameID;
    String gameType;

    Results results;
    CompeteResult competeResult;

    // load athlete's data from file or data structure
    private ObservableList<Athlete> athleteData = DataStructure.getAthleteArrayList();
    // load game's data from file or data structure
    private ObservableList<Game> gamesData = DataStructure.getGameArrayList();

    private ObservableList<Official> officialsData = DataStructure.getOfficialArrayList();

    private ObservableList<Results> resultsData = DataStructure.getResultArrayList();

    private ObservableList<Athlete> preAthleteData = FXCollections.observableArrayList();

    private ObservableList<Athlete> participantData = FXCollections.observableArrayList();

    private ObservableList<CompeteResult> competeResultsData = DataStructure.getCompeteResultArrayList();


    @FXML
    private BorderPane rootPane;

    @FXML // fx:id="tabGame"
    private Tab tabGame; // Value injected by FXMLLoader

//    @FXML // fx:id="btSwimming"
//    private Button btSwimming; // Value injected by FXMLLoader

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
    private Button btCompete; // Value injected by FXMLLoader

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
        reSetCheckBox();
        reSetParticipantData();

        lbGameInfo.setText("This is Cycling game\nPlease select participants to compete.");

        gameType = "Cycling";
        preAthlete(athleteData);
        displayAthlete();
        enableBt();
    }

    @FXML
    void btGameExitClick(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are your sure to quit?", ButtonType.YES,ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES){
            saveData();
            Alert thanks = new Alert(Alert.AlertType.INFORMATION,"Data saved to files\nEasy mark, Thank you.",ButtonType.OK);
            thanks.showAndWait();
            Stage stage = (Stage) btGameExit.getScene().getWindow();
            stage.close();
        }

    }



    @FXML
    void btCompeteClick(ActionEvent event) throws Exception {
        setGame();
        startGame();
        setWinner();

        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Compete successful!",ButtonType.OK);
        alert.showAndWait();

        refreshTables();
    }

    @FXML
    void btQuitGameClick(ActionEvent event) throws Exception {
        btGameExitClick(event);
    }

    @FXML
    void btResetClick(ActionEvent event) {
        reSetCheckBox();
        reSetParticipantData();

        btRun.setDisable(true);
        btCompete.setDisable(true);
        btReset.setDisable(true);

        initialize();
        lbGameInfo.setText("Select a game above to start the game");

    }

    @FXML
    void btResultNewGameClick(ActionEvent event) {
        btResetClick(event);
        tabGame.getTabPane().getSelectionModel().select(tabGame);

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
        else if (numOfParticipant < 4){
            Alert alert = new Alert(Alert.AlertType.WARNING,"Game can not hold within 4 participants\nNow we have "
                    + numOfParticipant + " participants"
                    + "\nPlease select more participants.",
                    ButtonType.OK);
            alert.showAndWait();
            for(Athlete a: preAthleteData){
                if (a.isChecked()){
                    participantData.remove(a);
                    System.out.println(a.getAthleteID()+ " is quit game.");
                    a.checkProperty().set(false);
                }
            }
        }
        else {
            competeResultsData.clear();
            setGame();
            startGame();
            setWinner();

            processGame();
            refreshTables();

            lbGameInfo.setText("Compete successful!\nPlease refer to 'Result Tab'");

            btRun.setDisable(true);
            btReset.setDisable(true);
            athleteTable.setDisable(true);
            btCompete.setDisable(false);
            reSetCheckBox();
        }
    }




    @FXML
    void btRunningClick(ActionEvent event) {
        reSetCheckBox();
        reSetParticipantData();

        lbGameInfo.setText("This is Running game\nPlease select participants to compete.");

        gameType = "Running";
        preAthlete(athleteData);
        displayAthlete();
        enableBt();
    }

    @FXML
    void btScoreNewGameClick(ActionEvent event) {
        btResetClick(event);
        tabGame.getTabPane().getSelectionModel().select(tabGame);
    }

    @FXML
    void btSwimmingClick(ActionEvent event) {
        reSetCheckBox();
        reSetParticipantData();

        lbGameInfo.setText("This is Swimming game\nPlease select participants to compete.");

        gameType = "Swimming";
        preAthlete(athleteData);
        displayAthlete();
        enableBt();
//        test();
//        transeferData();
    }



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

        displayCompeteResultTable();
        displayResultHistoryTable();
        displayScore();
    }

    /**
     * new function to load data to table
     *
     */

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

    @FXML
    public void displayResultHistoryTable (){
        resultHistoryTableGameIDCol.setCellValueFactory(cellData -> cellData.getValue().gameIdProperty());
        resultHistoryTableGameTypeCol.setCellValueFactory(cellData -> cellData.getValue().gameTypeProperty());
        resultHistoryTableOfficialIDCol.setCellValueFactory(cellData -> cellData.getValue().officialIdProperty());
        resultHistoryTableFirstPlaceCol.setCellValueFactory(cellData -> cellData.getValue().firstPlaceProperty());
        resultHistoryTableSecondPlaceCol.setCellValueFactory(cellData -> cellData.getValue().secondPlaceProperty());
        resultHistoryTableThirdPlaceCol.setCellValueFactory(cellData -> cellData.getValue().thirdPlaceProperty());

        resultHistoryTable.setItems(resultsData);
    }

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
        DataStructure.saveOfficialData(officialsData);
    }

    /**
     * other functions
     */



    private void setGame() {
        int size = gamesData.size();
        if (size<10)
            gameID = "G0"+size;
        else
            gameID = "G"+size;

        game = new Game(gameID,gameType);
        gamesData.add(game);
    }

    private void startGame() {
        competeResult = new CompeteResult(game,participantData);
        competeResult.getCompeteResults();
        competeResultsData.clear();
        // renew Compete Results Data
        for (CompeteResult c : competeResult.getCompeteResultObservableList())
            competeResultsData.add(c);
    }

    private void setWinner() throws Exception {
        results = new Results(game,participantData,official());
        results.setWinner();
        resultsData.add(
                new Results(
                        results.getGameID(),
                        results.getGameType(),
                        results.getOfficialID(),
                        results.getFirstID(),
                        results.getSecondID(),
                        results.getThirdID()
                )
        );
//        DataStructure.saveResultData(resultsData);

    }

    private Official official() {
        Random random = new Random();
        int index = random.nextInt(4);
        return officialsData.get(index);
    }

    private void reSetCheckBox(){
        for (Athlete a: preAthleteData)
            if (a.isChecked())
                a.checkProperty().set(false);
    }

    private void reSetParticipantData(){
        preAthleteData.clear();
        participantData.clear();
    }

    private void refreshTables() {
        scoreTable.refresh();
        competeResultTable.refresh();
        resultHistoryTable.refresh();
    }

    private void processGame() {
        String s = gameType+".gif";

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        File file = new File(s);
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(image);
        alert.setGraphic(imageView);
        alert.setContentText("Compete successful!\nPlease refer to 'Result Tab'");
        alert.setResult(ButtonType.OK);
        alert.showAndWait();
    }

    private void enableBt() {
        athleteTable.setDisable(false);
        btRun.setDisable(false);
        btReset.setDisable(false);
    }


    /**
     * testing
     */

//    private void test(){
//        int size = gamesData.size();
//        Game game = gamesData.get(size-1);
//        DataStructure.saveCompeteData(game.getGameID(),competeResultsData);
//    }
//
//    private void transeferData(){
//        /*
//            do what you want here
//            such as, HashMap to list.
//         */
//        String gameID = gamesData.get(gamesData.size()-1).getGameID();
//
//        ObservableMap a = DataStructure.getCompeteData();
//        ObservableList<CompeteResult> b;
//
//                //how to get value?
//    }

}
