package com.josephbrumaghim.jlang.keywords;

import com.josephbrumaghim.jlang.Execution;

public class SetPointer extends Keyword {
	
	private String pName;
	private Object val;

	public SetPointer() {
		super(2);
	}

	@Override
	public void load(Object[] args) {
		this.pName = (String) args[0];
		this.val = args[1];

	}

	@Override
	public Object execute() {
		Execution.pointers.put(pName, val);
		return val;
	}

}
