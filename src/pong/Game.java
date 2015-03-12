package pong;

import pong.objects.Ball;
import pong.objects.Paddle;
import pong.objects.PaddleAI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @Author: Gilbert Fulmore
 * @Version Alpha
 */

/* 
 * #debug commands#
 * java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("hh:mm:ss");
 * System.out.println("[" + dateFormat.format( new java.util.Date() ) + " INFO]: " + "[Message here]");
 */
public class Game extends JPanel implements Runnable {
	Controller 	  listener 	= new Controller();
	Paddle 		  playerPaddle  = new Paddle  (20, (Pong.height/2)-35, Pong.height);
	Paddle 		  aiPaddle 	= new Paddle  (Pong.width-33, (Pong.height/2)-35, Pong.height);
	Ball   		  ball 	  	= new Ball    (playerPaddle,  aiPaddle, Pong.width, Pong.height);
	PaddleAI 	  aiController  = new PaddleAI(aiPaddle, ball);
	Thread 		  startGame     = new Thread  (this);
	
	public Game(JFrame frame) {
                frame.setVisible(true);
		frame.addKeyListener(listener);
		frame.setFocusable(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);	//Clears Screen
		//background
		g.setColor(Color.WHITE);
		g.drawRect(0, 0, Pong.width, Pong.height);	//outer boarder
		g.drawLine((Pong.width/2), 0, (Pong.width/2), Pong.height);	//center line
		g.drawOval((Pong.width/2)-15, (Pong.height/2)-15, 30, 30);	//center circle
		
		//score
		g.drawString("" + ball.getPlayerScore() , (Pong.width/2)-25, 25);
		g.drawString("" + ball.getAiScore(), 	  (Pong.width/2)+15, 25);
		
		//objects
		ball.paint(g);
		playerPaddle.paint(g, playerPaddle.getX1(), playerPaddle.getY1());
		aiPaddle.paint	  (g, aiPaddle.getX1(), 	aiPaddle.getY1());
	}
	
	public void gameSpeed(int fps) {
		try {
			Thread.sleep(1000/fps);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			playerPaddle.setMoveUp(listener.getKeyUp());		//up key listener
			playerPaddle.setMoveDown(listener.getKeyDown());	//down key listener
			playerPaddle.movePaddle();
			aiController.movePaddle();
			ball.moveBall();
			gameSpeed(240);	//speed = fps
			repaint();
		}
	}
}