package com.gildedrose;

import com.gildedrose.model.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private String expectedResult = "OMGHAI!\n" +
            "-------- day 0 --------\n" +
            "name, sellIn, quality\n" +
            "+5 Dexterity Vest, 10, 20\n" +
            "Aged Brie, 2, 0\n" +
            "Elixir of the Mongoose, 5, 7\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\n" +
            "Backstage passes to a TAFKAL80ETC concert, 15, 20\n" +
            "Backstage passes to a TAFKAL80ETC concert, 10, 49\n" +
            "Backstage passes to a TAFKAL80ETC concert, 5, 49\n" +
            "Conjured Mana Cake, 3, 6\n" +
            "\n" +
            "-------- day 1 --------\n" +
            "name, sellIn, quality\n" +
            "+5 Dexterity Vest, 9, 19\n" +
            "Aged Brie, 1, 1\n" +
            "Elixir of the Mongoose, 4, 6\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\n" +
            "Backstage passes to a TAFKAL80ETC concert, 14, 21\n" +
            "Backstage passes to a TAFKAL80ETC concert, 9, 50\n" +
            "Backstage passes to a TAFKAL80ETC concert, 4, 50\n" +
            "Conjured Mana Cake, 2, 4\n" +
            "\n" +
            "-------- day 2 --------\n" +
            "name, sellIn, quality\n" +
            "+5 Dexterity Vest, 8, 18\n" +
            "Aged Brie, 0, 2\n" +
            "Elixir of the Mongoose, 3, 5\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\n" +
            "Backstage passes to a TAFKAL80ETC concert, 13, 22\n" +
            "Backstage passes to a TAFKAL80ETC concert, 8, 50\n" +
            "Backstage passes to a TAFKAL80ETC concert, 3, 50\n" +
            "Conjured Mana Cake, 1, 2\n" +
            "\n" +
            "-------- day 3 --------\n" +
            "name, sellIn, quality\n" +
            "+5 Dexterity Vest, 7, 17\n" +
            "Aged Brie, -1, 4\n" +
            "Elixir of the Mongoose, 2, 4\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\n" +
            "Backstage passes to a TAFKAL80ETC concert, 12, 23\n" +
            "Backstage passes to a TAFKAL80ETC concert, 7, 50\n" +
            "Backstage passes to a TAFKAL80ETC concert, 2, 50\n" +
            "Conjured Mana Cake, 0, 0\n" +
            "\n" +
            "-------- day 4 --------\n" +
            "name, sellIn, quality\n" +
            "+5 Dexterity Vest, 6, 16\n" +
            "Aged Brie, -2, 6\n" +
            "Elixir of the Mongoose, 1, 3\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\n" +
            "Backstage passes to a TAFKAL80ETC concert, 11, 24\n" +
            "Backstage passes to a TAFKAL80ETC concert, 6, 50\n" +
            "Backstage passes to a TAFKAL80ETC concert, 1, 50\n" +
            "Conjured Mana Cake, -1, 0\n" +
            "\n" +
            "-------- day 5 --------\n" +
            "name, sellIn, quality\n" +
            "+5 Dexterity Vest, 5, 15\n" +
            "Aged Brie, -3, 8\n" +
            "Elixir of the Mongoose, 0, 2\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\n" +
            "Backstage passes to a TAFKAL80ETC concert, 10, 25\n" +
            "Backstage passes to a TAFKAL80ETC concert, 5, 50\n" +
            "Backstage passes to a TAFKAL80ETC concert, 0, 50\n" +
            "Conjured Mana Cake, -2, 0\n" +
            "\n" +
            "-------- day 6 --------\n" +
            "name, sellIn, quality\n" +
            "+5 Dexterity Vest, 4, 14\n" +
            "Aged Brie, -4, 10\n" +
            "Elixir of the Mongoose, -1, 0\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\n" +
            "Backstage passes to a TAFKAL80ETC concert, 9, 27\n" +
            "Backstage passes to a TAFKAL80ETC concert, 4, 50\n" +
            "Backstage passes to a TAFKAL80ETC concert, -1, 0\n" +
            "Conjured Mana Cake, -3, 0\n" +
            "\n";

    @Test
    void test7Days() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OMGHAI!").append('\n');

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRoseUpdater app = new GildedRoseUpdater(items);

        int days = 7;

        for (int i = 0; i < days; i++) {
            stringBuilder.append("-------- day " + i + " --------").append('\n');
            stringBuilder.append("name, sellIn, quality").append('\n');
            for (Item item : items) {
                stringBuilder.append(item).append('\n');
            }
            stringBuilder.append("").append('\n');
            app.updateQuality();
        }

        assertEquals(expectedResult, stringBuilder.toString());
    }

}
