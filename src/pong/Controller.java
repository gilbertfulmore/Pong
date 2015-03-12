package pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Controller extends JPanel implements KeyListener {
	boolean keyUp = false;
	boolean keyDown = false;
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 38 || e.getKeyCode() == 87) {	//up Arrow
			keyUp = true;
		}
		if (e.getKeyCode() == 40 || e.getKeyCode() == 83) {	//down arrow
			keyDown = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 38 || e.getKeyCode() == 87) {	//up Arrow
			keyUp = false;
		}
		if (e.getKeyCode() == 40 || e.getKeyCode() == 83) {	//down Arrow
			keyDown = false;
		}
	}
	
	public boolean getKeyUp() { return keyUp; }
	public boolean getKeyDown() { return keyDown; }
}