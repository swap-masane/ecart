package com.ecart.constant;

/**
 * Enum to hold Item types, with their price and discounts. Methods are provided
 * to override ItemPrce and discounts.
 * 
 * @author swapnilm
 *
 */
public enum ItemType {
	BANANA(10, 0), ORANGE(15, 0), APPLE(20, 0), LEMON(5, 0), PEACH(10, 0);

	private double price;
	private double discount;

	/**
	 * Gets discounted price.
	 * price minus discounts on origional price
	 * @return - double 
	 */
	public double getDiscountedPrice() {
		return price - (price * (discount / 100));
	}

	ItemType(double price, double discount) {
		this.discount = discount;
		this.price = price;
	}

}