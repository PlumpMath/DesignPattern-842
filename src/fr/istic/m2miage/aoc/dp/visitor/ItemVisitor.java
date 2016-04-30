package fr.istic.m2miage.aoc.dp.visitor;

import fr.istic.m2miage.aoc.dp.model.Book;
import fr.istic.m2miage.aoc.dp.model.CD;
import fr.istic.m2miage.aoc.dp.model.Cosmetics;

public interface ItemVisitor {
	public void visit (CD cd);
	public void visit (Cosmetics cd);
	public void visit (Book cd);
}
