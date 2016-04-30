package fr.istic.m2miage.aoc.dp.visitor.sample;

import java.util.Iterator;

public class PrettyPrinter implements Visitor{
	
	public void print(Document d){
		d.accept(this);
	}

	@Override
	public void visitDocument(Document d) {
		System.out.println("Document : "  + d.getText());
		for(Iterator<Section> section = d.sections(); section.hasNext();){
			section.next().accept(this);
		}
	}
	
	@Override
	public void visitSection(Section s) {
		System.out.println("Section : "  + s.getText());
	}
}
