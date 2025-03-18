package com.gildedrose.model;

public class Item {

    public String name;

    public int sellInDays;

    public int quality;

    public Item(String name, int sellInDays, int quality) {
        this.name = name;
        this.sellInDays = sellInDays;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %d", this.name, this.sellInDays, this.quality);
    }
}
