//package com.ecart.model;
//
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Test;
//
//import com.ecart.constant.ItemType;
//
//public class TestItem {
//	Item item;
//
//	@Test
//	public void testParameterisedItem() {
//		item = new Item(ItemType.BANANA, new Double(15), new Double(20));
//		assertTrue(12.0 == item.getType().getDiscountedPrice());
//	}
//
//	@Test
//	public void testParameterisedItemWIthNull() {
//		item = new Item(ItemType.LEMON, null, null);
//		assertTrue(5.0 == item.getType().getDiscountedPrice());
//	}
//
//	@Test
//	public void testParameterisedItemWIthNullPrice() {
//		item = new Item(ItemType.ORANGE, null, 10.0);
//		System.out.println(item.getType().getDiscountedPrice());
//		assertTrue(13.5== item.getType().getDiscountedPrice());
//	}
//
//	@Test
//	public void testParameterisedItemWIthNullDiscount() {
//		item = new Item(ItemType.PEACH, 15.0, null);
//		assertTrue(15.0 == item.getType().getDiscountedPrice());
//	}
//}
