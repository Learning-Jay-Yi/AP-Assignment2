package MVC.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**********************************************************************************************************************
 * Author: Dario Ongsono
 * Purpose: MVC.Model.Game class that allows to create a game type object
 * Create Date: 28/07/2017
 * Version: 1.15
 * Update Date: 04/09/2017
 **********************************************************************************************************************/

public class Game {
    private String gameID;
    private String gameType;


    public Game (String gameID, String gameType){
        this.gameID = gameID;
        this.gameType = gameType;
    }




    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getGameID() {
        return gameID;
    }

    public String getGameType() {
        return gameType;
    }


    @Override
    public String toString() {
        return getGameID() + " " +getGameType();
    }

    public StringProperty gameIdProperty() {return new SimpleStringProperty(gameID);}
    public StringProperty gameTypeProperty() {return new SimpleStringProperty(gameType);}
}
