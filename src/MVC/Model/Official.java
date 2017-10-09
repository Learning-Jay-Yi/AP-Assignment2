package MVC.Model;

import MVC.Model.Participant;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**********************************************************************************************************************
 * Author: Dario Ongsono
 * Purpose: This is a subclass of the participant class to create the official object
 * Create Date: 28/07/2017
 * Version: 1.15
 * Update Date: 04/09/2017
 **********************************************************************************************************************/

public class Official extends Participant {
    public Official(String participantID, String participantName, String participantState, int participantAge) {
        super(participantID,participantName,participantState,participantAge);

    }

    public String printParticipant() {
        return "MVC.Model.Official ID: " + super.getParticipantID() +
                "\tMVC.Model.Official Name: " + super.getParticipantName();
    }

//    @Override
//    public String getParticipantAbility() {
//        return null;
//    }

    public StringProperty officialProperty() {return new SimpleStringProperty(super.getParticipantID());}



}
