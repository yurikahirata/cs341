package hirata;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_C_GameObject extends GameObject  implements KeyListener {
	private int imageWidth;
	private Canvas canvas;
	
	public Type_C_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.LEFT);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_C_Left.png"));
		imageList.add(new ImageIcon("images/Type_C_Right.png"));

		ImageIcon img = new ImageIcon("images/Type_C_Left.png");
		imageWidth = img.getIconWidth();

	}

	// Method to move automatically when not selected
	public void move(Canvas c) {
		canvas = c;
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
			setDirection(Direction.RIGHT);
		}
	}

	// Method to move when game object is selected
	public void moveUser(Canvas c) {
		canvas = c;
		c.addKeyListener(this);
		Icon icon = getCurrentImage();

		int  iconWidth   = icon.getIconWidth();
		int  canvasWidth = (int)c.getSize().getWidth();

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

	// Method to set correct image based on its direction
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

	public void keyPressed(KeyEvent e) { // Move gameObject based on user input
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setDirection(Direction.LEFT);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setDirection(Direction.RIGHT);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_TAB) { // If key pressed is not tab, stop moving object upon key release
			setDirection(Direction.NONE);
		} else if (e.getKeyCode() == KeyEvent.VK_TAB) { // If tab is pressed, remove Key Listener
			canvas.removeKeyListener(this);
		}
	}
}
