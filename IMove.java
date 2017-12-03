public interface IMove{
	public void move();
	public boolean collision(BoardObject object);

  public void setMove(double xMove, double yMove);
	
	public double getXMove();
	public double getYMove();
}
