class ArkanoidBoardController{

  public ArkanoidBoard arkanoidBoard;

  public ArkanoidBoardController(ArkanoidBoard arkanoidBoard){
    this.arkanoidBoard = arkanoidBoard;
  }

    public void arkanoidAnimation(long time, long lastTime){
        //gerer l'animation du jeu
        //gestion des colision
        //gestion des rebond
    }

    public boolean loadingLevel(int level){
            return this.arkanoidBoard.chargementDeNiveau(level);
    }

    public void pushLeftKey(){
            this.arkanoidBoard.getRaquette().goLeft();
            if(this.arkanoidBoard.getRaquette().collision(this.arkanoidBoard.getCadre()))
                    this.arkanoidBoard.getRaquette().goRight();
    }

    public void pushRightKey(){
            this.arkanoidBoard.getRaquette().goRight();
            if(this.arkanoidBoard.getRaquette().collision(this.arkanoidBoard.getCadre()))
                    this.arkanoidBoard.getRaquette().goLeft();
    }
    
    private boolean collision(Balle balle, BoardObject object){

        if(object instanceof Cadre){

            double x = ((Cadre)object).getX();
            double y = ((Cadre)object).getY();
            double w = ((Cadre)object).getWidth();
            double h = ((Cadre)object).getHeight();
            
            System.out.println(x+" "+(this.getX()+rayon()));

            if( x>=(this.getX()+rayon()) || (x+w)<=(this.getX()+rayon()) ){
            this.xMove = -this.xMove;
            this.move();
            return true;
            }

            if( y>=(this.getY()+rayon()) || (y+h)<=(this.getY()+rayon())  ){
            this.yMove = -this.yMove;
            this.move();
            
            return true;
        }
    }

    //Ajouter quand la balle touches le fond elle est detruite

    if(object instanceof Raquette){
        return false;
    }


    if(object instanceof Brique){
        return false;
    }

    return false;
    }

    //redefinir
    private boolean collisionBrique(double x,double y,double w, double h){
        if( x<=(this.getX()+rayon())    && y<=(this.getY()+rayon()) &&
        (x+w)>=(this.getX()+rayon()) && (y+h)>=(this.getY()+rayon()) )
            return true;
        else
            return false;
    }

}
