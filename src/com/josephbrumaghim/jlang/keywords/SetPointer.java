package com.josephbrumaghim.jlang.keywords;

import com.josephbrumaghim.jlang.Execution;

public class SetPointer extends Keyword {
	
	private String pName;
	private Object val;

	public SetPointer(Execution exec) {
		super(exec, 2);
	}

	@Override
	public void load(Object[] args) {
		this.pName = (String) args[0];
		this.val = args[1];

	}

	@Override
	public Object execute() {
		findExcecution(pName).pointers.put(pName, val);
		return val;
	}
	/**
	 * Find execution to for pointer to be set too.
	 * 
	 * Looks for pointer up execution chain
	 * if not found returns current exec;
	 * @param name
	 * @return
	 */
	public Execution findExcecution(String name) {
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
