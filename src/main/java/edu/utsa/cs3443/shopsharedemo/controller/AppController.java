//gt 10.27
package controller;

import main.java.edu.utsa.cs3443.model.GroceryList;
import main.java.edu.utsa.cs3443.model.Pantry;
import main.java.edu.utsa.cs3443.view.GroceryListScreen;
import main.java.edu.utsa.cs3443.view.PantryScreen;
import main.java.edu.utsa.cs3443.view.mainmenu.MainMenuScreen;

public class AppController { // needed a class to initialize models & views outside of main/view classes.
    private Pantry pantry; // pantry model
    private GroceryList groceryList; // list model
    private IngredientController ingredientController; // handle ingredient operations

    public AppController() {
        groceryList = new GroceryList();
        pantry = new Pantry(groceryList);
        /* initialize a grocery list, then initialize a pantry with the grocery list
            this ensures ingredients removed from the pantry are added to the grocery list
         */

        ingredientController = new IngredientController(pantry, groceryList); // initialize ingredient controller

        // initialize respective view classes
        PantryScreen.initialize(pantry);
        GroceryListScreen.initialize(groceryList, pantry);
    }

    public void startApplication() {
        //start menu
        MainMenuScreen.displayMainMenu();
    }

}

