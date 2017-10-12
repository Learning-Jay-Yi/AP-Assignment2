package MVC.Model; /**********************************************************************************************************************
 * Author: Dario Ongsono
 * Purpose: This class is used to set the winners of each game and to be used to record match data
 * Create Date: 28/07/2017
 * Version: 1.15
 * Update Date: 04/09/2017
 **********************************************************************************************************************/

import com.sun.org.apache.regexp.internal.RE;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;

public class Results {
    private final int THIRDPLACEPOINT = 1;
    private final int SECONDPLACEPOINT = 2;
    private final int FIRSTPLACEPOINT = 5;

    private String firstID; //variable to hold first place ID
    private String secondID; //variable to hold second place ID
    private String thirdID; //variable to hold third place ID
    private String gameType;
    private String gameID;
    private String offcialID;

    private Official official;//Passing the official object
    private Game game;
    private ObservableList<Athlete> athleteObservableList;
    private ObservableList<Results> resultsObservableList = FXCollections.observableArrayList();


    public Results(Game game, ObservableList<Athlete> athleteObservableList, Official official) {
        //This constructor will be used to store the winners data
        this.game = game;
        this.athleteObservableList = athleteObservableList;
        this.official = official;
    }

    public void setWinner() {
        Collections.sort(athleteObservableList,(o1, o2)->o1.getResult() - o2.getResult());
        gameID = game.getGameID();
        gameType = game.getGameType();
        firstID = athleteObservableList.get(0).getAthleteID();
        secondID = athleteObservableList.get(1).getAthleteID();
        thirdID = athleteObservableList.get(2).getAthleteID();
        offcialID = official.getOfficialID();
        athleteObservableList.get(0).setAthleteScore(FIRSTPLACEPOINT);
        athleteObservableList.get(1).setAthleteScore(SECONDPLACEPOINT);
        athleteObservableList.get(2).setAthleteScore(THIRDPLACEPOINT);
    }



    public Results(String gameID, String gameType, String officialID,String firstID, String secondID, String thirdID) { //result constructor to load data back in
        this.gameID = gameID;
        this.gameType = gameType;
        this.offcialID = officialID;
        this.firstID = firstID;
        this.secondID = secondID;
        this.thirdID = thirdID;

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

    public String getGameID() {
        return gameID;
    }

    public String getOfficialID() {
        return offcialID;
    }

    public String getGameType() {
        return gameType;
    }

//    public void setGame(Game game) {
//        this.game = game;
//    }
//
//    public void setOfficial(Official official){
//        this.official = official;
//    }

    public String toString() { //To string to save file
        return  gameID +
                " " + gameType +
                " " + offcialID +
                " " + firstID +
                " " + secondID +
                " " + thirdID;
    }

    public ObservableList<Results> getResultsObservableList() {
        resultsObservableList.add(new Results(gameID,gameType,offcialID,firstID,secondID,thirdID));
        return resultsObservableList;
    }

    public StringProperty firstPlaceProperty() {return new SimpleStringProperty(firstID);}
    public StringProperty secondPlaceProperty() {return new SimpleStringProperty(secondID);}
    public StringProperty thirdPlaceProperty() {return new SimpleStringProperty(thirdID);}
    public StringProperty officialIdProperty() {return new SimpleStringProperty(offcialID);}
    public StringProperty gameIdProperty() {return new SimpleStringProperty(gameID);}
    public StringProperty gameTypeProperty() {return new SimpleStringProperty(gameType);}
}
