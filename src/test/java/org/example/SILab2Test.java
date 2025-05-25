package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {


    @Test
    void testNullItemsList() {
        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(null, "1234567890123456"));
        assertEquals("allItems list can't be null!", ex.getMessage());
    }


    @Test
    void testExpensiveAndDiscountedItem() {
        List<Item> items = List.of(new Item("D", 2, 400, 0.25));
        double result = SILab2.checkCart(items, "1111222233334444");

        assertEquals(570.0, result, 0.0001);
    }


    @Test
    void testInvalidItemName() {
        List<Item> items = List.of(new Item(null, 1, 50, 0.0));
        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(items, "1234567890123456"));
        assertEquals("Invalid item!", ex.getMessage());
    }


    @Test
    void testInvalidCardNumberLength() {

        List<Item> items = List.of(new Item("A", 1, 500, 0.0));
        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(items, "1234"));
        assertEquals("Invalid card number!", ex.getMessage());
    }


    @Test
    void testInvalidCardNumberChar() {
        List<Item> items = List.of(new Item("A", 1, 10, 0.0));
        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(items, "1234ABCD5678EFGH"));
        assertEquals("Invalid character in card number!", ex.getMessage());
    }
    @Test
    void testCondition_TXX_priceGT300() {

        Item it = new Item("X", 1, 301, 0.0);
        double result = SILab2.checkCart(List.of(it), "0000111122223333");

        assertEquals(271.0, result, 1e-6);
    }


    @Test
    void testCondition_FTX_discountGT0() {

        Item it = new Item("Y", 1, 300, 0.5);
        double result = SILab2.checkCart(List.of(it), "0000111122223333");

        assertEquals(120.0, result, 1e-6);
    }


    @Test
    void testCondition_FFT_qtyGT10() {

        Item it = new Item("Z", 11, 300, 0.0);
        double result = SILab2.checkCart(List.of(it), "0000111122223333");

        assertEquals(3270.0, result, 1e-6);
    }


    @Test
    void testCondition_FFF_allFalse() {

        Item it = new Item("W", 10, 300, 0.0);
        double result = SILab2.checkCart(List.of(it), "0000111122223333");

        assertEquals(3000.0, result, 1e-6);
    }
}
