import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class Scene_DisplayScreen extends Scene {
	
	public Scene_DisplayScreen() {
		visible = false;
		setThisFont(new Font("TimesRoman", Font.PLAIN, 30));
		}

	@Override
	public void update(Keyboard keyboard) {
		if(visible) {
			
		}
	}

	@Override
	public void draw(Graphics2D graphics) {
		if(visible) {
			graphics.setFont(getThisFont());
			graphics.setColor(Color.white);
			FontMetrics fm = graphics.getFontMetrics();
			int strPlayWidth = fm.stringWidth("Press SPACE to play");
			int strPlayHeight = fm.getHeight();
			graphics.drawString("Press SPACE to play", strPlayWidth, Constants.boardheight/2+strPlayHeight);
		}
	}
}
