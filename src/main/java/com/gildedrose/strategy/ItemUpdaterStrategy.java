package com.gildedrose.strategy;

import com.gildedrose.model.Item;

public abstract class ItemUpdaterStrategy {
    private static final int DEFAULT_QUALITY_DECREASE = -1;
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    public void update(Item item) {
        updateItemQuality(item);
        updateItemSellInDays(item);
        if (item.sellInDays < 0) handleExpiredItem(item);
    }

    protected abstract void updateItemQuality(Item item);

    protected void handleExpiredItem(Item item) {
        updateQuality(item, DEFAULT_QUALITY_DECREASE);
    }

    protected void updateQuality(Item item, int qualityToApply) {
        item.quality = Math.max(MIN_QUALITY, Math.min(item.quality + qualityToApply, MAX_QUALITY));
    }

    private void updateItemSellInDays(Item item) {
        item.sellInDays--;
    }
}
