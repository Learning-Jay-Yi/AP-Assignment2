package MVC.Model;

import MVC.Control.GameController;
import MVC.Control.ProcessResults;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataStructure {

    private static ArrayList<Results> resultsArrayList = new ArrayList<>();
    private static ArrayList<Athlete> athleteArrayList = new ArrayList<>();
    private static ArrayList<Official> officialArrayList = new ArrayList<>();
    private static ArrayList<ProcessResults> processResultsArrayList = new ArrayList<>();
    private static ArrayList<Game> gameArrayList = new ArrayList<>();

    GameController gameController = new GameController();

//    private ObservableList <Athlete> athleteObservableList = initialize(athleteArrayList);

    public DataStructure(){

    }



    public void setAthleteArrayList(ArrayList<Athlete> athleteArrayList) {
        this.athleteArrayList = athleteArrayList;
    }

    public void setResultsArrayList(ArrayList<Results> resultsArrayList) {
        this.resultsArrayList = resultsArrayList;
    }

    public void setGameArrayList(ArrayList<Game> gameArrayList) {
        this.gameArrayList = gameArrayList;
    }

    public void setOfficialArrayList(ArrayList<Official> officialArrayList) {
        this.officialArrayList = officialArrayList;
    }

    public void setProcessResultsArrayList(ArrayList<ProcessResults> processResultsArrayList) {
        this.processResultsArrayList = processResultsArrayList;
    }


    public static ArrayList<Athlete> getAthleteArrayList() {
        return athleteArrayList;
    }

    public static ArrayList<Official> getOfficalArrayList(){
        return officialArrayList;
    }

    public static ArrayList<Results> getResultArrayList(){
        return resultsArrayList;
    }

    private ObservableList<Athlete> initialize(ArrayList<Athlete> athleteArrayList) {
        ObservableList <Athlete> athletes = FXCollections.observableArrayList();
//        if (athleteObservableList == null){
            for (Athlete athlete : athleteArrayList)
                athletes.add(athlete);
//        }
        return athletes;
    }


    public static void loadGame() throws IOException { //method to load all saved data
        loadResultData();
        loadAthleteData();
        loadOfficialData();
        System.out.println("Game loaded successfully ");
    }

    public static void saveGame() throws IOException { //method to call all save methods
        saveResultData();
        saveAthleteData();
        saveOfficialData();
        System.out.println("Game saved successfully!");
    }



    public static void saveResultData() throws IOException {
        try {
            FileWriter fw = new FileWriter("Results.txt");
            BufferedWriter output = new BufferedWriter(fw);

            for (int i = 0; i < DataStructure.getResultArrayList().size(); i++){ //save everything from Result arraylist
                output.write(DataStructure.getResultArrayList().get(i).toString());
                output.newLine();
            }



            output.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "I cannot create that file");
        }
    }

    public static void saveAthleteData() throws IOException {
        try {


            FileWriter fw2 = new FileWriter("Athlete.txt"); //Creating text file
            BufferedWriter output2 = new BufferedWriter(fw2); //Writing into file


            for (int i = 0; i < DataStructure.getAthleteArrayList().size(); i++){ // save everything from Athlete arraylist
                output2.write(DataStructure.getAthleteArrayList().get(i).toStringSave());
                output2.newLine();// goes to new line after each entry
            }

            output2.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "I cannot create that file");
        }
    }

    public static void saveOfficialData() throws IOException {
        try {

            FileWriter fw = new FileWriter("Official.txt");
            BufferedWriter output = new BufferedWriter(fw);

            for (int i = 0; i < DataStructure.getOfficalArrayList().size(); i++) { //Save everything from Official arraylist
                output.write(DataStructure.getOfficalArrayList().get(i).toString());
                output.newLine();// goes to new line after each entry
            }

            output.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "I cannot create that file");
        }

    }


    public static void loadOfficialData() throws FileNotFoundException { //load game result data back to results arraylist
        File f = new File("Official.txt");
        Scanner sc = new Scanner(f);

        while (sc.hasNext()){ //while the file still has next line

            String ID = sc.next();
            String name = sc.next();
            String state = sc.next();
            int age = sc.nextInt();


            DataStructure.getOfficalArrayList().add(new Official(ID,name,age,state));

        }
        sc.close();
    }

    public static void loadResultData() throws FileNotFoundException { //load game result data back to results arraylist
        File f = new File("Results.txt");
        Scanner sc = new Scanner(f);

        while (sc.hasNext()){ //while the file still has next line

            String gameID = sc.next();
            String gameType = sc.next();
            String firstPlace = sc.next();
            String secondPlace = sc.next();
            String thirdPlace = sc.next();
            String officialID = sc.next();

            DataStructure.getResultArrayList().add(new Results(gameID, gameType, firstPlace, secondPlace, thirdPlace, officialID));

        }
        sc.close();
    }

    public static void loadAthleteData() throws IOException {

        File f = new File("Athlete.txt"); //need to change file path for mac
        Scanner sc = new Scanner(f);


        while (sc.hasNext())  {
            String ID = sc.next();
            String name = sc.next();
            String state = sc.next();
            int age = (int)sc.nextInt();
            int points = (int)sc.nextInt();

            if (ID.charAt(0) == 'C' ) //If data belongs to Cyclist
            {
                DataStructure.getAthleteArrayList().add(new Cyclist(ID,name,age,state, points));
            }
            else if (ID.charAt(0) == 'R'){ //If data belongs to Runner
                DataStructure.getAthleteArrayList().add(new Runner(ID,name,age,state, points));
            }
            else if (ID.charAt(0) == 'S'){ //If data belongs to Swimmer
                DataStructure.getAthleteArrayList().add(new Swimmer(ID,name,age,state ,points));
            }
            else{//If data belongs to Super Athlete
                DataStructure.getAthleteArrayList().add(new SuperAthlete(ID,name,age, state, points));
            }






        }

        sc.close();
    }

    // do not use it again, find the new way to do this!!!
