import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

class Balle extends Circle implements BoardObject,IMove{

  private double xMove;
  private double yMove;

  private boolean destroyed; // balle percee

  public Balle(double x,double y,double rayon){
    super(x,y,rayon);
    this.setMove(200E-9,120E-9);
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

  public void move(double lapstime){
    this.setX(this.getX() + this.xMove*lapstime);
    this.setY(this.getY() + this.yMove*lapstime);
  }

  public void setMove(double xMove, double yMove){
    this.xMove = xMove;
    this.yMove = yMove;
  }

  public double getXMove(){
    return this.xMove;
  }

  public double getYMove(){
    return this.yMove;
  }

  public boolean destroyed(){
    return this.destroyed;
  }

  private double rayon(){
    return this.getRadius();
  }

  public void setColor(Color color){
    this.setFill(color);
  }

  public boolean collision(BoardObject object){

    if(object instanceof Cadre){

      double x = ((Cadre)object).getX();
      double y = ((Cadre)object).getY();
      double w = ((Cadre)object).getWidth();
      double h = ((Cadre)object).getHeight();

      System.out.println(x+" "+(this.getX()+rayon()));

      if( x>=(this.getX()+rayon()) || (x+w)<=(this.getX()+rayon()) ){
        this.xMove = -this.xMove;
        return true;
      }

      if( y>=(this.getY()+rayon()) || (y+h)<=(this.getY()+rayon())  ){
        this.yMove = -this.yMove;
        return true;
      }
    }

    //Ajouter quand la balle touches le fond elle est detruite

    if(object instanceof Raquette){
      return false;
    }


    if(object instanceof Brique){
      return false;
    }

    return false;
  }

  private boolean collisionBrique(double x,double y,double w, double h){
    if( x<=(this.getX()+rayon())    && y<=(this.getY()+rayon()) &&
    (x+w)>=(this.getX()+rayon()) && (y+h)>=(this.getY()+rayon()) )
      return true;
    else
      return false;
  }
}
