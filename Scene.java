import java.awt.Font;
import java.awt.Graphics2D;

public abstract class Scene {
	
	private Scene scene;
	private Font thisFont;
	public boolean visible;
	public abstract void update(Keyboard keyboard);
	public abstract void draw(Graphics2D graphics);
	public void setScene(Scene scene) {this.scene = scene;}
	public Font getThisFont() {return thisFont;}
	public void setThisFont(Font thisFont) {this.thisFont = thisFont;}	
}
