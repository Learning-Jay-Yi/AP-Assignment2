package MVC.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**********************************************************************************************************************
 * Author: Dario Ongsono
 * Purpose: This is a subclass of the participant class to create the official object
 * Create Date: 28/07/2017
 * Version: 1.15
 * Update Date: 04/09/2017
 **********************************************************************************************************************/

public class Official {

    private String officialID;
    private String officialName;
    private int officialAge;
    private String officialState;
    
    
    public Official(String officialID, String officialName, int officialAge, String officialState){
        this.officialID = officialID;
        this.officialName = officialName;
        this.officialAge = officialAge;
        this.officialState = officialState;
    }

    public String getOfficialID() {
        return officialID;
    }

    public String getOfficialName() {
        return officialName;
    }

    public int getOfficialAge() {
        return officialAge;
    }

    public String getOfficialState() {
        return officialState;
    }



    public StringProperty idProperty() {
        return new SimpleStringProperty(officialID);
    }

    public StringProperty nameProperty() {
        return new SimpleStringProperty(officialName);
    }

    public IntegerProperty ageProperty() {
        return new SimpleIntegerProperty(officialAge);
    }

    public StringProperty stateProperty(){
        return new SimpleStringProperty(officialState);
    }

    public String toString(){
        return getOfficialID() + " " + getOfficialName() + " " + getOfficialAge()  + " " + getOfficialState() ;
    }



}
