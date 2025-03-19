package com.gildedrose.strategy;

import com.gildedrose.model.Item;

/**
 * @author Bruno Ramirez
 */
public class BackstagePassStrategy extends ItemUpdaterStrategy {
    private static final int QUALITY_INCREASE_RATE_REGULAR = 1;
    private static final int QUALITY_INCREASE_RATE_MEDIUM = 2;
    private static final int QUALITY_INCREASE_RATE_HIGH = 3;
    private static final int QUALITY_INCREASE_THRESHOLD_MEDIUM = 11;
    private static final int QUALITY_INCREASE_THRESHOLD_HIGH = 6;

    @Override
    protected void updateItemQuality(Item item) {
        int qualityIncrease = getQualityIncreaseRate(item.sellInDays);
        updateQuality(item, qualityIncrease);
    }

    @Override
    protected void handleExpiredItem(Item item) {
        item.quality = 0;
    }

    private int getQualityIncreaseRate(int sellInDays) {
        if (sellInDays < QUALITY_INCREASE_THRESHOLD_HIGH) return QUALITY_INCREASE_RATE_HIGH;
        if (sellInDays < QUALITY_INCREASE_THRESHOLD_MEDIUM) return QUALITY_INCREASE_RATE_MEDIUM;
        return QUALITY_INCREASE_RATE_REGULAR;
    }
}