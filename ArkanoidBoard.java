import java.util.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class ArkanoidBoard extends Pane{

	private ArrayList<Brique> briques;

	private Raquette raquette;
	private Balle    balle;
	private Cadre    cadre;

	private int niveauActuel;
	private int nombreDeNiveau;

	private boolean looser;
	private boolean endOfLevel;
        private boolean running;

	private Niveau chargeurNiveau;

	

	public ArkanoidBoard(){

		this.chargeurNiveau = new Niveau();

		this.briques = new ArrayList<Brique>();

		this.cadre    =  new Cadre(0,0,300,400);
		this.raquette =  new Raquette(150-60/2,380,60,10,8);
		this.balle    =  new Balle(300,400,7);

		

		this.balle.setXMove(200E-9);
		this.balle.setYMove(-120E-9);

		this.setX(0);
		this.setY(0);

		this.niveauActuel   = 0;
		this.nombreDeNiveau = nombreDeNiveau();

		this.looser     = false;
		this.running    = false;
		this.endOfLevel = false;

		this.getChildren().add(cadre);
		this.getChildren().add(raquette);

		this.chargementDeNiveau(1);
	}

	public void setLooser(boolean looser){
		//mis a true si la balle est percee
		this.looser = looser;
	}

	public boolean getLooser(){
		return this.looser;
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

	public Cadre getCadre(){
		return this.cadre;
	}

	public void removeBrique(Brique brique){
		this.briques.remove(brique);
		this.getChildren().remove(brique);
	}

	public void setX(double x){

		double diff = x-this.cadre.getX();
		this.cadre.setX(x);

		this.balle.setX(this.balle.getX()+diff);
		this.raquette.setX(this.raquette.getX()+diff);

		for(int i=0; i<this.briques.size();i++)
			this.briques.get(i).setX(this.briques.get(i).getX()+diff);
	}

	public void setY(double y){

		double diff = y-this.cadre.getY();
		this.cadre.setY(y);

		this.balle.setY(this.balle.getY()+diff);
		this.raquette.setY(this.raquette.getY()+diff);

		for(int i=0; i<this.briques.size();i++)
			this.briques.get(i).setY(this.briques.get(i).getY()+diff);
	}

	public void setPosition(double x, double y){
		this.setX(x);
		this.setY(y);
	}

	public int getNiveauActuel(){
		return this.niveauActuel;
	}

	public void setNiveauActuel(int value){
		this.niveauActuel = value;
	}

	public int getNombreDeNiveau(){
		return this.nombreDeNiveau;
	}

	public void setEndOfLevel(boolean value){
		this.endOfLevel = value;
	}

	public boolean endOfLevel(){
		return this.endOfLevel;
	}

	public void setRunning(boolean value){
		this.running = value;
	}

	public boolean getRunning(){
		return this.running;
	}

	public boolean chargementDeNiveau(int niveau){

		this.getChildren().remove(this.balle);
		this.getChildren().removeAll(this.briques);
		this.briques.clear();

		//position initiale de la raquette
		this.raquette.setX((this.cadre.getWidth()/2-this.raquette.getWidth()/2));

		//position initiale de la balle
		this.balle.setX((this.cadre.getWidth())/2);
		this.balle.setY(this.raquette.getY()-this.balle.getRadius());

		if(!chargeurNiveau.chargement("Niveaux/niveau"+niveau))
			return false;

		this.briques.addAll(chargeurNiveau.getBriques());

		for(int i=0; i<this.briques.size();i++){

			double x = this.cadre.getX();
			double y = this.cadre.getY();

			this.briques.get(i).setY(this.briques.get(i).getY()+y);
			this.briques.get(i).setX(this.briques.get(i).getX()+x);
		}

                this.getChildren().addAll(briques);
		this.getChildren().add(this.balle);
		this.niveauActuel = niveau;

		return true;
	}

	private int nombreDeNiveau(){
		return chargeurNiveau.nombreDeFichierNiveau();
	}

}
