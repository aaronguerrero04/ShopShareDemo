package main.java.edu.utsa.cs3443.shopsharedemo.model.ingredient;

import main.java.edu.utsa.cs3443.shopsharedemo.model.UnitOfMeasure;

public class Ingredient
{
    private String name;
    private int id;
    private final float servingSize;
    private final UnitOfMeasure unitOfMeasure;
    private final Category category;
    private final int calories;
    private final float protien;
    private final float carbohydrates;
    private final float fiber;
    private final float fat;
    private final float sugar;
    private final float sodium;
    private final float cholesterol;
    private final MealType mealType;

    public Ingredient(String name, int id, float amount, UnitOfMeasure unitOfMeasure, Category category, int calories, float protien, float carbohydrates, float fiber, float fat, float sugar, float sodium, float cholesterol, MealType mealType)
    {
        this.name = name;
        this.id = id;
        this.servingSize = amount;
        this.unitOfMeasure = unitOfMeasure;
        this.category = category;
        this.calories = calories;
        this.protien = protien;
        this.carbohydrates = carbohydrates;
        this.fiber = fiber;
        this.fat = fat;
        this.sugar = sugar;
        this.sodium = sodium;
        this.cholesterol = cholesterol;
        this.mealType = mealType;
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public float getWeight()
    {
        return servingSize;
    }

    public UnitOfMeasure getUnitOfMeasure() {return unitOfMeasure;}

    public void setName(String name)
    {
        this.name = name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getCalories() {
        return calories;
    }

    public float getProtien() {
        return protien;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public float getFiber() {
        return fiber;
    }

    public float getFat() {
        return fat;
    }

    public float getSugar() {
        return sugar;
    }

    public float getCholesterol() {
        return cholesterol;
    }

    public float getSodium() {
        return sodium;
    }

    public MealType getMealType() {
        return mealType;
    }

    public Category getCategory() {
        return category;
    }
}