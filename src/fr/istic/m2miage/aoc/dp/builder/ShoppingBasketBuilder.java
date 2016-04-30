package fr.istic.m2miage.aoc.dp.builder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.istic.m2miage.aoc.dp.factory.ItemFactory;
import fr.istic.m2miage.aoc.dp.factory.ItemFactorySelector;
import fr.istic.m2miage.aoc.dp.model.Item;
import fr.istic.m2miage.aoc.dp.model.ItemException;
import fr.istic.m2miage.aoc.dp.model.ItemType;

/**
* Builder pattern: To simplify complex object creation by defining a class whose purpose is to
* build instances of another class.
* There is a subtle difference between a builder pattern and the factory pattern is that in builder
* pattern, the user is given the choice to create the type of object he/she wants but the
* construction process is the same. But with the factory method pattern the factory decides how to
* create one of several possible classes based on data provided to it.
*/
public class ShoppingBasketBuilder implements ItemBuilder {
	private List<Item> listItems = null;

	private void addItem(Item item) {
		if (listItems == null) {
			listItems = new ArrayList<Item>(20);
		}
		listItems.add(item);
	}

	/**
	 * builds a shopping basket
	 */
	public void buildBasket(ItemType itemType, String description, int qty,
			double unit_price) throws ItemException {
		// get the single instance of GoodsFactory using the singleton pattern
		// no matter how many times you call getInstance() you get access to the
		// same instance.
		ItemFactory factory = ItemFactorySelector.getItemFactory();
		// use factory method pattern to create item objects, based on itemType
		// supplied to it.
		Item item = factory.getItem(itemType, description, qty, unit_price);
		this.addItem(item); // adds the item to the basket
	}

	/**
	 * calculates total tax on the items in the built basket
	 */
	public double calculateTotalTax() throws ItemException {
		if (listItems == null) {
			throw new ItemException("No items in the basket");
		}
		double totalTax = 0.0;
		Iterator<Item> it = listItems.iterator();
		while (it.hasNext()) {
			Item item = (Item) it.next();
			totalTax += item.getExtendedTax();
		}
		return totalTax;
	}

	/**
	 * calculates total price on the items in the built basket
	 */
	public double calculateTotal() throws ItemException {
		if (listItems == null) {
			throw new ItemException("No items in the basket");
		}
		double total = 0.0;
		Iterator<Item> it = listItems.iterator();
		while (it.hasNext()) {
			Item item = (Item) it.next();
			total += item.getExtendedTaxPrice();
		}
		return total;
	}

	/**
	 * prints individual prices of the items in the built basket
	 */
	public void printExtendedTaxedPrice() throws ItemException {
		if (listItems == null) {
			throw new ItemException("No items in the basket");
		}
		//double totalTax = 0.0;
		Iterator<Item> it = listItems.iterator();
		while (it.hasNext()) {
			Item item = (Item) it.next();
			System.out.println(item + "" + item.getExtendedTaxPrice());
		}
	}

	public Iterator<Item> getIterator() {
		return listItems.iterator();
	}

	public fr.istic.m2miage.aoc.dp.iterator.ItemIterator getItemIterator() {
		return new ItemsIterator();
	}
	
	/**
	* inner class which iterates over basket of items
	*/
	class ItemsIterator implements fr.istic.m2miage.aoc.dp.iterator.ItemIterator {
		private int current = 0;
		private int step = 1;

		public Item nextItem() {
			Item item = null;
			current += step;
			if (!isDone()) {
				item = (Item) listItems.get(current);
			}
			return item;
		}

		public Item previousItem() {
			Item item = null;
			current -= step;
			if (!isDone()) {
				item = (Item) listItems.get(current);
			}
			return item;
		}

		public Item firstItem() {
			current = 0;
			return (Item) listItems.get(current);
		}

		public Item lastItem() {
			current = listItems.size() - 1;
			return (Item) listItems.get(current);
		}

		public boolean isDone() {
			return current >= listItems.size() ? true : false;
		}

		public Item currentItem() {
			if (!isDone()) {
				return (Item) listItems.get(current);
			} else {
				return null;
			}
		}

		public void setStep(int step) {
			this.step = step;
		}

	}

}
