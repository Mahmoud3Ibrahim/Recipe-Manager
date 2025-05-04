package assn3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

/**This is part of Assignment 02 named: Recipe Manager.
* Course: CST8284 - Lab 321
* Professor : Dr.Leanne Seaward
* @author - Mahmoud Ibrahim #ID: 041163059
* @version 1.0.0
* @since java 21.0.4
* @see RecipeManager
* @see Recipe
 * This class is include the main method, and other methods that the program will use.
 */
public class Assignment3 {
	/**
	 * this is the main method to execute the program.
	 * @param args empty string array not used.
	 */
    public static void main(String[] args) {
    	/**
    	 *  object from class RecipeManager.
    	 */
        RecipeManager item = new RecipeManager();

        /**
         * calling method readRicepiet from RecipeManager
         * implementing it into a new array
         */
        ArrayList<Recipe> items = item.readRicepiet();

        /**
         * calling the method mainmainMenu to print the menu where we start.
         */
        mainMenu();

        Scanner input = new Scanner(System.in);

			int choice;

	        while (true) {
	            choice = readInt(input);
	            if (choice == -1) continue;

	            switch (choice) {
	                case 1:
	                    printMenu(items);
	                    int nextChoice = readInt(input);
	                    if (nextChoice == 0) {

	                    	mainMenu();

	                    } else if (nextChoice == 4) {
	                        System.out.println("Thanks for using Mahmoud Program");
	                        System.exit(0);
	                    } else {
	                        System.out.println("invalid entry,");
	                        System.out.println("Press 4 to exit, or 0 to return to the main menu.");
	                    }
	                    break;
	                case 2:
	                    System.out.println("Lets Bake !!\n" + "enter the recipe number\n");
	                    int recipeNumber = readInt(input);
	                    if (recipeNumber == -1) break;
	                    orderBread(items, recipeNumber, 0);
	                    break;
	                case 3:
	                    makeShoppingList(items);
	                    System.out.println("let's do it again:\n");
	                    mainMenu();
	                    break;
	                case 4:
	                    System.out.println("Thanks for using Mahmoud Program");
	                    System.exit(0);
	                    break;
	                case 0:
	                    mainMenu();
	                    break;

	                default:
	                    System.out.println("Invalid input. Please choose a valid option.\r\n"
	                    		+ "");
	            }
	        }
	    }


    /**
     * this method to test the user input, if it valid or no.
     * @param input scanner object.
     * @return the input in case of try, and -1 in case of failed.
     */

    public static int readInt(Scanner input) {
        try {
            return input.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please choose a valid option.");
            input.nextLine();
            return -1;
        }
    }

    /**
     * this is a method for just printing the main menu
     * i didn't involve this at the main method because i will
     * use it in some other options.
     */

   public static void mainMenu() {
        System.out.println("Welcome to (\"Mahmoud Ibrahim\") recipe manager.\n" +
                "-------------------------\n" +
                "Please select one of the following options:\n" +
                "-------------------------\n" +
                "1. Show available recipes.\n" +
                "2. Create Shopping List.\n" +
                "3. Print Shopping List.\n" +
                "4. Quit Program.\n" +
                "0. to reprint this menu.\n" +
                "-------------------------\n" +
                "Please enter your choice:   ");
    }


/**
 * This method to print all the available recipes that
 * are in the recipe list in the text file.
 * @param recipes it is array list of type Recipe which using
 */
    public static void printMenu(ArrayList<Recipe> recipes) {
    	System.out.println(
        		"the available recipes is: \n" +
        		"-------------------------" );
    	for (int i = 0; i < recipes.size(); i++) {
            Recipe recipe = recipes.get(i);
            System.out.println( (i + 1) + ". " + recipe.getRecipeName());
        }
    	System.out.println("------------------");
    	System.out.println("Press (0) to go back to Main menu Or (4) if you done!!");
    }

    /**
     * this is the method to receive the orders from the user.
     * @param recipe ArrayList from type Recipe
     * @param index the index of each recipe
     * @param quantity the quantity that the user will enter.
     */

