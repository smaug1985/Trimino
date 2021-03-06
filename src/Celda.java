/**
 * 
 * @author smaug
 *
 * Representa una celda del tablero.
 */
public class Celda {

	private int x,y; // coordenadas de posición
	private char c; // Caracter con el que se rellenará la celda.
	
	public Celda(int x,int y, char c){
		this.x = x;
		this.y = y;
		this.c = c;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}
	
	
}
