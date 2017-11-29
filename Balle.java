class Balle extends BoardObject implements Move{
  private double x;
  private double y;
  private double rayon;

  public Balle(){
  }

  public Balle(double x,double y,double rayon){
    this.x = x;
    this.y = y;
    this.rayon = rayon;
  }
}
