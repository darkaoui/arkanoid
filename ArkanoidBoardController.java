

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

        double x = (object).getX();
        double y = (object).getY();
        double w = (object).getWidth();
        double h = (object).getHeight();

        if(object instanceof Cadre){

            if(xB-balle.getRadius() <= x || xB+balle.getRadius() >= (x+w)){
                balle.setXMove(-balle.getXMove());
                return true;
            }

            if(yB-balle.getRadius() <= y){
                balle.setYMove(-balle.getYMove());
                return true;
            }

	    if(yB+balle.getRadius() >= (y+h)){
		
		balle.setYMove(-balle.getYMove());
                this.arkanoidBoard.getBalle().setDestroyed(true);
		this.arkanoidBoard.getBalle().setFill(Color.RED);
		
                return true;
            }

            return false;
        }

        if(object instanceof Raquette){

	    Raquette r = arkanoidBoard.getRaquette();
	    double ecart = 2.0; //ecart pour le centre de la raquette

	    double rB  = balle.getRadius();

	    double intensite = Math.sqrt(Math.pow(balle.getXMove(),2)+Math.pow(balle.getYMove(),2));
	    double centreR = r.getX()+r.getWidth()/2;

	    //rebond sur la partie gauche de la raquette
	    if(yB+rB >= r.getY() && xB >= r.getX()-rB && xB < (centreR - ecart) ){

		balle.setYMove(-intensite*Math.sin(Math.PI/4));
		balle.setXMove(-intensite*Math.cos(Math.PI/4));
		
		return true;
	    }

	    //rebond sur la partie droite de la raquette
	    if(yB+rB >= r.getY() && xB > centreR+ecart && xB <= r.getX()+r.getWidth()+rB){

		balle.setYMove(intensite*Math.sin(-Math.PI/4));
		balle.setXMove(intensite*Math.cos(Math.PI/4));
		
		return true;
	    }

	    //rebond au milieu de la raquette
	    if(yB+rB >= r.getY()  && xB >= centreR-ecart && xB <= centreR+ecart){
		balle.setXMove(0);
		balle.setYMove(-intensite);
	    }
	    
            return false;
        }

        if(object instanceof Brique){

	    
	    
            return false;
        }

        return false;
    }
}
