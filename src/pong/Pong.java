package pong;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * PONG
 * 
 * @author Gilbert Fulmore
 * @version 2014-07-15
 */
public class Pong extends JPanel {

	static int width = 600;
	static int height = 350;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Pong");
		Game game = new Game(frame);
		
		//frame.setSize(width+17, height+40);
		frame.setSize(width+7, height+30);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		frame.add(game);
		
		game.setOpaque(true);	//transparent (needed for background)
		game.setBackground(Color.BLACK);
		game.startGame.start();
		
	}
}