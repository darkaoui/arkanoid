import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

class Balle extends Circle {

  private double xMove;
  private double yMove;

  private boolean destroyed; // balle percee

  public Balle(double x,double y,double rayon){
    super(x,y,rayon);

    this.setMove(0,0);

    this.setColor(Color.ROYALBLUE);
    this.destroyed = false;

  }

  public Balle(double x,double y,double rayon, double xMove, double yMove){
    this(x,y,rayon);
    this.xMove = x;
    this.yMove = y;
  }

  public void setX(double x){
    this.setCenterX(x);
  }

  public void setY(double y){
    this.setCenterY(y);
  }

  public double getX(){
    return this.getCenterX();
  }

  public double getY(){
    return this.getCenterY();
  }

  public void setMove(double xMove, double yMove){
    this.xMove = xMove;
    this.yMove = yMove;
  }

  public void setXMove(double xMove){
    this.xMove = xMove;
  }

  public void setYMove(double yMove){
    this.yMove = yMove;
  }

  public double getXMove(){
    return this.xMove;
  }

  public double getYMove(){
    return this.yMove;
  }

  public boolean getDestroyed(){
    return this.destroyed;
  }

  public void setDestroyed(boolean destroyed){
    this.destroyed = destroyed;
  }

  private double rayon(){
    return this.getRadius();
  }

  public void setColor(Color color){
    this.setFill(color);
  }
}
