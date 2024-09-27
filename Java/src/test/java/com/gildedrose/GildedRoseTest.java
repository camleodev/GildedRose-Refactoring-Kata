package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRoseConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void agedBrieTest() {
        Item[] items = new Item[] {
            new Item(AGED_BRIE, 0, 0) ,
            new Item(AGED_BRIE, 10, 5),
            new Item(AGED_BRIE, 20, 40),
            new Item(AGED_BRIE, -1, 8)

        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(AGED_BRIE, app.getItems()[0].name);
        assertEquals(2, app.getItems()[0].quality);
        assertEquals(-1, app.getItems()[0].sellIn);

        assertEquals(6, app.getItems()[1].quality);
        assertEquals(9, app.getItems()[1].sellIn);

        assertEquals(41, app.getItems()[2].quality);
        assertEquals(19, app.getItems()[2].sellIn);

        assertEquals(10, app.getItems()[3].quality);
        assertEquals(-2, app.getItems()[3].sellIn);
    }

    @Test
    void sulfurasTest() {
        Item[] items = new Item[] {
            new Item(SULFURAS, 0, 0) ,
            new Item(SULFURAS, 10, 10),
            new Item(SULFURAS, 20, 80)

        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(SULFURAS, app.getItems()[0].name);
        assertEquals(0, app.getItems()[0].quality);
        assertEquals(0, app.getItems()[0].sellIn);

        assertEquals(10, app.getItems()[1].quality);
        assertEquals(10, app.getItems()[1].sellIn);

        assertEquals(80, app.getItems()[2].quality);
        assertEquals(20, app.getItems()[2].sellIn);
    }

    @Test
    void backstagePassesTest() {
        Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, 0, 0) ,
            new Item(BACKSTAGE_PASSES, 10, 5),
            new Item(BACKSTAGE_PASSES, 20, 10)

        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BACKSTAGE_PASSES, app.getItems()[0].name);
        assertEquals(0, app.getItems()[0].quality);
        assertEquals(-1, app.getItems()[0].sellIn);

        assertEquals(7, app.getItems()[1].quality);
        assertEquals(9, app.getItems()[1].sellIn);

        assertEquals(11, app.getItems()[2].quality);
        assertEquals(19, app.getItems()[2].sellIn);
    }

    @Test
    void conjuredTest() {
        Item[] items = new Item[] {
            new Item(CONJURED, 10, 20)

        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(CONJURED, app.getItems()[0].name);
        assertEquals(18, app.getItems()[0].quality);
        assertEquals(9, app.getItems()[0].sellIn);

    }

}
