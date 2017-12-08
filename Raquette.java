import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Raquette extends Rectangle{

	private double moveConstant;

	public Raquette(double x, double y, double width, double height){
		super(x,x,width,height);
		this.moveConstant = 1.0;
		this.setFill(Color.BLUE);
	}

	public double getMoveConstant(){
		return this.moveConstant;
	}

	public void setMoveConstant(double moveConstant){
		this.moveConstant = moveConstant;
	}
}
