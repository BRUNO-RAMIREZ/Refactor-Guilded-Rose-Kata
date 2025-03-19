package com.gildedrose.strategy;

import com.gildedrose.model.Item;

/**
 * @author Bruno Ramirez
 */
public class DefaultItemStrategy extends ItemUpdaterStrategy {
    private static final int QUALITY_DECREASE_RATE = -1;

    @Override
    protected void updateItemQuality(Item item) {
        updateQuality(item, QUALITY_DECREASE_RATE);
    }
}
