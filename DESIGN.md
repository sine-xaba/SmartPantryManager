# Smart Pantry Manager — System Design

## 1. Project Details

- Author: Sinenhlanhla Xaba
- Module: Mobile App Development 700
- Application: Smart Pantry Manager
- Status: Proposed design; implementation in progress

The student number will appear in the assignment report and required
submission filenames.

## 2. Purpose

Smart Pantry Manager will help users reduce food waste by recording
ingredients already available at home and identifying recipes they
can prepare without buying additional ingredients.

A recipe will appear in Suggested Recipes only when every required
ingredient is available in a sufficient quantity.

## 3. Implementation Plan

- Programming language: Java
- Screen layouts: XML
- Database: SQLite using SQLiteOpenHelper
- Dynamic lists: RecyclerView with custom adapters
- Navigation between screens: Explicit Intents
- Settings storage: SharedPreferences

This is the intended structure. The document will be updated if the
implemented application differs from the plan.

## 4. Screen Design

### 4.1 Pantry List

Proposed Java class: MainActivity.java
Proposed layout: activity_main.xml

Purpose:
Display the user's saved pantry ingredients.

Screen elements:
- Screen title: My Pantry
- Add Ingredient button
- RecyclerView displaying pantry items
- Edit and Delete actions for each pantry item
- Suggested Recipes navigation button
- Settings navigation button
- Helpful message when the pantry is empty

Each pantry row will display:
- Ingredient name
- Quantity
- Unit

Deleting an ingredient will require confirmation.

### 4.2 Add/Edit Ingredient

Proposed Java class: AddEditIngredientActivity.java
Proposed layout: activity_add_edit_ingredient.xml

Purpose:
Create a pantry item or update an existing one.

Screen elements:
- Ingredient name input
- Quantity input
- Unit selection
- Save button
- Back navigation


Edit mode:
The screen will receive a pantry item ID through an Intent,
load the saved record, and update that record when Save is pressed.


### 4.3 Suggested Recipes

Proposed Java class: SuggestedRecipesActivity.java
Proposed layout: activity_suggested_recipes.xml

Purpose:
Display only recipes that pass the strict-matching checks.

Screen elements:
- Screen title: Suggested Recipes
- RecyclerView containing matching recipes
- Empty-state message when no recipes qualify
- Back navigation

Selecting a recipe will open Recipe Detail using its recipe ID.

### 4.4 Recipe Detail

Proposed Java class: RecipeDetailActivity.java
Proposed layout: activity_recipe_detail.xml

Purpose:
Display the selected recipe.

Screen elements:
- Recipe name
- Full required ingredient list
- Required quantities and units
- Preparation steps
- Back navigation

### 4.5 Settings

Proposed Java class: SettingsActivity.java
Proposed layout: activity_settings.xml

Purpose:
Provide a small, working user preference.

Planned preference:
- Alphabetically sort the pantry list: on or off

The preference will be saved and applied when the user returns
to the Pantry List.


## 5. Database Design

Database name:
smart_pantry.db

### 5.1 pantry_items

Stores the user's available ingredients.

| Column | Proposed type | Purpose |
|---|---|---|
| id | INTEGER PRIMARY KEY AUTOINCREMENT | Unique pantry record ID |
| name | TEXT NOT NULL | Normalised ingredient name |
| quantity | REAL NOT NULL | Available quantity, greater than zero |
| unit | TEXT NOT NULL | Supported measurement unit |

### 6.2 recipes

Stores the recipe collection.

| Column | Proposed type | Purpose |
|---|---|---|
| id | INTEGER PRIMARY KEY AUTOINCREMENT | Unique recipe ID |
| name | TEXT NOT NULL | Recipe name |
| instructions | TEXT NOT NULL | Preparation method |

### 6.3 recipe_ingredients

Stores the ingredient requirements for each recipe.

| Column | Proposed type | Purpose |
|---|---|---|
| id | INTEGER PRIMARY KEY AUTOINCREMENT | Unique requirement ID |
| recipe_id | INTEGER NOT NULL | References recipes.id |
| ingredient_name | TEXT NOT NULL | Normalised ingredient name |
| required_quantity | REAL NOT NULL | Required amount, greater than zero |
| unit | TEXT NOT NULL | Required measurement unit |


## 6. Strict Recipe-Matching Design

For each recipe:

1. Load every required ingredient.
2. Normalise the ingredient names.
3. Find matching pantry entries.
4. Check that units are compatible.
5. Convert compatible quantities into the same base unit.
6. Add together compatible matching pantry quantities.
7. Compare the available quantity with the required quantity.
8. Reject the recipe immediately if any requirement fails.
9. Include the recipe only if every requirement passes.

A recipe with no ingredient requirements will not be suggested.

### 8.1 Ingredient Name Normalisation

Planned handling:
- Remove leading and trailing spaces.
- Convert names to lowercase consistently.
- Replace repeated spaces with a single space.
- Use an explicit alias list for supported variations.

### 8.2 Supported Units

Initial units:
- g
- kg
- ml
- l
- pcs

Base units:
- Mass: g
- Volume: ml
- Count: pcs

Planned conversions:
- 1 kg = 1000 g
- 1 l = 1000 ml

### 8.3 Independent Suggestions

Each recipe will be checked independently against the current pantry.

Displaying a suggestion will not deduct ingredients.

The initial version will not include a "Cook Recipe" action.

## 9. Planned Java Files

Activities:
- MainActivity.java
- AddEditIngredientActivity.java
- SuggestedRecipesActivity.java
- RecipeDetailActivity.java
- SettingsActivity.java

Database:
- DatabaseHelper.java

Models:
- PantryItem.java
- Recipe.java
- RecipeIngredient.java

Adapters:
- PantryAdapter.java
- RecipeAdapter.java

Matching:
- IngredientNormalizer.java
- UnitConverter.java
- RecipeMatcher.java
