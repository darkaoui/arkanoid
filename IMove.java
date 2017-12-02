public interface IMove{
	public void move();
	public boolean collision(BoardOject object);

  public void setMove(double xMove, double yMove);
	
	public double getXMove();
	public double getYMove();
}
