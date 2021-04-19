package com.gildedrose;

import com.gildedrose.services.impl.ItemService;

class GildedRose {
    Item[] items;

    private final ItemService itemService = new ItemService();
    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (Item item : items) {
            if (itemService.isAgedBrie(item) || itemService.isBackStagePass(item)) {
                if (itemService.isQualityBelowAmount(item,50)) {
                    itemService.increaseQualityByAmount(item, 1);

                    if (itemService.isBackStagePass(item)) {
                        if (itemService.isSelInBelowAmount(item,11)) {
                            if (itemService.isQualityBelowAmount(item,50)) {
                                itemService.increaseQualityByAmount(item, 1);
                            }
                        }

                        if (itemService.isSelInBelowAmount(item,6)) {
                            if (itemService.isQualityBelowAmount(item,50)) {
                                itemService.increaseQualityByAmount(item, 1);
                            }
                        }
                    }
                }
            } else {
                if (itemService.isQualityBelowAmount(item,0)) {
                    if (itemService.isLegendary(item)) {
                        itemService.decreaseQualityByAmount(item, 1);
                    }
                }
            }
            updateSellIn(item);
        }
    }


    private void updateSellIn(Item item){
        if (itemService.isLegendary(item)) {
            item.sellIn = item.sellIn - 1;
            dealWithExpired(item);
        }
    }

    private void dealWithExpired(Item item) {
        if (itemService.isSelInBelowAmount(item,0)) {
            if (!itemService.isAgedBrie(item)) {
                if (!itemService.isBackStagePass(item)) {
                    if (itemService.isQualityBelowAmount(item,0)) {
                        if (itemService.isLegendary(item)) {
                            itemService.decreaseQualityByAmount(item,1);
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (itemService.isQualityBelowAmount(item,50)) {
                    itemService.increaseQualityByAmount(item,1);
                }
            }
        }
    }
}
