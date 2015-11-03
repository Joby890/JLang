package com.josephbrumaghim.jlang.keywords;

import com.josephbrumaghim.jlang.Execution;

public class GetPointer extends Keyword {
	
	private String name;
	
	public GetPointer() {
		super(1);
	}

	@Override
	public void load(Object[] name) {
		this.name = (String) name[0];
	}

	@Override
	public Object execute() {
		return Execution.pointers.get(name);
	}
	
}
