import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cadre extends Rectangle implements BoardObject{

	public Cadre(double x,double y,double longueur,double largeur){
		super(x,y,largeur,longueur);
	}

	public void setColor(Color color){
		this.setStroke(color);
		this.setFill(Color.TRANSPARENT);
	}
}
