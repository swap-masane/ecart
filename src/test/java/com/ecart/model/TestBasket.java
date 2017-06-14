//package com.ecart.model;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.EnumMap;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.ecart.constant.ExceptionConstants;
//import com.ecart.constant.ItemType;
//import com.ecart.exception.RbcException;
//
//public class TestBasket {
//
//	private Basket basket;
//	private Item item;
//	private EnumMap<ItemType, List<Item>> itemMap;
//
//	@Before
//	public void initialize() {
//		item = new Item();
//		item.setType(ItemType.APPLE);
//		item.setDescription("Its an apple");
//		item.setItemId(1);
//		// initialize list
//		List<Item> itemList = new ArrayList<>();
//		itemList.add(item);
//		// initialize map
//		itemMap = new EnumMap<>(ItemType.class);
//		itemMap.put(ItemType.APPLE, itemList);
//		basket = new Basket();
//	//	basket.setItemMap(itemMap);
//	}
//
//	@Test
//	public void testAddItemWithNull() {
//		assertEquals(false, basket.addItem(null));
//	}
//
//	@Test
//	public void testAddItemReturnWithNull() {
//		boolean returnVal = basket.addItem(null);
//		assertEquals(false, returnVal);
//	}
//
//	@Test
//	public void testAddItemReturnWithValidItem() {
//		item = new Item();
//		item.setDescription("Its an orange");
//		item.setItemId(1001);
//		item.setType(ItemType.ORANGE);
//		boolean returnVal = basket.addItem(item);
//		assertEquals(true, returnVal);
//		
//		assertTrue(1001==basket.getItemMap().get(ItemType.ORANGE).get(0).getItemId());
//		assertEquals("Its an orange", basket.getItemMap().get(ItemType.ORANGE).get(0).getDescription()  );
//	}
//
//	@Test
//	public void testAddItemWithNewItem() {
//		item = new Item();
//		item.setType(ItemType.ORANGE);
//		assertEquals(true, basket.addItem(item));
//	}
//
//	@Test
//	public void testAddItemWithValidItem() {
//		assertEquals(true, basket.addItem(item));
//	}
//
//	@Test
//	public void testAddItemWithNullMap() {
//		basket.setItemMap(null);
//		assertEquals(true, basket.addItem(item));
//	}
//
//	@Test
//	public void testAddItemWithNullList() {
//		basket.setItemMap(itemMap);
//		basket.getItemMap().put(ItemType.APPLE, null);
//
//		assertEquals(true, basket.addItem(item));
//	}
//
//	@Test
//	public void testRemoveItemWithNull() {
//		assertEquals(false, basket.removeItem(null));
//	}
//
//	@Test
//	public void testRemoveItemWithInvalidItem() {
//		// orange is not in the test basket
//		item = new Item();
//		item.setType(ItemType.ORANGE);
//
//		assertEquals(false, basket.removeItem(item));
//	}
//
//	@Test
//	public void testRemoveWithValidItem() {
//		assertEquals(true, basket.removeItem(item));
//	}
//
//	@Test
//	public void testRemoveItemWithNullMap() {
//		basket.setItemMap(null);
//		assertEquals(false, basket.removeItem(item));
//	}
//
//	@Test
//	public void testRemoveItemWithNullList() {
//		basket.setItemMap(itemMap);
//		basket.getItemMap().put(ItemType.APPLE, null);
//		assertEquals(false, basket.removeItem(item));
//	}
//
//	@Test
//	public void testGenerateBillWithNullMap() {
//		basket.setItemMap(null);
//		try{
//			basket.generateBill();
//		}catch (RbcException e) {
//			assertEquals(ExceptionConstants.EMPTY_BASKET_EXCEPTION, e.getExceptionType());
//		}
//	}
//
//
//	@Test
//	public void testGenerateBillForSingleBasket() throws RbcException {
//		assertTrue(basket.generateBill() == 20.0);
//
//	}
//	
//	@Test
//	public void testGenerateBillForMultipleBasket() throws Exception {
//		item = new Item();
//		item.setType(ItemType.LEMON);
//		item.setDescription("Its an Lemon");
//		item.setItemId(1);
//		// initialize list
//		List<Item> itemList = new ArrayList<>();
//		itemList.add(item);
//		
//		item = new Item();
//		item.setType(ItemType.LEMON);
//		item.setDescription("Its an Lemon");
//		item.setItemId(2);
//		itemList.add(item);
//		
//		// initialize map
//		itemMap.clear();
//		itemMap.put(ItemType.LEMON, itemList);
//		
//		basket.setItemMap(itemMap);
//		assertTrue(basket.generateBill() == 10.0);
//
//	}
//	
//	@Test
//	public void testGenerateBillForEmptyList() throws Exception {
//		itemMap.put(ItemType.APPLE, null);
//		basket.setItemMap(itemMap);
//		assertTrue(basket.generateBill() == 0);
//
//	}
//	
//
//}
