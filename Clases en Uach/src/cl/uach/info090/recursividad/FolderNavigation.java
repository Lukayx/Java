package cl.uach.info090.recursividad;

import java.io.File;

public class FolderNavigation {

	public static void main(String[] args) {
		File[] files = new File(".").listFiles();
		listAllfiles(files);

	}
	
	public static void listAllfiles(File[] files) {
	    for (File file : files) {
	        if (file.isDirectory()) {
	            System.out.println("Directory: " + file.getName());
	            listAllfiles(file.listFiles()); 
	        } else {
	            System.out.println("File: " + file.getName());
	        }
	    }
	}

}
