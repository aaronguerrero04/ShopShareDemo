package main.java.edu.utsa.cs3443.shopsharedemo.view.mainmenu;

public enum MainMenuOption
{
    groceryList(1),
    planner(2),
    recipes(3),
    pantry(4),
    exit(5);

    private final int value;

    MainMenuOption(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}