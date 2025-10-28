//gt 10.27

package main.java.edu.utsa.cs3443.shopsharedemo.view;

import main.java.edu.utsa.cs3443.shopsharedemo.model.GroceryList;
import main.java.edu.utsa.cs3443.shopsharedemo.model.ingredient.Ingredient;
import main.java.edu.utsa.cs3443.shopsharedemo.model.Pantry;
import main.java.edu.utsa.cs3443.shopsharedemo.view.mainmenu.MainMenuScreen;

import java.util.Scanner;

public class GroceryListScreen {
    private static GroceryList groceryList;
    private static Pantry pantry;

    public static void initialize(GroceryList groceryListInstance, Pantry pantryInstance) { // initialize above static variables with instances from AppController
        groceryList = groceryListInstance;
        pantry = pantryInstance;
    }

    public static void displayGroceryList() {
        if (groceryList == null || pantry == null) {
            throw new IllegalStateException("GroceryListScreen is not initialized. Call initialize() first.");
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Grocery List Screen:");
            int index = 1;

            for (int i = 0; i < groceryList.getIngredients().size(); i++) { // output ingredients in grocery list, 4 x 6
                Ingredient ingredient = groceryList.getIngredients().get(i);
                System.out.printf("%2d. %-10s  ", index, ingredient.getName());
                if (index % 4 == 0) System.out.println();
                index++;
            }

            System.out.println("\nEnter the number next to the ingredient to move it to the pantry, or type 'menu' to return:");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("menu")) { // option to return to main menu
                MainMenuScreen.displayMainMenu();
                return;
            }

            try {                                           // remove ingredient from grocery list and add to pantry
                int choice = Integer.parseInt(input);
                if (choice > 0 && choice <= groceryList.getIngredients().size()) {
                    Ingredient selectedIngredient = groceryList.getIngredients().get(choice - 1);
                    groceryList.moveToPantry(pantry, selectedIngredient);
                    System.out.println(selectedIngredient.getName() + " has been moved to the pantry.");
                }
                else {
                    System.out.println("Invalid choice. Try again.");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
