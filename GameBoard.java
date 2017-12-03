import java.util.*;

public class GameBoard{

	private ArrayList<BoardObject> objects;

	double x;
	double y;

	private int niveauActuel;
	private int nombreDeNiveau;
	
 	boolean pause;

	public GameBoard(){

		this.objects  = new ArrayList<BoardObject>();
		this.objects.add(new Cadre(0,0,300,400));
		this.objects.add(new Raquette(0,0,50,50));
		this.objects.add(new Balle(7,7,20));

		this.x = 0;
		this.y = 0;

		this.niveauActuel = 0;
		this.nombreDeNiveau = nombreDeNiveau();
		
		this.pause = false;
	}

	public ArrayList<BoardObject> getObjects(){
		return this.objects;
	}

	public Raquette getRaquette(){
		return (Raquette)this.objects.get(1);
	}

	public Balle getBalle(){
		return (Balle)this.objects.get(2);	
	}

	public void setX(double x){
		this.x = x;
		this.objects.get(0).setX(x);

		for(int i=1; i<this.objects.size();i++)
			this.objects.get(i).setX(this.objects.get(i).getX()+x);
	}

	public void setY(double y){
		this.y = y;
		this.objects.get(0).setY(y);

		for(int i=1; i<this.objects.size();i++)
			this.objects.get(i).setY(this.objects.get(i).getY()+y);		
	}

	public void setPosition(double x, double y){
		this.setX(x);
		this.setY(y);
	}

	public int getNiveauActuel(){
		return this.niveauActuel;
	}

	public int getNombreDeNiveau(){
		return this.nombreDeNiveau;
	}

	public boolean chargementDeNiveau(int niveau){

		//On charge le niveau si c'est possible on vide et on ajoute toutes les briques
		return true;
	}

	private int nombreDeNiveau(){
		//voir le nombre de fichiers
		return 5;
	}

}
