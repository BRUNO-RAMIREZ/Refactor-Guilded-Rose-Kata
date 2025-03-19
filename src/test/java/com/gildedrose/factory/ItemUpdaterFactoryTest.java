package com.gildedrose.factory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.gildedrose.strategy.*;

public class ItemUpdaterFactoryTest {

    @Test
    public void testGetUpdaterForAgedBrie() {
        ItemUpdaterStrategy strategy = ItemUpdaterFactory.getUpdater("Aged Brie");
        assertTrue(strategy instanceof AgedBrieStrategy);
    }
    
    @Test
    public void testGetUpdaterForBackstagePass() {
        ItemUpdaterStrategy strategy = ItemUpdaterFactory.getUpdater("Backstage passes to a TAFKAL80ETC concert");
        assertTrue(strategy instanceof BackstagePassStrategy);
    }
    
    @Test
    public void testGetUpdaterForSulfuras() {
        ItemUpdaterStrategy strategy = ItemUpdaterFactory.getUpdater("Sulfuras, Hand of Ragnaros");
        assertTrue(strategy instanceof SulfurasStrategy);
    }
    
    @Test
    public void testGetUpdaterForConjured() {
        ItemUpdaterStrategy strategy = ItemUpdaterFactory.getUpdater("Conjured Mana Cake");
        assertTrue(strategy instanceof ConjuredStrategy);
    }
    
    @Test
    public void testGetUpdaterForUnknownItem() {
        ItemUpdaterStrategy strategy = ItemUpdaterFactory.getUpdater("Some Unknown Item");
        assertTrue(strategy instanceof DefaultItemStrategy);
    }
}
