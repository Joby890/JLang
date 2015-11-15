package com.josephbrumaghim.jlang.keywords;

import com.josephbrumaghim.jlang.Execution;

public class Loop extends Keyword {
	
	private If ifkey;
	private String pointerX;
	private String pointerY;
	private String block;
	private Object modifer;

	public Loop(Execution exec) {
		super(exec, 3, true);
		ifkey = new If(exec);
	}

	@Override
	public void load(Object[] args) {}
	
	@Override
	public void load(Object[] args, String[] blocks) {
		pointerX = (String) args[0];
		pointerY = (String) args[2];
		this.modifer = args[1];
		this.block = blocks[0];
	}

	@Override
	public Object execute() {
		Object result = null;
		ifkey.load(new Object[]{findExecution(pointerX).pointers.get(pointerX), modifer, findExecution(pointerY).pointers.get(pointerY)}, new String[]{block});
		while(ifkey.check()) {
			result = ifkey.run(true);
			ifkey.load(new Object[]{findExecution(pointerX).pointers.get(pointerX), modifer, findExecution(pointerY).pointers.get(pointerY)}, new String[]{block});
		}
		return result;
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
