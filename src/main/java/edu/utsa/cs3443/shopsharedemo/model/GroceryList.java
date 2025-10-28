package model;

import main.java.edu.utsa.cs3443.model.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class GroceryList {
    private List<Ingredient> ingredients; // stores ingredients

    public GroceryList() {
        this.ingredients = new ArrayList<>(); // initialize ingredients list
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void moveToPantry(Pantry pantry, Ingredient ingredient) {
        if (ingredients.contains(ingredient)) {
            ingredients.remove(ingredient);
            pantry.addIngredient(ingredient);
        }
    }

}

