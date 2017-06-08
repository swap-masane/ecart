package com.ecart.service;

import com.ecart.exception.RbcException;
import com.ecart.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecart.service.CustomerService#checkOut(com.ecart.model.Customer)
	 */
	public double checkOut(Customer customer) throws RbcException {

		if (customer == null || customer.getBasket() == null) {
			throw new RbcException("EMPTHY_BASKET_EXCEPTION", new Exception("Basket is empty, Nothing to checkout."));
		}

		double basketBill = customer.getBasket().generateBill();

		double finalBill = basketBill - (basketBill * (customer.getAccountTYpe().getDiscount() / 100));
		return finalBill;

	}

	// TODO: We can have payment mode as -- offline /online, but consdering
	// thtat out of scope or this assignment

}
