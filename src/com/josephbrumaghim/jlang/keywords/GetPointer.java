package com.josephbrumaghim.jlang.keywords;

import com.josephbrumaghim.jlang.Execution;

public class GetPointer extends Keyword {
	
	private String name;
	
	public GetPointer(Execution exec) {
		super(exec, 1);
	}

	@Override
	public void load(Object[] name) {
		this.name = (String) name[0];
	}

	@Override
	public Object execute() {
		return findExecution(name).pointers.get(name);
	}
	
	
	public Execution findExecution(String name) {
		Execution current = exec;
		while(current != null) {
			if(current.pointers.containsKey(name)) {
				return current;
			} else {
				current = current.prev;
			}
		}
		return exec;
	}
}
