package com.gildedrose.strategy;

import com.gildedrose.model.Item;

/**
 * @author Bruno Ramirez
 */
public class BackstagePassStrategy extends ItemUpdaterStrategy {

    @Override
    public void update(Item item) {
        updateQuality(item, 1);
        if (item.sellInDays < 11) updateQuality(item, 1);
        if (item.sellInDays < 6) updateQuality(item, 1);

        updateSellInDays(item);

        if (item.sellInDays < 0) {
            item.quality = 0;
        }
    }
}