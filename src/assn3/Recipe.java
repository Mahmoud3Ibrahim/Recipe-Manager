package assn3;
import java.util.HashMap;

/**This is part of Assignment 02 named: Recipe Manager.
* Course: CST8284 - Lab 321
* Professor : Dr.Leanne Seaward
* @author - Mahmoud Ibrahim #ID: 041163059
* @version 1.0.0
* @since java 21.0.4
* @see RecipeManager
* @see Assignment3
 * This class is to prepare the program with the basics component.
 * Each recipe contains a name as a String, and a HashMap of ingredients with their quantities.
 */
public class Recipe {

	/**
	 * Variable for taking orders from user.
	 */
	private int orderCount = 0; 
	/**
	 * Variable will read the recipe name from the file.
	 */
	private String recipeName;  //the name of the recipe.
	/**
	 * hashMap will receive ( the ingredients , the amount)
	 */
	private HashMap< String, Double> ingredients; 


	/**
	 * first constructor of the class, this constructer will be called
	 * in case we will build an object depend on then name.
	 * @param recipeName
	 */
	public Recipe(String recipeName ) {
		this.recipeName = recipeName;
		this.ingredients = new HashMap<>();
	}
	//overloading constructor in case of need.

	/**
	 * this two parameter constructor with two arguments
	 * @param recipeName string read from the text file.
	 * @param ingredients Hash map where k: ingredient name, and V: the amount.
	 */

	public Recipe(String recipeName , HashMap<String, Double> ingredients ) {
		this.recipeName = recipeName;
		this.ingredients = ingredients;
	}

	//setter and getter for the class.


	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public HashMap<String, Double> getIngredients() {
		return ingredients;
	}

	public void setIngredients(HashMap<String, Double> ingredients) {
		this.ingredients = ingredients;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}



}
