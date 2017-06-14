package com.ecart.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

import com.ecart.constant.ItemType;
import com.ecart.model.Basket;
import com.ecart.model.Item;

public class TestBasketService {

	private BasketService basketserice;
	private Item item;
	private Basket basket;

	@Before
	public void initialize() {
		basketserice = new BasketServiceImpl(new Basket());
		item = new Item();
		item.setDescription("Apple");
		item.setItemId(1);
		item.setType(ItemType.APPLE);
		basket = new Basket();

	}

	@Test
	public void testAddItemWithNull() {
		assertEquals(false, basketserice.addItem(null));
	}

	@Test
	public void testAddItemWithValidItem() {
		assertEquals(true, basketserice.addItem(item));
	}

	@Test
	public void testRemoveItemWithNull() {
		assertEquals(false, basketserice.removeItem(null));
	}

	@Test
	public void testRemoveItemWithValidItem() {
		basketserice.addItem(item);
		assertEquals(true, basketserice.removeItem(item));
	}

	@Test
	public void testIsBasketEmptyWithNull() {
		basket = null;
		assertEquals(true, basketserice.isBasketEmpty(basket));
	}

	@Test
	public void testIsBasketEmptyWithNValidItem() {
		basket = new Basket();
		basket.setOrderId(1);
		basket.getItemList().add(item);
		assertEquals(false, basketserice.isBasketEmpty(basket));
	}

	@Test
	public void testIsBasketEmptyWithNewBasket() {
		basket = new Basket();
		assertEquals(true, basketserice.isBasketEmpty(basket));
	}

	@Test
	public void testIsBasketEmptAfterAddAndRemove() {
		basket = new Basket();
		basketserice.addItem(item);
		basketserice.removeItem(item);
		assertEquals(true, basketserice.isBasketEmpty(basket));
	}

	@Test
	public void printItemizedBillWithNull() {
		BasketService basketserice = new BasketServiceImpl(null);
		basketserice.printItemizedBill();

	}

	@Test
	public void testcClculateBaketCostWIthNullBasket() {
		BasketService basketserice = new BasketServiceImpl(null);
		assertTrue(0.0 == basketserice.calculateBaketCost());

	}

	@Test
	public void testcClculateBaketCostWIthEmptyBasket() {
		BasketService basketserice = new BasketServiceImpl(new Basket());
		assertTrue(0.0 == basketserice.calculateBaketCost());

	}

	@Test
	public void testcClculateBaketCostWItValidBasket() {
		BasketService basketserice = new BasketServiceImpl(new Basket());
		fillBasket(basketserice);
		assertTrue(85.0 == basketserice.calculateBaketCost());

	}

	@Test
	public void testClearBasket() {
		Basket basket = new Basket();
		BasketService basketserice = new BasketServiceImpl(basket);
		fillBasket(basketserice);
		assertEquals(basket.getItemList().size(), 5);
		basketserice.clearBasket();
		assertEquals(basket.getItemList().size(), 0);
	}

	@Test
	public void testClearBasketWithNullBasket() {
		Basket basket = null;
		BasketService basketserice = new BasketServiceImpl(basket);
		try {
			basketserice.clearBasket();
		} catch (Exception e) {
			Assert.fail("Exception occured while clearing empty basket ");
		}
	}

	@Test
	public void testClearBasketMock() {
		BasketService basketserice = mock(BasketServiceImpl.class);
		basketserice.clearBasket();
		verify(basketserice).clearBasket();
	}

	@Test
	public void testPrintItemizedBill() {
		Basket basket = new Basket();
		BasketService basketserice = new BasketServiceImpl(basket);
		BasketService basketsericeSpy = Mockito.spy(basketserice);
		basketsericeSpy.printItemizedBill();
		basketsericeSpy.printItemizedBill();
		verify(basketsericeSpy, times(2)).printItemizedBill();

	}

	@Test
	public void testPrivatePrintMethod() {
		Basket basket = new Basket();
		BasketService basketserice = new BasketServiceImpl(basket);
		String formatString = null;
		try {
			 formatString = Whitebox.invokeMethod(basketserice, "getFormatedString", 1, 20.0, ItemType.APPLE, new ArrayList<>());
		} catch (Exception e) {
			fail("Change is signature of methods, method innocation failed");
		}
		
		assertTrue(formatString.contains("APPLE") );
		assertTrue(formatString.contains("20.0") );
		
		
	}
	private void fillBasket(BasketService service) {
		Item item = new Item();
		item.setDescription("Apple");
		item.setItemId(1);
		item.setType(ItemType.APPLE);
		service.addItem(item);

		item = new Item();
		item.setDescription("Apple");
		item.setItemId(1);
		item.setType(ItemType.APPLE);
		service.addItem(item);

		item = new Item();
		item.setDescription("Orange");
		item.setItemId(1);
		item.setType(ItemType.ORANGE);
		service.addItem(item);

		item = new Item();
		item.setDescription("Orange");
		item.setItemId(1);
		item.setType(ItemType.ORANGE);
		service.addItem(item);

		item = new Item();
		item.setDescription("Orange");
		item.setItemId(1);
		item.setType(ItemType.ORANGE);
		service.addItem(item);

	}

}
