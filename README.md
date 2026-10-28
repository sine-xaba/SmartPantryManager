# Smart Pantry Manager

A Java Android application designed to help users reduce food waste by managing their pantry and identifying recipes they can prepare using only the ingredients they already have.

## Student Details

- Name: Sinenhlanhla Xaba
- Student number: 402412758
- Module: Mobile App Development 700
- Institution: Richfield Graduate Institute of Technology

## Project Status

Work in progress.

This README describes the intended application. Features should only be marked as complete after they have been implemented and tested.

## Application Overview

Smart Pantry Manager will allow users to record the ingredients available in their pantry, including quantities and units.

The application will compare the pantry against a stored recipe collection and suggest only recipes for which every required ingredient is available in sufficient quantity.

The application will not include mapping, GPS, location-based services, or payment processing.

## Planned Features

- Add pantry ingredients.
- View pantry ingredients in a dynamic list.
- Edit ingredient details.
- Delete pantry ingredients.
- Store pantry data between application sessions.
- Provide a preloaded collection of 20 recipes.
- Suggest recipes using strict ingredient and quantity matching.
- Display recipe ingredients and preparation instructions.
- Show a helpful message when no recipes match.
- Validate ingredient input.
- Provide a settings screen.

## Planned Screens

1. Pantry List
2. Add/Edit Ingredient
3. Suggested Recipes
4. Recipe Detail
5. Settings

## Strict Recipe-Matching Rule

A recipe qualifies as a suggestion only when every required ingredient is present in the pantry in at least the required quantity.

The matching implementation will account for supported ingredient-name variations and compatible unit conversions.

Ingredients will not be treated as available merely because they are common household staples. If a recipe requires an ingredient, it must be recorded in the pantry.

## Technology Plan

- Programming language: Java
- Development environment: Android Studio
- User interface: XML layouts
- Database: SQLite using SQLiteOpenHelper
- Dynamic lists: RecyclerView with custom adapters
- Navigation: Android Activities and Intents
- Version control: Git and GitHub

## Database Choice and Justification

The planned database is SQLite, accessed through SQLiteOpenHelper.

A local database fits the application's focus on managing one user's pantry on their device. It avoids the need to configure a remote database, user authentication, or a separate backend.

The database implementation will support creating, reading, updating, and deleting pantry records. Pantry data must remain available after the application is closed and reopened.

Recipe data and recipe ingredient requirements will also be stored locally.

This section will be updated if the final database implementation differs from this plan.

## Development Requirements

- Android Studio
- Android SDK components required by the project
- Git, if cloning the repository through Git
- An Android device or Android emulator compatible with the project's minimum SDK

The project's Gradle configuration defines its SDK and dependency requirements.

## Known Limitations

The application is still under development.

Implemented features, supported unit conversions, testing results, and remaining limitations will be documented as development progresses.

