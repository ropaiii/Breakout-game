import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick extends Sprite {
	
	private Color color;
	private int health;
	private int value;
	
	public Brick(int x, int y, int width, int height, Color color) {
		super(x,y,width,height);
		this.color = color;
		
		if(color == Color.yellow) {
			health = 1;
			value = 10;
		} else if(color == Color.green) {
			health = 2;
			value = 20;
		} else if(color == Color.orange) {
			health = 3;
			value = 30;
		} else if(color == Color.red) {
			health = 4;
			value = 40;
		}
		
	}

	@Override
	public void update(Keyboard keyboard) {
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(this.color);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public int getHealth() {
		return health;
	}
	public void addHealth(int x) {
		health += x;
	}
	public void decHealth(int x) {
		health -= x;
	}
	
	public int getValue() {
		return value; 
	}
}
