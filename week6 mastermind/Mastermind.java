import javax.swing.JFrame;

public class Mastermind {

	public static void main(String[] args) {

		JFrame frame = new JFrame("MASTERMIND");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new MastermindPanel());

		frame.pack();
		frame.setVisible(true);
	}
}
