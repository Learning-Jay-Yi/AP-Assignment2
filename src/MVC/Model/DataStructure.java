package MVC.Model;

import MVC.Control.ProcessResults;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class DataStructure {

    private static ObservableList<Results> resultsArrayList = FXCollections.observableArrayList();
    private static ObservableList<Athlete> athleteArrayList = FXCollections.observableArrayList();
    private static ObservableList<Official> officialArrayList = FXCollections.observableArrayList();
    private static ObservableList<ProcessResults> processResultsArrayList = FXCollections.observableArrayList();
    private static ObservableList<Game> gameArrayList = FXCollections.observableArrayList();


//    public DataStructure(ObservableList<Results> resultsArrayList,
//                         ObservableList<Athlete> athleteArrayList,
//                         ObservableList<Official> officialArrayList,
//                         ObservableList<ProcessResults> processResultsArrayList,
//                         ObservableList<Game> gameArrayList){
//        this.athleteArrayList = athleteArrayList;
//        this.officialArrayList = officialArrayList;
//        this.gameArrayList = gameArrayList;
//        this.resultsArrayList = resultsArrayList;
//        this.processResultsArrayList = processResultsArrayList;
//
//    }
    public DataStructure(){

    }


    public void setAthleteArrayList(ObservableList<Athlete> athleteArrayList) {
        this.athleteArrayList = athleteArrayList;
    }

    public void setResultsArrayList(ObservableList<Results> resultsArrayList) {
        this.resultsArrayList = resultsArrayList;
    }

    public void setGameArrayList(ObservableList<Game> gameArrayList) {
        this.gameArrayList = gameArrayList;
    }

    public void setOfficialArrayList(ObservableList<Official> officialArrayList) {
        this.officialArrayList = officialArrayList;
    }

    public void setProcessResultsArrayList(ObservableList<ProcessResults> processResultsArrayList) {
        this.processResultsArrayList = processResultsArrayList;
    }


    public static ObservableList<Athlete> getAthleteArrayList() {
        return athleteArrayList;
    }

    public static ObservableList<Official> getOfficialArrayList(){
        return officialArrayList;
    }

    public static ObservableList<Game> getGameArrayList() {
        return gameArrayList;
    }

    public static ObservableList<Results> getResultArrayList(){
        return resultsArrayList;
    }


    public static void loadfiles() throws IOException { //method to load all saved data
        loadResultData();
        loadAthleteData();
        loadOfficialData();
        loadGame();
        System.out.println("Data loaded successfully ");
    }

    public static void savefiles() throws IOException { //method to call all save methods
        saveResultData();
        saveAthleteData();
        saveOfficialData();
        saveGame();
        System.out.println("Data saved successfully!");
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

            for (int i = 0; i < DataStructure.getOfficialArrayList().size(); i++) { //Save everything from Official arraylist
                output.write(DataStructure.getOfficialArrayList().get(i).toString());
                output.newLine();// goes to new line after each entry
            }
            output.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "I cannot create that file");
        }

    }

    public static void saveGame() throws IOException {
        try {

            FileWriter fw = new FileWriter("Games.txt");
            BufferedWriter output = new BufferedWriter(fw);

            for (int i = 0; i < DataStructure.getGameArrayList().size(); i++) { //Save everything from Official arraylist
                output.write(DataStructure.getGameArrayList().get(i).toString());
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
            int age = sc.nextInt();
            String state = sc.next();
            DataStructure.getOfficialArrayList().add(new Official(ID,name,age,state));

        }
        sc.close();
    }

    public static void loadGame() throws FileNotFoundException { //load game result data back to results arraylist
        File f = new File("Games.txt");
        Scanner sc = new Scanner(f);

        while (sc.hasNext()){ //while the file still has next line
            String ID = sc.next();
            String type = sc.next();

            DataStructure.getGameArrayList().add(new Game(ID,type));

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
            int age = (int)sc.nextInt();
            String state = sc.next();
            String ability =sc.next();
            int points = (int)sc.nextInt();

            //If data belongs to Cyclist
            if (ability.equalsIgnoreCase("Cyclist")) {
                DataStructure.getAthleteArrayList().add(new Cyclist(ID, name, age, state, ability, points));
            }
            //If data belongs to Runner
            else if (ability.equalsIgnoreCase("Runner")){
                DataStructure.getAthleteArrayList().add(new Runner(ID, name, age, state, ability, points));
            }
            //If data belongs to Swimmer
            else if (ability.equalsIgnoreCase("Swimmer")){
                DataStructure.getAthleteArrayList().add(new Swimmer(ID, name, age, state, ability, points));
            }
            //If data belongs to Super Athlete
            else {
                DataStructure.getAthleteArrayList().add(new SuperAthlete(ID, name, age, state, ability, points));
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
            System.out.println("Find files, load data from files.");
            loadfiles();
        } catch(IOException ioe) {
            System.out.println("Don't find files, load data from data Structure.");
            addAthletes();
            setOfficial();
            setGame();
        }
    }

    private static void setGame() {
        gameArrayList.add(new Game("G00",null));
    }

    public static void addAthletes(){
        athleteArrayList.add(new Cyclist("C01","Cyc01",25,"VIC","Cyclist",0));
        athleteArrayList.add(new Cyclist("C02","Cyc02",25,"VIC","Cyclist",0));
        athleteArrayList.add(new Cyclist("C03","Cyc03",25,"VIC","Cyclist",0));
        athleteArrayList.add(new Cyclist("C04","Cyc04",25,"VIC","Cyclist",0));
        athleteArrayList.add(new Cyclist("C05","Cyc05",25,"VIC","Cyclist",0));
        athleteArrayList.add(new Cyclist("C06","Cyc06",25,"VIC","Cyclist",0));
        athleteArrayList.add(new Cyclist("C07","Cyc07",25,"VIC","Cyclist",0));

        athleteArrayList.add(new Runner("R01","Run01",25,"VIC","Runner",0));
        athleteArrayList.add(new Runner("R02","Run02",35,"VIC","Runner",0));
        athleteArrayList.add(new Runner("R03","Run03",35,"VIC","Runner",0));
        athleteArrayList.add(new Runner("R04","Run04",35,"VIC","Runner",0));
        athleteArrayList.add(new Runner("R05","Run05",35,"VIC","Runner",0));
        athleteArrayList.add(new Runner("R06","Run06",35,"VIC","Runner",0));
        athleteArrayList.add(new Runner("R07","Run07",35,"VIC","Runner",0));

        athleteArrayList.add(new Swimmer("S01","Swim01",21,"VIC","Swimmer",0));
        athleteArrayList.add(new Swimmer("S02","Swim02",21,"VIC","Swimmer",0));
        athleteArrayList.add(new Swimmer("S03","Swim03",21,"VIC","Swimmer",0));
        athleteArrayList.add(new Swimmer("S04","Swim04",21,"VIC","Swimmer",0));
        athleteArrayList.add(new Swimmer("S05","Swim05",21,"VIC","Swimmer",0));
        athleteArrayList.add(new Swimmer("S06","Swim06",21,"VIC","Swimmer",0));
        athleteArrayList.add(new Swimmer("S07","Swim07",21,"VIC","Swimmer",0));

        athleteArrayList.add(new SuperAthlete("SA01","Sup01",22,"VIC","Super",0));
        athleteArrayList.add(new SuperAthlete("SA02","Sup02",22,"VIC","Super",0));
        athleteArrayList.add(new SuperAthlete("SA03","Sup03",22,"VIC","Super",0));
        athleteArrayList.add(new SuperAthlete("SA04","Sup04",22,"VIC","Super",0));
    }

    public static void setOfficial(){
        Official official1 = new Official("OF01","Official01",50,"VIC");
        Official official2 = new Official("OF02","Official02",52,"VIC");
        Official official3 = new Official("OF03","Official03",54, "VIC");
        Official official4 = new Official("OF04","Official04",58, "VIC");
        officialArrayList.add(official1);
        officialArrayList.add(official2);
        officialArrayList.add(official3);
        officialArrayList.add(official4);


    }




}
