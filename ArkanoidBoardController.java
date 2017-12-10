
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

class ArkanoidBoardController{

    public ArkanoidBoard arkanoidBoard;
    private long lapstime;

    public ArkanoidBoardController(ArkanoidBoard arkanoidBoard){
        this.arkanoidBoard = arkanoidBoard;
    }

    public void arkanoidAnimation(long time, long lastTime){

        long lapstime = time-lastTime;

        Balle balle = this.arkanoidBoard.getBalle();
	
        double xBalleNew = balle.getX()+balle.getXMove()*lapstime;
        double yBalleNew = balle.getY()+balle.getYMove()*lapstime;

        if(this.collision(this.arkanoidBoard.getBalle(),this.arkanoidBoard.getCadre(),xBalleNew,yBalleNew)){
            //verifier si le ballle a explose
            return;
        }

	if(this.collision(this.arkanoidBoard.getBalle(),this.arkanoidBoard.getRaquette(),xBalleNew,yBalleNew)){
	    //Traitement
	  return;
	}

	for(int i=0; i<this.arkanoidBoard.getBriques().size();i++){
	    if(this.collision(this.arkanoidBoard.getBalle(),this.arkanoidBoard.getBriques().get(i),xBalleNew,yBalleNew)){
	      //Traitement
	      //return;
	    }
	}
	
        //Verifier si on casse Une brique pour le disparaitre
        //Au cas ou toutes les briques sont brisee fin du jeux

        //Verifier

        balle.setX(xBalleNew);
        balle.setY(yBalleNew);
    }

    public void run(){
        this.arkanoidBoard.setRunning(true);
    }

    public void stop(){
        this.arkanoidBoard.setRunning(false);
    }

    public boolean loadingLevel(int level){
        if(!this.arkanoidBoard.chargementDeNiveau(level))
            return false;

        this.arkanoidBoard.setNiveauActuel(level);
	
        return true;
    }

    public void pushLeftKey(){

	double x = this.arkanoidBoard.getRaquette().getX();
        x-= this.arkanoidBoard.getRaquette().getMoveConstant();

        if(x > this.arkanoidBoard.getCadre().getX())
	  this.arkanoidBoard.getRaquette().setX(x);
	else
	    this.arkanoidBoard.getRaquette().setX(this.arkanoidBoard.getCadre().getX()+0.1);
    }

    public void pushRightKey(){

	double x = this.arkanoidBoard.getRaquette().getX();
        double w = this.arkanoidBoard.getRaquette().getWidth();

	double xR = this.arkanoidBoard.getCadre().getX();
	double wR =  this.arkanoidBoard.getCadre().getWidth();
	
        x+= this.arkanoidBoard.getRaquette().getMoveConstant();

	
        if((x+w) < (xR+wR))
	  this.arkanoidBoard.getRaquette().setX(x);
	else
	    this.arkanoidBoard.getRaquette().setX( xR+wR+-w-0.1);
    }

    private boolean collision(Balle balle, Rectangle object, double xB, double yB){

	Point2D p1 = new Point2D(object.getX(),object.getY());
	Point2D p2 = new Point2D(object.getX()+object.getWidth(), object.getY()+object.getHeight());

	Point2D pB = new Point2D(xB,yB);

	double  rB = balle.getRadius();

	
	//en fonction du point de contact on calcul la distance puis on compare au rayon de la balle
	
	if(object instanceof Cadre){
	    
	    if(pB.distance(p1.getX(),pB.getY())<=rB || (pB.distance(p2.getX(),pB.getY())) <= rB ){
		balle.setXMove(-balle.getXMove());
		return true;
	    }

	    if(pB.distance(pB.getX(),p1.getY())<=rB){
		balle.setYMove(-balle.getYMove());
                return true;
	    }

	    if(pB.distance(pB.getX(),p2.getY()) <= rB){

		balle.setYMove(-balle.getYMove());
                this.arkanoidBoard.getBalle().setDestroyed(true);
		this.arkanoidBoard.getBalle().setFill(Color.RED);
		
                return true;
	    }

	}

	if(object instanceof Raquette){

	    double ecart = 2.0; //grandeur du centre

	    double centreR   = this.arkanoidBoard.getRaquette().getWidth()/2;
	    double intensite = Math.sqrt(Math.pow(balle.getXMove(),2)+Math.pow(balle.getYMove(),2));
	    
	    if(pB.distance(pB.getX(),p1.getY()) <= rB && pB.getX() >= p1.getX() && pB.getX() <= p2.getX()){

		System.out.println("Raquette toucher");

		//A gauche 
		if(pB.getX() < p1.getX()+centreR-ecart){
		    balle.setYMove(-intensite*Math.sin(Math.PI/4));
		    balle.setXMove(-intensite*Math.cos(Math.PI/4));
		}

		//A droite
		if(pB.getX() > p1.getX()+centreR + ecart){
		    balle.setYMove(intensite*Math.sin(-Math.PI/4));
		    balle.setXMove(intensite*Math.cos(Math.PI/4));
		}

		return true;
	    }

	    //les coins de la raquette
	    if(pB.distance(p1) <= rB){
		balle.setYMove(-intensite*Math.sin(Math.PI/4));
		balle.setXMove(-intensite*Math.cos(Math.PI/4));

		return true;
	    }

	    if(pB.distance(p2.getX(),p1.getY()) <= rB){
		balle.setYMove(intensite*Math.sin(-Math.PI/4));
		balle.setXMove(intensite*Math.cos(Math.PI/4));

		return true;
	    }
	    
	}

	if(object instanceof Brique){

	    boolean col = false;

	    //en haut
	    if(pB.distance(pB.getX(),p1.getY()) <= rB && pB.getX() >= p1.getX() && pB.getX() <= p2.getX()){
		balle.setYMove(-balle.getYMove());
		col = true;
		System.out.println("Brique toucher");
	    }

	    //en bas
	    if(pB.distance(pB.getX(),p2.getY()) <= rB && pB.getX() >= p1.getX() && pB.getX() <= p2.getX()){
		balle.setYMove(-balle.getYMove());
		col = true;
		System.out.println("Brique toucher");
	    }

	    //a gauche
	    if(pB.distance(p1.getX(),pB.getY()) <= rB && pB.getY() >= p1.getY() && pB.getY() <= p2.getY()){
		balle.setXMove(-balle.getXMove());
		col = true;
		System.out.println("Brique toucher");
	    }

	    //a droite
	    if(pB.distance(p2.getX(),pB.getY()) <= rB && pB.getY() >= p1.getY() && pB.getY() <= p2.getY()){
		balle.setXMove(-balle.getXMove());
		col = true;
		System.out.println("Brique toucher");
	    }

	    //les coins
	    if(pB.distance(p1) <= rB || pB.distance(p2) <= rB ||
	       pB.distance(p2.getX(),p1.getY()) <= rB || pB.distance(p1.getX(),p2.getY()) <= rB){
		balle.setYMove(-balle.getYMove());
		balle.setXMove(-balle.getXMove());
		col = true;
		System.out.println("Brique toucher");
	    }

	    return col;
	}
	

        return false;
    }
}
