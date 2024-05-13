import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class Scene_GameScreen extends Scene {
	
	public Scene_GameScreen() {
		visible = false;
		setThisFont(new Font("TimesRoman", Font.PLAIN, 30));
		}

	@Override
	public void update(Keyboard keyboard) {

	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setFont(getThisFont());
	}
}
