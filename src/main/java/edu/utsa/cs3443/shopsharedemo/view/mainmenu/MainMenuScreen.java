package main.java.edu.utsa.cs3443.shopsharedemo.view.mainmenu;

import main.java.edu.utsa.cs3443.shopsharedemo.view.GroceryListScreen;
import main.java.edu.utsa.cs3443.shopsharedemo.view.PantryScreen;
import main.java.edu.utsa.cs3443.shopsharedemo.view.PlannerScreen;
import main.java.edu.utsa.cs3443.shopsharedemo.view.RecipesScreen;

import java.util.Scanner;

public class MainMenuScreen
{
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu()
    {
        System.out.println("============================================");
        System.out.println("|\t\t\t\t Main Menu \t\t\t\t   |");
        System.out.println("============================================");
        System.out.println("\t[1] Grocery List");
        System.out.println("\t[2] Planner");
        System.out.println("\t[3] Recipes");
        System.out.println("\t[4] Pantry");
        System.out.println("\t[5] Exit");
        System.out.println("============================================");

        //prompt
        MainMenuOption mainMenuOption = promptForMainMenuOption();
        executeMainMenuOption(mainMenuOption);
    }

    // perform main menu option
    public static void executeMainMenuOption(MainMenuOption mainMenuOption)
    {
        switch (mainMenuOption)
        {
            case groceryList:
                GroceryListScreen.displayGroceryList();
                break;
            case planner:
                PlannerScreen.displayPlanner();
                break;
            case recipes:
                RecipesScreen.displayRecipes();
                break;
            case pantry:
                PantryScreen.displayPantry();
                break;
            case exit:
                System.out.println("Exit");
                break;
        }
    }

    public static MainMenuOption promptForMainMenuOption()
    {
        int mainMenuSelection;

        System.out.print("Enter the Main Menu options (1-5): ");
        mainMenuSelection = scanner.nextInt();

        for(MainMenuOption mainMenuOption : MainMenuOption.values())
        {
            if(mainMenuOption.getValue() == mainMenuSelection)
            {
                return mainMenuOption;
            }
        }

        return MainMenuOption.exit;
    }
}