package main.java.edu.utsa.cs3443.shopsharedemo;

import main.java.edu.utsa.cs3443.shopsharedemo.model.ingredient.Ingredient;
import main.java.edu.utsa.cs3443.shopsharedemo.model.recipe.Recipe;
import main.java.edu.utsa.cs3443.shopsharedemo.model.recipe.RecipeRepository;
import main.java.edu.utsa.cs3443.shopsharedemo.view.mainmenu.MainMenuScreen;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        //JUST TESTING TO SEE IF I GOT ALL RECIPES + INGREDIENTS
        RecipeRepository recipeRepository = new RecipeRepository();
        List<Recipe> recipeList = recipeRepository.loadRecipesFromFile("data/daily_food_nutrition_dataset.csv", "data/recipes.txt");

        MainMenuScreen.displayMainMenu();
    }
}

/* public static void main(String[] args) {
        // create and start application through the AppController
        AppController appController = new AppController();
        appController.startApplication();
    }
*/
