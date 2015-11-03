package com.josephbrumaghim.jlang.keywords;

public abstract class Keyword {
	
	public int argsLength;

	public Keyword(int argsLength) {
		this.argsLength = argsLength;
	}
	
	public abstract void load(Object[] args);
	
	public abstract Object execute();
	
}
