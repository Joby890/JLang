package com.josephbrumaghim.jlang.keywords;

import java.io.File;

import com.josephbrumaghim.jlang.Execution;
import com.josephbrumaghim.jlang.FileLoader;

public class Import extends Keyword {
	
	private File toload;
	
	public Import(Execution exec) {
		super(exec, 1);
	}
	@Override
	public void load(Object[] args) {
		toload = FileLoader.loadFile(""+args[0]);
	}

	@Override
	public Object execute() {
		exec.executeFile(toload);
		return null;
	}
	
	
	

}
