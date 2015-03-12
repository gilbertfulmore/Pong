package pong.objects;

import java.util.Random;

public class PaddleAI {
	Paddle aiPaddle;
	Ball ball;
	Random rn = new Random();
	
	public PaddleAI(Paddle aiPaddle, Ball ball) {
		this.aiPaddle = aiPaddle;
		this.ball = ball;
	}
	
	public void movePaddle() {
		
		int rand = rn.nextInt((10 - 0) + 10) + 0;
		if(ball.getE()) {
			if(!(aiPaddle.getY1() <=0)) {
				if(ball.getY2() < aiPaddle.getY1()+35) {
					if(rand == 0) {
					} else if(rand == 1 || rand == 2) {
						aiPaddle.setY1(aiPaddle.getY1()-2);
					} else {
						aiPaddle.setY1(aiPaddle.getY1()-1);
					}
				}
			}
			if(!(aiPaddle.getY2() > 350)) {
				if(ball.getY1() > aiPaddle.getY1()+35) {
					if(rand == 0) {
					} else if(rand == 1 || rand == 2) {
						aiPaddle.setY1(aiPaddle.getY1()+2);
					} else {
						aiPaddle.setY1(aiPaddle.getY1()+1);
					}
				}
			}
		}
		
	}	//end movePaddle()
	
}	//end class