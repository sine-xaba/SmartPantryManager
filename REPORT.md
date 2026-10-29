# Smart Pantry Manager — Project Report

**Student name:** Sinenhlanhla Xaba  
**Student number:** 402412758
**Module:** Mobile App Development 700  
**Date:** 28 October 2026

## 1. Introduction

Smart Pantry Manager is a Java Android application that helps users track
ingredients available at home and identify recipes they can prepare using
those ingredients.

The application aims to reduce food waste by making it easier to see which
recipes can be prepared from the user's current pantry.

## 2. Problem statement

Households often have ingredients available but do not know which meals can
be prepared from them. This can lead to forgotten food and unnecessary waste.

The application addresses this by storing pantry ingredients and suggesting
only recipes whose complete ingredient requirements are met.

## 3. Objectives

- Enable users to add, view, edit and delete pantry ingredients.
- Store ingredient names, quantities and units persistently.
- Provide 20 stored recipes with ingredients and preparation steps.
- Suggest recipes only when every required ingredient is available in a
  sufficient quantity.
- Handle basic ingredient-name differences and compatible unit conversions.
- Provide a functional Settings screen.
- Provide validation feedback and empty-state messages.

## 4. Scope and limitations

The application is designed for a single user's pantry.

It does not include:
- User registration or multi-user accounts.
- Cloud synchronisation.
- Maps, GPS or location services.
- Payment processing.
- Barcode scanning.

The application supports mass, volume and count measurements. It does not
assume universal conversions between unrelated measurement types.

## 5. Technology and architecture

The application uses:
- Java for application logic.
- XML layouts for the user interface.
- SQLite through SQLiteOpenHelper for persistent storage.
- ListView with custom adapters for pantry and recipe lists.
- Explicit Intents for navigation between Activities.
- SharedPreferences for the pantry sorting preference.
- Git and GitHub for version control.

The main components are:
- Activities for the five screens.
- Repository classes for database access.
- Model classes for pantry and recipe data.
- Utility classes for ingredient normalisation and unit conversion.
- Adapters for displaying database results in lists.

## 6. Database design

The SQLite database contains four tables:

| Table | Purpose |
|---|---|
| ingredients | Canonical ingredient names and measurement types. |
| pantry_items | Ingredients currently owned by the user. |
| recipes | Recipe names and preparation steps. |
| recipe_ingredients | Ingredient requirements for each recipe. |

Foreign keys connect pantry items and recipe requirements to ingredient
definitions. A pantry item is linked to one ingredient, while a recipe can
require many ingredients.

## 7. Screen design

The application contains five screens:

1. Pantry List
2. Add/Edit Ingredient
3. Suggested Recipes
4. Recipe Detail
5. Settings

Navigation:
- Pantry List opens Add/Edit Ingredient, Suggested Recipes and Settings.
- Suggested Recipes opens Recipe Detail.
- Recipe Detail returns to Suggested Recipes.
- Add/Edit Ingredient and Settings return to Pantry List.

## 8. Implementation

### Ingredient management
Users can add ingredients with a name, quantity and unit. The application
validates blank names and non-positive quantities. Duplicate canonical
ingredients are rejected, and the user is directed to edit the existing
pantry item.

### Strict recipe matching
A recipe appears in Suggested Recipes only when every required ingredient is
present in a sufficient quantity. Compatible units are converted to base
units before comparison: grams for mass, millilitres for volume and pieces
for count.

## 9. Challenges encountered

Record only challenges you actually experienced. Examples may include:
- Configuring the Android emulator.
- Resolving Gradle or installation errors.
- Handling duplicate ingredients correctly.
- Designing strict matching without treating incompatible units as equal.
- Debugging an Activity startup error.

## 10. Conclusion

Smart Pantry Manager provides pantry management and strict recipe matching
using Java, SQLite and Android Activities. The application demonstrates
persistent local storage, input validation, navigation and recipe filtering.

## 11. Future work

Possible improvements include:
- Barcode scanning for quicker ingredient entry.
- Expiry-date reminders.
- Multiple pantry profiles.
- Cloud synchronisation.
- More advanced recipe filtering and substitution suggestions.

