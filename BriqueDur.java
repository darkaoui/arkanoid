import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class BriqueDur extends Brique implements BoardObject{
	private int resistance;
	
	public Brique(double x,double y,double longueur,double largeur, int resistance){
    super(x,y,largeur,longueur);
		this.resistance = resistance;
  }

	public void affaiblir){
		this.resistance--;
	}

	public int getResistance(){
		return this.resistance;
	}
}
