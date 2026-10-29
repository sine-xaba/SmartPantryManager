# Smart Pantry Manager — Runtime Test Results

Tester: Sinenhlanhla Xaba
Date: 29 October 2026
Test environment: Android Emulator

| Test | Expected result | Actual result | Evidence |
|---|---|---------------|---|
| Add rice | Rice appears in pantry | pass          | 02_rice_added.png |
| Duplicate rice | Duplicate is rejected | pass          | 03_duplicate_rice_error.png |
| Strict matching | Scrambled Eggs appears | pass          | 04_scrambled_eggs_suggested.png |
| Insufficient eggs | Scrambled Eggs is excluded | pass          | 05_insufficient_eggs_excluded.png |
| Unit conversion | 1 kg and 1000 g behave equivalently | pass          | 06_unit_conversion_test.png |
| Edit ingredient | Updated quantity appears | pass          | 07_edit_ingredient.png |
| Delete ingredient | Item is removed | pass          | 09_pantry_after_delete.png |
| Persistence | Items remain after restart | pass          | 10_persistence_after_restart.png |
| Settings sorting | Pantry order changes | pass          | 12_settings_descending.png |