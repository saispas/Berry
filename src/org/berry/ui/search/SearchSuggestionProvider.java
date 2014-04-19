package org.berry.ui.search;

import android.content.SearchRecentSuggestionsProvider;

/**
 * User: qii
 * Date: 13-2-4
 */
public class SearchSuggestionProvider extends SearchRecentSuggestionsProvider {
    public final static String AUTHORITY = "org.berry.ui.search.SearchSuggestionProvider";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public SearchSuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }
}
