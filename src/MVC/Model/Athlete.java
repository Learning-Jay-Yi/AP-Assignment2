package MVC.Model;

import javafx.beans.property.*;

public abstract class Athlete extends Participant
{
    private int athleteScore;

    public Athlete(String participantID, String participantName, int participantAge, String participantState, int athleteScore)
    {
        super(participantID,participantName,participantState,participantAge);
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



}
