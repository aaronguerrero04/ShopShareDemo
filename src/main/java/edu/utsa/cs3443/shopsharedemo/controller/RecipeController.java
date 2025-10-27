package main.java.edu.utsa.cs3443.shopsharedemo.controller;

import main.java.edu.utsa.cs3443.shopsharedemo.model.recipe.RecipeService;

public class RecipeController
{
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService)
    {
        this.recipeService = recipeService;
    }
}