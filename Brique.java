import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Brique extends Rectangle implements BoardObject{

  public Brique(double x,double y,double longueur,double largeur){
    super(x,y,largeur,longueur);
  }

	public void setColor(Color color){
		this.setFill(color);
	}
}
