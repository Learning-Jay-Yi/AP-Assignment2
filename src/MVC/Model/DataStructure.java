package MVC.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class DataStructure {

    private static ObservableList<Results> resultsArrayList = FXCollections.observableArrayList();
    private static ObservableList<Athlete> athleteArrayList = FXCollections.observableArrayList();
    private static ObservableList<Official> officialArrayList = FXCollections.observableArrayList();
    private static ObservableList<Game> gameArrayList = FXCollections.observableArrayList();
    private static ObservableList<CompeteResult> competeResultArrayList = FXCollections.observableArrayList();

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

//    public void setProcessResultsArrayList(ObservableList<ProcessResults> processResultsArrayList) {
//        this.processResultsArrayList = processResultsArrayList;
//    }

    public static void setCompeteResultArrayList(ObservableList<CompeteResult> competeResultArrayList) {
        DataStructure.competeResultArrayList = competeResultArrayList;
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

    public static ObservableList<CompeteResult> getCompeteResultArrayList() {
        return competeResultArrayList;
    }



//    public static void savefiles() throws Exception { //method to call all save methods
//        saveResultData();
//        saveAthleteData();
//        saveOfficialData();
//        saveGame();
//        System.out.println("Data saved successfully!");
//    }


    /**
     * save data
     */

    public static void saveCompeteResults(ObservableList<CompeteResult> list) throws Exception{


        try {
            FileWriter fw = new FileWriter("CompeteResults.txt");
            BufferedWriter output = new BufferedWriter(fw);
            for (CompeteResult c: list){
                output.write(c.toString());
                output.newLine();
            }

            output.close();
        } catch (Exception e){
            System.out.println("I cannot create that file");
        }


    }

    public static void saveResultData(ObservableList<Results> list) throws Exception {
        try {
            FileWriter fw = new FileWriter("Results.txt");
            BufferedWriter output = new BufferedWriter(fw);

            for (Results r: list){ //save everything from Result arraylist
                output.write(r.toString());
                output.newLine();
            }
            output.close();
        } catch (Exception e) {
            System.out.println("I cannot create that file");
        }
    }

    public static void saveAthleteData(ObservableList<Athlete> list) throws Exception {
        try {
            FileWriter fw = new FileWriter("Athlete.txt"); //Creating text file
            BufferedWriter output = new BufferedWriter(fw); //Writing into file

            for (Athlete a: list){ // save everything from Athlete arraylist
                output.write(a.toStringSave());
                output.newLine();// goes to new line after each entry
            }
            output.close();
        } catch (Exception e) {
            System.out.println("I cannot create that file");
        }
    }

    public static void saveOfficialData(ObservableList<Official> list) throws Exception {
        try {

            FileWriter fw = new FileWriter("Official.txt");
            BufferedWriter output = new BufferedWriter(fw);

            for (Official o: list) { //Save everything from Official arraylist
                output.write(o.toString());
                output.newLine();// goes to new line after each entry
            }
            output.close();
        } catch (Exception e) {
            System.out.println("I cannot create that file");
        }

    }

    public static void saveGame(ObservableList<Game> list) throws Exception {
        try {
            FileWriter fw = new FileWriter("Games.txt");
            BufferedWriter output = new BufferedWriter(fw);

            for (Game g: list) { //Save everything from Official arraylist
                output.write(g.toString());
                output.newLine();// goes to new line after each entry
            }
            output.close();
        } catch (Exception e) {
            System.out.println("I cannot create that file");
        }

    }

    /**
     * load data
     */

    public static void  loadCompeteResultsData() throws Exception{
        File f = new File("CompeteResults.txt");
        Scanner sc = new Scanner(f);

        while (sc.hasNext()){
            String gameID = sc.next();
            String athleteID = sc.next();
            String athleteName = sc.next();
            String athleteType = sc.next();
            int athleteResults = sc.nextInt();

            competeResultArrayList.add(new CompeteResult(gameID,athleteID,athleteName,athleteType,athleteResults));
        }
        sc.close();
    }

    public static void loadOfficialData() throws Exception { //load game result data back to results arraylist
        File f = new File("Official.txt");
        Scanner sc = new Scanner(f);

        while (sc.hasNext()){ //while the file still has next line
            String ID = sc.next();
            String name = sc.next();
            int age = sc.nextInt();
            String state = sc.next();
            officialArrayList.add(new Official(ID,name,age,state));
        }
        sc.close();
    }

    public static void loadGame() throws Exception { //load game result data back to results arraylist
        File f = new File("Games.txt");
        Scanner sc = new Scanner(f);

        while (sc.hasNext()){ //while the file still has next line
            String ID = sc.next();
            String type = sc.next();
            gameArrayList.add(new Game(ID,type));
        }
        sc.close();
    }

    public static void loadResultData() throws Exception { //load game result data back to results arraylist
        File f = new File("Results.txt");
        Scanner sc = new Scanner(f);

        while (sc.hasNext()){ //while the file still has next line

            String gameID = sc.next();
            String gameType = sc.next();
            String officialID = sc.next();
            String firstPlace = sc.next();
            String secondPlace = sc.next();
            String thirdPlace = sc.next();


            resultsArrayList.add(new Results(gameID, gameType,  officialID, firstPlace, secondPlace, thirdPlace));

        }
        sc.close();
    }

    public static void loadAthleteData() throws Exception {

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
                athleteArrayList.add(new Cyclist(ID, name, age, state, ability, points));
            }
            //If data belongs to Runner
            else if (ability.equalsIgnoreCase("Runner")){
                athleteArrayList.add(new Runner(ID, name, age, state, ability, points));
            }
            //If data belongs to Swimmer
            else if (ability.equalsIgnoreCase("Swimmer")){
                athleteArrayList.add(new Swimmer(ID, name, age, state, ability, points));
            }
            //If data belongs to Super Athlete
            else {
                athleteArrayList.add(new SuperAthlete(ID, name, age, state, ability, points));
            }
        }
        sc.close();
    }


    /**
     * we need load data from text file
     * or add data from here
     * @return
     */

    public static void initialize() throws Exception{
        try {
            loadfiles();
        } catch(Exception e) {

            System.out.println(e);
        }
    }

    private static void loadfiles() throws Exception { //method to load all saved data
        try{
            System.out.println("Finding files");
            loadResultData();
            loadAthleteData();
            loadOfficialData();
            loadGame();
            loadCompeteResultsData();
            System.out.println("Data loaded successfully ");
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Don't find files, load data from data Structure.");
            addAthletes();
            setOfficial();
            setGame();
        }
    }

    private static void setGame() {
        gameArrayList.add(new Game("G00",null));
    }

    private static void addAthletes(){
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

    private static void setOfficial(){
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
