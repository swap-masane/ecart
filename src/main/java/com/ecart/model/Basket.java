/**
 * Problem Statement :
 * Please write a program that takes a basket of items and outputs its total cost.
 * The basket can contain one or more of the following items:
 * Bananas, Oranges, Apples, Lemons, Peaches"
 */

/**
 *  Basket is a cart which has itemMap - a enum map of items and its list.
 */
package com.ecart.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

	private int orderId;

	final private List<Item> itemList = new ArrayList<>();

	
	public List<Item> getItemList() {
		return itemList;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	

}
