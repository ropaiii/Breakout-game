import java.awt.*;
import java.awt.event.*;
import javax.swing.JComponent;

public class GameBoard extends JComponent {
	private final int FPS = 60; 
	private Keyboard keyboard;
	private Game game;
	private Dimension screenSize = new Dimension(Constants.boardwidth,Constants.boardheight);
	
	
	public GameBoard(ScoreManager score, LatestRunsComponent latestRuns) {
		setPreferredSize(screenSize);
		keyboard = new Keyboard();
		game = new Game(this, score, latestRuns);
		this.setFocusable(true);
		
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D graphics = (Graphics2D)arg0;
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, getWidth(), getHeight());
		game.draw(graphics);
	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		if (e.getID() == KeyEvent.KEY_PRESSED)
			keyboard.processKeyEvent(e.getKeyCode(), true);
		else if (e.getID() == KeyEvent.KEY_RELEASED)
			keyboard.processKeyEvent(e.getKeyCode(), false);
	}

	public void start() {
		while(true) {
			game.update(keyboard);
			try {
				Thread.sleep(1000 / FPS); //Throttle thread
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
	}
}
