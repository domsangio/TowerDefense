package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	
	private boolean[] keys;
	
	public boolean upgrade, combine, destroy;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		upgrade = keys[KeyEvent.VK_U];
		combine = keys[KeyEvent.VK_G];
		destroy = keys[KeyEvent.VK_X];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
