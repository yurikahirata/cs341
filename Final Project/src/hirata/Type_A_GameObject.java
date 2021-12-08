package hirata;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_A_GameObject extends GameObject  implements KeyListener {
	private int imageHeight;
	private int prevDirect;

	public Type_A_GameObject(int x, int y) {
		super(x, y);
		//setDirection(Direction.DOWN);
		//setHighlighted(true);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_A_Up.png"));
		imageList.add(new ImageIcon("images/Type_A_Down.png"));

		ImageIcon img = new ImageIcon("images/Type_A_Up.png");
		imageHeight = img.getIconHeight();

	}

	public void move(Canvas c) {
		c.removeKeyListener(this);

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
			setDirection(prevDirect);

		}
	}

	public void moveUser(Canvas c) {
		c.addKeyListener(this);
		int  canvasHeight = (int) c.getSize().getHeight();

		//MOVE BLUE GAME OBJECT
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

	public void keyPressed(KeyEvent e) {
		//if (getHighlighted() == true) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setDirection(Direction.UP);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setDirection(Direction.DOWN);
			}
		//}

	}

	public void keyReleased(KeyEvent e) {
		//if (getHighlighted() == true) {		
			if (e.getKeyCode() != KeyEvent.VK_TAB) {  
				prevDirect = getDirection();
				setDirection(Direction.NONE);
			}
		//}

	}
}
