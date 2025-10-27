package main.java.edu.utsa.cs3443.shopsharedemo.model.ingredient;

import main.java.edu.utsa.cs3443.shopsharedemo.model.UnitOfMeasure;

public class Ingredient
{
    private String name;
    private String id;
    private float amount;
    private final UnitOfMeasure unitOfMeasure;


    public Ingredient(String name, String id, float amount, UnitOfMeasure unitOfMeasure)
    {
        this.name = name;
        this.id = id;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
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
        return amount;
    }

    public UnitOfMeasure getUnitOfMeasure() {return unitOfMeasure;}

    public void setName(String name)
    {
        this.name = name;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setAmount(float amount) { this.amount = amount; }
}