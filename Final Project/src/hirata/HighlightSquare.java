package hirata;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class HighlightSquare {
	private int x;
	private int y;

	ImageIcon square = new ImageIcon("images/Highlighted.png");

	public HighlightSquare (int xvalue, int yvalue) {
		x = xvalue;
		y = yvalue;
	}

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
	
	public void draw(Component c, Graphics g) {
		square.paintIcon(c, g, x, y);
	}
}
