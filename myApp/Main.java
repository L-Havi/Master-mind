package myApp;

import myApp.InputScannerApp;

public class Main {
	public static void main(String[] args) {
	    try {
	        InputScannerApp app = new InputScannerApp();
	        app.startApp();
	      } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error.");
	      	}	
	}
}
