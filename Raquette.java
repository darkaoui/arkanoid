public class Raquette extends BoardObject  implements Move{

	double longueur;
	double largeur;

	double xMove;
	double yMove;
  
	public Raquette(int x, int y, int longueur, int largeur){
		
		this.longueur = x;
		this.largeur  = y;

		this.xMove = 0;
		this.yMove = 0;
  }
	
	public move(){
		this.x+=xMove;
		this.y+=yMove;
	}

	public boolean collision(){
		
	}

	public void setMove(double xMove, double yMove){
		this.xMove = xMove;
		this.yMove = yMove;
	}

	public double getX(){
		return this.x;
	}

	public double getY(){
		return this.y;
	}

	public double getXMove(){
		return xMove;
	}
	
	public double getYMove(){
		return yMove;
	}
}
