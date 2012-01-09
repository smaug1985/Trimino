/**
 * 
 * @author smaug
 *
 * Clase para representar la configuraci—n del programa.
 */
public class Config {

	private boolean debugMode = false; // Hacer la traza
	private boolean showHelp = false; // Mostrar el menudo de ayuda
	private boolean isWellConstructed = false; // Si la configuraci—n est‡ bien construida para la ejecuci—n del programa.
	private int coordX = -1; // Coordenada X de la primera casilla marcada.
	private int coordY = -1; // Coordenada Y de la primera casilla marcada.
	private int size = 8; // Tama–o del tablero
	private String outFilename = null; // Nombre del fichero de salida
	
	/**
	 * Constructor privado
	 */
	private Config(){
	}
	

	/**
	 * Metodo est‡tico  que recibe un array de argumentos y devuelve un objeto del tipo Config con la configuraci—n del programa.
	 * @param args Array de argumentos.
	 * @return Clase de configuraci—n.
	 */
	public static Config getConfig(String[]args){
		int i=0;
		Config config = new Config();
		
		if (args.length == 0) return config;
		
		//Activa el modo debug
		while(i<args.length){
			if(args[i].equals("-t")){
				config.debugMode = true;
			}
			//Activa si mostrar la ayuda
			else if(args[i].equals("-h")){
					config.showHelp = true;
			}
			else if((config.coordX =isPositiveNumber(args[i]))!=-1){
				i++;
				if(i<args.length)
					config.coordY =isPositiveNumber(args[i]);
				i++;
				if(i<args.length){
					if(isPositiveNumber(args[i])!=-1){
						config.size = isPositiveNumber(args[i]);
						i++;
					}
					if(i<args.length){
						config.outFilename = args[i];
						break;
					}
				}
			}
			i++;
		}
		config.isWellConstructed = config.isValid(); // comprueba que la configuraci—n sea valida para la ejecuci—n.
		return config;
	}
	/**
	 * Comprueba que el nœmero que recibe sea potencia de 2
	 * @param n
	 * @return
	 */
	private boolean isPower2(int n){
		if(n<=1) return false;
		while(n > 2){	
			if(n % 2 == 0){
				n /=2;
			}else{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Comprueba que la configuraci—n sea valida.
	 * Que el tama–o de la matriz sea potencia de dos y las coordenadas de la posici—n principal esten dentro del tama–o
	 * de la matriz.
	 * @return
	 */
	private boolean isValid(){
		if(!isPower2(size)) return false; 
		if(coordX<0 || coordX>=size) return false;
		if(coordY<0 || coordY>=size) return false;
		return true;
	}
	
	/**
	 * Metodo utilitario que devuelve un entero positivo, parseado desde un String.
	 * @param str
	 * @return Devuelve -1 si no es un nœmero o no es positivo.
	 */
	private static int isPositiveNumber(String str){
		try{
			int n=Integer.parseInt(str);
			return n;
		}catch(NumberFormatException e){}
		
		return -1;
	}
	
	public String toString(){
		return "x = "+coordX+", y = "+coordY+", size = "+size+", show Help = "+showHelp+", debugMode = "+debugMode+", filename = "+ outFilename+", is Well Constructed = "+isWellConstructed; 
	}



	public boolean isDebugMode() {
		return debugMode;
	}



	public boolean isShowHelp() {
		return showHelp;
	}



	public boolean isWellConstructed() {
		return isWellConstructed;
	}



	public int getCoordX() {
		return coordX;
	}



	public int getCoordY() {
		return coordY;
	}



	public int getSize() {
		return size;
	}



	public String getOutFilename() {
		return outFilename;
	}
	
	
}
