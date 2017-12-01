public interface IMove{
	public void move();
	public boolean collision(BoardOject object);

  public void setMove(double xMove, double yMove);
	public int getXMove();
	public int getYMove();
}
