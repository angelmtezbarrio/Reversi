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
	 * Atributo carácter de tipo char.
	 */
	private char caracter;

	/**
	 * Método que le asigna al atributo carácter el carácter pasado por
	 * parámetro.
	 * 
	 * @param c
	 *            carácter.
	 */
	private Color(char c) {
		caracter = c;
	}
}