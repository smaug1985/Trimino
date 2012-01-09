import java.util.ArrayList;
/**
 * Clase rectangulo, utilizada para ir centrandonos en un cuadrado especifico de la matriz del tablero.
 * @author smaug
 *
 */

public class Rectangulo {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	
	public Rectangulo(int x,int y, int width,int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height = height;
	}
	/**
	 * Divide las coordenadas del cuadrado, en 4 subcuadrados utilizados por el algoritmo divide y venceras.
	 * @return
	 */
	public ArrayList<Rectangulo> dividirEnCuatro(){
		ArrayList<Rectangulo> lista = new ArrayList<Rectangulo>();
		int a=getMitadX();
		int b =getMitadY();
		lista.add(new Rectangulo(x,y,a,b)); //Cuadrante 1
		lista.add(new Rectangulo(a+1,y,width,b)); // Cuadrante 2
		lista.add(new Rectangulo(x,b+1,a,height)); // Cuadrante 3
		lista.add(new Rectangulo(a+1,b+1,width,height)); // Cuadrante 4
		return lista;
	}
	/**
	 * Devuelve la mitad del ancho
	 * @return
	 */
	public int getMitadX(){
		return (width-x)/2 +x;
	}
	/**
	 * Devuelve la mitad del alto
	 * @return
	 */
	public int getMitadY(){
		return (height-y)/2 + y;
	}
	/**
	 * Devuelve el tama–o de del lado del cuadrado
	 * @return
	 */
	public int getSize(){
		return width-x+1;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public String toString(){
		return "x = "+x+" y = "+y+" width = "+width+" height = "+height;
	}
}
