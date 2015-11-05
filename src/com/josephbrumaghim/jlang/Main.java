package com.josephbrumaghim.jlang;

import java.io.File;
import java.util.List;

public class Main {
	
	private static final boolean DEBUG = true;
	private static final File dir = new File("./moduletest");
	
	private FileLoader loader;
	private Execution exec;
	
	
	public Main() {
		loader = new FileLoader();
		exec = new Execution(null);
		temp();
		//exec.executeFile(loader.loadFile("recus"));
	}
	
	public void temp() {
		List<File> files = loader.getJobyFiles(dir);
		for(File f : files) {
			exec.executeFile(f);
		}
	}
	
	public static void debug(Object print) {
		if(DEBUG) {
			System.out.println(print);
		}
	}
	
	
	public static void main(String[] args) {
		new Main();
	}
}
