package MVC.Model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Athlete
{
    private String id;
    private String name;
    private int age;
    private String type;
    private int score;

    private BooleanProperty checked;

//    private ObservableList<Athlete> athleteObservableList = FXCollections.observableList();

    public Athlete(String id, String name, int age, String type, int score)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;
        this.score = score;

        checked = new SimpleBooleanProperty(false);
    }




    public String getName() { return name; }
    public String getID() { return id; }
    public String getType() { return type;}
    public int getAge() { return age;}
    public int getScore() {return score;}
    public boolean isChecked() { return checked.get(); }

    public StringProperty nameProperty() { return new SimpleStringProperty(name); }
    public StringProperty idProperty() { return new SimpleStringProperty(id); }
    public StringProperty typeProperty() { return new SimpleStringProperty(type); }
    public IntegerProperty scoreProperty() { return new SimpleIntegerProperty(score); }
    public IntegerProperty ageProperty() { return new SimpleIntegerProperty(age);}
    public BooleanProperty checkProperty() { return checked; }
}
