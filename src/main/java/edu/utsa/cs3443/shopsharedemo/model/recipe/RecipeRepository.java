package main.java.edu.utsa.cs3443.shopsharedemo.model.recipe;

import main.java.edu.utsa.cs3443.shopsharedemo.model.UnitOfMeasure;
import main.java.edu.utsa.cs3443.shopsharedemo.model.ingredient.Category;
import main.java.edu.utsa.cs3443.shopsharedemo.model.ingredient.Ingredient;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecipeRepository
{
    private List<Ingredient> ingredients;

    public static Category parseCategory(String category){
        return switch (category) {
            case "MEAT" -> Category.MEAT;
            case "GRAINS" -> Category.GRAINS;
            case "FRUIT" -> Category.FRUIT;
            case "VEGETABLE" -> Category.VEGETABLE;
            case "BEVERAGES" -> Category.BEVERAGES;
            case "SNACKS" -> Category.SNACKS;
            case "DAIRY" -> Category.DAIRY;
            default -> null;
        };
    }

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
                    int ingredientID = Integer.parseInt(splitLine[1]);

                    for(Ingredient ingredient : ingredients)
                    {
                        if(ingredient.getId() == ingredientID)
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
                try {
                    String[] splitLine = line.split(",");
                    int id = Integer.parseInt(splitLine[0]);
                    String name = splitLine[1];
                    float servingSize = Float.parseFloat(splitLine[2]);
                    Category category = parseCategory(splitLine[3]);
                    int calories = Integer.parseInt(splitLine[4]);
                    float protein = Float.parseFloat(splitLine[5]);
                    float carbohydrates = Float.parseFloat(splitLine[6]);
                    float fats = Float.parseFloat(splitLine[7]);
                    float fiber = Float.parseFloat(splitLine[8]);
                    float suger = Float.parseFloat(splitLine[9]);
                    float sodium = Float.parseFloat(splitLine[10]);
                    float cholestoral = Float.parseFloat(splitLine[11]);

                    Ingredient ingredient = new Ingredient(name, id, servingSize, UnitOfMeasure.UNIT, category, calories, protein, carbohydrates, fiber, fats, suger, sodium, cholestoral);
                    ingredients.add(ingredient);
                } catch (NumberFormatException e) {
                    continue;
                }
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