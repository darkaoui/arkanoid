import javafx.scence.shape.Circle;
import javafx.scence.shape.Shape;

class Balle extends BoardObject implements Move{

  private double rayon;
	private double xMove;
	private double yMove;

  public Balle(double x,double y,double rayon){
		this.x = x;
    this.y = y;
    this.rayon = rayon;

    object = new Circle(this.x, this.y,this.rayon);
    this.object.setRadius(this.rayon);
		
		xMove =0;
		yMove =0;
  }

  public Balle(double x,double y,double rayon, double xMove, double yMove){
		Balle(x,y,rayon);
		xMove = x;
		yMove = y;
  }

	public double getRayon(){
    return this.rayon;
	}

	public void setX(double x){
		this.x =x;
		((Cricle)object).setCenterX(this.x);
	}

	public void setY(){
		this.y = y;
		((Circle))object).setCenterY(this.y);
	}

	public void move(){
    this.x += this.xMove;
    this.y += this.yMove;
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

	public boolean collision(BoardObject object){
	}
}
