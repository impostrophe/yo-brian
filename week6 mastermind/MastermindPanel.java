import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.text.NumberFormat;

public class MastermindPanel extends JPanel {

	private JButton newGame, num1, num2, num3, num4, num5, num6, clear, enter, exit, howToPlay, logo; // Buttons for GUI
	private JLabel displayArea, instructionArea; // displayArea reiterates buttons pressed. instructionArea provides information for the user
	private JPanel buttonPanel; // Panel for all the buttons
	private int guess = 7777, guessAttempts = 0; // Initial user guess number and initial attempts
	private final int MAX_GUESS_ATTEMPTS = 3;
	private boolean guessMode = false;
	String welcomeMessage = "Please enter your guess using the button keypad.", saveDisplay; // saveDisplay saves the numbers entered by buttons to a variable

	public MastermindPanel() {
		newGame = new JButton("New Game");
		num1 = new JButton("1");
		num2 = new JButton("2");
		num3 = new JButton("3");
		num4 = new JButton("4");
		num5 = new JButton("5");
		num6 = new JButton("6");
		clear = new JButton("Clear");
		enter = new JButton("Enter");
		exit = new JButton("Exit");
		howToPlay = new JButton("How To Play");
		logo = new JButton("", new ImageIcon("LOGO.gif")); // Bottom right logo

		// Add listener for buttons
		ButtonListener listener = new ButtonListener();

		newGame.addActionListener(listener);
		num1.addActionListener(listener);
		num1.setBackground(Color.red);
		num2.addActionListener(listener);
		num2.setBackground(Color.yellow);
		num3.addActionListener(listener);
		num3.setBackground(Color.blue);
		num4.addActionListener(listener);
		num4.setBackground(Color.orange);
		num5.addActionListener(listener);
		num5.setBackground(Color.green);
		num6.addActionListener(listener);
		num6.setBackground(Color.magenta);
		clear.addActionListener(listener);
		enter.addActionListener(listener);
		exit.addActionListener(listener);
		howToPlay.addActionListener(listener);

		// Layout manager for the entire window
		setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
		setBackground(Color.black); // Set background color
		setMinimumSize(new Dimension(600, 200));
		setPreferredSize(new Dimension(600, 375));

		instructionArea = new JLabel(welcomeMessage);
		displayArea = new JLabel();

		instructionArea.setForeground(Color.white);
		instructionArea.setPreferredSize(new Dimension(580, 150));
		instructionArea.setMaximumSize(new Dimension(580, 150));
		instructionArea.setAlignmentX(Component.CENTER_ALIGNMENT);

		displayArea.setForeground(Color.white);
		displayArea.setPreferredSize(new Dimension(550, 25));
		displayArea.setMaximumSize(new Dimension(550, 25));
		displayArea.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Create button panel component and assign color and dimensions
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.lightGray); // Sets buttonPanel background color

		buttonPanel.add(num1);
		buttonPanel.add(num2);
		buttonPanel.add(num3);
		buttonPanel.add(num4);
		buttonPanel.add(num5);
		buttonPanel.add(num6);
		buttonPanel.add(clear);
		buttonPanel.add(enter);
		buttonPanel.add(newGame);
		buttonPanel.add(exit);
		buttonPanel.add(howToPlay);
		buttonPanel.add(logo);
		buttonPanel.setLayout(new GridLayout (4, 4)); // Create layout manager for the button panel

		// Add to GUI and create spaces using createRigidArea
		add(Box.createRigidArea(new Dimension (0, 10)));
		add(instructionArea);
		add(Box.createRigidArea(new Dimension (0, 5)));
		add(displayArea);
		add(Box.createRigidArea(new Dimension (0, 5)));
		add(buttonPanel);

