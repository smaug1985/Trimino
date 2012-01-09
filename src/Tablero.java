import java.io.PrintStream;
/**
 * Representa el tablero de juego
 * @author smaug
 *
 */

public class Tablero {
	
	private char tablero[][]; // Matriz para el tablero de juego.
	
	/**
	 * Crea un tablero vacio
	 * @param lado Tama–o del lado
	 */
	public Tablero(int lado){
		this.tablero = new char[lado][lado];
	}
	/**
	 * Crea un tablero con la celda especificada marcada
	 * @param lado Tama–o del lado
	 * @param celdaInicial celda inicial que se marcar‡.
	 */	
	public Tablero(int lado,Celda celdaInicial){
		this.tablero = new char[lado][lado];
		insertarCelda(celdaInicial);
	}
	
	/**
	 * Comprueba que se pueda insertar una celda
	 * @param celda
	 * @return
	 */
	public boolean puedeInsertarCelda(Celda celda){
		int size=tablero.length;
		if(celda.getX() < 0 ||celda.getX() >= size) return false;
		if(celda.getY() < 0 ||celda.getY() >= size) return false;
		if(tablero[celda.getX()][celda.getY()]!='\0') return false;
		return true;
	}
	
	/**
	 * Inserta una celda si se puede en el tablero.
	 * @param celda
	 */
	public void insertarCelda(Celda celda){
		if(puedeInsertarCelda(celda)){
			tablero[celda.getX()][celda.getY()] = celda.getC();
		}	
	}
	/**
	 * Devuelve el tama–o de la celda
	 * @return
	 */
	public int size(){
		return tablero.length;
	}
	
	/** 
	 * Inserta una ficha trimino en el tablero si se puede
	 * @param ficha
	 */
	public void insertarFichar(Ficha ficha){
		
		if(puedeInsertarCelda(ficha.getCeldaCentral()) &&
		   puedeInsertarCelda(ficha.getCeldaDerecha()) &&
		   puedeInsertarCelda(ficha.getCeldaIzquierda()) ){
			insertarCelda(ficha.getCeldaCentral());
			insertarCelda(ficha.getCeldaDerecha());
			insertarCelda(ficha.getCeldaIzquierda());
		}
	}
	/**
	 * Devuelve el caracter de la posici—n especificada.
	 * En caso de salirse de rango devuelve \0
	 * @param x
	 * @param y
	 * @return
	 */
	public char getCaracterAtPosition(int x,int y){
		if((x>=tablero.length) || (y >= tablero.length))
			return '\0';
		
		return this.tablero[x][y];
	}

	/**
	 * Devuelve un rectangulo del tama–o del tablero
	 * @return
	 */
	public Rectangulo getRectangulo(){
		return new Rectangulo(0,0,size()-1,size()-1);
	}
	
	/**
	 * Imprime el tablero en la salida output
	 * @param output
	 */
	public void imprimirTablero(PrintStream output){
		for(int i=0;i<tablero.length;i++){
			output.print("|");
			for(int j=0;j<tablero.length;j++){
				char c = tablero[i][j];
				if(c=='\0') c='.';
				output.print(c);
				output.print("|");
			}
			output.println();
		}
		
	}
	
	/**
	 * Imprime el tablero por la salida estandard
	 */
	public void imprimirTablero(){
		imprimirTablero(System.out);
	}
}
