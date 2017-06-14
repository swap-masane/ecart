package com.ecart.service;

/**
 * CustomerService to handle customer requests like add,remove, clear or checkout.
 * It can also have additional methods like Pay(mode), login, sing up, but considering them out of scope for this assignment
 * CustomerService internally uses basket service
 */

import com.ecart.model.Item;

public interface CustomerService {
	/**
	 * CHeckout from customer end. It will apply customer discounts before
	 * generating final bill
	 * 
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	public void checkOut();

	/**
	 * Method to reset basket
	 */
	public void clearBasket();

	/**
	 * Method to add item into basket, this will internally call basket service.
	 * 
	 * @param item
	 * @return
	 */
	public boolean addToBasket(Item item);

	/**
	 * Method to remove item from basket, this will internally call basket
	 * service.
	 * 
	 * @param item
	 * @return
	 */
	public boolean removeFromBasket(Item item);
	
	
	/**
	 * Gets final customer bill after applying discounts 
	 * @return
	 */
	public double getCustomerBillAfterDiscounts(); 

}
