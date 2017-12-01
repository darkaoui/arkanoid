import javafx.scence.shape.Circle;

class Balle extends BoardObject implements Move{

  private double rayon;
	private double xMove;
	private double yMove;

  private Circle object;

  public Balle(){
  }

  public Balle(double x,double y,double rayon, double xMove, double yMove){
    this.x = x;
    this.y = y;
    this.rayon = rayon;
    object = new Circle();
  }

	public double getRayon(){
    return this.rayon;
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

	public double getXMove(){
		return this.xMove;
	}

	public double getYMove(){
		return ths.yMove;
	}

  public Circle dessiner(){
    this.object.setCenterX(this.x);
    this.object.setCenterY(this.y);
    this.object.setRadius(this.rayon);
    return object;
  }
}
