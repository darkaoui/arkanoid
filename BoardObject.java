import javafx.scence.shape.Shape;

public abstract class BoardObject{
  
	private double x;
  private double y;

	private Shape object;

	public void setX();
	public void setY();

	public void setPosition(double x,double y){
		this.setX(x);
		this.setY(y);		
	}

  public double getX(){
    return x;
  }

  public double getY(){
    return y;
  }

	public Shape drawableObject(){
		return object;
	}

	public void  setColor(Color color){
		this.object.setFill(color);
	}
}
