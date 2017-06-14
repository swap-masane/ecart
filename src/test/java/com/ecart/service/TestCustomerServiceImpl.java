package com.ecart.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.powermock.reflect.Whitebox;

import com.ecart.constant.AccountType;
import com.ecart.constant.ItemType;
import com.ecart.model.Basket;
import com.ecart.model.Customer;
import com.ecart.model.Item;

public class TestCustomerServiceImpl {

	private CustomerService service;
	private Customer customer;
	private Item item;
	
	@InjectMocks
	 BasketService mockBasket;
	
	@InjectMocks
	BasketService mockBasketService = mock(BasketService.class);
	@InjectMocks
	CustomerServiceImpl mockService;

	@Before
	public void initialize() {

		customer = new Customer();
		customer.setFirstName("John");
		customer.setLastName("Doe");
		customer.setAccountTYpe(AccountType.GOLD_MEMBER);
		customer.setBasket(new Basket());
		service = new CustomerServiceImpl(customer);

		item = new Item();
		item.setDescription("Apple");
		item.setItemId(1);
		item.setType(ItemType.APPLE);

	}

	@Test
	public void TestAddToBasket() {
		assertTrue(service.addToBasket(item));
	}

	@Test
	public void TestAddToBasketWithNull() {
		assertFalse(service.addToBasket(null));
	}

	@Test
	public void testRemoveBasket() {
		service.addToBasket(item);
		assertTrue(service.removeFromBasket(item));
	}

	@Test
	public void testRemoveBasketWithNull() {
		assertFalse(service.addToBasket(null));
	}

	@Test
	public void TestGetCustomerBillAfterDiscounts() {
		// initialize new apple
		item = new Item();
		item.setDescription("Apple");
		item.setItemId(1);
		item.setType(ItemType.APPLE);
		// add two apples into basket
		service.addToBasket(item);
		service.addToBasket(item);
		assertTrue(36.0 == service.getCustomerBillAfterDiscounts());
	}
	
	
	@Test
	public void testPayAndEmptyBasker(){
		CustomerServiceImpl customerService = new CustomerServiceImpl(customer); 
		customerService.addToBasket(item);

		assertTrue(customerService.getCustomerBillAfterDiscounts() == 18.0);
		
		try {
			 Whitebox.invokeMethod(customerService, "payAndEmptyBasker", (double)20);
		} catch (Exception e) {
			fail("Change is signature of methods, method innocation failed");
		}
		
		assertTrue(customerService.getCustomerBillAfterDiscounts() == 0.0);
	}

}
