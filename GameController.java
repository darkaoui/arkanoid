class GameController implements EventHandler<Event>{

  private GameBoad gameBoard;
  private GameView gameView;

  public GameController(){
  }

  public GameController(GameBoad gameBoard, GameView gameView){
    this.gameView  = gameView;
    this.gameBoard = gameBoard;

		//ajouter toutes action sur les elements evementiels de gameBoard
  }

  
	public void handle(ActionEvent event) {
		System.out.println("Hello World!");
		//gerer les directions de la raquette
  }

	public void animation(){

	}
}
