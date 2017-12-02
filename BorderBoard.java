import javafx.scene.paint.Color;

public class BorderBoard extends Brique{

	public BorderBoard(double x,double y,double longueur,double largeur){
		this.super(x,y,longueur,largeur);
	}

	public void setColor(Color color){
		this.object.setStroke(color);
		this.object.setFill(Color.TRANSPARENT)
	}
}
