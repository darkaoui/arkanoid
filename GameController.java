class GameController{

  private GameBoad gameBoard;
  private GameView gameView;

  public GameController(){

  }

  public GameController(GameBoad gameBoard, GameView gameView){
    this.gameView  = gameView;
    this.gameBoard = gameBoard;
  }

  

}
