public class MastermindSystem {
	
	// instance variables
	private boolean isRunning;
	private int turn;
	private int guessPos;

	// constructor
	public MastermindSystem() {
		isRunning = true;
		turn = 0;
		guessPos = 0;
	}
	
	// check for an active game
	public boolean getIsRunning() {
		return isRunning;
	}
	
	// get the current turn (10 total)
	public int getTurn() {
		return turn;
	}
	
	// get the position of the next guess (4 per turn)
	public int getGuessPos() {
		return guessPos;
	}
	
	// begin a game
	public void newGame() {
		turn = 0;
		guessPos = 0;
		isRunning = true;
	}
	
	// end the current game
	public void gameOver() {
		isRunning = false;
	}

	// undo a guess up to the beginning of the current turn
	public void undoMove() {
		guessPos--;
	}
	
	// check to see if player can use undo button
	public boolean undoAllowed() {
		if (guessPos > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// if there is an active game and rules allow, advance the turn or move to the next turn
	public void nextGuess() {
		if (guessPos < 3) {
			guessPos++;
		} else {
			turn++;
			guessPos = 0;				
		}
	}
	
} // end of MastermindSystem class