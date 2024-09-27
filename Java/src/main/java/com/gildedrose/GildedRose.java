package com.gildedrose;

import java.util.Arrays;

import static com.gildedrose.GildedRoseConstants.*;

class GildedRose {
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void updateQuality() {
      Arrays.stream(items).forEach(this::processItem);
    }

    private void processItem(Item item) {
        if(isItemConjured(item)){
            updateConjuredItem(item);
        }

        if (isItemAgedBrie(item)) {
            updateAgedBrieitem(item);
        }

        if (isItemBackstagePasses(item)) {
            updateBackstageItem(item);
        }
    }

    private void updateBackstageItem(Item item) {
        if (isItemQualityUnder50(item)) {
            increaseItemQuality(item);

            if(isItemQualityUnder50(item)){
                if(isItemSellInUnder11(item)){
                    increaseItemQuality(item);
                }
                if(isItemSellInUnder6(item)){
                    increaseItemQuality(item);
                }
            }
        }
        decreaseItemSellIn(item);
        if (isItemSellInUnder0(item)) {
            setItemQualityToZero(item);
        }
    }

    private void updateAgedBrieitem(Item item) {
        if (isItemQualityUnder50(item)) {
            increaseItemQuality(item);
        }
        decreaseItemSellIn(item);
        if (isItemSellInUnder0(item) && isItemQualityUnder50(item)) {
            increaseItemQuality(item);
        }
    }

    private void updateConjuredItem(Item item) {
        decreaseItemQualityByTwo(item);
        decreaseItemSellIn(item);
    }

    private boolean isItemSellInUnder6(Item item) {
        return item.sellIn < 6;
    }

    private boolean isItemSellInUnder11(Item item) {
        return item.sellIn < 11;
    }

    private void setItemQualityToZero(Item item) {
        item.quality = 0;
    }

    private boolean isItemSellInUnder0(Item item) {
        return item.sellIn < 0;
    }

    private boolean isItemQualityUnder50(Item item) {
        return item.quality < MAX_QUALITY_ITEM;
    }

    private void decreaseItemSellIn(Item item){
       item.sellIn --;
    }

    private void decreaseItemQualityByTwo(Item item){
        item.quality -= 2;
    }

    private void increaseItemQuality(Item item){
        item.quality++;
    }

    private boolean isItemBackstagePasses(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private boolean isItemConjured(Item item) {
        return item.name.equals(CONJURED);
    }

    private boolean isItemAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }
}
