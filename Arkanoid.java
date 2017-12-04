import java.util.*;

import javafx.application.Application;
import javafx.animation.AnimationTimer;
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


public class Arkanoid extends Application {

    private ArkanoidBoard arkanoidBoard;
		private ArkanoidBoardController arkanoidBoardController;

		private Text messageText;
		private AnimationTimer animation;

		private boolean pause;
		private boolean gameBlocked;

		private ArrayList<Button> levelButtonList;

    public Arkanoid(){
			
			this.arkanoidBoard           = new ArkanoidBoard();
			this.arkanoidBoardController = new ArkanoidBoardController(arkanoidBoard);
						
			messageText = new Text(10,0,"push S to Start Game");

			this.pause       = true;
			this.gameBlocked = false;

      this.levelButtonList = new ArrayList();

			this.animation = new AnimationTimer(){
				long lastTime = System.nanoTime();
				public void handle(long time){
          if(arkanoidBoard.endOfLevel()){
            gameBlocked   = true;
            if(arkanoidBoard.getLooser())
              messageText.setText("Vous avez perdu ! Level "+arkanoidBoard.getNiveauActuel());
            else
              messageText.setText("Vous avez gagne ! Level "+arkanoidBoard.getNiveauActuel());
            this.stop();
          }            
					arkanoidBoardController.arkanoidAnimation(time,lastTime);
				}
			};			

    }

    @Override
    public void start(Stage stage) {
			
			Pane bas=new Pane();
			Pane gauche=new VBox();
			Pane haut=new Pane();

			MenuBar menubar=new MenuBar(new Menu("Game"));
			haut.getChildren().add(menubar);

			gauche.getChildren().add(new Text(2,0,"Levels"));
      LevelButtonActionEvent action = new LevelButtonActionEvent();
			int nbNiveau = this.arkanoidBoard.getNombreDeNiveau();
			for(int i=0; i<nbNiveau; i++){
				Button btn = new Button("Level "+(i+1));
        this.levelButtonList.add(btn);
        gauche.getChildren().add(btn);
				btn.setOnAction(action);
			}
			
			bas.getChildren().add(messageText);

			this.arkanoidBoard.setPosition(20,20);
			BorderPane bpane = new BorderPane();
			bpane.setCenter(arkanoidBoard);
			bpane.setBottom(bas);
			bpane.setLeft(gauche);
			bpane.setTop(haut);

			Scene scene = new Scene(bpane,500,500);
			
			scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
					public void handle(KeyEvent e){
						if(gameBlocked)
							return;

						if(e.getCode() == KeyCode.LEFT && pause != true)
							arkanoidBoardController.pushLeftKey();
						else if(e.getCode() == KeyCode.RIGHT && pause != true)
							arkanoidBoardController.pushRightKey();
						else if(e.getCode() == KeyCode.R || e.getCode() == KeyCode.S){
							animation.start();
							pause = false;
              messageText.setText("Level "+arkanoidBoard.getNiveauActuel());
						}else if(e.getCode() == KeyCode.P){
							animation.stop();
							pause = true;
              messageText.setText("Game in Pause\nPress P to resume");
						}else if(e.getCode() == KeyCode.ESCAPE){
              //Quitter l'application
            }
         }
			});
			
			stage.setScene(scene);
			stage.setTitle("Arkanoid");
			stage.show();
    }

		class LevelButtonActionEvent implements EventHandler<ActionEvent>{
      public void handle(ActionEvent e){
        for(int i=0; i<levelButtonList.size();i++)
					if(e.getSource() == levelButtonList.get(i)){
            animation.stop();
            if(arkanoidBoardController.loadingLevel(i+1)){
              gameBlocked = false;
              messageText.setText("push S to Start Game");
            }else{
              gameBlocked = true;
              messageText.setText("unable to Load");
            }
          }
			}	
		} 

    public static void main(String[]args){
			launch();
    }
}
