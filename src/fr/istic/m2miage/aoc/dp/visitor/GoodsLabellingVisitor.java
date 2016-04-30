package fr.istic.m2miage.aoc.dp.visitor;

import fr.istic.m2miage.aoc.dp.model.Book;
import fr.istic.m2miage.aoc.dp.model.CD;
import fr.istic.m2miage.aoc.dp.model.Cosmetics;

public class GoodsLabellingVisitor implements ItemVisitor {
	public void visit(CD cd) {
		markWithCatalogNumber(cd);
	}
	public void visit(Cosmetics cosmetics) {
		markWithColorNumber(cosmetics);
	}
	public void visit(Book book) {
		markWithISBNNumber(book);
	}
	private void markWithCatalogNumber(CD cd) {
		System.out.println("Catalog number for : " + cd.getDescription());
	}
	private void markWithColorNumber(Cosmetics cosmetics) {
		System.out.println("Color number for : " + cosmetics.getDescription());
	}
	public void markWithISBNNumber(Book book) {
		System.out.println("ISBN number for : " + book.getDescription());
	}

}
