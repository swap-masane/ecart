package com.ecart.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ecart.constant.AccountType;

public class TestCustomer {
	Customer customer;
	
	@Test
	public void testDefaultCustomer(){
		customer = new Customer();
		assertEquals(customer.getAccountTYpe(), AccountType.NON_MEMBER);
	}
	
	@Test
	public void testGoldMember(){
		customer = new Customer(AccountType.GOLD_MEMBER);
		assertEquals(customer.getAccountTYpe(), AccountType.GOLD_MEMBER);
	}

}
