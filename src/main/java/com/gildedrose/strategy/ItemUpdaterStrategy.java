package com.gildedrose.strategy;

import com.gildedrose.model.Item;

/**
 * @author Bruno Ramirez
 */
public abstract class ItemUpdaterStrategy {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    public abstract void update(Item item);

    protected void updateQuality(Item item, int change) {
        item.quality = Math.max(MIN_QUALITY, Math.min(item.quality + change, MAX_QUALITY));
    }

    protected void updateSellInDays(Item item) {
        item.sellInDays--;
    }
}
