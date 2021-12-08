package hirata;

import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_B_GameObject_Adapter extends GameObject {
	private Type_B_GameObject typeBObject;

	
	public Type_B_GameObject_Adapter(int x, int y, Type_B_GameObject b) {
		super(x, y);
		typeBObject = b;
		
		setDirection(Direction.NONE);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_B.png"));

	}

	public void setVelocityY(int y) {
		typeBObject.velocityY = y;
	}
	
	public int getVelocityY() {
		return typeBObject.velocityY;
	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();

		int  iconHeight   = icon.getIconHeight();
		int iconWidth = icon.getIconWidth();
		int canvasWidth = (int)c.getSize().getWidth();
		int  canvasHeight = (int)c.getSize().getHeight();
		
		int x = getX();
        int y = getY();
        int vx = getVelocity();
        int vy = getVelocityY();
       
        x += vx;
        y += vy;
        
        if (x  < 0) {
            vx = -vx; 
            x = 0; 
          } else if (x + iconWidth > canvasWidth) {
            vx = -vx;
            x = canvasWidth - iconWidth;
          }
 
          if (y < 0) {
            vy = -vy;
            y = 0;
          } else if (y + iconHeight > canvasHeight) {
            vy = -vy;
            y = canvasHeight - iconHeight;
          }
        
        setX(x);
        setVelocity(vx);
        setY(y);
        setVelocityY(vy);
		
	}

	public void setImage() {
		currentImage = 0;
	}

	public void moveUser(Canvas c) {
		Icon icon = getCurrentImage();

		int  iconHeight   = icon.getIconHeight();
		int iconWidth = icon.getIconWidth();
		int canvasWidth = (int)c.getSize().getWidth();
		int  canvasHeight = (int)c.getSize().getHeight();
		
		int x = getX();
        int y = getY();
        int vx = getVelocity();
        int vy = getVelocityY();
       
        x += vx;
        y += vy;
        
        if (x  < 0) {
            vx = -vx; 
            x = 0; 
          } else if (x + iconWidth > canvasWidth) {
            vx = -vx;
            x = canvasWidth - iconWidth;
          }
 
          if (y < 0) {
            vy = -vy;
            y = 0;
          } else if (y + iconHeight > canvasHeight) {
            vy = -vy;
            y = canvasHeight - iconHeight;
          }
        
        setX(x);
        setVelocity(vx);
        setY(y);
        setVelocityY(vy);
		
	}


}
