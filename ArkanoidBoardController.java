class ArkanoidBoardController{

  public ArkanoidBoard arkanoidBoard;

  public ArkanoidBoardController(ArkanoidBoard arkanoidBoard){
		this.arkanoidBoard = arkanoidBoard;
  }

	public void arkanoidAnimation(long time, long lastTime){
		//gerer l'animation du jeu
		//gestion des colision
		//gestion des rebond
	}

	public boolean loadingLevel(int level){
		return this.arkanoidBoard.chargementDeNiveau(level);
	}

	public void pushLeftKey(){
		this.arkanoidBoard.getRaquette().goLeft();
		if(this.arkanoidBoard.getRaquette().collision(this.arkanoidBoard.getCadre()))
			this.arkanoidBoard.getRaquette().goRight();
	}

	public void pushRightKey(){
		this.arkanoidBoard.getRaquette().goRight();
		if(this.arkanoidBoard.getRaquette().collision(this.arkanoidBoard.getCadre()))
			this.arkanoidBoard.getRaquette().goLeft();
	}

	public void balleMove(){
		this.arkanoidBoard.getBalle().move();
	}
}
