public class BorderBoard extends BoardObject{
	private double longueur;
	private double largeur;

	private Rectangle object;

	public BorderBoard(){
		//donner des valeurs initiales
	}

	public BorderBoard(double longueur,double largeur){
		this.longueur = longueur;
		this.largeur  = largeur;
	}

	public void setColor(Color color){
		this.object.setStroke(color);
		this.object.setFill(Color.TRANSPARENT)
	}

	public Rectangle dessiner(){
		this.object.setX(this.x);
		this.object.setY(this.y);
		return this.object;
	}
}
