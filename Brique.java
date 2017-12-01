import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Brique extends BoardObject{

  private double largeur;
  private double longueur;
  private Rectangle object;

  public Brique(double x,double y,double longueur,double largeur){
    this.x = x;
    this.y = y;
    this.largeur  = largeur;
    this.longueur = longueur;

    object = new Rectangle();
    this.object.setWidth(largeur);
    this.object.setWidth(longueur);
  }

  public Rectangle dessiner(){
    this.object.setX(this.x);
    this.object.setY(this.y);
    return object;
  }

  public void setColor(Color color){
    this.object.setFill(color);
  }
}
