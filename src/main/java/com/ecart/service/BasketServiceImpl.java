package com.ecart.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ecart.constant.ItemType;
import com.ecart.model.Basket;
import com.ecart.model.Item;

public class BasketServiceImpl implements BasketService {

	private final Basket basket;

	public BasketServiceImpl(Basket basket) {
		this.basket = basket;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecart.service.BasketService#addItem(com.ecart.model.Item)
	 */
	@Override
	public boolean addItem(Item item) {
		if (item == null) {
			return false;
		}
		return basket.getItemList().add(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecart.service.BasketService#removeItem(com.ecart.model.Item)
	 */
	@Override
	public boolean removeItem(Item item) {

		// if (item == null) {
		// return false;
		// }
		return basket.getItemList().remove(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ecart.service.BasketService#isBasketEmpty(com.ecart.model.Basket)
	 */
	@Override
	public boolean isBasketEmpty(Basket basket) {

		return (basket == null || basket.getItemList() == null || basket.getItemList().size() == 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecart.service.BasketService#calculateBaketCost()
	 */
	@Override
	public double calculateBaketCost() {

		if (isBasketEmpty(basket)) {
			return 0.0;
		}

		List<Item> itemList = basket.getItemList();

		// using lambada expression to find aggregated value of bill
		double basketCost = itemList.parallelStream().map(e -> e.getType().getDiscountedPrice()).reduce(0.0,
				(x, y) -> x + y);

		return basketCost;
	}

	
	
	@Override
	public void printItemizedBill() {

		if (isBasketEmpty(basket)) {
			// do nothing, just log the event
			return;
		}

		List<Item> itemList = basket.getItemList();

		String line = "---------------------------------------------------";
		System.out.println(line);
		System.out.println("Sr\tItem\tUnitPrice\tQty\tTotalCost");
		System.out.println(line);
		
		int serialNumber = 0;
		double itemizedSum;
		double totalBill = 0.0;
		
		// creating itemized map
		Map<ItemType, List<Item>> itemMap = itemList.stream().collect(Collectors.groupingBy(Item::getType));

		for (Map.Entry<ItemType, List<Item>> entry : itemMap.entrySet()) {
			serialNumber++;
			// Using parallel stream for faster processing, mapping it to price
			// and then using using reduce function to get sum of items by
			// its type
			itemizedSum = entry.getValue().parallelStream().map(e -> e.getType().getDiscountedPrice()).reduce(0.0,
					Double::sum);
			totalBill = totalBill + itemizedSum;
			
			System.out.println(getFormatedString(serialNumber, itemizedSum, entry.getKey(), entry.getValue()));
		}

		System.out.println(line);
		System.out.println("\t\t\t\tTotal : " + totalBill);

	}

	/**
	 * to format the string for printing
	 * 
	 * @param serialNumber
	 * @param itemizedSum
	 * @param entry
	 * @return
	 */
	private String getFormatedString(int serialNumber, double itemizedSum,ItemType type,  List<Item> itemList) {
		StringBuffer buffer = new StringBuffer();
		String tab = "\t";
		buffer.append(" ");
		buffer.append(serialNumber);
		buffer.append(tab);
		buffer.append(type);
		buffer.append(tab);
		buffer.append(type.getDiscountedPrice());
		buffer.append(tab);
		buffer.append(tab);
		buffer.append(itemList.size());
		buffer.append(tab);
		buffer.append(itemizedSum);
		buffer.append(tab);
		return buffer.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecart.service.BasketService#clearBasket()
	 */
	@Override
	public void clearBasket() {
		if (!isBasketEmpty(basket)) {
			basket.getItemList().clear();
		}
	}

}
