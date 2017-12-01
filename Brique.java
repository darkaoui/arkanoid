import javafx.scene.paint.Color;

class Brique extends BoardObject{

  private double largeur;
  private double longueur;
  private Color couleur;

  private Rectangle object;

  public Brique(double x,double y,double largeur,double longueur){
    this.x = x;
    this.y = y;
    this.largeur  = largeur;
    this.longueur = longueur;

    object = new Rectangle;
  }

  public Rectangle dessiner(){
    this.object.setX(this.x);
    this.object.setY(this.y);
    this.setWidth(largeur);
    this.setWidth(longueur);

    return object;
  }
}
