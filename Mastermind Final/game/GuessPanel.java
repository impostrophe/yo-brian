import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class GuessPanel extends JPanel {

	// instance variable
	JPanel[][] guessPanelArray;
	
	// constructor
	public GuessPanel() {
	    setLayout(new GridLayout(10,4,1,1));

	    // create 2d array of Jpanels
	    guessPanelArray = new JPanel[10][4];
	    
	    // initialize each JPanel and add it to the 2d array
	    for (int a = 0; a < guessPanelArray.length; a++) {
	        for (int b = 0; b < guessPanelArray[0].length; b++) {
	        	guessPanelArray[a][b] = new JPanel();
	        	add(guessPanelArray[a][b]);
	        }
	    }
	    
	    // panels are gray by default
	    setDefaultColors();
	    
	    setVisible(true);
	}
	
	// set each panel to its default color of gray
	public void setDefaultColors() {
	    for (int i = 0; i < guessPanelArray.length; i++) {
	    	for (int j = 0; j < guessPanelArray[i].length; j++) {
	    		guessPanelArray[i][j].setBackground(Color.GRAY);
	    	}
	    }
	}
	
	// get a specific panel from the 2d array
	public JPanel getPanel(int x, int y) {
		return guessPanelArray[x][y];
	}

} // end of GuessPanel class
