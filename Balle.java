class Balle extends BoardObject implements Move{
  
  private double rayon;
	
	private double xMove;
	private double yMove;

  public Balle(){
  }

  public Balle(double x,double y,double rayon, double xMove, double yMove){
    this.x = x;
    this.y = y;
    this.rayon = rayon;
  }

	public double getRayon(){
		
	}

	public boolean collision(BoardObject object){
		
	}

	public void move(){
	}

	public void rebond(BoardObject object){
	}

	public void setMove(double xMove, double yMove){
		this.xMove = xMove;
		this.yMove = yMove;
	}

	public int getXMove(){
		return xMove;
	}
	
	public int getYMove(){
		return yMove;
	}

}
