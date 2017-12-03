import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Raquette extends Rectangle implements BoardObject,IMove{

	private double xMove;
	private double yMove;

	public Raquette(double x, double y, double longueur, double largeur){
		super(x,x,largeur,longueur);
		this.xMove = 0;
		this.yMove = 0;
  }

	public void move(){
		this.setX(this.getX() + xMove);
		this.setY(this.getY() + yMove);
	}

	public void setMove(double xMove, double yMove){
		this.xMove = xMove;
		this.yMove = yMove;
	}

	public double getXMove(){
		return xMove;
	}

	public double getYMove(){
		return yMove;
	}

	public void setColor(Color color){
		this.setFill(color);
	}

	public boolean collision(BoardObject object){
		//A remplir		
		return true;
	}
}
