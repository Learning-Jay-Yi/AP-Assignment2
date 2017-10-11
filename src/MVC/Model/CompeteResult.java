package MVC.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collection;
import java.util.Collections;


public class CompeteResult {
    private Game game;
    private ObservableList<Athlete> athleteObservableList;
    private ObservableList<CompeteResult> competeResultObservableList = FXCollections.observableArrayList();

    private String gameID;
    private String athleteID;
    private String athleteName;
    private String athleteType;
    private int athleteResults;



    public CompeteResult(String gameID, String athleteID, String athleteName, String athleteType, int athleteResults){
        this.gameID = gameID;
        this.athleteID = athleteID;
        this.athleteName = athleteName;
        this.athleteType = athleteType;
        this.athleteResults = athleteResults;
    }


    public StringProperty resultGameIDProperty() {
        return new SimpleStringProperty(gameID);
    }

    public StringProperty resultAthleteIDProperty() {
        return new SimpleStringProperty(athleteID);
    }

    public StringProperty resultAthleteNameProperty() {
        return new SimpleStringProperty(athleteName);
    }

    public StringProperty resultAthleteTypeProperty(){
        return new SimpleStringProperty(athleteType);
    }

    public IntegerProperty resultAthleteResultProperty(){
        return new SimpleIntegerProperty(athleteResults);
    }


    public String getGameID() {
        return gameID;
    }

    public String getAthleteID() {
        return athleteID;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public String getAthleteType() {
        return athleteType;
    }

    public int getAthleteResults() {
        return athleteResults;
    }


    public CompeteResult(Game game, ObservableList<Athlete> athleteObservableList) {
        this.game = game;
        this.athleteObservableList = athleteObservableList;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public ObservableList<Athlete> getAthleteObservableList() {
        return athleteObservableList;
    }

    public Game getGame() {
        return game;
    }

    /**
     * here will be have problems
     * @return
     */
    // get athlete's compete and return new list
    public void getCompeteResults(){
        for (Athlete a: athleteObservableList){
            a.compete(game.getGameType());
        }
    }

    public ObservableList<CompeteResult> getCompeteResultObservableList() {
        Collections.sort(athleteObservableList,(o1,o2)->o1.getResult() - o2.getResult());
        for (Athlete a: athleteObservableList) {
            competeResultObservableList.add(new CompeteResult(game.getGameID(), a.getAthleteID(), a.getAthleteName(), a.getAthleteAbility(), a.getResult()));
        }
        return competeResultObservableList;
    }


    @Override
    public String toString() {
        return  getGameID() + " " +
                getAthleteID() + " " +
                getAthleteName()+ " " +
                getAthleteType() + " " +
                getAthleteResults();
    }
}
