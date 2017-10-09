package MVC.Model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Athlete extends Participant
{

    private int athleteScore;



//    private ObservableList<Athlete> athleteObservableList = FXCollections.observableList();

    public Athlete(String participantID, String participantName, int participantAge, String participantState, int athleteScore)
    {
        super(participantID,participantName,participantState,participantAge);
        this.athleteScore = athleteScore;


    }





    public int getScore() {return athleteScore;}

    public abstract int compete(String gameType);

    public IntegerProperty scoreProperty() { return new SimpleIntegerProperty(athleteScore);}
    public abstract StringProperty abilityProperty();

}
