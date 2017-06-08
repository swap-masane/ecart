package com.ecart.service;

import com.ecart.exception.RbcException;
import com.ecart.model.Customer;

public interface CustomerService {
	/**
	 * CHeckout from customer end. It will apply customer discounts before
	 * generating finall bill
	 * 
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	public double checkOut(Customer customer) throws RbcException;

}
