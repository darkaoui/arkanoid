import java.util.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;


public class GameView extends Application {
    
    //private GameBoard gameModel;
    //private ArrayList<Button> btnNiveauList;
    
    private Circle ball;
    private Rectangle raquette;
    private ArrayList<Rectangle> briques;
    
    public GameView(/*GameBoard gameModel*/){
	//this.gameModel = gameModel;
	//	btnNiveauList=new ArrayList();
	//initialser les composantes graphiques de la vue
	ball=new Circle(205.0,475.0,5);
	ball.setFill(Color.BLACK);
	raquette=new Rectangle(205.0,545.0,50.0,10.0);
	raquette.setFill(Color.GREY);
	briques=new ArrayList();
	Rectangle r=new Rectangle(105.0,55.0,50.0,25.0);
	r.setFill(Color.GREEN);
	briques.add(r);
	r=new Rectangle(55.0,155.0,50.0,100.0);
	r.setFill(Color.RED);
	briques.add(r);
	
    }
    
    public void view(){
	//faire la jonctions du modele au object de la vue
    }
    
    @Override
    public void start(Stage stage) {
	BorderPane bpane=new BorderPane();
	Pane centre=new Pane();
	Pane bas=new Pane();
	Pane gauche=new VBox();
	Pane haut=new Pane();

	MenuBar menubar=new MenuBar(new Menu("Game"));
	haut.getChildren().add(menubar);

	gauche.getChildren().add(new Text(2,0,"Levels"));
	gauche.getChildren().add(new Button("Level 1"));
	gauche.getChildren().add(new Button("Level 2"));
	gauche.getChildren().add(new Button("Level 3"));
	gauche.getChildren().add(new Button("Level 4"));
	gauche.getChildren().add(new Button("Level 5"));

	bas.getChildren().add(new Text(10,0,"Game in pause.\nPresse p to resume."));

	Rectangle cadre=new Rectangle(5,5,400.0,550.0);
	cadre.setFill(Color.WHITE);
	cadre.setStroke(Color.BLACK);
	centre.getChildren().add(cadre);
	centre.getChildren().add(raquette);
	centre.getChildren().add(ball);
	for(int i=0;i<briques.size();i++){
	    centre.getChildren().add(briques.get(i));
	}
	centre.setPrefSize(300,600);
	bpane.setCenter(centre);
	bpane.setBottom(bas);
	bpane.setLeft(gauche);
	bpane.setTop(haut);
	Scene scene=new Scene(bpane,600,700);
	stage.setScene(scene);
	stage.setTitle("Arkanoid");
	
	
	stage.show();
    }
    
    public static void main(String[]args){
	launch();
    }
}
