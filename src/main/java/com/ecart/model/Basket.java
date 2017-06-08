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
import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;

import com.ecart.constant.ExceptionConstants;
import com.ecart.constant.ItemType;
import com.ecart.exception.RbcException;

public class Basket {

	private EnumMap<ItemType, List<Item>> itemMap;

	public EnumMap<ItemType, List<Item>> getItemMap() {
		return itemMap;
	}

	public void setItemMap(EnumMap<ItemType, List<Item>> itemMap) {
		this.itemMap = itemMap;
	}

	/**
	 * Method to add item in basket
	 * 
	 * @param item
	 * @return
	 */
	public boolean addItem(Item item) {
		if (itemMap == null) {
			itemMap = new EnumMap<>(ItemType.class);
		}
		if (item != null && item.getType() != null) {
			List<Item> itemList = itemMap.get(item.getType());
			if (itemList == null) {
				itemList = new ArrayList<Item>();
				itemMap.put(item.getType(), itemList);
			}
			return itemList.add(item);
		}

		return false;
	}

	/**
	 * Method to remove item from basket
	 * 
	 * @param item
	 * @return boolean
	 */
	public boolean removeItem(Item item) {
		if (item != null &&  itemMap !=null) {
			List<Item> itemList = itemMap.get(item.getType());
			if (itemList != null && itemList.contains(item)) {
				return itemList.remove(item);
			}

		}

		return false;
	}

	/**
	 * Method to get billing cost. Billing cost is ( total cost of items in
	 * basket - discount to customer ) Individual items can have discounts as
	 * well as customers can have different discounts. we can have custom
	 * exceptions thrown. For time Constraint, lets just throw normal Exception
	 * 
	 * @param temList
	 * @return
	 * @throws Exception
	 * 
	 */
	public double generateBill() throws RbcException {

		if (itemMap == null || itemMap.size() == 0) {
			throw new RbcException(ExceptionConstants.EMPTY_BASKET_EXCEPTION, new Exception("Basket is empty"));
		}
		double billAmount = 0;
		List<Item> itemList;
		double itemUnitPrice = 0;

		for (Entry<ItemType, List<Item>> entry : itemMap.entrySet()) {
			itemUnitPrice = entry.getKey().getDiscountedPrice();
			itemList = entry.getValue();
			if (itemList != null) {
				billAmount = billAmount + (itemList.size() * itemUnitPrice);
			}
		}
		
		return billAmount;

	}

}
