package pong.objects;

import java.awt.Graphics;
import java.util.Random;

public class Ball {
    Paddle playerPaddle;
    Paddle aiPaddle;
    Random rd = new Random();
    private int screenWidth = 0;
    private int screenHeight = 0;
    private int x1 = 0;         //point 1
    private int y1 = 0;          
    private int x2 = 0;         //point 2
    private int y2 = 0;
    private int ballSlope = 1;
    private int playerScore = 0;
    private int aiScore     = 0;
    private boolean n = true;   //north
    private boolean s = false;  //south
    private boolean e = false;  //east
    private boolean w = true;   //west
    
    public Ball(Paddle playerPaddle, 
                Paddle aiPaddle, 
                int screenWidth, 
                int screenHeight) {
        this.playerPaddle = playerPaddle;
        this.aiPaddle = aiPaddle;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.x1 = screenWidth-175;
        this.y1 = screenHeight/2;
    }
    
    public Ball() {
       this.x1 = screenWidth-175;
       this.y1 = screenHeight/2;
    }
    
    public void moveBall() {
        //top wall
        if (y1 <= 0) {  //if ball hits top wall
            n = false;
            s = true;
        }
        //bottom wall
        if (y2 >= screenHeight) {   //if ball hits bottom wall
            n = true;
            s = false;
        }
        //left Wall
        if (x1 <= -15) {        //if ball hits left wall
            aiScored();
        }
        //right Wall
        if (x2 >= screenWidth) {    //if ball hits right wall
            playerScored();
        }
        //player Paddle collision
        if(x1 == playerPaddle.getX2()) {
            if( !(y2 < playerPaddle.getY1()) && !(y1 > playerPaddle.getY2())    ) {
                e = true;
                w = false;
                if( !(y2 < playerPaddle.getY1()) && !(y1 > (playerPaddle.getY1() + 5))  ) { //corner top of player paddle
                    if(s == false) {    //ball not moving south
                        n = true;
                        s = false;
                        if(!(playerPaddle.getMoveDown())) {
                            ballSlope++;
                        }
                    }
                }
                if( !(y1 > playerPaddle.getY2()) && !(y2 < (playerPaddle.getY2()-5))    ) { //bottom corner of player paddle
                    if(n == false) {
                        n = false;
                        s = true;
                        if(!(playerPaddle.getMoveUp())) {
                            ballSlope++;
                        }
                    }
                }
            }
        }
        //ai paddle collision
        if(x2 == aiPaddle.getX1()) {
            if(  !(y2 < aiPaddle.getY1()) && !(y1 > aiPaddle.getY2())   ) {
                e = false;
                w = true;
                if( !(y2 < aiPaddle.getY1()) && !(y1 > (aiPaddle.getY1() + 5))  ) { //corner top of ai paddle
                    if(s)
                    n = true;
                    s = false;
                    if(!(aiPaddle.getMoveDown())) {
                        ballSlope++;
                    }
                }
                if( !(y1 > aiPaddle.getY2()) && !(y2 < (aiPaddle.getY2()-5))    ) { //bottom corner of ai paddle
                    n = false;
                    s = true;
                    if(!(aiPaddle.getMoveUp())) {
                        ballSlope++;
                    }
                }
            }
        }
        //Advance ball position
        if (n)  {   //move ball up
            for(int k = 0; k < ballSlope; k++) {
                y1--;
            }
        }
        if (s)  {   //move ball down
            for(int k = 0; k < ballSlope; k++) {
                y1++;
            }   
        }
        if (e)  x1++;   //move ball right
        if (w)  x1--;   //move ball west
    }
    
    /* If AI scores spawn ball at AI */
    public void aiScored() {
        int rand = rd.nextInt((1 - 0) + 1) + 0;
        x1 = screenWidth - 450;
        y1 = screenHeight/2;
        if (rand == 0) {
            n = true;
            s = false;
        } else {
            n = false;
            s = true;
        }
        e = true;
        w = false;
        ballSlope = 1;
        aiScore++;
        
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /* If Player scores spawn ball at Player */
    public void playerScored() {
        int rand = rd.nextInt((1 - 0) + 1) + 0;
        x1 = screenWidth - 150;
        y1 = screenHeight/2;
        if (rand == 0) {
            n = false;
            s = true;
        } else {
            n = true;
            s = false;
        }
        e = false;
        w = true;
        ballSlope = 1;
        playerScore++;
        
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /* Redraw ball */
    public void paint(Graphics g) {
        x2 = x1 + 10;
        y2 = y1 + 10;
        g.drawOval(x1, y1, 10, 10);
        g.fillOval(x1, y1, 10, 10);
    }
    
    public int getX1() { 
        return x1; 
    }
    public int getY1() { 
        return y1; 
    }
    public int getX2() { 
        return x2; 
    }
    public int getY2() { 
        return y2; 
    }
    public int getBallSlope() { 
        return ballSlope; 
    }
    public boolean getN() { 
        return n; 
    }
    public boolean getS() { 
        return s; 
    }
    public boolean getE() { 
        return e; 
    }
    public boolean getW() { 
        return w; 
    }
    public int getPlayerScore() { 
        return playerScore; 
    }
    public int getAiScore() { 
        return aiScore; 
    }
    
    public void setX1(int x1) { 
        this.x1 = x1; 
    }
    public void setY1(int y1) { 
        this.y1 = y1; 
    }
    public void setX2(int x2) { 
        this.x2 = x2; 
    }
    public void setY2(int y2) { 
        this.y2 = y2; 
    }
    public void setBallSlope(int ballSlope) { 
        this.ballSlope = ballSlope; 
    }
    public void getS(boolean s) { 
        this.n = s; 
    }
    public void getE(boolean e) { 
        this.n = e; 
    }
    public void getW(boolean w) { 
        this.n = w; 
    }
    public void setPlayerScore(int playerScore) { 
        this.playerScore = playerScore; 
    }
    public void setAiScore(int aiScore) { 
        this.aiScore = aiScore; 
    }
}
