//gt 10.27

package controller;

import main.java.edu.utsa.cs3443.model.GroceryList;
import main.java.edu.utsa.cs3443.model.ingredient.Ingredient;
import main.java.edu.utsa.cs3443.model.Pantry;

import java.util.List;

public class IngredientController { // handles ingredient operations between pantry and the grocery list
    private Pantry pantry;
    private GroceryList groceryList;

    public IngredientController(Pantry pantry, GroceryList groceryList) {
        this.pantry = pantry;
        this.groceryList = groceryList;
    }

    public void addIngredientToPantry(Ingredient ingredient) { // self-explanatory
        pantry.addIngredient(ingredient);
    }

    public void removeIngredientFromPantry(Ingredient ingredient) { // self-explanatory
        pantry.removeIngredient(ingredient);
    }

    public void moveIngredientToPantry(Ingredient ingredient) { // self-explanatory
        groceryList.removeIngredient(ingredient);
        pantry.addIngredient(ingredient);
    }

    public List<Ingredient> getPantryIngredients() { // self-explanatory
        return pantry.getIngredients();
    }

    public List<Ingredient> getGroceryListIngredients() { // self-explanatory
        return groceryList.getIngredients();
    }

}

