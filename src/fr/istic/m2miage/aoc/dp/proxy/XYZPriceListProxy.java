package fr.istic.m2miage.aoc.dp.proxy;

/**
 * synchronized proxy class for XYZPriceList
 */
public class XYZPriceListProxy implements PriceList {
	// assume that we only have two items in the pricelist
	Integer[] locks = { new Integer(1), new Integer(2) };// locks for each item in the price list
	public static PriceList singleInstance = new XYZPriceListProxy();// single instance of XYZPriceListProxy
	PriceList realPriceList = XYZPriceList.getInstance(); // real object

	public static PriceList getInstance() {
		return singleInstance;
	}

	public double getPrice(int itemId) {
		synchronized (locks[itemId]) {
			return realPriceList.getPrice(itemId);
		}
	}

	public void setPrice(int itemId, double newPrice) {
		synchronized (locks[itemId]) {
			realPriceList.setPrice(itemId, newPrice);
		}
	}
}