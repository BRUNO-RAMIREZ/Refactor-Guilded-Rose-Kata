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
        
        // Verificar que cada ítem se actualizó según su estrategia
        assertEquals(1, items[0].quality); // Aged Brie aumenta calidad
        assertEquals(1, items[0].sellInDays);
        
        assertEquals(23, items[1].quality); // Backstage pass aumenta más si está cerca de sellIn
        assertEquals(4, items[1].sellInDays);
        
        assertEquals(80, items[2].quality); // Sulfuras no cambia
        assertEquals(0, items[2].sellInDays);
        
        assertEquals(4, items[3].quality); // Conjured pierde 2 de calidad
        assertEquals(2, items[3].sellInDays);
        
        assertEquals(9, items[4].quality); // Item estándar pierde 1 de calidad
        assertEquals(4, items[4].sellInDays);
    }
    
    @Test
    public void testUpdateQualityWithEmptyArray() {
        Item[] items = new Item[0];
        GildedRoseUpdater app = new GildedRoseUpdater(items);
        
        // Verificar que no hay error al actualizar un array vacío
        assertDoesNotThrow(() -> app.updateQuality());
    }
}