//    public ObservableList<Athlete> getAthleteObservableList() {
//        return athleteObservableList;
//    }

    /**
     * loading athletes
     *
     */


    /**
     * we need load data from text file
     * or add data from here
     * @return
     */

    public static void initialize() throws IOException{
    try {
        loadAthleteData();
        loadOfficialData();
        loadResultData();
    } catch(IOException ioe) {
       addAthletes();
       setOfficial(officialArrayList);

    }
    }

    public static void addAthletes(){
        athleteArrayList.add(new Cyclist("C01","Cyc01",25,"VIC",25));
        athleteArrayList.add(new Cyclist("C02","Cyc02",25,"VIC",36));
        athleteArrayList.add(new Cyclist("C03","Cyc03",25,"VIC",27));
        athleteArrayList.add(new Cyclist("C04","Cyc04",25,"VIC",32));
        athleteArrayList.add(new Cyclist("C05","Cyc05",25,"VIC",31));
        athleteArrayList.add(new Cyclist("C06","Cyc06",25,"VIC",22));
        athleteArrayList.add(new Cyclist("C07","Cyc07",25,"VIC",26));

        athleteArrayList.add(new Runner("R01","Run01",25,"VIC",24));
        athleteArrayList.add(new Runner("R02","Run02",35,"VIC",25));
        athleteArrayList.add(new Runner("R03","Run03",35,"VIC",27));
        athleteArrayList.add(new Runner("R04","Run04",35,"VIC",31));
        athleteArrayList.add(new Runner("R05","Run05",35,"VIC",33));
        athleteArrayList.add(new Runner("R06","Run06",35,"VIC",32));
        athleteArrayList.add(new Runner("R07","Run07",35,"VIC",29));

        athleteArrayList.add(new Swimmer("S01","Swim01",21,"VIC",23));
        athleteArrayList.add(new Swimmer("S02","Swim02",21,"VIC",25));
        athleteArrayList.add(new Swimmer("S03","Swim03",21,"VIC",28));
        athleteArrayList.add(new Swimmer("S04","Swim04",21,"VIC",35));
        athleteArrayList.add(new Swimmer("S05","Swim05",21,"VIC",25));
        athleteArrayList.add(new Swimmer("S06","Swim06",21,"VIC",27));
        athleteArrayList.add(new Swimmer("S07","Swim07",21,"VIC",26));

        athleteArrayList.add(new SuperAthlete("SA01","Sup01",22,"VIC",33));
        athleteArrayList.add(new SuperAthlete("SA02","Sup02",22,"VIC",31));
        athleteArrayList.add(new SuperAthlete("SA03","Sup03",22,"VIC",32));
        athleteArrayList.add(new SuperAthlete("SA04","Sup04",22,"VIC",34));


        
    }









    public static void setOfficial(ArrayList officialArrayList){
        Official official1 = new Official("OF01","Official01",50,"VIC");
        Official official2 = new Official("OF02","Official02",52,"VIC");
        Official official3 = new Official("OF03","Official03",54, "VIC");
        Official official4 = new Official("OF04","Official04",58, "VIC");
        officialArrayList.add(official1);
        officialArrayList.add(official2);
        officialArrayList.add(official3);
        officialArrayList.add(official4);


    }

