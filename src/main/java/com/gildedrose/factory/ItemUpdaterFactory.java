package com.gildedrose.factory;

import com.gildedrose.strategy.*;


/**
 * @author Bruno Ramirez
 */
public class ItemUpdaterFactory {
    public static ItemUpdaterStrategy getUpdater(String itemName) {
        switch (itemName) {
            case "Aged Brie":
                return new AgedBrieStrategy();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassStrategy();
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasStrategy();
            case "Conjured Mana Cake":
                return new ConjuredStrategy();
            default:
                return new DefaultItemStrategy();
        }
    }
}
