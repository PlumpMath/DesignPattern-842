package fr.istic.m2miage.aoc.dp.factory;

import fr.istic.m2miage.aoc.dp.model.Book;
import fr.istic.m2miage.aoc.dp.model.CD;
import fr.istic.m2miage.aoc.dp.model.Cosmetics;
import fr.istic.m2miage.aoc.dp.model.Item;
import fr.istic.m2miage.aoc.dp.model.ItemException;
import fr.istic.m2miage.aoc.dp.model.ItemType;
/**
* GoodsFactory responsible for creating Item objects like CD, Book, and Cosmetics etc
*/
public class GoodsFactory implements ItemFactory {
	protected GoodsFactory() {
	} // protected so that only ItemFactorySelector within this package can

	// instantiate it to provide a single point of access
	// (i.e. singleton).
	/**
	 * Factory method, which decides how to create Items.
	 *
	 * Benefits are: -- loosely-couples the client (i.e. ShoppingBasketBuilder
	 * class) from Items such as CD, Book, and Cosmetics etc. In future if we
	 * need to create a Book item, which is imported, we can easily incorporate
	 * this by adding a new item.TYPE_BOOK_IMPORTED and subsequently adding
	 * following piece of code as shown:
	 *
	 * else if(itemType == TYPE_BOOK_IMPORTED){
	 *
	 * item = new Book(description, qty,price);
	 *
	 * item.setIsImported(true); }
	 *
	 * -- It is also possible to create an object cache or object pool of our
	 * items instead of creating a new instance every time without making any
	 * changes to the calling class. -- Java does not support overloaded
	 * constructors which take same parameter list. Instead, use several factory
	 * methods. E.g. getImportedItem(int itemType, String description, int qty,
	 * double price), getTaxedItem (int itemType ....) etc
	 */
	public Item getItem(ItemType itemType, String description, int qty, double price) throws ItemException {
		
		Item item = null;

		switch (itemType) {
		case BOOK:
			item = new Book(description, qty, price);
			break;
		case CD:
			item = new CD(description, qty, price);
			break;
		case CD_IMPORTED:
			item = new CD(description, qty, price);
			item.setImported(true);
			break;
		case COSMETICS:
			item = new Cosmetics(description, qty, price);
			break;
		}

		return item; 
	}

}
