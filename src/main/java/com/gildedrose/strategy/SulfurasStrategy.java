package com.gildedrose.strategy;

import com.gildedrose.model.Item;

public class SulfurasStrategy extends ItemUpdaterStrategy {
    private static final int QUALITY_INCREASE_RATE = 0;

    @Override
    public void update(Item item) {
    }

    @Override
    protected void updateItemQuality(Item item) {
        updateQuality(item, QUALITY_INCREASE_RATE);
    }
}