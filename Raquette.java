import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Raquette extends Rectangle implements BoardObject{

	private double moveConstant;

	public Raquette(double x, double y, double width, double height){
		super(x,x,width,height);
		this.moveConstant = 1.0;
		this.setColor(Color.BLUE);
	}

	public void goLeft(){
		this.setX(this.getX()-this.moveConstant);
	}

	public void goRight(){
		this.setX(this.getX()+this.moveConstant);
	}

	public void setColor(Color color){
		this.setFill(color);
	}

	public boolean collision(BoardObject object){
		//A remplire
		return true;
	}
}
