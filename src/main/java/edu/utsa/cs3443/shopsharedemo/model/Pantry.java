//gt 10.27

package model;

import main.java.edu.utsa.cs3443.model.ingredient.Ingredient;
import main.java.edu.utsa.cs3443.model.ingredient.Category;
import main.java.edu.utsa.cs3443.model.UnitOfMeasure;
import main.java.edu.utsa.cs3443.model.recipe.RecipeRepository;

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
                            name,                // String name
                            0,                   // int id (default value)
                            1.0f,                // float servingSize (default value)
                            unit,                // UnitOfMeasure unitOfMeasure
                            category,            // Category category
                            0,                   // int calories (default value)
                            0.0f,                // float protein (default value)
                            0.0f,                // float carbohydrates (default value)
                            0.0f,                // float fiber (default value)
                            0.0f,                // float fat (default value)
                            0.0f,                // float sugar (default value)
                            0.0f,                // float sodium (default value)
                            0.0f,                // float cholesterol (default value)
                            null                 // MealType mealType (default value)
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

