
package assn3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**This is part of Assignment 02 named: Recipe Manager.
* Course: CST8284 - Lab 321
* Professor : Dr.Leanne Seaward
* @author - Mahmoud Ibrahim #ID: 041163059
* @version 1.0.0
* @since java 21.0.4
* @see Recipe
* @see Assignment3
 * This class is to read recipes from a text file
 * and converting it into a list of Recipes objects.
 * Each recipe contains a name and a set of ingredients with their quantities.
 */
public class RecipeManager {

	/**
	 * this is the method responsible for reading the file (Line by Line).
	 * converting the Lines into ArrayList of type Recipe, which accept
	 * (name, HashMap (Key: ingredient , V: amount ))
	 * @return recipes ArrayList
	 */
	public ArrayList<Recipe> readRicepiet() {
	    ArrayList<Recipe> recipes = new ArrayList<>();
	    Recipe currentRecipet = null; // will receive the HashMap keys and values.

	    try {
	        File myObj = new File("./recipelist.txt");
	        Scanner myReader = new Scanner(myObj);

	        while (myReader.hasNextLine()) {
	            String data = myReader.nextLine().trim();

	            if (data.isEmpty()) continue;

	            if (data.startsWith("Recipe")) {
	                String name = data.substring("Recipe".length()).trim();
	                currentRecipet = new Recipe(name);
	                recipes.add(currentRecipet);
	            } else {
	                String[] parts = data.split(" ");
	                String key = parts[0];
	                double value = Double.parseDouble(parts[1]);
	                if (currentRecipet != null) {
	                    currentRecipet.getIngredients().put(key, value);
	                }
	            }
	        }

	        myReader.close();

	    } catch (FileNotFoundException e) {
	        System.out.println("didn't find the recipe list file");
	    }

	    return recipes;
	}
}


