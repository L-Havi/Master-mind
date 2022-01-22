package myApp.models;

public class Game {

	public int[] rightRow = new int[4];
	public int[] guessRow = new int[4];
	
	public void setRightRow(int[] rightRow){
		this.rightRow = rightRow;
	}
	
	public int[] getRightRow(){
		return rightRow;
	}
	
	public void setGuessRow(int[] guessRow){
		this.guessRow = guessRow;
	}
	
	public int[] getGuessRow(){
		return rightRow;
	}
}
