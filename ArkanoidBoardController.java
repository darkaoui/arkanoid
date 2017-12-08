import javafx.scene.shape.Rectangle;
import javafx.animation.AnimationTimer;

class ArkanoidBoardController{

    public ArkanoidBoard arkanoidBoard;
    private long lapstime;
    private AnimationTimer animation;

    public ArkanoidBoardController(ArkanoidBoard arkanoidBoard, AnimationTimer animation){
        this.arkanoidBoard = arkanoidBoard;
        this.animation     = animation;
    }

    public void arkanoidAnimation(long time, long lastTime){

        long lapstime = time-lastTime;

        Balle balle = this.arkanoidBoard.getBalle();
        double xB = balle.getX()+balle.getXMove()*lapstime;
        double yB = balle.getY()+balle.getYMove()*lapstime;

        if(this.collision(this.arkanoidBoard.getBalle(),this.arkanoidBoard.getCadre(),xB,yB)){
            //verifier si le ballle a explose
            return;
        }

        //Verifier si on casse Une brique pour le disparaitre
        //Au cas ou toutes les briques sont brisee fin du jeux

        //Verifier

        balle.setX(xB);
        balle.setY(yB);
    }

    public void run(){
        this.arkanoidBoard.setRunning(true);
        this.animation.start();
    }

    public void stop(){
        this.arkanoidBoard.setRunning(false);
        this.animation.stop();
    }

    public boolean loadingLevel(int level){
        if(!this.arkanoidBoard.chargementDeNiveau(level))
            return false;

        this.arkanoidBoard.setNiveauActuel(level);
        return false;
    }

    public void pushLeftKey(){
        double x = this.arkanoidBoard.getRaquette().getX();
        x-= this.arkanoidBoard.getRaquette().getMoveConstant();

        if(x > this.arkanoidBoard.getCadre().getX())
            this.arkanoidBoard.getRaquette().setX(x);
    }

    public void pushRightKey(){
        double x = this.arkanoidBoard.getRaquette().getX();
        double w = this.arkanoidBoard.getRaquette().getWidth();
        x+= this.arkanoidBoard.getRaquette().getMoveConstant();

        if((x+w) > this.arkanoidBoard.getCadre().getX())
            this.arkanoidBoard.getRaquette().setX(x);
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

            if(yB-balle.getRadius() <= y || yB+balle.getRadius() >= (y+h)){
                balle.setYMove(-balle.getYMove());
                return true;
            }

            return false;
        }

        //Ajouter quand la balle touches le fond elle est detruite

        if(object instanceof Raquette){
            return false;
        }

        if(object instanceof Brique){
            return false;
        }

        if(object instanceof Cadre){
            return false;
        }

        return false;
    }
}
