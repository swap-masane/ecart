package com.ecart.service;

import com.ecart.model.Basket;
import com.ecart.model.Item;

public interface BasketService {

	/**
	 * Method to add item in basket
	 * 
	 * @param item
	 * @return
	 */
	public boolean addItem(Item item);

	/**
	 * Method to remove from basket
	 * 
	 * @param item
	 * @return
	 */
	public boolean removeItem(Item item);

	/**
	 * Checks if basket is empty
	 * 
	 * @param basket
	 * @return
	 */
	public boolean isBasketEmpty(Basket basket);

	/**
	 * Calculates basket value
	 * 
	 * @return
	 */
	public double calculateBaketCost();

	/**
	 * Method to clear basket
	 */
	public void clearBasket();

	/**
	 * MEthod to print Itemized Bill
	 */
	public void printItemizedBill();

}