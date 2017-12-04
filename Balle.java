import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

class Balle extends Circle implements BoardObject,IMove{

  private double xMove;
	private double yMove;

  public Balle(double x,double y,double rayon){

		super(x,y,rayon);
		
		xMove =0;
		yMove =0;
    
    this.setColor(Color.ROYALBLUE);
  }

  public Balle(double x,double y,double rayon, double xMove, double yMove){
		this(x,y,rayon);
		xMove = x;
		yMove = y;
  }

	public void setX(double x){
		this.setCenterX(x);
	}

	public void setY(double y){
		this.setCenterY(y);
	}

	public double getX(){
		return this.getCenterX();
	}

	public double getY(){
		return this.getCenterY();
	}

	public void move(){
    this.setX(this.getX() + this.xMove);
    this.setY(this.getY() + this.yMove);
	}

	public void setMove(double xMove, double yMove){
		this.xMove = xMove;
		this.yMove = yMove;
	}

	public double getXMove(){
		return this.xMove;
	}

	public double getYMove(){
		return this.yMove;
	}

	private double rayon(){
    return this.getRadius();
	} 

	public void setColor(Color color){
		this.setFill(color);
	}

	public void rebond(BoardObject object){
	}

	public boolean collision(BoardObject object){
		return true;
	}
}
