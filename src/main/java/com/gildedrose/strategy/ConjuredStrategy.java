package com.gildedrose.strategy;

import com.gildedrose.model.Item;

public class ConjuredStrategy extends ItemUpdaterStrategy {
    private static final int QUALITY_DECREASE_RATE = -2;

    @Override
    protected void updateItemQuality(Item item) {
        updateQuality(item, QUALITY_DECREASE_RATE);
    }

    @Override
    protected void handleExpiredItem(Item item) {
        updateQuality(item, QUALITY_DECREASE_RATE);
    }
}
