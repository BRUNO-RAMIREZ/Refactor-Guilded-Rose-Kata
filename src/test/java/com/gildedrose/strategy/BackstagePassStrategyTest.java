package com.gildedrose.strategy;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.gildedrose.model.Item;

public class BackstagePassStrategyTest {

    @Test
    public void testUpdateMoreThan10Days() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        BackstagePassStrategy strategy = new BackstagePassStrategy();
        
        strategy.update(item);
        
        assertEquals(14, item.sellInDays);
        assertEquals(21, item.quality); //+1 regular increase
    }
    
    @Test
    public void testUpdate10DaysOrLess() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        BackstagePassStrategy strategy = new BackstagePassStrategy();
        
        strategy.update(item);
        
        assertEquals(9, item.sellInDays);
        assertEquals(22, item.quality); //+1 regular, +1 for <= 10 days
    }
    
    @Test
    public void testUpdate5DaysOrLess() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        BackstagePassStrategy strategy = new BackstagePassStrategy();
        
        strategy.update(item);
        
        assertEquals(4, item.sellInDays);
        assertEquals(23, item.quality); //+1 regular, +1 for <= 10 days, +1 for <= 5 days
    }
    
    @Test
    public void testUpdateAfterConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        BackstagePassStrategy strategy = new BackstagePassStrategy();
        
        strategy.update(item);
        
        assertEquals(-1, item.sellInDays);
        assertEquals(0, item.quality); //Quality drops to 0 after concert
    }
    
    @Test
    public void testQualityNeverExceedsMax() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48);
        BackstagePassStrategy strategy = new BackstagePassStrategy();
        
        strategy.update(item);
        
        assertEquals(4, item.sellInDays);
        assertEquals(50, item.quality); //Quality should cap at 50 even with multiple increases
    }
}