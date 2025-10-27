package main.java.edu.utsa.cs3443.shopsharedemo.model;

public class Ingredient
{
    private String name;
    private double price;
    private boolean isInGroceryList;

    public Ingredient(String name, double price, boolean isInGroceryList)
    {
        this.name = name;
        this.price = price;
        this.isInGroceryList = isInGroceryList;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public boolean isInGroceryList()
    {
        return isInGroceryList;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setInGroceryList(boolean inGroceryList)
    {
        isInGroceryList = inGroceryList;
    }
}