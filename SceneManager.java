import java.awt.Graphics2D;
import java.util.ArrayList;

public class SceneManager extends Scene {
	
	/*
	 * Jag såg ett sätt efter jag hade skapat detta scen system att kunna byta mellan scener genom att använda JComponent
	 * men då jag har för lite tid på mig för att implementera detta så kommer jag fortsatt använda mitt egengjorda
	 * scen system även om det är lite halvdant.
	 */
	
	private Scene_DisplayScreen displayScreen;
	private Scene_GameScreen gameScreen;
	private Scene_WinScreen winScreen;
	private Scene_LoseScreen loseScreen;
	private ArrayList<Scene> allScenes;
	private Scene currentScene;
	
	private ScoreManager score;
	
	public SceneManager(ScoreManager score) {
		
		this.score = score;
		
		this.displayScreen = new Scene_DisplayScreen();
		this.gameScreen = new Scene_GameScreen();
		this.winScreen = new Scene_WinScreen(this.score);
		this.loseScreen = new Scene_LoseScreen();
		this.currentScene = displayScreen;
		allScenes = new ArrayList<Scene>();
		allScenes.add(displayScreen);
		allScenes.add(gameScreen);
		allScenes.add(winScreen);
		allScenes.add(loseScreen);
	}

	@Override
	public void update(Keyboard keyboard) {
		for(int i = 0; i < allScenes.size(); i++) {
			if(currentScene == allScenes.get(i)) {
				allScenes.get(i).visible = true;
				allScenes.get(i).update(keyboard);
			} else {
				allScenes.get(i).visible = false;
			}
		}
	}

	@Override
	public void draw(Graphics2D graphics) {
		if(currentScene.visible) {
			currentScene.draw(graphics);
		}
	}

	@Override
	public void setScene(Scene scene) {
		this.currentScene = scene;
	}
	
	public Scene getCurrentScene() {
		return currentScene;
	}
	
	public Scene getDisplayScene() {
		return displayScreen;
	}
	
	public Scene getGameScene() {
		return gameScreen;
	}
	
	public Scene getWinScene() {
		return winScreen;
	}
	
	public Scene getLoseScene() {
		return loseScreen;
	}
}