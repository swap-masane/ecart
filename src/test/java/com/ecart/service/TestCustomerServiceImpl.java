package com.ecart.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.ecart.constant.AccountType;
import com.ecart.constant.ItemType;
import com.ecart.model.Basket;
import com.ecart.model.Customer;
import com.ecart.model.Item;

public class TestCustomerServiceImpl {
	
	private CustomerService service ;
	private Customer customer;
	private Item item;
	@Before
	public void initialize(){
		
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
	public void TestAddToBasket(){
		assertTrue(service.addToBasket(item));
	}
	
	@Test
	public void TestAddToBasketWithNull(){
		assertFalse(service.addToBasket(null));
	}
	
	@Test
	public void testRemoveBasket(){
		service.addToBasket(item);
		assertTrue(service.removeFromBasket(item));
	}
	
	@Test
	public void testRemoveBasketWithNull(){
		assertFalse(service.addToBasket(null));
	}
	
//	@Test
//	public void testClearBasket(){
//		assertFalse(service.clearBasket());
//	}
	
}
