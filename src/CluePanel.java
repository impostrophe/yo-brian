import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class CluePanel extends JPanel{

	//instance variable
	JPanel[][] cluePanel;
	
	// constructor
	public CluePanel() {
	    setLayout(new GridLayout(10,4,1,1));

	    // create the JPanel 2d array
	    cluePanel = new JPanel[10][4];

	    // initialize each JPanel and add it to the 2d array
	    for (int a = 0; a < cluePanel.length; a++) {
	        for (int b = 0; b < cluePanel[0].length; b++) {
	        	cluePanel[a][b] = new JPanel();
	        	add(cluePanel[a][b]);
	        }
	    }
	    
	    // panels are gray by default
	    setDefaultColors();

	    setVisible(true);
	}	

	// set each panel to its default color of gray
	public void setDefaultColors() {
	    for (int i = 0; i < cluePanel.length; i++) {
	    	for (int j = 0; j < cluePanel[i].length; j++) {
	    		cluePanel[i][j].setBackground(Color.GRAY);
	    	}
	    }
    }
	
	// get a specific panel from the 2d array
	public JPanel getPanel(int x, int y) {
		return cluePanel[x][y];
	}
	
} // end of CluePanel class
