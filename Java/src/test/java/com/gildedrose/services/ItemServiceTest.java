package com.gildedrose.services;

import com.gildedrose.Item;
import com.gildedrose.services.impl.ItemService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ItemServiceTest {


    private ItemService itemService = new ItemService();

    private Item sampleItem;

    @BeforeEach
    public void setup(){
        sampleItem = new Item("sample",10,5);
    }

    @Test
    public void testIncreaseQualityByAmount(){
        itemService.increaseQualityByAmount(sampleItem,5);
        assertEquals(10,sampleItem.quality);
    }

    @Test
    public void testDecreaseQualityByAmount(){
        itemService.decreaseQualityByAmount(sampleItem,5);
        assertEquals(0,sampleItem.quality);

    }

    @Test
    public void testIsSellInBelowAmount(){
        assertTrue(itemService.isSelInBelowAmount(sampleItem,5));
        assertFalse(itemService.isSelInBelowAmount(sampleItem,15));
    }

    @Test
    public void testIsQualityBelowAmount(){
        assertTrue(itemService.isQualityBelowAmount(sampleItem,4));
        assertFalse(itemService.isQualityBelowAmount(sampleItem,15));
    }



}
