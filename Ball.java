import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball extends Sprite {
	
	private Color color;
	private int xDir;
	private int yDir;
	private int amount;
	private int speed;
	private boolean sticky = false;
	
	public Ball(int x, int y, int width, int height, int Xdir, int Ydir, Color color, int speed) {
		super(x, y, width, height);
		this.color = color;
		this.xDir = Xdir;
		this.yDir = Ydir;
		this.speed = speed;
		
		amount = Constants.amount_of_ballsOnStart;
	}
	
	@Override
	public void update(Keyboard keyboard) {
		move();
		if(getY() > Constants.respawnpointY) {
			respawn(false);
		}
		
		if(sticky) {
			if(keyboard.isKeyDown(Key.Space)) {
				speed = Constants.ballSpeed;
				sticky = false;
			}
		}
	}
	
	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillArc(getX(), getY(), getWidth(), getHeight(), 0, 360);
	}

	
	private void move() {
		setX(getX()+xDir*speed);
		setY(getY()+yDir*speed);
	}
	
	public void respawn(boolean onStart) {
		setY(Constants.boardheight/2);
		setX(Randomnumber.generator(Constants.wallWidth,Constants.boardwidth-Constants.wallWidth));
		if(!onStart) {
			amount--;
		}
	}
	
	public int getBalls() {
		return amount;
	}
	
	public void setBalls(int x) {
		amount = x;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int x) {
		speed = x;
	}
	
	public int getXDir() {
		return xDir;
	}
	
	public void setXDir(int x) {
		xDir = x;
	}
	
	public int getYDir() {
		return yDir;
	}
	
	public void setYDir(int x) {
		yDir = x;
	}
	
	public boolean isSticky() {
		return sticky;
	}
	
	public void setSticky(boolean x) {
		sticky = x;
	}
}
