//gt 10.27
package main.java.edu.utsa.cs3443.shopsharedemo.controller;

import main.java.edu.utsa.cs3443.shopsharedemo.model.GroceryList;
import main.java.edu.utsa.cs3443.shopsharedemo.model.Pantry;
import main.java.edu.utsa.cs3443.shopsharedemo.model.recipe.Recipe;
import main.java.edu.utsa.cs3443.shopsharedemo.model.recipe.RecipeRepository;
import main.java.edu.utsa.cs3443.shopsharedemo.view.GroceryListScreen;
import main.java.edu.utsa.cs3443.shopsharedemo.view.PantryScreen;
import main.java.edu.utsa.cs3443.shopsharedemo.view.mainmenu.MainMenuScreen;

import java.util.ArrayList;

public class AppController { // needed a class to initialize models & views outside of main/view classes.
    private Pantry pantry; // pantry model
    private GroceryList groceryList; // list model
    private IngredientController ingredientController; // handle ingredient operations
    private ArrayList<Recipe> recipes;
    private RecipeRepository recipeRepository;

    public AppController() {
        groceryList = new GroceryList();
        pantry = new Pantry(groceryList);
        recipeRepository = new RecipeRepository();
        recipes = new ArrayList<Recipe>(recipeRepository.loadRecipesFromFile("data/daily_food_nutrition_dataset.csv", "data/recipes.txt"));

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

