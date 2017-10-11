package MVC.Model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.*;

public abstract class Athlete
{
    private String athleteID;
    private String athleteName;
    private int athleteAge;
    private String athleteState;
    private String athleteAbility;
    private int athleteScore;
    private BooleanProperty checked;

    public Athlete(String athleteID, String athleteName, int athleteAge, String athleteState, String athleteAbility, int athleteScore)
    {
        this.athleteID = athleteID;
        this.athleteName = athleteName;
        this.athleteAge = athleteAge;
        this.athleteState = athleteState;
        this.athleteAbility =athleteAbility;
        this.athleteScore = athleteScore;
        checked = new SimpleBooleanProperty(false);
    }


    public String getAthleteID() {
        return athleteID;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public int getAthleteAge() {
        return athleteAge;
    }

    public String getAthleteState() {
        return athleteState;
    }

    public String getAthleteAbility() {
        return athleteAbility;
    }

    public int getAthleteScore() {
        return athleteScore;
    }

    public void setAthleteScore(int athleteScore) {
        this.athleteScore += athleteScore;
    }

    public boolean isChecked() {return checked.get(); }


    public StringProperty idProperty() {
        return new SimpleStringProperty(athleteID);
    }

    public StringProperty nameProperty() {
        return new SimpleStringProperty(athleteName);
    }

    public IntegerProperty ageProperty() {
        return new SimpleIntegerProperty(athleteAge);
    }

    public StringProperty stateProperty(){
        return new SimpleStringProperty(athleteState);
    }

    public StringProperty abilityProperty(){
        return new SimpleStringProperty(athleteAbility);
    }

    public IntegerProperty scoreProperty(){
        return new SimpleIntegerProperty(athleteScore);
    }

    public BooleanProperty checkProperty(){
        return checked;
    }


    public abstract void compete(String gameType);

    public abstract int getResult();

    public String toStringSave() {
        return  getAthleteID() + " " +
                getAthleteName() + " " +
                getAthleteAge()+ " " +
                getAthleteState() + " " +
                getAthleteAbility() + " " +
                getAthleteScore();
    }

}
