package fr.istic.m2miage.aoc.dp.visitor.sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Document implements Element{
	private String text;
	private List<Section> sections = new ArrayList<Section>();
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void addSection(Section s){
		this.sections.add(s);
	}
	public void removeSection(Section s){
		this.sections.remove(s);
	}
	
	public Iterator<Section> sections(){
		return sections.iterator();
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitDocument(this);
	}
}
