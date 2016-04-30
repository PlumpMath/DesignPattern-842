package fr.istic.m2miage.aoc.dp.visitor.sample;

public class Section implements Element{
	private String text;
	
	public Section(String text) {
		this.text = text;
	}
	public String getText(){
		return text;
	}
	@Override
	public void accept(Visitor v) {
		v.visitSection(this);
	}
}
