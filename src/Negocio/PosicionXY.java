package Negocio;

public class PosicionXY {

	private int posX;
	private int posY;

	public PosicionXY(int x, int y) {
		this.posX = x;
		this.posY = y;
	}

	///////////////////////////////////////////////////////////////////////////// GETTERS
	///////////////////////////////////////////////////////////////////////////// &
	///////////////////////////////////////////////////////////////////////////// SETTERS
	public int getX() { return posX; }

	public void setX(int x) { this.posX = x; }

	public int getY() { return posY; }

	public void setY(int y) { this.posY = y; }

}
