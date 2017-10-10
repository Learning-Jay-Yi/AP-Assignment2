package MVC.Model; /**********************************************************************************************************************
 * Author: Dario Ongsono
 * Purpose: This class is used to set the winners of each game and to be used to record match data
 * Create Date: 28/07/2017
 * Version: 1.15
 * Update Date: 04/09/2017
 **********************************************************************************************************************/

import MVC.Control.ProcessResults;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Results {
    private String firstID; //variable to hold first place ID
    private String secondID; //variable to hold second place ID
    private String thirdID; //variable to hold third place ID
    private Official official;//Passing the official object
    private String gameType;
    private String gameID;
    private String offcialID;
    private Game game;//Passing the game object


    public Results(Game game, String firstID, String secondID, String thirdID, Official official) {
        //This constructor will be used to store the winners data
        this.game = game;
        this.firstID = firstID;
        this.secondID = secondID;
        this.thirdID = thirdID;
        this.official = official;
    }

    public Results(String gameID, String gameType, String firstID, String secondID, String thirdID, String officialID) { //result constructor to load data back in
        this.gameID = gameID;
        this.gameType = gameType;
        this.firstID = firstID;
        this.secondID = secondID;
        this.thirdID = thirdID;
        this.offcialID = officialID;
    }

    public void setWinners(ArrayList<ProcessResults> finalResult){
        firstID = finalResult.get(0).getAthID();
        secondID = finalResult.get(1).getAthID();
        thirdID = finalResult.get(2).getAthID();
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

//
//
//    public String toPrint() { // TODO: 10/10/2017 need to change this original ToString methods in coontroller class
//        return  game.toString()+
//                "\n\tRefer from \n" + official.printParticipant() +
//                "\nFirstPlace: " + firstID +
//                "\nSecondPlace: " + secondID +
//                "\nThirdPlace: " + thirdID;
//
//    }

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
