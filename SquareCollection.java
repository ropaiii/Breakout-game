import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class SquareCollection {
	
	private Brick brick;
	private ArrayList<Brick> oneHitBrick = new ArrayList<Brick>();
	private ArrayList<Brick> twoHitBrick = new ArrayList<Brick>();
	private ArrayList<Brick> threeHitBrick = new ArrayList<Brick>();
	private ArrayList<Brick> fourHitBrick = new ArrayList<Brick>();
	
	private boolean hasRespawned;
	
	public SquareCollection() {
		hasRespawned = false;
		instantiateBricks();
	}
	
	public void draw(Graphics2D graphics) {
		for(int i = 0; i < oneHitBrick.size(); i++) {
			oneHitBrick.get(i).draw(graphics);
		}
		for(int i = 0; i < twoHitBrick.size(); i++) {
			twoHitBrick.get(i).draw(graphics);
		}
		for(int i = 0; i < threeHitBrick.size(); i++) {
			threeHitBrick.get(i).draw(graphics);
		}
		for(int i = 0; i < fourHitBrick.size(); i++) {
			fourHitBrick.get(i).draw(graphics);
		}
	}
	
	private void instantiateBricks() {
		int squareWidth = 30;
		int squareHeight = 15;
		int squareXOffset = 40;
		int squareYOffset = 40;
		for(int i = 0; i < Constants.amountOfBricks; i++) {
			brick = new Brick(Constants.boardwidth/2-(Constants.amountOfBricks/2*squareXOffset)+i*squareXOffset,(Constants.boardheight/2)-squareYOffset,squareWidth,squareHeight, Color.yellow);
			oneHitBrick.add(brick);
		}
		for(int i = 0; i < Constants.amountOfBricks; i++) {
			brick = new Brick(Constants.boardwidth/2-(Constants.amountOfBricks/2*squareXOffset)+i*squareXOffset,(Constants.boardheight/2)-(squareYOffset*2),squareWidth,squareHeight,Color.green);
			twoHitBrick.add(brick);
		}
		for(int i = 0; i < Constants.amountOfBricks; i++) {
			brick = new Brick(Constants.boardwidth/2-(Constants.amountOfBricks/2*squareXOffset)+i*squareXOffset,(Constants.boardheight/2)-(squareYOffset*3),squareWidth,squareHeight,Color.orange);
			threeHitBrick.add(brick);
		}
		for(int i = 0; i < Constants.amountOfBricks; i++) {
			brick = new Brick(Constants.boardwidth/2-(Constants.amountOfBricks/2*squareXOffset)+i*squareXOffset,(Constants.boardheight/2)-(squareYOffset*4),squareWidth,squareHeight,Color.red);
			fourHitBrick.add(brick);
		}
	}
	
	public void collision(Ball ball, ScoreManager score) {
		for(int i = oneHitBrick.size()-1; i >= 0; i--) {
			if(ball.getBounds().intersects(oneHitBrick.get(i).getBounds())) {
				ball.setYDir(-ball.getYDir());
				oneHitBrick.get(i).decHealth(1);
				if(oneHitBrick.get(i).getHealth() == 0) {
					score.setScore(score.getScore()+oneHitBrick.get(i).getValue());
					oneHitBrick.remove(i);
				}
			}
		}
		
		for(int i = twoHitBrick.size()-1; i >= 0; i--) {
			if(ball.getBounds().intersects(twoHitBrick.get(i).getBounds())) {
				ball.setYDir(-ball.getYDir());
				twoHitBrick.get(i).decHealth(1);
				if(twoHitBrick.get(i).getHealth() == 0) {
					score.setScore(score.getScore()+twoHitBrick.get(i).getValue());
					twoHitBrick.remove(i);
				}
			}
		}
		
		for(int i = threeHitBrick.size()-1; i >= 0; i--) {
			if(ball.getBounds().intersects(threeHitBrick.get(i).getBounds())) {
				ball.setYDir(-ball.getYDir());
				threeHitBrick.get(i).decHealth(1);
				if(threeHitBrick.get(i).getHealth() == 0) {
					score.setScore(score.getScore()+threeHitBrick.get(i).getValue());
					threeHitBrick.remove(i);
				}
			}
		}
		
		for(int i = fourHitBrick.size()-1; i >= 0; i--) {
			if(ball.getBounds().intersects(fourHitBrick.get(i).getBounds())) {
				ball.setYDir(-ball.getYDir());
				fourHitBrick.get(i).decHealth(1);
				ball.setSticky(true);
				if(fourHitBrick.get(i).getHealth() == 0) {
					score.setScore(score.getScore()+fourHitBrick.get(i).getValue());
					fourHitBrick.remove(i);
				}
			}
		}
		
		hasRespawned = false;
	}
	
	public void respawn() {
		if(!hasRespawned) {
			killall();
			instantiateBricks();
		}
	}
	
	public void killall() {
		oneHitBrick.clear();
		twoHitBrick.clear();
		threeHitBrick.clear();
		fourHitBrick.clear();
	}
	
	public int getAmountOfBricks() {
		return oneHitBrick.size()+twoHitBrick.size()+threeHitBrick.size()+fourHitBrick.size(); 
	}

}
