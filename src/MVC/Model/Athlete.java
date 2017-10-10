package MVC.Model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Athlete extends Participant
{
    private int athleteScore;

    public Athlete(String participantID, String participantName, int participantAge, String participantState, int athleteScore)
    {
        super(participantID,participantName,participantAge,participantState);
        this.athleteScore = athleteScore;
    }


    public void setAthleteScore(int athleteScore) {
        this.athleteScore += athleteScore;
    }

    public int getAthleteScore() {
        return athleteScore;
    }



    public abstract int compete(String gameType);

    public IntegerProperty scoreProperty() { return new SimpleIntegerProperty(athleteScore);}
    public abstract StringProperty abilityProperty();

    public String toStringSave() {
        return getParticipantID() + getParticipantName() + getParticipantState() + getParticipantAge() + athleteScore;
    }

}
