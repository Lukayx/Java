package cl.uach.info090.recursividad;

import java.io.File;

public class FolderNavigation {

	public static void main(String[] args) {
		File[] files = new File(".").listFiles();
		listAllfiles(files,"* ");
	}
	
	public static void listAllfiles(File[] files, String t) {
	    for (File file : files) {
	        if (file.isDirectory()) {
	            System.out.println(t+"Directory: " + file.getName());
	            listAllfiles(file.listFiles(),t+"   "); 
	        } else {
	            System.out.println(t+"File: " + file.getName());
	        }
	    }
	}

}
