package MVC.Model; /**********************************************************************************************************************
 * Author: Dario Ongsono
 * Purpose: This class is used to set the winners of each game and to be used to record match data
 * Create Date: 28/07/2017
 * Version: 1.15
 * Update Date: 04/09/2017
 **********************************************************************************************************************/

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.util.Collections;

public class Results {
    private final int THIRDPLACEPOINT = 1;
    private final int SECONDPLACEPOINT = 2;
    private final int FIRSTPLACEPOINT = 5;
    private String firstID; //variable to hold first place ID
    private String secondID; //variable to hold second place ID
    private String thirdID; //variable to hold third place ID
    private Official official;//Passing the official object
    private String gameType;
    private String gameID;
    private String offcialID;
    private Game game;
    private ObservableList<Athlete> athleteObservableList;


    public Results(Game game, ObservableList<Athlete> athleteObservableList, Official official) {
        //This constructor will be used to store the winners data
        this.game = game;
        this.athleteObservableList = athleteObservableList;
        this.official = official;
    }

    public void setWiner() {
        Collections.sort(athleteObservableList,(o1, o2)->o1.getResult() - o2.getResult());
        athleteObservableList.get(0).setAthleteScore(FIRSTPLACEPOINT);
        athleteObservableList.get(1).setAthleteScore(SECONDPLACEPOINT);
        athleteObservableList.get(2).setAthleteScore(THIRDPLACEPOINT);
    }

    // TODO: 2017/10/11 load to GUI


    public Results(String gameID, String gameType, String firstID, String secondID, String thirdID, String officialID) { //result constructor to load data back in
        this.gameID = gameID;
        this.gameType = gameType;
        this.firstID = firstID;
        this.secondID = secondID;
        this.thirdID = thirdID;
        this.offcialID = officialID;
    }

    public String getFirstID() {
        return firstID;
    }

    public String getSecondID() {
        return secondID;
    }

    public String getThirdID() {
        return thirdID;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setOfficial(Official official){
        this.official = official;
    }

    @Override
    public String toString() { //To string to save file
        return  game.getGameID() +
                " " + game.getGameType() +
                " " + firstID +
                " " + secondID +
                " " + thirdID +
                " " + official.getOfficialID();

    }

    public StringProperty firstPlaceProperty() {return new SimpleStringProperty(firstID);}
    public StringProperty secondPlaceProperty() {return new SimpleStringProperty(secondID);}
    public StringProperty thirdPlaceProperty() {return new SimpleStringProperty(thirdID);}
    public StringProperty officialIdProperty() {return new SimpleStringProperty(official.getOfficialID());}
    public StringProperty gameIdProperty() {return new SimpleStringProperty(game.getGameID());}
    public StringProperty gameTypeProperty() {return new SimpleStringProperty(game.getGameType());}
}
