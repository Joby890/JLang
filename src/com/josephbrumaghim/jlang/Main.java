package com.josephbrumaghim.jlang;

import java.io.File;
import java.util.List;

public class Main {
	
	private static final boolean DEBUG = false;
	private static final File dir = new File("./files");
	
	private Execution exec;
	
	
	public Main() {
		exec = new Execution(null);
	}
	
	public void run(File dir, File main) {
		if(dir.isDirectory()) {
			List<File> files = FileLoader.getJobyFiles(dir);
			for(File f : files) {
				exec.executeFile(f);
			}
		}

		if(main != null) {
			exec.executeFile(main);
		}

	}
	
	public static void debug(Object print) {
		if(DEBUG) {
			System.out.println(print);
		}
	}
	
	
	public static void main(String[] args) {
		Main main = new Main();
		if(args.length == 0) {
			Main.debug("Running Joby main default directory.");
			main.run(Main.dir, null);
		} else if(args.length == 1) {
			Main.debug("Running Joby main on file " + args[0] + " with default directory");
			main.run(new File(args[0]), null);	
		} else {
			Main.debug("Running Joby main on file: " + args[0] + " adding to execution " + args[1] + ".");
			main.run(new File(args[1]), new File(args[0]));
		}
	}
}
