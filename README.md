# Recipe Manager – Java Project

This is a modular Java application that manages cooking recipes. Users can load recipes from a file, view them, select multiple recipes, and generate a combined shopping list. The project demonstrates object-oriented programming (OOP), use of collections, and file I/O in Java.

## 📦 Features

- Load recipes from a text file
- Each recipe includes a name and ingredients (`HashMap<String, Integer>`)
- View and display recipe details
- Select multiple recipes and generate a combined shopping list
- Save the shopping list to an output file

## 🧱 Class Structure

- `Recipe`  
  - Represents a single recipe with a name and a list of ingredients  
  - Uses `HashMap<String, Integer>` to store ingredient names and quantities  
  - Methods include: `addIngredient()`, `getIngredients()`, `toString()`

- `RecipeManager`  
  - Manages a list of `Recipe` objects  
  - Loads recipes from file  
  - Allows selecting recipes  
  - Generates a combined shopping list from selected recipes

- `Assignment3`  
  - Main class with the `main()` method  
  - Provides interaction with the user via console  
  - Reads recipes from input file and writes the shopping list to output

## 📂 File I/O

- **Input file format** (e.g. `recipes.txt`):
  ```
  Recipe: Spaghetti
  TomatoSauce:2
  Pasta:1
  Cheese:1

  Recipe: Salad
  Lettuce:1
  Tomato:2
  Cucumber:1
  ```

- **Output file** (`shopping_list.txt`) example:
  ```
  Cheese: 1
  Cucumber: 1
  Lettuce: 1
  Pasta: 1
  Tomato: 2
  TomatoSauce: 2
  ```

## ▶️ How to Run

1. Compile all Java files:
   ```
   javac Recipe.java RecipeManager.java Assignment3.java
   ```

2. Run the application:
   ```
   java Assignment3
   ```

3. Make sure `recipes.txt` is in the project root directory.

## 🧠 Skills Demonstrated

- Object-Oriented Programming (encapsulation, modularity)
- Java Collections (`HashMap`, `ArrayList`)
- File reading/writing (`BufferedReader`, `FileWriter`)
- Input validation and string parsing
- Data aggregation from multiple objects

---

📌 **Course**: CST8284 – Java Programming  
👨‍💻 **Author**: Mahmoud Ibrahim  
📅 **Term**: Winter 2025
