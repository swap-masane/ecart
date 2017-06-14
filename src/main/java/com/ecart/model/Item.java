package com.ecart.model;

import com.ecart.constant.ItemType;

public class Item {

	private Integer itemId;
	private String description;
	private ItemType type;

	// default construcor
	public Item(){
		
	}

	/**
	 * Parameterized constructor if we need to override price or discount of items
	 * @param type
	 * @param price
	 * @param discount
	 */
	public Item(ItemType type, Double price, Double discount) {
		this.type = type;
		// methods to override discount or price.
		// If null is passed then do not overridee
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
