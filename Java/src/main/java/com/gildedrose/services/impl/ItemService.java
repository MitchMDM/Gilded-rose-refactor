package com.gildedrose.services.impl;

import com.gildedrose.Item;

public class ItemService {




    public void increaseQualityByAmount(Item item, int amount){
        item.quality = item.quality + amount;
    }

    public void decreaseQualityByAmount(Item item, int amount){
        item.quality = item.quality - amount;
    }

    public Boolean isLegendary(Item item){
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    public boolean isBackStagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    public Boolean isQualityBelowAmount(Item item, int amount){
        return item.quality > amount;
    }

    public Boolean isSelInBelowAmount(Item item, int amount){
        return item.sellIn > amount;
    }

}
