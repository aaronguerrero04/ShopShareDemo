//gt 10.27

package main.java.edu.utsa.cs3443.shopsharedemo.model;

import main.java.edu.utsa.cs3443.shopsharedemo.model.ingredient.Ingredient;
import main.java.edu.utsa.cs3443.shopsharedemo.model.ingredient.Category;
import main.java.edu.utsa.cs3443.shopsharedemo.model.UnitOfMeasure;
import main.java.edu.utsa.cs3443.shopsharedemo.model.recipe.RecipeRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pantry {
    private List<Ingredient> ingredients;
    private GroceryList groceryList;

    public Pantry(GroceryList groceryList) {
        this.ingredients = new ArrayList<>();
        this.groceryList = groceryList;
        populateWithIngredientsFromDataset("data/daily_food_nutrition_dataset.csv"); // update with the correct path
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
        groceryList.addIngredient(ingredient);
    }

    public void populateWithIngredientsFromDataset(String filePath) { // populate pantry with ingredients from dataset.
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("Dataset file not found: " + filePath);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] splitLine = line.split(",");
                    String name = splitLine[1];
                    Category category = RecipeRepository.parseCategory(splitLine[3]);
                    UnitOfMeasure unit = UnitOfMeasure.UNIT;

                    Ingredient ingredient = new Ingredient(
                            name,                
                            0,                   
                            1.0f,                
                            unit,                
                            category,            
                            0,                   
                            0.0f,                
                            0.0f,                
                            0.0f,                
                            0.0f,                
                            0.0f,                
                            0.0f,                
                            0.0f                )
                    );
                    ingredients.add(ingredient);
                    ingredients.add(ingredient);
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading dataset file: " + filePath, e);
        }
    }

}

