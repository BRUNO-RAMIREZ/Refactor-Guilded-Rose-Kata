package com.gildedrose.strategy;

import com.gildedrose.model.Item;

public class AgedBrieStrategy extends ItemUpdaterStrategy {
    private static final int QUALITY_INCREASE_RATE = 1;

    @Override
    protected void updateItemQuality(Item item) {
        updateQuality(item, QUALITY_INCREASE_RATE);
    }

    @Override
    protected void handleExpiredItem(Item item) {
        updateQuality(item, QUALITY_INCREASE_RATE);
    }
}
