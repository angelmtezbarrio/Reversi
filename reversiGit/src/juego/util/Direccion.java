/**
 * Paquete util.
 */
package juego.util;

/**
 * Clase de tipo enumerado: Direccion.
 * 
 * @author Rubén Blanco Alcántara.
 * @since 1.0
 * 
 */
public enum Direccion {
	/**
	 * Tipo enumerado dirección HORIZONTAL.
	 */
	HORIZONTAL(0, 1),
	/**
	 * Tipo enumerado dirección VERTICAL.
	 */
	VERTICAL(1, 0),
	/**
	 * Tipo enumerado dirección DIAGONAL_SO_NE.
	 */
	DIAGONAL_SO_NE(1, -1),
	/**
	 * Tipo enumerado dirección DIAGONAL_NO_SE.
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

	
}