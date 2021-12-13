package hirata;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Timer;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Canvas extends JComponent implements ActionListener, KeyListener { // ActionListener listens for the gameLoop, keyListener listens for user input
	// Data members: window, game loop, list of game objects
	private JFrame frame;
	private Timer gameLoopTimer;
	private List <GameObject> gameObjectList;
	private static final long serialVersionUID = 1L;
	private int highlighted = 0;
	private HighlightSquare square;

	public Canvas () {
		// Create list of game objects
		gameObjectList = new LinkedList <GameObject>();

		// Create the window (the canvas)
		frame = new JFrame("Final Project Experiment");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);

		// Construct a timer and start it
		gameLoopTimer = new Timer(25, this);
		gameLoopTimer.start();

		// Make the window visible
		frame.setVisible(true);

		setFocusTraversalKeysEnabled(false);
		addKeyListener(this);
		
		square = new HighlightSquare(500,100);
	}

	// Method to add Game Objects
	public synchronized void addGameObject(GameObject gObject) {
		gameObjectList.add(gObject);
	}

	// Method Paint
	public synchronized void paint (Graphics g) {
		for (GameObject gObject: gameObjectList) {
			gObject.draw(this, g);
		}
		square.draw(this, g);
	}

	// Implementing inherited abstract method
	public synchronized void actionPerformed(ActionEvent e) {
		// Loop through all the game objects and display them
		for (GameObject gameObject: gameObjectList) {
			if (gameObject == gameObjectList.get(highlighted)) {
				gameObject.moveUser(this);
				square.setX(gameObject.getX());
				square.setY(gameObject.getY());
				gameObject.setImage();
				continue;
			}
			
			gameObject.move(this);
			gameObject.setImage();
		}
		repaint();
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	
		if (e.getKeyCode() == KeyEvent.VK_TAB) { // Change highlighted object when tab is pressed
			highlighted = highlighted + 1;
			if (highlighted == gameObjectList.size()) {
				highlighted = 0;
			}
			}
	}
}
