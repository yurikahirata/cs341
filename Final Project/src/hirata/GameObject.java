package hirata;

import java.awt.Component;
import java.awt.Graphics;
import java.util.List;

import javax.swing.Icon;

public abstract class GameObject {
	private int x; // x-position
	private int y; // y-position
	private int velocity; // Need two velocities if moving in 2D
	private int direction;
	// private boolean isHighlighted;
	
	protected List<Icon> imageList;
	protected int currentImage;
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		velocity = 1;
		currentImage = 0;
		//isHighlighted = false;
	}
	
	public void draw(Component c, Graphics g) {
		imageList.get(currentImage).paintIcon(c, g, x, y);
	}
	
	// Abstract method for movement of GameObject
	public abstract void move(Canvas c);
	public abstract void setImage();
	public abstract void moveUser(Canvas c);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public Icon getCurrentImage() {
		return imageList.get(currentImage);
	}
	
	/*
	 * public boolean getHighlighted() { return isHighlighted; }
	 * 
	 * public void setHighlighted (boolean b) { isHighlighted = b; }
	 */
	
}
