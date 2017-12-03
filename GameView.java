import java.util.*;

import javafx.application.Application;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.input.*;


public class GameView extends Application {

    public GameBoard gameBoard;
    public ArrayList<Button> btnNiveauList;
		
		MenuBar menubar=new MenuBar(new Menu("Game"));
		
		private MenuItem menu1 = new MenuItem("Redemarre");
		
		private Scene scene;
		private Pane centre;
		private BorderPane bpane=new BorderPane();

		private Text messageText;

    public GameView(GameBoard gameBoard){
			
			this.gameBoard = gameBoard;
			btnNiveauList=new ArrayList();
			messageText = new Text(10,0,"Start Game");

			Scene scene=new Scene(bpane,500,500);
			centre = new Pane();
			
	
			/*
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
			*/

    }

    public void view(){
			//GameBoard : afficher la liste des composantes(objects)
			//si une composantes de dans la view n'est plus dans GameBoard.objects on la supp
			//si une composantes dans GameBoard.objects n'est pas dans View on l'ajoute
			for(int i=0; i<this.gameBoard.getObjects().size(); i++)			
				centre.getChildren().add((Shape)this.gameBoard.getObjects().get(i));
			//******

			if(this.gameBoard.pause)
				this.messageText.setText("Game in pause.\nPresse p to resume.");
			else if(this.gameBoard.getNiveauActuel() == -1)
				this.messageText.setText("Unloaded level");
			else
				this.messageText.setText("");
    }

    @Override
    public void start(Stage stage) {
			
			
			Pane centre=new Pane();
			Pane bas=new Pane();
			Pane gauche=new VBox();
			Pane haut=new Pane();

			MenuBar menubar=new MenuBar(new Menu("Game"));
			haut.getChildren().add(menubar);

			gauche.getChildren().add(new Text(2,0,"Levels"));
			
			for(int i=0; i<this.gameBoard.getNombreDeNiveau(); i++)
				gauche.getChildren().add(new Button("Level "+i));
			
			bas.getChildren().add(messageText);


			this.gameBoard.setPosition(5,5);
			this.view();

			bpane.setCenter(centre);
			bpane.setBottom(bas);
			bpane.setLeft(gauche);
			bpane.setTop(haut);
			
			stage.setScene(scene);
			stage.setTitle("Arkanoid");

			stage.show();			

    }

		public void addKeyEventHandler(EventHandler<Event> ek){
			//changer d'approche
			this.scene.setOnKeyPressed(ek);
		}

		public void listenButton(EventHandler<Event> eh){
			//Changer d'approche
			for(int i=0; i<btnNiveauList.size(); i++)
				btnNiveauList.get(i).setOnAction(eh);
		}


    //public static void main(String[]args){
			//launch();
    //}
}
