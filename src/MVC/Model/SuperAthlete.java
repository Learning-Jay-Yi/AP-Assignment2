package MVC.Model; /**********************************************************************************************************************
 * Author: Dario Ongsono
 * Purpose: This is the super athlete subclass where this athlete can compete in any of the 3 sport
 * Create Date: 28/07/2017
 * Version: 1.15
 * Update Date: 04/09/2017
 **********************************************************************************************************************/

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Random;

public class SuperAthlete extends Athlete {
    private String participantAbility;
    private int result; //results from the compete method

    public SuperAthlete (String participantID, String participantName,  int participantAge,String participantState, int athleteScore) {
        super(participantID,participantName,participantAge,participantState, athleteScore);
        participantAbility = "Super";
    }


    public String getParticipantAbility() {
        return participantAbility;
    }

    public int compete(String gameType) { //Take gameType parameter so that this class knows which compete to use
        Random random =  new Random();
        int min = 0;
        int max = 0;
        if(gameType == "Swimming"){
            //MVC.Model.Swimmer calculations
            min = 100; //min result in seconds
            max = 200; //max result in seconds
        }
        else if(gameType == "Running"){
            //MVC.Model.Runner Calculations
            min = 10;//min result in seconds
            max = 20; //max result in seconds
        }
        else if(gameType == "Cycling") {
            //MVC.Model.Cyclist Calculations
            min = 500; //min result in seconds
            max = 800; //max result in seconds
        }
        //provides a number
        //Generates a number between the range provided by the min and max variables
        result = random.nextInt(max - min + 1) + min;
        return result;
    }

    @Override
    public String printParticipant() {
        return participantAbility;
    }// TODO: 9/10/2017
    @Override
    public StringProperty abilityProperty() {return new SimpleStringProperty(participantAbility);}
}
