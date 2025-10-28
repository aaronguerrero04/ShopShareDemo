//gt 10.27
package main.java.edu.utsa.cs3443.shopsharedemo.view;

import main.java.edu.utsa.cs3443.shopsharedemo.model.Pantry;
import main.java.edu.utsa.cs3443.shopsharedemo.model.ingredient.Ingredient;
import main.java.edu.utsa.cs3443.shopsharedemo.view.mainmenu.MainMenuScreen;

import java.util.Scanner;

public class PantryScreen {
    private static Pantry pantry;

    public static void initialize(Pantry pantryInstance) { // initialize pantry instance
        pantry = pantryInstance;
    }

    public static void displayPantry() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Pantry Screen:");
            int index = 1;

            for (Ingredient ingredient : pantry.getIngredients()) {
                System.out.printf("%2d. %-10s  ", index, ingredient.getName());
                if (index % 4 == 0) System.out.println();
                index++;
            }

            System.out.println("\nEnter the number next to the ingredient to remove it, or type 'menu' to return:");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("menu")) { // option to return to main menu
                MainMenuScreen.displayMainMenu();
                return;
            }

            try {                                            // remove ingredient from pantry and add to grocery list
                int choice = Integer.parseInt(input);
                if (choice > 0 && choice <= pantry.getIngredients().size()) {
                    Ingredient selectedIngredient = pantry.getIngredients().get(choice - 1);
                    pantry.removeIngredient(selectedIngredient);
                    System.out.println(selectedIngredient.getName() + " has been removed from the pantry.");
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
