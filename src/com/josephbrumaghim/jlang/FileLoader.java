package com.josephbrumaghim.jlang;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
	
	
	
	public static List<File> getJobyFiles(File dir) {
		List<File> files = new ArrayList<>();
		for(File f : dir.listFiles()) {
			if(f.isDirectory()) {
				files.addAll(getJobyFiles(f));
			} else {
				boolean endsWith = f.getName().endsWith(".joby");
				if(endsWith) {
					files.add(f);
				}
			}
		}
		return files;
	}
	

	public static File loadFile(String name) {
		return new File(name + ".joby");
	}
	
	
}
