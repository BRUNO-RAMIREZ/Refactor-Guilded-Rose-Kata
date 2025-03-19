package com.gildedrose.strategy;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.gildedrose.model.Item;

public class ConjuredStrategyTest {

    @Test
    public void testUpdateNormalCase() {
        Item item = new Item("Conjured Mana Cake", 5, 10);
        ConjuredStrategy strategy = new ConjuredStrategy();
        
        strategy.update(item);
        
        assertEquals(4, item.sellInDays);
        assertEquals(8, item.quality); // Loses 2 quality
    }
    
    @Test
    public void testUpdateAfterSellBy() {
        Item item = new Item("Conjured Mana Cake", 0, 10);
        ConjuredStrategy strategy = new ConjuredStrategy();
        
        strategy.update(item);
        
        assertEquals(-1, item.sellInDays);
        assertEquals(6, item.quality); // -2 normal, -2 after expiration
    }
    
    @Test
    public void testQualityNeverLessThanZero() {
        Item item = new Item("Conjured Mana Cake", 0, 3);
        ConjuredStrategy strategy = new ConjuredStrategy();
        
        strategy.update(item);
        
        assertEquals(-1, item.sellInDays);
        assertEquals(0, item.quality); // Should not go below 0
        
        // Try again when already at 0
        strategy.update(item);
        assertEquals(-2, item.sellInDays);
        assertEquals(0, item.quality); // Should still be 0
    }
}
