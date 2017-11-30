public class Main{
  public void main(String args[]){
		GameBoard gameModel = new GameBoard();
		GameView  gameView  = new GameView(gameView);
		GameController gameController = new GameController(gameModel,gameView);
  }
}
