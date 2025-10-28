package main.java.edu.utsa.cs3443.shopsharedemo.model.planner;

import main.java.edu.utsa.cs3443.shopsharedemo.model.recipe.Recipe;

public class PlannerDay {
    private Date date;
    private Recipe breakfast;
    private Recipe lunch;
    private Recipe dinner;

    public PlannerDay(Date date, Recipe breakfast, Recipe lunch, Recipe dinner){
        this.date = date;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public String toString(){
        return date.toString() + ":\t\nBreakfast:\t"+breakfast+"\t\nLunch:\t"+lunch+"\t\nDinnner:\t"+dinner;
    }
}
