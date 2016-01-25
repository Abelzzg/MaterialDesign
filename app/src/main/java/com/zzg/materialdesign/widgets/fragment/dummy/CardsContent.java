package com.zzg.materialdesign.widgets.fragment.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample cardName for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class CardsContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<CardItem> ITEMS = new ArrayList<CardItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, CardItem> ITEM_MAP = new HashMap<String, CardItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createCardItem(i));
        }
    }

    private static void addItem(CardItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static CardItem createCardItem(int position) {
        return new CardItem(String.valueOf(position), "card"+position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of cardName.
     */
    public static class CardItem {
        public final String id;
        public final String cardName;
        public final String details;

        public CardItem(String id, String content, String details) {
            this.id = id;
            this.cardName = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return cardName;
        }
    }
}
