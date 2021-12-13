package hirata;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_A_GameObject extends GameObject  implements KeyListener {
	private int imageHeight;
	private Canvas canvas;

	public Type_A_GameObject(int x, int y) {
		super(x, y);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_A_Up.png"));
		imageList.add(new ImageIcon("images/Type_A_Down.png"));

		ImageIcon img = new ImageIcon("images/Type_A_Up.png");
		imageHeight = img.getIconHeight();

	}

	// Method to move automatically when not selected
	public void move(Canvas c) {

		canvas = c;
		
		if (getDirection() == Direction.UP) {
			setY(getY() - getVelocity());
			if(getY() < 0) { // If collided with the wall, reset position to edge and change direction
				setY(0);
				setDirection(Direction.DOWN);
			}
		} else if (getDirection() == Direction.DOWN) {
			setY(getY() + getVelocity());
			if(getY() + imageHeight > c.getSize().getHeight()) { // If collided with the wall, reset position to edge and change direction
				setY((int)c.getSize().getHeight()-imageHeight);
				setDirection(Direction.UP);
			}
		} else {
			setDirection(Direction.UP);
		}
	}

	// Method to move when game object is selected
	public void moveUser(Canvas c) {
		canvas = c;
		
		c.addKeyListener(this);
		int  canvasHeight = (int) c.getSize().getHeight();

		switch (getDirection()) {
		case Direction.UP:
			setY(getY() - getVelocity());
			if (getY() < 0) {
				setY(0);
			}
			break;
		case Direction.DOWN:
			setY(getY() + getVelocity());
			if (getY() + imageHeight > canvasHeight) {
				setY((int)(canvasHeight - imageHeight));
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
		case Direction.UP:
			currentImage = 0;
			break;
		case Direction.DOWN:
			currentImage = 1;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) { // Move gameObject based on user input
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setDirection(Direction.UP);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setDirection(Direction.DOWN);
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
