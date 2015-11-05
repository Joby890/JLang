package com.josephbrumaghim.jlang.keywords;

import com.josephbrumaghim.jlang.Execution;

public class Mul extends Keyword {
	
	private int num1;
	private int num2;

	public Mul(Execution exec) {
		super(exec, 2);
	}

	@Override
	public void load(Object[] args) {
		
		if(args[0] instanceof String) {
			num1 = Integer.parseInt((String)args[0]);	
		} else {
			num1 = (int) args[0];
		}
		if(args[1] instanceof String) {
			num2 = Integer.parseInt((String)args[1]);	
		} else {
			num2 = (int) args[1];
		}
	}

	@Override
	public Object execute() {
		return num1 * num2;
	}

}
