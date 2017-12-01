public class GameBoard{

	private ArrayList<Brique> briques;
	private Raquette raquette;
	private Balle balle;


	public GameBoard(){
		//initialiser les attributs
	}
	
	public ArrayList<Brique> getBriques(){
		return this.briques;
	}

	public Raquette getRaquette(){
		return this.raquette;
	}

	public Balle getBalle(){
		return this.balle;
	}
}
