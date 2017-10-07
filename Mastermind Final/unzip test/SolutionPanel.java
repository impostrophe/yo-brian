import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class SolutionPanel extends JPanel {

	// instance variables
	JPanel[] solutionArray;
	JPanel[] solutionHiddenArray;
	int randomNum;
	Random rand = new Random();
	
	public SolutionPanel() {
	    setLayout(new GridLayout(1,4,5,5));

	    // create the solution array and the blank array to show while the game is running
	    solutionArray = new JPanel[4];
	    solutionHiddenArray = new JPanel[4];
	    
	    for (int a = 0; a < solutionArray.length; a++) {
	    	solutionArray[a] = new JPanel();
	    	// uncomment next line to always show solution for testing
	    	// add(solutionArray[a]);	        
	    	}
	    
	    // initialize each JPanel and add it to the array
	    for (int a = 0; a < solutionHiddenArray.length; a++) {
	    	solutionHiddenArray[a] = new JPanel();
	        add(solutionHiddenArray[a]);
	        }	    
	    
	    // panels are gray by default
	    setDefaultColors();
	    
	    // generate a random solution
	    setSolutionArray();
	    
	    setVisible(true);
	}
	
	// set each panel to its default color of gray
	public void setDefaultColors() {
	    for (int i = 0; i < solutionHiddenArray.length; i++) {
	    	solutionHiddenArray[i].setBackground(Color.GRAY);
	    }
    }
	
	// get a specific panel from the array
	public JPanel getPanel(int x) {
		return solutionArray[x];
	}
	
	// generate a random solution
	public void setSolutionArray() {
	    for (int i = 0; i < solutionArray.length; i++) {
	    	randomNum = ThreadLocalRandom.current().nextInt(0, 6);
	    	
	    	switch (randomNum) {
	    		case 0:
	    				solutionArray[i].setBackground(Color.RED);
	    				break;
	    		case 1:
	    				solutionArray[i].setBackground(Color.YELLOW);		
	    				break;
	    		case 2:
	    				solutionArray[i].setBackground(Color.BLUE);		
	    				break;
	    		case 3:
	    				solutionArray[i].setBackground(Color.GREEN);		
	    				break;
	    		case 4:
	    				solutionArray[i].setBackground(Color.pink);		
	    				break;
	    		case 5:
	    				solutionArray[i].setBackground(Color.MAGENTA);		
	    				break;
	    	
	    	}
	    }	
	}
	
	// display the solution
	public void showSolution() {
		for (int i = 0; i < 4; i++) {
		solutionHiddenArray[i].setBackground(solutionArray[i].getBackground());
		}
	}
	
} // end of SolutionPanel class
