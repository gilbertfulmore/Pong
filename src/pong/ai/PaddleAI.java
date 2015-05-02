package pong.ai;

import pong.objects.*;

public class PaddleAI {
	Paddle aiPaddle;
	Ball ball;
	
	public PaddleAI(Paddle aiPaddle, Ball ball) {
		this.aiPaddle = aiPaddle;
		this.ball = ball;
	}
	
	public void movePaddle() {
		if(ball.getE() && ball.getX1() > 300) {
			if(!(aiPaddle.getY1() <= 0)) {
				if(ball.getY2() < aiPaddle.getY1() + 35) {
					aiPaddle.setY1(aiPaddle.getY1() - 1);
				}
			}
			if(!(aiPaddle.getY2() > 350)) {
				if(ball.getY1() > aiPaddle.getY1() + 35) {
					aiPaddle.setY1(aiPaddle.getY1() + 1);
				}
			}
		}
	}	//end movePaddle()
	
}	//end class
