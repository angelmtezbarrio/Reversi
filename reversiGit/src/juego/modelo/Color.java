/**
 * Paquete modelo.
 */
package juego.modelo;

/**
 * Clase de tipo enumerado: Color.
 * 
 * @author Carolina Colina Colina Zamorano.
 * @since 1.0
 * 
 */
public enum Color {
	/**
	 * Tipo enumerado color BLANCO.
	 */
	BLANCO('O'),
	/**
	 * Tipo enumerado color NEGRO.
	 */
	NEGRO('X');

	/**
	 * Atributo car�cter de tipo char.
	 */
	private char caracter;

	/**
	 * M�todo que le asigna al atributo car�cter el car�cter pasado por
	 * par�metro.
	 * 
	 * @param c
	 *            car�cter.
	 */
	private Color(char c) {
		caracter = c;
	}
}