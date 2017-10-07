import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MenuPanel extends JPanel {

	JButton newGameButton;
    JButton quitButton;
    JButton giveUpButton;
    JButton undoButton;
    JButton howToPlay;
    JButton logo;
    
	public MenuPanel() {
	    setSize(300, 600);
	    setLayout(new GridLayout(2,2,5,5));

	    
	    newGameButton = new JButton("New Game");
	    add(newGameButton);
	    quitButton = new JButton("Quit");
	    add(quitButton);
	    giveUpButton = new JButton("Give Up");
	    add(giveUpButton);
	    undoButton = new JButton("Undo");
	    add(undoButton);
	    undoButton.setEnabled(false);
	    howToPlay = new JButton("How to Play");
	    add(howToPlay);
	    logo = new JButton("", new ImageIcon("logo.gif"));
	    add(logo);
	    logo.setEnabled(false);
 
	    setVisible(true);    

	}
	
	// disable the undo button when appropriate
	public void disableUndo() {
	    undoButton.setEnabled(false);		
	}

	// enable the undo button when appropriate
	public void enableUndo() {
	    undoButton.setEnabled(true);		
	}
	
}
