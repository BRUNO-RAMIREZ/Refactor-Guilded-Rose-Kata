package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.gildedrose.model.Item;

public class GildedRoseUpdaterTest {

    @Test
    public void testUpdateQualityWithMultipleItems() {
        Item[] items = new Item[] {
            new Item("Aged Brie", 2, 0),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Conjured Mana Cake", 3, 6),
            new Item("Standard Item", 5, 10)
        };
        
        GildedRoseUpdater app = new GildedRoseUpdater(items);
        app.updateQuality();
        
        //Verify that the quality and sellInDays of each item is updated correctly
        assertEquals(1, items[0].quality); //Aged Brie increases in quality
        assertEquals(1, items[0].sellInDays);
        
        assertEquals(23, items[1].quality); //Backstage pass increases more as sellInDays approaches
        assertEquals(4, items[1].sellInDays);
        
        assertEquals(80, items[2].quality); //Sulfuras does not change
        assertEquals(0, items[2].sellInDays);
        
        assertEquals(4, items[3].quality); //Conjured items lose 2 in quality
        assertEquals(2, items[3].sellInDays);
        
        assertEquals(9, items[4].quality); //Standard item loses 1 in quality
        assertEquals(4, items[4].sellInDays);
    }
}
