import javafx.EventHandler;
import javafx.ActionEvent;
import javafx.animation.AnimationTimer;

class GameController implements EventHandler<Event>{

  private GameBoad gameBoard;
  private GameView gameView;
	private AnimationTimer animation;

	int nombreDeNiveau;

  public GameController(GameBoard gameBoard,GameView gameView){
		this.gameBoard = gameModel;
		this.gameView  = gameView;

		//ajouter toutes action sur les elements evementiels de la gameView
		//

		this.animation = new AnimationTimer(){
			long lastTime = System.nanoTime();
			public void handle(long time){
				gameAnimation(time,lastTime);
			}
		};

		this.nombreDeNiveau = 0;
  }

	public void gameLaunch(String args[]){
		//apres toutes les initialisations de base on lanch
		gameView.launch(args);
	}

	public void handle(ActionEvent event) {
		System.out.println("Hello World!");
		//gerer les directions de la raquette
  }

	public void gameAnimation(long time, long lastTime){
		//gerer l'animation du jeu
	}
}
