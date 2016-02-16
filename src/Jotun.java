import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import jotun.entity.mob.Player;
import jotun.graphics.Game;

public class Jotun extends Application implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -388365905501050966L;

	public static void main(String[] args){
		Application.launch();
	}
	//one second in nanoseconds
	final double ns = 1000000000.0 / 60.0;
	//used to store the current time to calculate fps
	//used to store the last time to calculate fps
	private long lastTime = 0;
	//acumulated difference between current time and last time
	private double delta = 0;

	private AnimationTimer mainLoop;
	private String title;
	private Stage stage;
	private Group pane;
	private Game game;
	private int frames;
	private int updates;
	private long timer;
	private int width = 800;
	private Scene scene;
	private Player player;

	@Override
	public void start(Stage stage) throws Exception {
		this.title = "Jotun";
		initContent(stage);
		mainLoop.start();
	}

	private void initContent(Stage stage) {
		this.stage = stage;
		this.stage.setTitle(this.title);
		this.pane = new Group();
		initMainLoop(pane.getChildren());
		stage.setOnCloseRequest(event -> {
			mainLoop.stop();
			//saveGame();
			System.exit(0);
		});
		//this.game = initGame();
		this.game = new Game(width);
		this.player = this.game.getPlayer();
		this.game.setDisable(false);
		this.game.setVisible(true);
		this.pane.getChildren().add(game);
		this.scene = new Scene(this.pane);
		this.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.W){
                	player.move(0, -1);
                } else if(event.getCode() == KeyCode.S){
                	player.move(0, 1);
                }
                if(event.getCode() == KeyCode.A){
                	player.move(-1, 0);
                }else if(event.getCode() == KeyCode.D){
                	player.move(1, 0);
                }
            }
        });
		
		this.scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.W){
                	player.move(0, 0);
                } else if(event.getCode() == KeyCode.S){
                	player.move(0, 0);
                }
                if(event.getCode() == KeyCode.A){
                	player.move(0, 0);
                }else if(event.getCode() == KeyCode.D){
                	player.move(0, 0);
                }
            }
        });
		
		this.stage.setScene(this.scene);
		this.stage.setWidth(width);
		this.stage.setHeight(width / 16 * 9);
		this.stage.show();
	}
	
	public void initMainLoop(ObservableList<Node> rootPane){
		lastTime = System.nanoTime();
		this.frames = 0;
		this.updates = 0;
		this.timer = System.currentTimeMillis();
		mainLoop = new AnimationTimer() {

			@Override
			public void handle(long now) {
				delta += (now - lastTime) / ns;
				lastTime = now;

				while (delta >= 1) {
					update();
					updates++;
					delta--;
				}
				render();
				frames++;

				if (System.currentTimeMillis() - timer > 1000) {
					timer += 1000;
					stage.setTitle(title + " | " + updates + " ups, " + frames + " fps.");
					frames = 0;
					updates = 0;
				}
			}
		};
	}

	private void render() {
		this.game.render();
	}

	private void update() {
		this.game.update();
	}

	private Game initGame() {
		Game game = null;
		try {
			game = loadGame();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		if(game == null){
			game = new Game(width);
		}
		return game;
	}

	public void saveGame() {
		try {
			File savegame = new File("./game.save");
			if(!savegame.exists()) {
				savegame.createNewFile();
			} 
			FileOutputStream fos = new FileOutputStream(savegame);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Game Saved");
	}

	private Game loadGame() throws IOException, ClassNotFoundException {
		File savegame = new File("./game.save");
		Game game2 = null;
		if(!savegame.exists()) {
			try {
				savegame.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			FileInputStream fis = new FileInputStream(savegame);
			ObjectInputStream ois = new ObjectInputStream(fis);
			game2 = (Game) ois.readObject();
			ois.close();
			System.out.println("Game loaded");
		}

		return game2;
	}
}
