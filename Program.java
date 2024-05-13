import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class Program extends JFrame {
	GameBoard board;
	HighscoreComponent highscore;
	LatestRunsComponent latestRuns;
	ScoreManager score;
	
	public Program() {
		
		this.score = new ScoreManager();
		setLayout(new BorderLayout());
		highscore = new HighscoreComponent(score);
		latestRuns = new LatestRunsComponent(score);
		board = new GameBoard(score, latestRuns);
		add(board, BorderLayout.CENTER);
		add(highscore, BorderLayout.EAST);
		add(latestRuns, BorderLayout.WEST);
		setResizable(false);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		board.start();
	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		//board.processKeyEvent(e);
	}

	public static void main(String[] args) {
		Program program = new Program();
		
	}

}
