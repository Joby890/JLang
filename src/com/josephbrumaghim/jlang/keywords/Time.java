package com.josephbrumaghim.jlang.keywords;

import com.josephbrumaghim.jlang.Execution;

public class Time extends Keyword {
	
	public Time(Execution exec) {
		super(exec, 0);
	}

	@Override
	public void load(Object[] args) {}

	@Override
	public Object execute() {
		return (int) System.currentTimeMillis();
	}

}
