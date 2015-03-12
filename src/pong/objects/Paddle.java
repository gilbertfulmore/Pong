package pong.objects;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
	private int screenHeight;
	//Paddle radius (used for ball collisions)
	private int x1, y1, x2, y2;
	private boolean moveUp = false;
	private boolean moveDown = false;
	
	public Paddle(int x1, 
				  int y1,  
				  int screenHeight) {
		this.x1 = x1;
		this.y1 = y1;
		this.screenHeight = screenHeight;
		
		this.x2 = x1 + 13;
		this.y2 = y1 + 70;
	}
	
	/*
	 * If moveUp == true then move up
	 * If moveUp == false then move down
	 */
	public void movePaddle() {
		if(y1 >= 0) {
			if(moveUp)
				y1-=2;
		}
		if(y2 <= screenHeight) {
			if(moveDown)
				y1+=2;
		}
	}
	
	public void paint(Graphics g, int x, int y) {
		x1 = x;
		y1 = y;
		x2 = x + 13;
		y2 = y + 70;
		g.setColor(Color.WHITE);
		g.drawRect(x, y, 13, 70);
		g.fillRect(x, y, 13, 70);
	}
	
	public int getX1() { return x1; }
	public int getY1() { return y1; }
	public int getX2() { return x2; }
	public int getY2() { return y2; }
	public boolean getMoveUp() { return moveUp; }
	public boolean getMoveDown() { return moveDown; }
	
	public void setX1(int x1) { this.x1 = x1; }
	public void setY1(int y1) { this.y1 = y1; }
	public void setX2(int x2) { this.x2 = x2; }
	public void setY2(int y2) { this.y2 = y2; }
	
	public void setMoveUp(boolean moveUp) { 
		this.moveUp = moveUp;
	}
	public void setMoveDown(boolean moveDown) { 
		this.moveDown = moveDown; 
	}
}