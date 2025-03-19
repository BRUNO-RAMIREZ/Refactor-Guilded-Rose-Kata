package com.gildedrose.factory;

import java.util.Map;
import java.util.HashMap;
import com.gildedrose.strategy.*;

public class ItemUpdaterFactory {
    private static final Map<String, ItemUpdaterStrategy> strategyMap = new HashMap<>();
    
    static {
        strategyMap.put("Aged Brie", new AgedBrieStrategy());
        strategyMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassStrategy());
        strategyMap.put("Sulfuras, Hand of Ragnaros", new SulfurasStrategy());
        strategyMap.put("Conjured Mana Cake", new ConjuredStrategy());
    }
    
    public static ItemUpdaterStrategy getUpdater(String itemName) {
        return strategyMap.getOrDefault(itemName, new DefaultItemStrategy());
    }
}