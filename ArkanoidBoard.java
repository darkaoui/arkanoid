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
        
        private Niveau chargeurNiveau;

	public ArkanoidBoard(){
	
            chargeurNiveau = new Niveau();

            briques = new ArrayList<>();
            

            this.cadre    =  new Cadre(0,0,300,400);
            this.raquette =  new Raquette(100,100,50,10);
            this.balle    =  new Balle(50,50,8);

            this.setX(0);
            this.setY(0);

            this.niveauActuel   = 0;
            this.nombreDeNiveau = nombreDeNiveau();
            this.looser = false;
            
            this.setVisible();
            
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
	
		this.cadre.setX(x);
		this.balle.setX(this.balle.getX()+x);
		this.raquette.setX(this.raquette.getX()+x);
		
		for(int i=1; i<this.briques.size();i++)
                    this.briques.get(i).setX(this.briques.get(i).getX()+x);
	}

	public void setY(double y){
	
            this.cadre.setY(y);
            this.balle.setY(this.balle.getY()+y);
            this.raquette.setY(this.raquette.getY()+y);

            for(int i=1; i<this.briques.size();i++)
                this.briques.get(i).setY(this.briques.get(i).getY()+y);
	
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
	

	public boolean endOfLevel(){
            //si la balle est percee ou les briques sont fini
            return false;
	}

	public boolean chargementDeNiveau(int niveau){
            
            this.getChildren().remove(this.balle);
            this.getChildren().removeAll(this.briques);
            this.briques.clear();
            
            
            //position initiale de la raquette
            this.raquette.setX((this.raquette.getWidth()/2)+this.this.cadre.getWidth()/2);
            
            //position initiale de la balle
            this.balle.setX((this.raquette.getX()+this.raquette.getWidth())/2);
            this.balle.setY(this.raquette.getY()-this.balle.getRadius());
            
            
            if(!chargeurNiveau.chargement("niveau"+niveau+".txt"))
                return false;
                
            this.briques.addAll(chargeurNiveau.getBriques());
                
            for(int i=1; i<this.briques.size();i++){
                
                double x = this.cadre.getX();
                double y = this.cadre.getY();
                
                this.briques.get(i).setY(this.briques().get(i).getY()+y);
                this.briques.get(i).setX(this.briques().get(i).getX()+x);
            }
            
            this.getChildren().addAll(briques);
            this.getChildren().add(this.balle);
            return true;
	}

	private int nombreDeNiveau(){
            //voir le nombre de fichiers
            //On utilise Niveau
            
            return 10;
	}

}
