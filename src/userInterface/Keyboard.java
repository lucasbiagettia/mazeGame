package userInterface;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keyboard  implements KeyListener, IKeyboardSender{
    IKeyboardObserver observer;
	
    public Keyboard(IKeyboardObserver theObserver) {
    	observer=theObserver;
    }
    
    
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		try {
			sendEvent(e.getKeyCode());
		} catch (Exception e1) {
			// TODO KeyboardException
			e1.printStackTrace();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void sendEvent(int keyCode) throws Exception {
		if (observer != null) {
			observer.receiveEvent(keyCode);
		}else {
			throw new Exception();
		}
	}
}
