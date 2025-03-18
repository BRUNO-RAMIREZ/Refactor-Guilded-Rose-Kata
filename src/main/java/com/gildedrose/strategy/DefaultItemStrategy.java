package com.gildedrose.strategy;

import com.gildedrose.model.Item;

/**
 * @author Bruno Ramirez
 */
public class DefaultItemStrategy extends ItemUpdaterStrategy {

    @Override
    public void update(Item item) {
        updateQuality(item, -1);
        updateSellInDays(item);
        if (item.sellInDays < 0) {
            updateQuality(item, -1);
        }
    }

    @Override
    protected void updateQuality(Item item, int change) {
        item.quality = Math.max(0, item.quality + change);
    }
}
