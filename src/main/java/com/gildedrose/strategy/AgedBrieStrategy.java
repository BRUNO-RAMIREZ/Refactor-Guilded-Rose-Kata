package com.gildedrose.strategy;

import com.gildedrose.model.Item;

public class AgedBrieStrategy extends ItemUpdaterStrategy {

    @Override
    public void update(Item item) {
        updateQuality(item, 1);
        updateSellInDays(item);
        if (item.sellInDays < 0) {
            updateQuality(item, 1);
        }
    }
}
