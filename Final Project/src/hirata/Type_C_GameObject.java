package hirata;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_C_GameObject extends GameObject  implements KeyListener {
	private int imageWidth;
	private int prevDirect;
	public Type_C_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.LEFT);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_C_Left.png"));
		imageList.add(new ImageIcon("images/Type_C_Right.png"));

		ImageIcon img = new ImageIcon("images/Type_C_Left.png");
		imageWidth = img.getIconWidth();

	}

	public void move(Canvas c) {
		c.removeKeyListener(this);
		if (getDirection() == Direction.LEFT) {
			setX(getX() - getVelocity());
			if(getX() < 0) { // If collided with the wall, reset position to edge and change direction
				setX(0);
				setDirection(Direction.RIGHT);
			}
		} else if (getDirection() == Direction.RIGHT) {
			setX(getX() + getVelocity());
			if(getX() + imageWidth > c.getSize().getWidth()) { // If collided with the wall, reset position to edge and change direction
				setX((int)c.getSize().getWidth() - imageWidth);
				setDirection(Direction.LEFT);
			}
		} else {
			setDirection(prevDirect);
		}
	}

	public void moveUser(Canvas c) {
		c.addKeyListener(this);
		Icon icon = getCurrentImage();

		int  iconWidth   = icon.getIconWidth();
		int  canvasWidth = (int)c.getSize().getWidth();

		//MOVE BLUE GAME OBJECT
		switch (getDirection()) {

		case Direction.LEFT: 
			setX(getX() - getVelocity()); 
			if (getX() < 0) { 
				setX(0);
			} 
			break; 
		case Direction.RIGHT: 
			setX(getX() + getVelocity()); 
			if (getX() + iconWidth > canvasWidth) { 
				setX((int)(canvasWidth - iconWidth)); 
			} 
			break;
		default:
			break;
		}

	}

	public void setImage() {
		switch (getDirection()) {
		case Direction.NONE:
			break;
		case Direction.LEFT:
			currentImage = 0;
			break;
		case Direction.RIGHT:
			currentImage = 1;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setDirection(Direction.LEFT);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setDirection(Direction.RIGHT);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_TAB) {
			prevDirect = getDirection();
			setDirection(Direction.NONE);
		}
	}
}
