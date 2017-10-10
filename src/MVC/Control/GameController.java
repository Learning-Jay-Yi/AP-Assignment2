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

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class GameController {
    Game game;
//    Driver driver;
//    GameProcess gameProcess;
    DataStructure dataStructure;

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
        game.setGameType("Swimming");
        ObservableList<Athlete> prepAthletes = athleteType(game,athleteData);
        ObservableList<Athlete> participant = selectedAthletes(prepAthletes);

        enable();
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
        athleteTable.setDisable(true);
        athleteTable.setEditable(true);

    }

    private ObservableList<Athlete> athleteData = getAthlete(DataStructure.getAthleteArrayList());



    public ObservableList<Athlete> getAthlete(ArrayList<Athlete> athleteArrayList){

        ObservableList<Athlete> athleteData = FXCollections.observableArrayList();
        for (Athlete a : athleteArrayList)
            athleteData.add(a);
        return athleteData;
    }



    private void enable() {
        athleteTable.setDisable(false);
        btRun.setDisable(false);
        btReset.setDisable(false);
    }



    /**
     *
     * @return return suitable athletes to controller
     */
    public ObservableList<Athlete> athleteType(Game game, ObservableList<Athlete> athleteData) {
        ObservableList<Athlete> athleteType = FXCollections.observableArrayList();
        if (game.getGameType() == "Swimming"){
            for (Athlete a : athleteData){
                if (a instanceof Swimmer && a instanceof SuperAthlete)
                    athleteType.add(a);
            }

        }else if (game.getGameType() == "Cycling"){
            for (Athlete a : athleteData){
                if (a instanceof Cyclist && a instanceof SuperAthlete)
                    athleteType.add(a);
            }

        }else if (game.getGameType() == "Running"){
            for (Athlete a : athleteData){
                if (a instanceof Runner && a instanceof SuperAthlete)
                    athleteType.add(a);
            }

        }
        return athleteType;
    }


    /**
     * selected athletes
     */
    public ObservableList<Athlete> selectedAthletes(ObservableList<Athlete> athletes) {

        return null;
    }

    /****************************************************************************************************************
     *
     * Saving && Loading
     *
     ****************************************************************************************************************/
    public static void saveGame() throws IOException { //method to call all save methods
        saveResultData();
        saveAthleteData();
        saveOfficialData();
        System.out.println("Game saved successfully!");
    }

    public static void loadGame() throws IOException { //method to load all saved data
        loadResultData();
        loadAthleteData();
        loadOfficialData();
        System.out.println("Game loaded successfully ");
    }

    public static void loadOfficialData() throws FileNotFoundException { //load game result data back to results arraylist
        File f = new File("Official.txt");
        Scanner sc = new Scanner(f);

        while (sc.hasNext()){ //while the file still has next line

            String ID = sc.next();
            String name = sc.next();
            String state = sc.next();
            int age = sc.nextInt();


            DataStructure.getOfficalArrayList().add(new Official(ID,name,age,state));

        }
        sc.close();
    }

    public static void loadResultData() throws FileNotFoundException { //load game result data back to results arraylist
        File f = new File("Results.txt");
        Scanner sc = new Scanner(f);

        while (sc.hasNext()){ //while the file still has next line

            String gameID = sc.next();
            String gameType = sc.next();
            String firstPlace = sc.next();
            String secondPlace = sc.next();
            String thirdPlace = sc.next();
            String officialID = sc.next();

            DataStructure.getResultArrayList().add(new Results(gameID, gameType, firstPlace, secondPlace, thirdPlace, officialID));

        }
        sc.close();
    }

    public static void loadAthleteData() throws IOException {

        File f = new File("Athlete.txt"); //need to change file path for mac
        Scanner sc = new Scanner(f);


        while (sc.hasNext())  {
            String ID = sc.next();
            String name = sc.next();
            String state = sc.next();
            int age = (int)sc.nextInt();
            int points = (int)sc.nextInt();

            if (ID.charAt(0) == 'C' ) //If data belongs to Cyclist
            {
                DataStructure.getAthleteArrayList().add(new Cyclist(ID,name,age,state, points));
            }
            else if (ID.charAt(0) == 'R'){ //If data belongs to Runner
                DataStructure.getAthleteArrayList().add(new Runner(ID,name,age,state, points));
            }
            else if (ID.charAt(0) == 'S'){ //If data belongs to Swimmer
                DataStructure.getAthleteArrayList().add(new Swimmer(ID,name,age,state ,points));
            }
            else{//If data belongs to Super Athlete
                DataStructure.getAthleteArrayList().add(new SuperAthlete(ID,name,age, state, points));
            }






        }

        sc.close();
    }

    public static void saveResultData() throws IOException {
        try {
            FileWriter fw = new FileWriter("Results.txt");
            BufferedWriter output = new BufferedWriter(fw);

            for (int i = 0; i < DataStructure.getResultArrayList().size(); i++){ //save everything from Result arraylist
                output.write(DataStructure.getResultArrayList().get(i).toString());
                output.newLine();
            }



            output.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "I cannot create that file");
        }
    }

    public static void saveAthleteData() throws IOException {
        try {


            FileWriter fw2 = new FileWriter("Athlete.txt"); //Creating text file
            BufferedWriter output2 = new BufferedWriter(fw2); //Writing into file


            for (int i = 0; i < DataStructure.getAthleteArrayList().size(); i++){ // save everything from Athlete arraylist
                output2.write(DataStructure.getAthleteArrayList().get(i).toString());
                output2.newLine();// goes to new line after each entry
            }

            output2.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "I cannot create that file");
        }
    }

    public static void saveOfficialData() throws IOException {
        try {

            FileWriter fw = new FileWriter("Official.txt");
            BufferedWriter output = new BufferedWriter(fw);

            for (int i = 0; i < DataStructure.getOfficalArrayList().size(); i++) { //Save everything from Official arraylist
                output.write(DataStructure.getOfficalArrayList().get(i).toString());
                output.newLine();// goes to new line after each entry
            }

            output.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "I cannot create that file");
        }

    }



}
