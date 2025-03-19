package com.gildedrose.strategy;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.gildedrose.model.Item;

public class SulfurasStrategyTest {

    @Test
    public void testUpdateNeverChanges() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        SulfurasStrategy strategy = new SulfurasStrategy();
        
        strategy.update(item);
        
        // Verificar que Sulfuras nunca cambia sus valores
        assertEquals(0, item.sellInDays);
        assertEquals(80, item.quality);
        
        // Probar múltiples actualizaciones
        for (int i = 0; i < 10; i++) {
            strategy.update(item);
        }
        
        assertEquals(0, item.sellInDays);
        assertEquals(80, item.quality);
    }
}