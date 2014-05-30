/**
 * Paquete util.
 */
package juego.util;

/**
 * Clase de tipo enumerado: Direccion.
 * 
 * @author Rubï¿½n Blanco Alcï¿½ntara.
 * @since 1.0
 * 
 */
public enum Direccion {
	/**
	 * Tipo enumerado direcciï¿½n HORIZONTAL.
	 */
	HORIZONTAL(0, 1),
	/**
	 * Tipo enumerado direcciï¿½n VERTICAL.
	 */
	VERTICAL(1, 0),
	/**
	 * Tipo enumerado direcciï¿½n DIAGONAL_SO_NE.
	 */
	DIAGONAL_SO_NE(1, -1),
	/**
	 * Tipo enumerado direcciï¿½n DIAGONAL_NO_SE.
	 */
	DIAGONAL_NO_SE(1, 1);

	/**
	 * Atributo desplazamientoFila de tipo entero.
	 */
	private int desplazamientoFila;

	/**
	 * Atributo desplazamientoColumna de tipo entero.
	 */
	private int desplazamientoColumna;

	/**
	 * Constructor que crea los objetos desplFila y desplColumna.
	 * 
	 * @param desplFila desplazamiento de la fila.
	 * @param desplColumnadesplazamiento de la columna.
	 * @autor angel
	 */
	private Direccion(int desplFila, int desplColumna) {
		this.desplazamientoFila = desplFila;
		this.desplazamientoColumna = desplColumna;
	}
	
	/**
	 * Método que obtiene el desplazamiento de la fila.
	 * 
	 * @return el desplazamiento de la fila.
	 */
	public int obtenerDesplazamientoFila() {
		return desplazamientoFila;
	}
}
