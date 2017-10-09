package MVC.Model; /**********************************************************************************************************************
 * Author: Dario Ongsono
 * Purpose: This class responsible for the cyclist athlete and how it process its compete method
 * Create Date: 28/07/2017
 * Version: 1.15
 * Update Date: 04/09/2017
 **********************************************************************************************************************/
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Random;

public class Cyclist extends Athlete {

    private String participantAbility;
    private int result = 0; //result for compete method

    public Cyclist(String participantID, String participantName,  int participantAge,String participantState, int athleteScore) {
        super(participantID,participantName,participantAge,participantState, athleteScore);
        participantAbility = "Run";
    }



    public int compete(String gameType) {

        int min = 500;  //min result in seconds
        int max = 800;  //max result in seconds
        Random random =  new Random();
        result = random.nextInt(max - min + 1) + min;//provides a number between 100 seconds to 200 second
        return result;
    }

    @Override
    public String printParticipant() {
        return null;
    }

    // TODO: 9/10/2017
    @Override
    public StringProperty abilityProperty(){ return new SimpleStringProperty(participantAbility);}

}
