import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MastermindGame extends JFrame implements ActionListener {

	// main method creating an instance of MastermindGame
	public static void main(String[] args) {
		MastermindGame gameLaunch = new MastermindGame();
		gameLaunch.setTitle(gameLaunch.title);
	}

	// instance variables
	MastermindSystem gameSystem;
	GuessPanel guessPanel;
	PegPanel pegPanel;
	CluePanel cluePanel;
	MenuPanel menuPanel;
	SolutionPanel solution;
	int matchCounter;
	String title;

	// constructor
	public MastermindGame() {

		title = "Mastermind";
		gameSystem = new MastermindSystem();
		matchCounter = 0;

	    setSize(600, 400);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new BorderLayout());

	    // initialize panels
	    guessPanel = new GuessPanel();
	    add(guessPanel, BorderLayout.WEST);
	    pegPanel = new PegPanel();
	    add(pegPanel, BorderLayout.SOUTH);
	    cluePanel = new CluePanel();
	    add(cluePanel, BorderLayout.EAST);
	    menuPanel = new MenuPanel();
	    add(menuPanel, BorderLayout.NORTH);
	    solution = new SolutionPanel();
	    add(solution, BorderLayout.CENTER);

	    setVisible(true);

	    //add action listener to menu buttons
	    menuPanel.newGameButton.addActionListener(this);
	    menuPanel.quitButton.addActionListener(this);
	    menuPanel.giveUpButton.addActionListener(this);
	    menuPanel.undoButton.addActionListener(this);
	    menuPanel.howToPlay.addActionListener(this);

	    //add action listener to color buttons
	    pegPanel.redButton.addActionListener(this);
	    pegPanel.yellowButton.addActionListener(this);
	    pegPanel.blueButton.addActionListener(this);
	    pegPanel.greenButton.addActionListener(this);
	    pegPanel.pinkButton.addActionListener(this);
	    pegPanel.magentaButton.addActionListener(this);

	} // end of MastermindGame constructor

	// handle button clicks
	public void actionPerformed(ActionEvent event) {

	// 'How to Play' clicked
		if (event.getSource().equals(menuPanel.howToPlay)) {
			JOptionPane.showMessageDialog(null, "Mastermind is a memory puzzle game where the objective is to " +
												"guess the\ncorrect arrangement of colored pegs within a " +
												"certain number of guesses.");
			JOptionPane.showMessageDialog(null, "Begin by clicking the colored peg you think is in the first location, " +
												"followed by clicking the colored peg you think is in the second location, " +
												"and so on.\nOnce all four guesses are entered the computer will leave a cue " +
												"if any are correct." +
												"\n\n1.  A white peg means that one of the guessed pegs is correctly in the right location and is the right color. " +
												"\n2.  A red peg means that one of the guessed pegs is correct in terms of color, but the location is wrong. " +
												"\n3.  A black peg means that one of the guessed pegs is incorrect, both in color and location.");

	// 'New Game' clicked
		} else if (event.getSource() == menuPanel.newGameButton) {
			// reset panels to default gray color
		    guessPanel.setDefaultColors();
		    cluePanel.setDefaultColors();
		    solution.setDefaultColors();
		    // generate new random solution
		    solution.setSolutionArray();
		    // begin new game
			gameSystem.newGame();
			return;

	// 'Quit' clicked
		} else if (event.getSource() == menuPanel.quitButton) {
			// close program
			System.exit(0);

		// check that a game is active
		} else if (gameSystem.getIsRunning() == true) {

	// 'Give Up' clicked
			if (event.getSource() == menuPanel.giveUpButton) {
				// end the current game and show solution
				gameSystem.gameOver();
				solution.showSolution();
				return;

	// 'Undo' clicked
			} else if (event.getSource() == menuPanel.undoButton) {
				// undo the most recent color picked
				gameSystem.undoMove();
				guessPanel.getPanel(gameSystem.getTurn(), gameSystem.getGuessPos()).setBackground(Color.gray);
				// check to see if undo still available
				if (!gameSystem.undoAllowed()) {
					menuPanel.disableUndo();
				}
				return;

	// when color pegs clicked, set active guess panel's background color to match
			} else if (event.getSource() == pegPanel.redButton) {
				guessPanel.getPanel(gameSystem.getTurn(), gameSystem.getGuessPos()).setBackground(Color.red);
			} else if (event.getSource() == pegPanel.yellowButton) {
				guessPanel.getPanel(gameSystem.getTurn(), gameSystem.getGuessPos()).setBackground(Color.yellow);
			} else if (event.getSource() == pegPanel.blueButton) {
				guessPanel.getPanel(gameSystem.getTurn(), gameSystem.getGuessPos()).setBackground(Color.blue);
			} else if (event.getSource() == pegPanel.greenButton) {
				guessPanel.getPanel(gameSystem.getTurn(), gameSystem.getGuessPos()).setBackground(Color.green);
			} else if (event.getSource() == pegPanel.pinkButton) {
				guessPanel.getPanel(gameSystem.getTurn(), gameSystem.getGuessPos()).setBackground(Color.pink);
			} else if (event.getSource() == pegPanel.magentaButton) {
				guessPanel.getPanel(gameSystem.getTurn(), gameSystem.getGuessPos()).setBackground(Color.magenta);
			}

			// check guess when turn is complete
			checkGuess();
			gameSystem.nextGuess();
			// enable or disable undo option if appropriate
			if (gameSystem.undoAllowed()) {
				menuPanel.enableUndo();
			} else menuPanel.disableUndo();

		} // end of if statement for active game
	} // end of actionPerformed method

	// method to check the current completed turn against the solution
	public void checkGuess() {
		if (gameSystem.getGuessPos() == 3) {
			// reset match counter
			matchCounter = 0;
			// compare each guess against entire solution
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					// continue if the guess matches any part of the solution
					if (guessPanel.getPanel(gameSystem.getTurn(), i).getBackground() == solution.getPanel(j).getBackground()) {
						// if the match is in the same position in the guess and solution, it is marked correct and program jumps to next position
						if (i == j) {
							cluePanel.getPanel(gameSystem.getTurn(), i).setBackground(Color.WHITE);
							matchCounter++;
							break;
						// if the match positions are in different places, it is a partial match and is marked red
						} else {
							cluePanel.getPanel(gameSystem.getTurn(), i).setBackground(Color.RED);
						}
					// if no match is found for the current guess position, the matching clue panel is darkened
					} else if (j == 3 && cluePanel.getPanel(gameSystem.getTurn(), i).getBackground() == Color.gray){
						cluePanel.getPanel(gameSystem.getTurn(), i).setBackground(Color.DARK_GRAY);
					}
				}
			}
			// if all guess positions are correct, you win!
			if (matchCounter == 4) {
				gameSystem.gameOver();
				solution.showSolution();
			} else if (gameSystem.getTurn() == 9 && gameSystem.getGuessPos() == 3) {
				gameSystem.gameOver();
				solution.showSolution();
			}
		}
	}
} // end of MastermindGame class