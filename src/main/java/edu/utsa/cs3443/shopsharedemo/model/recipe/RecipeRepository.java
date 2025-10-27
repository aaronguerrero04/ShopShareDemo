package main.java.edu.utsa.cs3443.shopsharedemo.model.recipe;

import main.java.edu.utsa.cs3443.shopsharedemo.model.Ingredient;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecipeRepository
{
    private List<Ingredient> ingredients;

    public List<Recipe> loadRecipesFromFile(String ingredientsFile, String recipesFile)
    {
        try {
            ingredients = loadIngredientsFromFile(ingredientsFile);
            List<Recipe> recipes = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(recipesFile));
            String line;
            List<Ingredient> recipeIngredients = new ArrayList<>();

            String name = "";
            String id = "";
            boolean isSaved = false;
            boolean isCustom = false;

            while((line = reader.readLine()) != null)
            {
                String[] splitLine = line.split(": ");

                if(line.startsWith("NAME:"))
                {
                    name = splitLine[1];
                }

                if(line.startsWith("ID:"))
                {
                    id = splitLine[1];
                }

                if(line.startsWith("SAVED:"))
                {
                    isSaved = Boolean.parseBoolean(splitLine[1]);
                }

                if(line.startsWith("CUSTOM:"))
                {
                    isCustom = Boolean.parseBoolean(splitLine[1]);
                }

                if(line.startsWith("INGREDIENT:"))
                {
                    String ingredientID = splitLine[1];

                    for(Ingredient ingredient : ingredients)
                    {
                        if(ingredient.getId().equals(ingredientID))
                        {
                            recipeIngredients.add(ingredient);
                            break;
                        }
                    }
                }

                if(line.equals("done"))
                {
                    Recipe recipe = new Recipe(new ArrayList<>(recipeIngredients), name, id, isSaved, isCustom);
                    recipes.add(recipe);
                    recipeIngredients.clear();
                }
            }

            reader.close();

            return recipes;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ingredient> loadIngredientsFromFile(String file)
    {
        try {
            List<Ingredient> ingredients = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while((line = reader.readLine()) != null)
            {
                String[] splitLine = line.split(",");
                String name = splitLine[0];
                String id = splitLine[1];
                String weight = splitLine[2];
                boolean isInGroceryList = Boolean.parseBoolean(splitLine[3]);
                boolean isInPantry = Boolean.parseBoolean(splitLine[4]);

                Ingredient ingredient = new Ingredient(name, id, weight, isInGroceryList, isInPantry);
                ingredients.add(ingredient);
            }

            reader.close();

            return ingredients;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}