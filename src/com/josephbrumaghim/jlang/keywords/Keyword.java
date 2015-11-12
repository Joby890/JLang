package com.josephbrumaghim.jlang.keywords;

import com.josephbrumaghim.jlang.Execution;

public abstract class Keyword {
	
	public int argsLength;
	public boolean block;
	public Execution exec;

	public Keyword(Execution exec, int argsLength) {
		this.exec = exec;
		this.argsLength = argsLength;
	}
	
	public Keyword(Execution exec, int argsLength, boolean block) {
		this.exec = exec;
		this.argsLength = argsLength;
		this.block = block;
	}
	
	public abstract void load(Object[] args);
	
	public void load(Object[] args, String[] blocks) {
		load(args);
	};
	
	public abstract Object execute();
	
}
