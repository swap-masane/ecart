package com.ecart.service;

import com.ecart.model.Customer;
import com.ecart.model.Item;

public class CustomerServiceImpl implements CustomerService {

	// injecting basket
	private BasketService basketService;

	// injecting customer
	private Customer customer;

	// parameterized constructor to initialize service
	public CustomerServiceImpl(Customer customer) {
		this.customer = customer;
		basketService = new BasketServiceImpl(customer.getBasket());
	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.ecart.service.CustomerService#checkOut(com.ecart.model.Customer)
	 */
	public void checkOut() {
		// If we need checkout to be part of some other interface,
		// we can have billing service and handle other methods like payment
		// mode, but keeping it out of scope for this assignment

		double totalBill = getCustomerBillAfterDiscounts();
		basketService.printItemizedBill();
		// prints discounted bill.
		// System.out.println("Final bill after discount :" + totalBill);
		payAndEmptyBasker(totalBill);
	}

	/**
	 * Applies Customer discount and returns the final bill
	 * 
	 * @return
	 */
	public double getCustomerBillAfterDiscounts() {
		double basketBill = basketService.calculateBaketCost();
		return basketBill - (basketBill * (customer.getAccountTYpe().getDiscount() / 100));
	}

	/**
	 * Dummy method to pay bill, for elaborated application, we can have BIlling
	 * service, which can take care of this **?
	 * 
	 */
	private void payAndEmptyBasker(double finalBill) {
		// billingService.pay(finalBill);
		// reset basket
		basketService.clearBasket();

	}

	@Override
	public boolean addToBasket(Item item) {
		return basketService.addItem(item);
	}

	@Override
	public boolean removeFromBasket(Item item) {
		return basketService.removeItem(item);
	}

	@Override
	public void clearBasket() {
		basketService.clearBasket();
	}

}
