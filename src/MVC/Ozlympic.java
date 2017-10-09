package MVC;

import MVC.Model.Athlete;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Ozlympic extends Application {
    /**
     *  initialize table view
     */


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ozlympic Game");

        try
        {
            Parent root = (Pane) FXMLLoader.load(getClass().getResource("View/View.fxml"));
            Scene athletesScene = new Scene(root);
            primaryStage.setScene(athletesScene);
        }
        catch (Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }

        primaryStage.show();
    }




}
