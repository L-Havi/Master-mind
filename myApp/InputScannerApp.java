package myApp;

import myApp.models.Game;

import utils.InputScanner;

import java.util.Arrays;

public class InputScannerApp {

  private static InputScanner scanner = new InputScanner();
  
  static String info = "Type: (use enter after input)\n";

  public void startApp() {
	 
	String[] arr = new String[1];
	int playedGames = 0;
	int highScore = 0;
	  
    System.out.println("\tGame\n" + "------------------------------------------------------------------\n\t" + info + "\tstart\n" + "\tinstructions\n" + "\tquit\n");
    try {
    		arr = scanner.scanArguments(1);
    		if (arr[0].equals("start")) {
    	        startGame(playedGames, highScore);
    	    } else if (arr[0].equals("instructions")) {
    	    	instructions();
            } else if (arr[0].equals("quit")) {
                quitGame();
            } else {
                System.out.println("Nothing selected.");
                startApp();
            }    	   
    }catch (Exception e) {
    	System.out.println("Error! " + e.getMessage());
    }
  }
  
  private static void startGame(int playedGames, int highScore) {
	  InputScannerApp app = new InputScannerApp();
	  String[] arr = new String[1];
	  int[] sampleArr = new int[4];
	  int[] inputArr = new int[4];
	  int currentScore = 0;
	  int x = 0;
	  int X = 0;
	  
	  Game game = new Game();
	  
	  boolean[] test = new boolean[game.rightRow.length];
	  
	  for (int i = 0; i < game.rightRow.length; i++) {
		  sampleArr[i] = (int)(Math.random()*6) + 1;
	  }
	  game.setRightRow(sampleArr);
	  
	  do {
		  System.out.println("\t" + info + "\tType in 4 numbers between 1-6 one by one");
		  String args[] = scanner.scanArguments(4);
		  if (args.length == 4) {
		      try {
		    	inputArr[0] = Integer.parseInt(args[0]);
		    	inputArr[1] = Integer.parseInt(args[1]);
		    	inputArr[2] = Integer.parseInt(args[2]);
		    	inputArr[3] = Integer.parseInt(args[3]);
		        game.setGuessRow(inputArr);
		      } catch (NumberFormatException nfe) {
		        nfe.printStackTrace();
		      }
		      //checking if given row matches correct row. Might have incorrect hints sometimes when correct row has 2 same values
			  for (int i = 0; i < game.rightRow.length; i++) {
				  if(game.rightRow[i] == game.guessRow[i]) {
			          test[i] = true;
					  X++;
				  }				 
			  }
			  for (int i=0 ; i<game.rightRow.length; i++) {
				    if (game.rightRow[i] != game.guessRow[i]) {
				        for (int j=0 ; j<game.rightRow.length; j++) {
				            if(!test[j] && j!=i && game.guessRow[j] == game.rightRow[i]) {
				                test[j] = true;
				                x++; 
				                break;
				            }
				        }
				    }   
				}
		  }
		  currentScore++;
		  if(Arrays.equals(game.rightRow, game.guessRow)) {
			  if(playedGames == 0) {
				  highScore = currentScore;
			  } else {
				  if(highScore > currentScore) {
					  highScore = currentScore;
				  }
			  }
			  System.out.print("\tYou have won the game\n\tYour row was: ");
			  for(int i = 0;i <  game.guessRow.length; i++) {
				  System.out.print(game.guessRow[i] + " ");
			  } 
			  System.out.print("\n\tCorrect row was: ");
			  for(int i = 0;i <  game.rightRow.length; i++) {
				  System.out.print(game.rightRow[i] + " ");
			  } 
			  System.out.println("\n\tYou needed " + currentScore + " tries to guess the right row" + "\n\tHigh score is " + highScore);
		  } else{
			  System.out.print("\tYour row: ");
			  for(int i = 0;i <  game.guessRow.length; i++) {
				  System.out.print(game.guessRow[i] + " ");
			  } 
			  System.out.println("\n\tRight numbers in right position: " + X + "\n\tRight numbers in wrong position: " + x);
		  }
		  x = 0;
		  X = 0;
	  } while(!(Arrays.equals(game.rightRow, game.guessRow)));
	  
	playedGames++;
	System.out.println("\tDo you want to play a new game or return to main menu? new/menu");
	arr = scanner.scanArguments(1);
	if (arr[0].equals("new")) {
        startGame(playedGames, highScore);
    } else if (arr[0].equals("menu")) {
    	app.startApp();
    } else {
        System.out.println("Nothing selected.");
    }
  }
  
  private static void instructions() {
	  String[] arr = new String[1];
	  InputScannerApp app = new InputScannerApp();
	  System.out.println("------------------------------------------------------------------------------------------------------------------------------------");	  
	  System.out.println("\t\r\n"
	  		+ "\tThe program generates a secret code by dialing four numbers from 1 to 6, for example 6163.\r\n"
	  		+ "\r\n"
	  		+ "\tAs the solver, you enter the first guess, for example 1233, and get the answer one in the correct and correct place (third)\n\tand one in the wrong place (first). This continues until the player guesses the correct code. The goal is to come up\n\twith code with as few guesses as possible");	 
	  System.out.println("------------------------------------------------------------------------------------------------------------------------------------");	 
	  System.out.println("\t" + info + "\tEnter anything to return to main menu");
	    try {
    		arr = scanner.scanArguments(1);
    		if (arr.length == 1) {
    	        app.startApp();
    	    } 	   
    }catch (Exception e) {
    	System.out.println("Error! " + e.getMessage());
    }
  }
  
  private static void quitGame() {
	  String[] arr = new String[1];
	  System.out.println(info + "Do you really want to quit the game? yes/no");
	  InputScannerApp app = new InputScannerApp();
	    try {
	    		arr = scanner.scanArguments(1);
	    		if (arr[0].equals("yes")) {
	    	        System.exit(0);
	    	    } else if (arr[0].equals("no")) {
	    	    	app.startApp();
	            } else {
	                System.out.println("Nothing selected.");
	                quitGame();
	            }    	   
	    }catch (Exception e) {
	    	System.out.println("Error! " + e.getMessage());
	    }
  }
}
