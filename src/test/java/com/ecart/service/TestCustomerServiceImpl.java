package com.ecart.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.ecart.constant.AccountType;
import com.ecart.constant.ItemType;
import com.ecart.model.Basket;
import com.ecart.model.Customer;
import com.ecart.model.Item;

public class TestCustomerServiceImpl {
	CustomerService service;
	Customer customer ;
	
	@Before
	public void initialize(){
		service = new CustomerServiceImpl();
		customer = new Customer();
		// parameterized item just to makes sure price is overriden, so that expected results wont change 
		Item item = new Item(ItemType.APPLE, 20.0,0.0);
		item.setItemId(1);
		item.setType(ItemType.APPLE);
		item.setDescription("Its an Apple");
		
		Basket basket = new Basket();
		basket.addItem(item);
		customer.setBasket(basket);
		
	}
	
	@Test(expected=Exception.class)
	public void testCheckOutWithNulCustl() throws Exception{
		service.checkOut(null);
	}
	
	@Test(expected=Exception.class)
	public void testCheckOutWithNullBasket() throws Exception{
		// set basket to null
		customer.setBasket(null);
		service.checkOut(customer);
	}
	
	@Test
	public void testCheckOutWithGeneralCustomer() throws Exception{
		assertTrue(20.0== service.checkOut(customer));
	}
	
	@Test
	public void testCheckOutWithGoldCustomer() throws Exception{
		customer = new Customer();
		Item item = new Item();
		item.setItemId(1);
		item.setType(ItemType.APPLE);
		item.setDescription("Its an Apple");
		
		Basket basket = new Basket();
		basket.addItem(item);
		customer.setBasket(basket);
		customer.setAccountTYpe(AccountType.GOLD_MEMBER);
		assertTrue(18.0== service.checkOut(customer));
	}
	
	@Test
	public void testCheckOutWithSilverCustomer() throws Exception{
		customer = new Customer();
		Item item = new Item();
		item.setItemId(1);
		item.setType(ItemType.APPLE);
		item.setDescription("Its an Apple");
		
		Basket basket = new Basket();
		basket.addItem(item);
		customer.setBasket(basket);
		customer.setAccountTYpe(AccountType.SILVER_MEMBER);
		
		assertTrue(19.0== service.checkOut(customer));
	}
	

}
