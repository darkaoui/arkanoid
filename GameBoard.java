public class GameBoard{
	
	private ArrayList<Brique> briques;	
	private Raquette raquette;
	private Balle balle;

	private niveau;
	
	public GameBoard(){
		//initialiser les attributs
	}

	//En cas d'echec retourne false
	public boolean chargementNiveau(int niveau){
		
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
