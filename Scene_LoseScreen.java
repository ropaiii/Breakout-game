import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Scene_LoseScreen extends Scene {
	
	public Scene_LoseScreen() {
		visible = false;
		setThisFont(new Font("TimesRoman", Font.PLAIN, 20));
		
	}
	
	@Override
	public void update(Keyboard keyboard) {
		if(visible) {
			
			
		}
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setFont(getThisFont());
		graphics.setColor(Color.white);
		int textOffset = 100;
		String A = "YOU FAILED!";
		int widthA = graphics.getFontMetrics().stringWidth(A);
		int heightA = graphics.getFontMetrics().getHeight();
		String B = "HORRENDOUSLY!";
		int widthB = graphics.getFontMetrics().stringWidth(B);
		int heightB = graphics.getFontMetrics().getHeight();
		String C = ("YOU HAVE 0");
		int widthC = graphics.getFontMetrics().stringWidth(C);
		int heightC = graphics.getFontMetrics().getHeight();
		String D = "BALLS LEFT!";
		int widthD = graphics.getFontMetrics().stringWidth(D);
		int heightD = graphics.getFontMetrics().getHeight();
		String E = "Press SPACE to play again";
		int widthE = graphics.getFontMetrics().stringWidth(E);
		int heightE = graphics.getFontMetrics().getHeight();
		graphics.drawString(A, Constants.boardwidth/2-widthA/2, textOffset+heightA*1);
		graphics.drawString(B, Constants.boardwidth/2-widthB/2, textOffset+heightB*2);
		graphics.drawString(C, Constants.boardwidth/2-widthC/2, textOffset+heightC*3);
		graphics.drawString(D, Constants.boardwidth/2-widthD/2, textOffset+heightD*4);
		graphics.drawString(E, Constants.boardwidth/2-widthE/2, textOffset+heightE*5);
	}
}
