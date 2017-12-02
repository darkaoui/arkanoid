public class Raquette extends Brique implements Move{

	public Raquette(double x, double y, double longueur, double largeur){
		this.super(x,x,longueur,largeur);
		this.xMove = 0;
		this.yMove = 0;
  }

	public move(){
		this.x+=xMove;
		this.y+=yMove;
	}

	public void setMove(double xMove, double yMove){
		this.xMove = xMove;
		this.yMove = yMove;
	}

	public double getXMove(){
		return xMove;
	}

	public double getYMove(){
		return yMove;
	}

	public boolean collision(BorderObject object){
	}
}
