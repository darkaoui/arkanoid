import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class GameView extends Application {

	private GameBoard gameModel;

	private Button btnNiveau1;
	private Button btnNiveau2;
	private Button btnNiveau3;
	private Button btnNiveau4;
	private Button btnNiveau5;
	private Button btnNiveau6;
	private Button btnNiveau7;	

	public GameView(){		
	}

	public GameView(GameBoard gameModel){
		this.gameModel = gameModel;

		//initialser les composantes graphiques de la vue
	}

	public void view(){
		//faire la jonctions du modele au object de la vue
	}	

  @Override
  public void start(Stage primaryStage) {
  }
}
