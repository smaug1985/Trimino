/**
 * @author smaug
 * Clase que representa una ficha trimino.
 */

/**
 * Orientaciones de una ficha.
 */
enum FichaOrientacion{
	FichaOrientacionArribaIzquierda,
	FichaOrientacionArribaDerecha,
	FichaOrientacionAbajoIzquierda,
	FichaOrientacionAbajoDerecha,
}


public class Ficha {
	 /**
	  * La lista de caracteres que pueden representar un trimino.
	  */
	static	char[] caracteres={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k',
				'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I',
				'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	static	int contadorCaracter = 0; // Contador para ir seleccionando el caracter que toque.
	
	
	private Celda celdaCentral,celdaIzquierda,celdaDerecha; // Celdas del trimino.
	private FichaOrientacion orientacion; // Orientacion de la ficha.
	
	/**
	 * Constructor de una ficha
	 * @param x Coordenada X de la ficha central
	 * @param y Coordenada Y de la ficha central
	 * @param orientacion Orientaci—n de la ficha, hacia donde est‡ el hueco.
	 */
	public Ficha(int x,int y, FichaOrientacion orientacion){
		this.orientacion = orientacion;
		char c = caracteres[contadorCaracter++]; // Asocia el caracter correspondiente de las celdas.
		if(contadorCaracter >= caracteres.length) contadorCaracter=0; // Filtro para que no se salga del array
		//Construccion de la ficha segœn la posici—n y orientacion.
		switch(orientacion){
		case FichaOrientacionArribaIzquierda:
				this.celdaCentral = new Celda(x, y, c);
				this.celdaIzquierda = new Celda(x-1, y, c);
				this.celdaDerecha = new Celda(x, y-1, c);
			break;
		case FichaOrientacionArribaDerecha:
				this.celdaCentral = new Celda(x, y, c);
				this.celdaIzquierda = new Celda(x, y-1, c);
				this.celdaDerecha = new Celda(x+1, y, c);
			break;
		case FichaOrientacionAbajoIzquierda:
				this.celdaCentral = new Celda(x, y, c);
				this.celdaIzquierda = new Celda(x, y+1, c);
				this.celdaDerecha = new Celda(x-1, y, c);
			break;
		case FichaOrientacionAbajoDerecha:
				this.celdaCentral = new Celda(x, y, c);
				this.celdaIzquierda = new Celda(x+1, y, c);
				this.celdaDerecha = new Celda(x, y+1, c);
			break;
		}
	}

	public Celda getCeldaCentral() {
		return celdaCentral;
	}

	public void setCeldaCentral(Celda celdaCentral) {
		this.celdaCentral = celdaCentral;
	}

	public Celda getCeldaIzquierda() {
		return celdaIzquierda;
	}

	public void setCeldaIzquierda(Celda celdaIzquierda) {
		this.celdaIzquierda = celdaIzquierda;
	}

	public Celda getCeldaDerecha() {
		return celdaDerecha;
	}

	public void setCeldaDerecha(Celda celdaDerecha) {
		this.celdaDerecha = celdaDerecha;
	}

	public FichaOrientacion getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(FichaOrientacion orientacion) {
		this.orientacion = orientacion;
	}
	
	
}
