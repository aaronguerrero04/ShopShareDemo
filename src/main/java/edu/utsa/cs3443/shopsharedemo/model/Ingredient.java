package main.java.edu.utsa.cs3443.shopsharedemo.model;

public class Ingredient
{
    private String name;
    private String id;
    private String weight;
    private boolean isInGroceryList;
    private boolean isInPantry;

    public Ingredient(String name, String id, String weight, boolean isInGroceryList, boolean isInPantry)
    {
        this.name = name;
        this.id = id;
        this.weight = weight;
        this.isInGroceryList = isInGroceryList;
        this.isInPantry = isInPantry;
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public String getWeight()
    {
        return weight;
    }

    public boolean isInGroceryList()
    {
        return isInGroceryList;
    }

    public boolean isInPantry()
    {
        return isInPantry;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    public void setInGroceryList(boolean inGroceryList)
    {
        isInGroceryList = inGroceryList;
    }

    public void setInPantry(boolean inPantry)
    {
        isInPantry = inPantry;
    }
}