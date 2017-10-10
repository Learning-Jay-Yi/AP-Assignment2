package MVC.Model; /**********************************************************************************************************************
 * Author: Dario Ongsono
 * Purpose: This class responsible for the MVC.Model.Runner athlete and how it process its compete method
 * Create Date: 28/07/2017
 * Version: 1.15
 * Update Date: 04/09/2017
 **********************************************************************************************************************/

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Random;

public class Runner extends Athlete {

    private int result; //returns latest result from compete()

    public Runner (String athleteID, String athleteName, int athleteAge, String athleteState, String athleteAbility, int athleteScore) {
        super(athleteID,athleteName,athleteAge,athleteState,athleteAbility,athleteScore);
    }
    public int compete(String gameType) {

        int min = 10;  //min result in seconds
        int max = 20;  //max result in seconds
        Random random =  new Random();
        result = random.nextInt(max - min + 1) + min;//provides a number between 100 seconds to 200 second
        return result;
    }
}

