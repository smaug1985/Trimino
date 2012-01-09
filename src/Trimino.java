import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * 
 * @author smaug
 * 
 * Contiene el main del programa  y el algoritmo de resoluci—n Divide y Venceras.
 *
 */

public class Trimino {
	static Tablero tablero; // El tablero del trimino.
	static Config gameConfig; // La configuraci—n del programa segœn los parametros de entrada.
	static PrintStream outStream; // El flujo de salida para el programa.
	
	/**
	 * Metodo que se encarga de buscar donde est‡ la pieza marcada y poner en el centro de la matriz representada en el triangulo
	 * el trimino correspondiente.
	 * Devuelve si es el caso trivial, que es representado por un Rectangulo 2x2
	 */
	public static boolean buscarLleno(Rectangulo r){
		boolean mustBreak=false;
		Ficha ficha=null; 
		int mitadX = r.getMitadX()+1;
		int mitadY = r.getMitadY()+1;
		int i=0,j=0;
		
		// Buscamos la casilla marcada
		for(i=r.getX();i<=r.getWidth();i++){
			for(j=r.getY();j<=r.getHeight();j++){
				if(tablero.getCaracterAtPosition(i, j)!='\0'){
					mustBreak=true;
					break;
				}
			}
			if(mustBreak) break;
		}
		
		// Creamos la ficha trimino, segœn el cuadrante en el que estŽ la casilla marcada,
		// Lo crea en el centro de y con el hueco apuntando hacia el cuadrante de la casilla marcada.
		if(i < mitadX && j < mitadY){
			 ficha = new Ficha(mitadX,mitadY,FichaOrientacion.FichaOrientacionArribaIzquierda);
		}else if(i >= mitadX && j < mitadY){
			 ficha = new Ficha(mitadX-1,mitadY,FichaOrientacion.FichaOrientacionArribaDerecha);
		}else if(i < mitadX && j >= mitadY){
			 ficha = new Ficha(mitadX,mitadY-1,FichaOrientacion.FichaOrientacionAbajoIzquierda);
		}else if(i >= mitadX && j >= mitadY){
			 ficha = new Ficha(mitadX-1,mitadY-1,FichaOrientacion.FichaOrientacionAbajoDerecha);
		}
		tablero.insertarFichar(ficha);
		// Si est‡ activada, imprime la traza del proceso de resoluci—n.
		if(gameConfig.isDebugMode()){
			tablero.imprimirTablero(outStream);
			outStream.println();
		}
		// Devuelve si es el caso trivial 
		if(r.getSize() == 2){
			return true;
		}else{
			return false;
		}

	}
	
	/**
	 * Algoritmo divide y venceras. Se encarga de solucionar el problema del Trimino.
	 * Recibe un objeto Rectangulo, que representa el cuadrado de la matriz a resolver.
	 */
	public static void divide(Rectangulo r){
		boolean b=buscarLleno(r); 
		if(b) // comprobacion de si es el caso trivial 
			return;
		// Division en subproblemas
		ArrayList<Rectangulo> rects = r.dividirEnCuatro();
		for(Rectangulo r1  : rects){
			divide(r1); // Llamada recursiva para resolver el subproblema
		}
	}
	
	/**
	 * Muestra la ayuda del programa por pantalla
	 */
	public static void showHelp(){
		System.out.println("Invocaci—n del programa: Trimino [-t]Ê[-h] x y [d] [file.txt]");
		System.out.println("Opciones:");
		System.out.println("-t \t\tMuestra la traza de la resoluci—n del trimino.");
		System.out.println("-h \t\tMuestra este menœ de ayuda.");
		System.out.println("x y \t\tSon las coordenadas de la primera casilla marcada, tienen que ser entre 0 y d-1");
		System.out.println("d \t\tEl tama–o de la matriz cuadrada. Tiene que ser un nœmero del tipo 2^k. Por ejemplo: 4,8,64. Por defecto es 8");
		System.out.println("file.txt \tSi se especifica un nombre de fichero, la salida en vez de ser por la  pantalla, ser‡ la fichero.");
	}
	
	
	public static void main(String[] args) {
		
		gameConfig = Config.getConfig(args); // Parseamos el array de argumentos y obtenemos un objeto de configuraci—n.
		
		
		// Si los parametros de entrada han sido bien construidos
		if(gameConfig.isWellConstructed()){
			// Muestra la ayuda si se ha pedido por parametros.
			if(gameConfig.isShowHelp()){
				showHelp();
			}
			
			//Preparamos el flujo de salida, que puede ser por pantalla o un fichero.
			if(gameConfig.getOutFilename()!=null){
				try {
					outStream = new PrintStream(gameConfig.getOutFilename());
				} catch (FileNotFoundException e) {
					outStream = System.out;
				}
			}else{
				outStream = System.out;
			}
			//Prepara la celda marcada y el tablero.
			Celda celda = new Celda(gameConfig.getCoordX(),gameConfig.getCoordY(), '#');
			tablero = new Tablero(gameConfig.getSize(),celda);
			divide(tablero.getRectangulo()); // Comenzamos el divide y venceras para resolver el problema.
			if(!gameConfig.isDebugMode()) tablero.imprimirTablero(outStream); //Muestra el tablero si no se ha mostrado la traza.
		}else{
			showHelp();
		}
	}

}
