import java.util.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class ArkanoidBoard extends Pane{

	private ArrayList<BoardObject> objects;

	private int niveauActuel;
	private int nombreDeNiveau;
	
  private boolean looser;
	
	public ArkanoidBoard(){
		
		objects = new ArrayList<>();

		this.objects.add(new Cadre(0,0,300,400));
		this.objects.add(new Raquette(100,100,50,10));
		this.objects.add(new Balle(50,50,20));

		for(int i=0; i<this.objects.size();i++)
			this.getChildren().add((Shape)this.objects.get(i));

		this.objects.get(0).setX(0);
		this.objects.get(0).setY(0);

		this.niveauActuel   = 0;
		this.nombreDeNiveau = nombreDeNiveau();
    
    this.looser = false;
	}

	public void setLooser(boolean looser){
    this.looser = looser;
  }

  public boolean getLooser(){
    return this.looser;
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

	public Cadre getCadre(){
		return (Cadre)this.objects.get(0);
	}

	public void removeBrique(Brique brique){
		this.objects.remove(brique);
	}

	public void setX(double x){
		this.objects.get(0).setX(x);
		this.objects.get(0).setX(x);
		
		//Adapter la position des objects au cadre
		for(int i=1; i<this.objects.size();i++)
			this.objects.get(i).setX(this.objects.get(i).getX()+x);
	}

	public void setY(double y){
		this.objects.get(0).setY(y);
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

	public boolean endOfLevel(){
    return true;
	}

	public boolean chargementDeNiveau(int niveau){

		//On charge le niveau si c'est possible on vide et on ajoute toutes les briques
		return true;
	}

	private int nombreDeNiveau(){
		//voir le nombre de fichiers
		return 10;
	}

}
