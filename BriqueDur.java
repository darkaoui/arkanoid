import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class BriqueDur extends Brique implements BoardObject{
	private int resistance;
	
	public BriqueDur(double x,double y,double width,double height, int resistance){
    super(x,y,width,height);
		this.resistance = resistance;
  }

	public void affaiblir(){
		this.resistance--;
	}

	public int getResistance(){
		return this.resistance;
	}
}
