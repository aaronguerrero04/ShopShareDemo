package main.java.edu.utsa.cs3443.shopsharedemo.model.planner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Planner {
    ArrayList<PlannerDay> plannerDays;

    public void loadPlannerFromFile(String filePath){
        try {
            File plannerFile = new File(filePath);
            Scanner plannerReader = new Scanner(plannerFile);

            while (plannerReader.hasNextLine()){
                String date = plannerReader.nextLine();
                String breakfastCode = plannerReader.nextLine();
                String lunchCode = plannerReader.nextLine();
                String dinnerCode = plannerReader.nextLine();



                String[] splitDate = date.split("/");
                short month = Short.parseShort(splitDate[0]);
                short day = Short.parseShort(splitDate[1]);
                int year = Integer.parseInt(splitDate[2]);

                PlannerDay pd = new PlannerDay(new Date(month, day, year), );
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public Planner(){
        plannerDays = new ArrayList<PlannerDay>();
        loadPlannerFromFile("data/saved_planner.txt");
    }
}
