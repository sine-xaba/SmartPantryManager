package com.sine.smartpantrymanager.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class IngredientNormaliser {

    private static final Map<String, String> ALIASES;

    static {
        Map<String, String> aliases = new HashMap<>();

        aliases.put("tomatoes", "tomato");
        aliases.put("potatoes", "potato");
        aliases.put("eggs", "egg");
        aliases.put("onions", "onion");
        aliases.put("carrots", "carrot");
        aliases.put("bananas", "banana");
        aliases.put("apples", "apple");
        aliases.put("lemons", "lemon");
        aliases.put("peppers", "pepper");

        ALIASES = Collections.unmodifiableMap(aliases);
    }

    private IngredientNormaliser() {
    }

    public static String normalize(String input) {
        if (input == null) {
            return "";
        }

        String cleaned = input
                .trim()
                .toLowerCase(Locale.ROOT)
                .replaceAll("\\s+", " ");

        String canonicalName = ALIASES.get(cleaned);

        return canonicalName != null ? canonicalName : cleaned;
    }
}
