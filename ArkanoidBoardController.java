import javafx.scene.shape.Rectangle;

class ArkanoidBoardController{

    public ArkanoidBoard arkanoidBoard;

    public ArkanoidBoardController(ArkanoidBoard arkanoidBoard){
        this.arkanoidBoard = arkanoidBoard;
    }

    public void arkanoidAnimation(long time, long lastTime){

        double lapstime = time-lastTime;
        Balle balle = this.arkanoidBoard.getBalle();

        double xB = balle.getX()+balle.getXMove()*lapstime;
        double yB = balle.getY()+balle.getYMove()*lapstime;

        //gerer l'animation du jeu
        //gestion des colision
        //gestion des rebond

        if(this.collision(this.arkanoidBoard.getBalle(),this.arkanoidBoard.getCadre(),xB,yB))
            return;

        balle.setX(xB);
        balle.setY(yB);
    }

    public boolean loadingLevel(int level){
        return this.arkanoidBoard.chargementDeNiveau(level);
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

            if(xB+balle.getRadius() <= x || xB >= (x+w)){
                balle.setXMove(-balle.getXMove());
                return true;
            }

            if(yB+balle.getRadius() <= y || yB >= (y+h)){
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
