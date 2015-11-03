package com.josephbrumaghim.jlang.keywords;

public class Print extends Keyword {

	private Object obj;
	public Print() {
		super(1);
	}

	@Override
	public void load(Object[] obj) {
		this.obj = obj[0];
	}

	@Override
	public Object execute() {
		System.out.println(obj);
		return null;
	}

}
