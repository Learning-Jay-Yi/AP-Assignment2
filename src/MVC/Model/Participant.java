package MVC.Model;

import javafx.beans.property.*;

/**********************************************************************************************************************
 * Author: Dario Ongsono
 * Purpose: This class is the abstract class of all participants of this system including officials
 * Create Date: 28/07/2017
 * Version: 1.15
 * Update Date: 04/09/2017
 **********************************************************************************************************************/

public abstract class Participant {

    private String participantID;
    private String participantName;
    private String participantState;
    private int participantAge;

    private BooleanProperty checked;



    public Participant(String participantID, String participantName , int participantAge, String participantState){
        this.participantID = participantID;
        this.participantName = participantName;
        this.participantState = participantState;
        this.participantAge = participantAge;

        checked = new SimpleBooleanProperty(false);
    }


    public String getParticipantID(){
        return participantID;
    }

    public String getParticipantName(){
        return participantName;
    }

    public String getParticipantState(){
        return participantState;
    }

    public int getParticipantAge() {
        return participantAge;
    }

    public boolean isChecked() {return checked.get(); }

    public void setParticipantID(String participantID) {
        this.participantID = participantID;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public void setParticipantState(String participantState) {
        this.participantState = participantState;
    }

    public void setParticipantAge(int participantAge) {
        this.participantAge = participantAge;
    }

    public abstract String printParticipant();



    public StringProperty nameProperty() { return new SimpleStringProperty(participantName);}
    public StringProperty idProperty() { return new SimpleStringProperty(participantID);}
    public IntegerProperty ageProperty() { return new SimpleIntegerProperty(participantAge);}
    public StringProperty stateProperty() { return new SimpleStringProperty(participantState);}

    public BooleanProperty checkProperty() { return checked; }




}