		// Disable buttons
		clear.setEnabled(false);
		enter.setEnabled(false);
		newGame.setEnabled(true);
		logo.setEnabled(false);
	}

	// Create listener for the buttons using action event
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			// Add numeric buttons. Consecutive button presses are added to previous button inputs
			if (event.getSource().equals(num1)) {
				String buttonOneText = displayArea.getText() + num1.getText();
				displayArea.setText(buttonOneText);
			} else if (event.getSource().equals(num2)) {
				String buttonTwoText = displayArea.getText() + num2.getText();
				displayArea.setText(buttonTwoText);
			} else if (event.getSource().equals(num3)) {
				String buttonThreeText = displayArea.getText() + num3.getText();
				displayArea.setText(buttonThreeText);
			} else if (event.getSource().equals(num4)) {
				String buttonFourText = displayArea.getText() + num4.getText();
				displayArea.setText(buttonFourText);
			} else if (event.getSource().equals(num5)) {
				String buttonFiveText = displayArea.getText() + num5.getText();
				displayArea.setText(buttonFiveText);
			} else if (event.getSource().equals(num6)) {
				String buttonSixText = displayArea.getText() + num6.getText();
				displayArea.setText(buttonSixText);
			}

			// HOW TO PLAY
			if (event.getSource().equals(howToPlay)) {
				JOptionPane.showMessageDialog(null, "Mastermind is a two-player memory puzzle game where one player " +
													"chooses an assortment of colored\npegs in a specific pattern and " +
													"the second player has a certain number of tries to discover the " +
													"pattern.");
				JOptionPane.showMessageDialog(null, "The player places a guess of the code in one row. When the player " +
													"provides the input, the computer\nwill respond by placing the black " +
													"and white pieces to show how much of the guess is right: " +
													"\n\n1.  Each white peg means that one of the guessed pegs is correct, but is in the wrong hole. " +
													"\n2.  Each black peg means that one of the guessed pegs is correct, and is in the right hole.");
			}

			// Exit button
			if (event.getSource().equals(exit)) {
				System.exit(0);
			}

			// Clear button
			if (event.getSource().equals(clear)) {
				displayArea.setText("");
			}

			// Disables clear button if no value is present in the display.
			if (displayArea.getText().equals("")) {
				clear.setEnabled(false);
			} else {
				clear.setEnabled(true);
			}

			// Disables enter button if no value is present in the display.
			if (displayArea.getText().equals("")) {
				enter.setEnabled(false);
			} else {
				enter.setEnabled(true);
			}

			// Prompt for guess number and closes window after MAX_GUESS_ATTEMPTS
			if (!guessMode) {
				instructionArea.setText(welcomeMessage);
				if (guessAttempts < MAX_GUESS_ATTEMPTS) {
					if (event.getSource().equals(enter)) {
						saveDisplay = displayArea.getText(); // Parses buttons entered to a double to be used to check against initial guess
						double check = Double.parseDouble(saveDisplay);
						if (guess == check){
							instructionArea.setText("YOU WON! YOU GUESSED CORRECTLY!\n");
							displayArea.setText("");
							guessMode = true;

							// Enable num buttons
							num1.setEnabled(false);
							num2.setEnabled(false);
							num3.setEnabled(false);
							num4.setEnabled(false);
							num5.setEnabled(false);
							num6.setEnabled(false);

							// Disable unused buttons
							clear.setEnabled(false);
							enter.setEnabled(false);
							newGame.setEnabled(true);

						} else {
							guessAttempts ++;
							instructionArea.setText("That guess is incorrect. You have used " + guessAttempts + " of " + MAX_GUESS_ATTEMPTS + " guesses.");
							displayArea.setText("");
						}
					}
				} else {
					System.exit(0); // Exit once guesses run out
				}

			} else {

				// New Game
				if (event.getSource().equals(newGame)) {
					guessMode = false;
					displayArea.setText("");
					instructionArea.setText("Test");

					// Disable unused buttons
					clear.setEnabled(false);
					newGame.setEnabled(false);

					// Enable num buttons
					num1.setEnabled(true);
					num2.setEnabled(true);
					num3.setEnabled(true);
					num4.setEnabled(true);
					num5.setEnabled(true);
					num6.setEnabled(true);
				}
			}
		}
	}
}