//    public static void setCyclist(ArrayList athleteArrayList){
//        Athlete cyclist1 = new Cyclist("C01","Cyc01",25,"VIC",25);
//        Athlete cyclist2 = new Cyclist("C02","Cyc02",25,"VIC",36);
//        Athlete cyclist3 = new Cyclist("C03","Cyc03",25,"VIC",27);
//        Athlete cyclist4 = new Cyclist("C04","Cyc04",25,"VIC",32);
//        Athlete cyclist5 = new Cyclist("C05","Cyc05",25,"VIC",31);
//        Athlete cyclist6 = new Cyclist("C06","Cyc06",25,"VIC",22);
//        Athlete cyclist7 = new Cyclist("C07","Cyc07",25,"VIC",26);
//        athleteArrayList.add(cyclist1);
//        athleteArrayList.add(cyclist2);
//        athleteArrayList.add(cyclist3);
//        athleteArrayList.add(cyclist4);
//        athleteArrayList.add(cyclist5);
//        athleteArrayList.add(cyclist6);
//        athleteArrayList.add(cyclist7);
//
//    }

//    public static void setRunner(ArrayList athleteArrayList){
//        Athlete runner1 = new Runner("R01","Run01",25,"VIC",24);
//        Athlete runner2 = new Runner("R02","Run02",35,"VIC",25);
//        Athlete runner3 = new Runner("R03","Run03",35,"VIC",27);
//        Athlete runner4 = new Runner("R04","Run04",35,"VIC",31);
//        Athlete runner5 = new Runner("R05","Run05",35,"VIC",33);
//        Athlete runner6 = new Runner("R06","Run06",35,"VIC",32);
//        Athlete runner7 = new Runner("R07","Run07",35,"VIC",29);
//        athleteArrayList.add(runner1);
//        athleteArrayList.add(runner2);
//        athleteArrayList.add(runner3);
//        athleteArrayList.add(runner4);
//        athleteArrayList.add(runner5);
//        athleteArrayList.add(runner6);
//        athleteArrayList.add(runner7);

//    }

//    public static void setSwimmer(ArrayList athleteArrayList){
//        Athlete swimmer1 = new Swimmer("S01","Swim01",21,"VIC",23);
//        Athlete swimmer2 = new Swimmer("S02","Swim02",21,"VIC",25);
//        Athlete swimmer3 = new Swimmer("S03","Swim03",21,"VIC",28);
//        Athlete swimmer4 = new Swimmer("S04","Swim04",21,"VIC",35);
//        Athlete swimmer5 = new Swimmer("S05","Swim05",21,"VIC",25);
//        Athlete swimmer6 = new Swimmer("S06","Swim06",21,"VIC",27);
//        Athlete swimmer7 = new Swimmer("S07","Swim07",21,"VIC",26);
//        athleteArrayList.add(swimmer1);
//        athleteArrayList.add(swimmer2);
//        athleteArrayList.add(swimmer3);
//        athleteArrayList.add(swimmer4);
//        athleteArrayList.add(swimmer5);
//        athleteArrayList.add(swimmer6);
//        athleteArrayList.add(swimmer7);
//
//    }

//    public static void setSuperAthlete(ArrayList athleteArrayList){
//        Athlete superAthlete1 = new SuperAthlete("SA01","Sup01",22,"VIC",33);
//        Athlete superAthlete2 = new SuperAthlete("SA02","Sup02",22,"VIC",31);
//        Athlete superAthlete3 = new SuperAthlete("SA03","Sup03",22,"VIC",32);
//        Athlete superAthlete4 = new SuperAthlete("SA04","Sup04",22,"VIC",34);
//        athleteArrayList.add(superAthlete1);
//        athleteArrayList.add(superAthlete2);
//        athleteArrayList.add(superAthlete3);
//        athleteArrayList.add(superAthlete4);
//    }



}
