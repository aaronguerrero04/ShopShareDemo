package main.java.edu.utsa.cs3443.shopsharedemo;

import main.java.edu.utsa.cs3443.shopsharedemo.model.ingredient.Ingredient;
import main.java.edu.utsa.cs3443.shopsharedemo.model.recipe.Recipe;
import main.java.edu.utsa.cs3443.shopsharedemo.model.recipe.RecipeRepository;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        //JUST TESTING TO SEE IF I GOT ALL RECIPES + INGREDIENTS
        RecipeRepository recipeRepository = new RecipeRepository();
        List<Recipe> recipeList = recipeRepository.loadRecipesFromFile("data/ingredients.csv", "data/recipes");

        for(Recipe r : recipeList)
        {
            System.out.println("NAME:");
            System.out.println(r.getName());

            System.out.println("INGREDIENTS:");
            for(Ingredient i : r.getIngredients())
            {
                System.out.println(i.getName());
            }
            System.out.println();
        }
    }
}