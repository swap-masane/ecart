package com.ecart.constant;

/**
 * Enum to hold different Account Types with there membership discounts
 * 
 * @author swapnilm
 *
 */
public enum AccountType {
	GOLD_MEMBER(10.0), SILVER_MEMBER(5.0), NON_MEMBER(0.0);

	private AccountType(Double discount) {
		this.discount = discount;
	}

	private final double discount;

	public double getDiscount() {
		return this.discount;
	}

}
