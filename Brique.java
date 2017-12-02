import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Brique extends BoardObject{

  private double largeur;
  private double longueur;

  public Brique(double x,double y,double longueur,double largeur){
    this.x = x;
    this.y = y;
    this.largeur  = largeur;
    this.longueur = longueur;

    object = new Rectangle();
    this.object.setHeigth(largeur);
    this.object.setWidth(longueur);
  }

	public void setX(double x){
		this.x =x;
		((Rectangle)).setX(x);
	}

	public void setY(double y){
		this.y =y;
		((Rectangle)).setY(y);
	}
}
