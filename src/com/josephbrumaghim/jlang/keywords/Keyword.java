package com.josephbrumaghim.jlang.keywords;

public abstract class Keyword {
	
	public int argsLength;
	public boolean block;

	public Keyword(int argsLength) {
		this.argsLength = argsLength;
	}
	
	public Keyword(int argsLength, boolean block) {
		this.argsLength = argsLength;
		this.block = block;
	}
	
	public abstract void load(Object[] args);
	
	public void load(Object[] args, String block) {
		load(args);
	};
	
	public abstract Object execute();
	
}
