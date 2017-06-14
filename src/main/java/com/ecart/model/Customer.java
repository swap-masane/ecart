package com.ecart.model;

import com.ecart.constant.AccountType;
/**
 * Customer class for customer who would be shoppig
 * @author SwapnilM
 *
 */
public class Customer {

	private String firstName;
	private String lastName;
	private Basket basket;
	private AccountType accountTYpe;

	// Default Account type is Non_member, unless explicitely specified
	public Customer() {
		this.accountTYpe = AccountType.NON_MEMBER;
	}

	// Default Account type is Non_member, unless explicitely specified
	public Customer(AccountType accountTYpe) {
		this.accountTYpe = accountTYpe;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public AccountType getAccountTYpe() {
		return accountTYpe;
	}

	public void setAccountTYpe(AccountType accountTYpe) {
		this.accountTYpe = accountTYpe;
	}

}
