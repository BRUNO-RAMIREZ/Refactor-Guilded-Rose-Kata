package com.gildedrose.strategy;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.gildedrose.model.Item;

public class AgedBrieStrategyTest {

    @Test
    public void testUpdateNormalCase() {
        Item item = new Item("Aged Brie", 5, 10);
        AgedBrieStrategy strategy = new AgedBrieStrategy();
        
        strategy.update(item);
        
        assertEquals(4, item.sellInDays);
        assertEquals(11, item.quality);
    }
    
    @Test
    public void testUpdateAfterSellBy() {
        Item item = new Item("Aged Brie", 0, 10);
        AgedBrieStrategy strategy = new AgedBrieStrategy();
        
        strategy.update(item);
        
        assertEquals(-1, item.sellInDays);
        assertEquals(12, item.quality); // +1 normal, +1 after sell-by
    }
    
    @Test
    public void testQualityNeverExceedsMax() {
        Item item = new Item("Aged Brie", 0, 49);
        AgedBrieStrategy strategy = new AgedBrieStrategy();
        
        strategy.update(item);
        
        assertEquals(-1, item.sellInDays);
        assertEquals(50, item.quality); // Max quality is 50
        
        // Try again when already at max
        strategy.update(item);
        assertEquals(-2, item.sellInDays);
        assertEquals(50, item.quality); // Should still be 50
    }
}