    public static void orderBread(ArrayList<Recipe> recipe, int index, int quantity) {

    	Scanner input = new Scanner(System.in);

        try {
            if (index <= 0 || index > recipe.size()) {
                System.out.println("!Invalid bread number. Please try again.");
                return;
            }

            Recipe selectedRecipe = recipe.get(index - 1);
            System.out.println("You selected: " + selectedRecipe.getRecipeName());

            System.out.print("How much of " + selectedRecipe.getRecipeName() + " do you want? ");
            quantity = input.nextInt();

            int newOrderCount = selectedRecipe.getOrderCount() + quantity;
            if (newOrderCount < 0) {
                System.out.println("order will be negative, this is wrong");
                return;
            }

            selectedRecipe.setOrderCount(newOrderCount);
            System.out.println("You ordered " + quantity + " of " + selectedRecipe.getRecipeName() +
                    ". Total ordered: " + selectedRecipe.getOrderCount());

            while (true) {
                System.out.println("what's next:\n(2) more recepies (3) print shopping list \n(4) quit (0) go back to main menu");
                int next = input.nextInt();

                if (next == 2) {
                    System.out.print("Enter the recipe number: ");
                    int anotherIndex = input.nextInt();
                    orderBread(recipe, anotherIndex, 0);  // Recursive call to re-order
                    return;
                } else if (next == 3) {
                    makeShoppingList(recipe);
                    return;
                } else if (next == 4) {
                    System.out.println("Thanks for using Mahmoud Program");
                    System.exit(0);
                } else if (next == 0) {
                    Assignment3.mainMenu();
                    return;
                } else {
                    System.out.println("Invalid input. Please choose a valid option.");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please choose a valid option.");
            input.nextLine();
        }
    }

    /**
     * this method is to retrieve the summary of the user choices and
     * convert it into ingredients.
     * @param recipes this is the ArrayList, that holding the recipes.
     */

    public static void makeShoppingList(ArrayList<Recipe> recipes) {
        HashMap<String, Double> shoppingList = new HashMap<>();
        StringBuilder summary = new StringBuilder();

        for (Recipe order : recipes) {
            if (order.getOrderCount() > 0) {
                summary.append(order.getOrderCount()).append(" ").append(order.getRecipeName()).append(", ");
                for (Map.Entry<String, Double> entry : order.getIngredients().entrySet()) {
                    String key = entry.getKey();
                    double value = entry.getValue() * order.getOrderCount();
                    shoppingList.put(key, shoppingList.getOrDefault(key, 0.0) + value);
                }
            }
        }

        if (summary.length() > 0) {
            summary.setLength(summary.length() - 2);
            System.out.println("You chose to bake: " + summary);
            System.out.println("\nSo you need:");
        }

        for (Map.Entry<String, Double> item : shoppingList.entrySet()) {
        	if (item.getValue() > 0 && item.getKey().contains("eggs")) {
        		System.out.println(item.getKey() + " : " + item.getValue() + " eggs");
        	}
            if (item.getValue() > 0 && ! item.getKey().contains("eggs")) {
                System.out.println(item.getKey() + " : " + item.getValue() + " gm");
            }
        }
        saveShoppingList("You chose to buy: " + summary + "\n\nSo you need:", shoppingList);
    }
/**
 * this method to save the shopping list at text file called shoppinglist.txt
 * @param summary is a string that print all the user choices.
 * @param shoppingList is a hash map that has the (K: ingredient , V: the amount).
 */

    public static void saveShoppingList(String summary, HashMap<String, Double> shoppingList) {
        Scanner input = new Scanner(System.in);
        System.out.print("Do you want to save this list to a file? (Y/n): ");
        String answer = input.nextLine();

        while (true) {
            if (answer.equalsIgnoreCase("y")) {
                try (PrintWriter writer = new PrintWriter("./shoppinglist.txt")){
                    writer.println(summary);

                    for (Map.Entry<String, Double> item : shoppingList.entrySet()) {
                        if (item.getValue() > 0 && ! item.getKey().trim().equalsIgnoreCase("eggs") ){
                            writer.println(item.getKey() + " : " + item.getValue() + "gm");
                            writer.println();
                        }
                        if (item.getValue() > 0 &&  item.getKey().trim().equalsIgnoreCase("eggs")) {
                            writer.println(item.getKey() + " : " + item.getValue() + " eggs");
                            writer.println();
                        }
                    }

                    writer.close();
                    System.out.println("Shopping list saved to shoppinglist.txt");
                    System.out.println("Please press (0) to go back to the main menu");
                } catch (IOException e) {
                    System.out.println("Error saving file.");
                }
                break;

            } else if (answer.equalsIgnoreCase("n")) {
                System.out.println("Okay, shopping list was not saved.");
                System.out.println("Press (0) to go back to main menu");
                break;

            } else {
                System.out.println("Invalid entry, try again.");
                answer = input.nextLine();
            }
        }
    }

}

