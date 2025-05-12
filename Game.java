import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.*;
import java.util.ArrayList;
import java.awt.Rectangle;

public class Game {
	
	private int fps;
	
	private boolean gamePause = true;
	private boolean gameWin = false;
	
	private Ball ball;
	private Paddle paddle;
	private Wall leftWall;
	private Wall rightWall;
	private Wall upperWall;
	private SquareCollection squares;
	private LatestRunsComponent latestRuns;
	private ScoreManager score;
	private SceneManager sceneManager;
	
	public Game(GameBoard board, ScoreManager score, LatestRunsComponent latestRuns) {
		
		leftWall = new Wall(0,0,Constants.wallWidth,Constants.boardheight,Color.green);
		rightWall = new Wall(Constants.boardwidth-Constants.wallWidth,0,Constants.wallWidth,Constants.boardheight,Color.green);
		upperWall = new Wall(0,0,Constants.boardwidth,Constants.wallWidth*2,Color.green);
		ball = new Ball(Randomnumber.generator(Constants.wallWidth,Constants.boardwidth-Constants.wallWidth), Constants.boardheight/2, 20, 20, -1, -2, Color.blue, Constants.ballSpeed);
		paddle = new Paddle(Constants.boardwidth/2, Constants.boardheight-Constants.paddleHeight*2, Constants.paddleWidth, Constants.paddleHeight, Color.pink, 10);
		squares = new SquareCollection();
		sceneManager = new SceneManager(score);
		this.score = score;
		this.latestRuns = latestRuns;
	}

	public void update(Keyboard keyboard) {
		
		++fps;
		if(fps%60 == 0) {
			fps = 0;
		}
		
		sceneManager.update(keyboard);
		
		if(gamePause) {
			sceneManager.setScene(sceneManager.getDisplayScene());
			if(keyboard.isKeyDown(Key.Space)) {
				score.setScore(0);
				gamePause = false;
			}
		}
		
		if(!gamePause) {
			sceneManager.setScene(sceneManager.getGameScene());
			paddle.update(keyboard);
			ball.update(keyboard);
			collision_detection();
			if(squares.getAmountOfBricks() == 0) {
				gameWin = true;
				gamePause = true;
				latestRuns.newScore(score.getScore());
				ball.respawn(true);
			}
		}
		
		if(gameWin) {
			sceneManager.setScene(sceneManager.getWinScene());
			squares.killall();
			if(keyboard.isKeyDown(Key.Space)) {
				gamePause = false;
				gameWin = false;
				squares.respawn();
				ball.setBalls(Constants.amount_of_ballsOnStart);
				latestRuns.setFlag_hasAddedScore(false);
			}
		}
		
		if(keyboard.isKeyDown(Key.Escape) && !gamePause){
			gamePause = true;
		}
		
		if(ball.getBalls() == 0) {
			sceneManager.setScene(sceneManager.getLoseScene());
			gamePause = true;
			if(keyboard.isKeyDown(Key.Space)) {
				gamePause = false;
				ball.setBalls(Constants.amount_of_ballsOnStart);
				score.setScore(0);
				squares.respawn();
				ball.respawn(true);
			}
		}
	}
	
	public void draw(Graphics2D graphics) {
		sceneManager.draw(graphics);
		ball.draw(graphics);
		paddle.draw(graphics);
		leftWall.draw(graphics);
		rightWall.draw(graphics);
		upperWall.draw(graphics);
		squares.draw(graphics);
		if(!gamePause) {
			drawScore(graphics);
			drawAmountOfBalls(graphics);
		}
	}
	
	private void drawScore(Graphics2D graphics) {
		graphics.setColor(Color.white);
		int score_OffsetX = 200;
		int score_OffsetY = 250;
		graphics.drawString(Integer.toString(score.getScore()), Constants.boardwidth/2-score_OffsetX, Constants.boardheight/2-score_OffsetY);
	}
	
	private void drawAmountOfBalls(Graphics2D graphics) {
		graphics.setColor(Color.white);
		int balls_OffsetX = 200;
		int balls_OffsetY = -250;
		graphics.drawString(Integer.toString(ball.getBalls()), Constants.boardwidth/2+balls_OffsetX, Constants.boardheight/2+balls_OffsetY);
	}
	
	private void collision_detection() {
		paddle.collision(ball);
		squares.collision(ball, score);
		
		//Collision between ball and wall
		if(ball.getBounds().intersects(leftWall.getBounds()) || ball.getBounds().intersects(rightWall.getBounds())) {
			ball.setXDir(-ball.getXDir());
		}
		if(ball.getBounds().intersects(upperWall.getBounds())) {
			ball.setYDir(-ball.getYDir());
		}
	}
}
