import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PegPanel extends JPanel{

	// instance variables
    JButton redButton;
    JButton yellowButton;
    JButton blueButton;
    JButton greenButton;
    JButton magentaButton;
    JButton pinkButton;
	
    // constructor
	public PegPanel() {
	    setLayout(new GridLayout(2,3,15,15));
	    
	    // initialize and add each button to the panel
	    redButton = new JButton("Red");
	    add(redButton);
	    redButton.setBackground(Color.red);
	    yellowButton = new JButton("Yellow");
	    add(yellowButton);
	    yellowButton.setBackground(Color.yellow);
	    blueButton = new JButton("Blue");
	    add(blueButton);
	    blueButton.setBackground(Color.blue);
	    greenButton = new JButton("Green");
	    add(greenButton);
	    greenButton.setBackground(Color.green);
	    magentaButton = new JButton("Magenta");
	    add(magentaButton);
	    magentaButton.setBackground(Color.magenta);
	    pinkButton = new JButton("Pink");
	    add(pinkButton);
	    pinkButton.setBackground(Color.pink);

	    setVisible(true);
	}	

}
