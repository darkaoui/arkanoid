public class GameBoard{

	private ArrayList<Brique> briques;
	private Raquette raquette;
	private Balle balle;

	private int level;
	private boolean pause;

	public GameBoard(){
		this.briques  = new ArrayList<Brique>();
		this.raquette = new Raquette(0,0,0,0);
		this.balle    = new Balle(0,0,0,0);

		this.level =  -1;
		this.pause =  false;
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

	public int getLevel(){
		return this.level;
	}

	public boolean getPause(){
		return this.pause;
	}

	public void setLevel(int level){
		this.level = level;
	}

	public void chargementNiveau(int niveau){
	}	
}
