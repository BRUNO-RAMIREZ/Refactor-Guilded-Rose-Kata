package com.gildedrose;

import com.gildedrose.factory.ItemUpdaterFactory;
import com.gildedrose.model.Item;
import com.gildedrose.strategy.ItemUpdaterStrategy;

class GildedRoseUpdater {
    Item[] items;

    public GildedRoseUpdater(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdaterStrategy updater = ItemUpdaterFactory.getUpdater(item.name);
            updater.update(item);
        }
    }
}