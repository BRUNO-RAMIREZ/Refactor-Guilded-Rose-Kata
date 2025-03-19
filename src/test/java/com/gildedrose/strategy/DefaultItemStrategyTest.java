package com.gildedrose.strategy;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.gildedrose.model.Item;

public class DefaultItemStrategyTest {

    @Test
    public void testUpdateNormalCase() {
        Item item = new Item("Standard Item", 5, 10);
        DefaultItemStrategy strategy = new DefaultItemStrategy();
        
        strategy.update(item);
        
        assertEquals(4, item.sellInDays);
        assertEquals(9, item.quality); // -1 quality
    }
    
    @Test
    public void testUpdateAfterSellBy() {
        Item item = new Item("Standard Item", 0, 10);
        DefaultItemStrategy strategy = new DefaultItemStrategy();
        
        strategy.update(item);
        
        assertEquals(-1, item.sellInDays);
        assertEquals(8, item.quality); // -1 normal, -1 after expiration
    }
    
    @Test
    public void testQualityNeverLessThanZero() {
        Item item = new Item("Standard Item", 0, 1);
        DefaultItemStrategy strategy = new DefaultItemStrategy();
        
        strategy.update(item);
        
        assertEquals(-1, item.sellInDays);
        assertEquals(0, item.quality); // Should not go below 0
        
        // Try again when already at 0
        strategy.update(item);
        assertEquals(-2, item.sellInDays);
        assertEquals(0, item.quality); // Should still be 0
    }
}