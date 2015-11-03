package com.josephbrumaghim.jlang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
	
	private FileLoader loader;
	private Execution exec;
	
	public Main() {
		loader = new FileLoader();
		exec = new Execution();
		temp();
	}
	
	public void temp() {
		try {
			File f = loader.loadFile("test");
			BufferedReader br = new BufferedReader(new FileReader(f));			
			while(br.ready()) {
				exec.executeLine(br.readLine());
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	public static void main(String[] args) {
		new Main();
	}
}
