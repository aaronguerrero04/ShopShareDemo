package main.java.edu.utsa.cs3443.shopsharedemo.model.recipe;

import main.java.edu.utsa.cs3443.shopsharedemo.model.Ingredient;

import java.util.List;

public class Recipe
{
    private List<Ingredient> ingredients;
    private String name;
    private String id;
    private boolean isSaved;
    private boolean isCustom;

    public Recipe(List<Ingredient> ingredients, String name, String id, boolean isSaved, boolean isCustom)
    {
        this.ingredients = ingredients;
        this.name = name;
        this.id = id;
        this.isSaved = isSaved;
        this.isCustom = isCustom;
    }

    public List<Ingredient> getIngredients()
    {
        return ingredients;
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public boolean isSaved()
    {
        return isSaved;
    }

    public boolean isCustom()
    {
        return isCustom;
    }
}