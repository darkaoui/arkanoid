public class Main{
  public void main(String args[]){
		GameBoard gameBoard = new GameBoard();
		GameView  gameView  = new GameView(gameBoard);
		GameController gameController = new GameController(gameBoard,gameView);
		gameController.gameLaunch(args);
  }
}
