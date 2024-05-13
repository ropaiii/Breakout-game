import java.awt.Color;
import java.util.Timer;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Paddle extends Sprite {
	
	Color color;
	private int Xdir;
	private int speed;
	private int Xarch = 15;
	private int Yarch = 20;
	private boolean canCollide = true;
	private Rectangle leftSide;
	private Rectangle rightSide;
	
	public Paddle(int x, int y, int width, int height, Color color, int speed) {
		super(x,y,width,height);
		this.color = color;
		this.Xdir = -1;
		this.speed = speed;
	}

	@Override
	public void update(Keyboard keyboard) {
		move(keyboard);
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRoundRect(getX(), getY(), getWidth(), getHeight(), Xarch, Yarch);
		
	}
	
	public void collision(Ball ball) {
		//Check if ball collides with left or right side of paddle
		leftSide = new Rectangle(getX(), getY(), getWidth()/2, getHeight());
		rightSide = new Rectangle(getX()+getWidth()/2, getY(), getWidth()/2, getHeight());
		if(ball.getBounds().intersects(this.getBounds())) {
			if(ball.getBounds().intersects(rightSide)) {
				ball.setXDir(1);
				if(ball.isSticky()) {
					ball.setSpeed(0);
					ball.setX(getX()+getWidth()/2);
					canCollide = false;
				} else {
					ball.setSpeed(Constants.ballSpeed);
				}
			} else if(ball.getBounds().intersects(leftSide)) {
				ball.setXDir(-1);
				if(ball.isSticky()) {
					ball.setSpeed(0);
					ball.setX(getX()+getWidth()/2);
				} else {
					ball.setSpeed(Constants.ballSpeed);
				}
			}
			ball.setYDir(-ball.getYDir());
		}
	}
	
	private void move(Keyboard keyboard) {
		if(keyboard.isKeyDown(Key.Left)) {
			setX(getX()-speed);
		} else if(keyboard.isKeyDown(Key.Right)) {
			setX(getX()+speed);
		}
	}
}
