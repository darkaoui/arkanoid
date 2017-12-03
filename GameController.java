import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;

class GameController implements EventHandler<Event>{

  public GameBoard gameBoard;
  public GameView gameView;
	
	private AnimationTimer animation;

  public GameController(GameBoard gameBoard,GameView gameView){
		
		this.gameBoard = gameBoard;
		this.gameView  = gameView;

		this.gameView.addActionEventHandler(this);
		this.gameView.addKeyEventHandler(this);

		this.animation = new AnimationTimer(){
			long lastTime = System.nanoTime();
			public void handle(long time){
				gameAnimation(time,lastTime);
			}
		};
  }

	public void gameLaunch(String args[]){
		gameView.launch(args);
	}

	public void handle(Event event){

		if(event instanceof ActionEvent){
			System.out.println("Hello World!");
		}else if(event instanceof KeyEvent){
			System.out.println("hello world! "+((KeyEvent)event).getText());			
		}

  }

	public void controlleButton(String name){
	}

	public void controlleKey(String name){

	}

	public void gameAnimation(long time, long lastTime){
		//gerer l'animation du jeu
	}
}
