/**
 * Paquete modelo.
 */
package juego.modelo;

/**
 * Nombre de la clase pública. Pieza.
 * 
 * @author Carolina Colina Zamorano.
 * @since 1.0
 * 
 */
public class Pieza {

	/**
	 * Atributo color de tipo Color.
	 */
	private Color color;
	/**
	 * Atributo celda de tipo Celda.
	 */
	private Celda celda;

	/**
	 * Constructor de la clase que crea el objeto color.
	 * 
	 * @param color
	 *            color de la pieza
	 */
	public Pieza(Color color) {
		this.color = color;
	}
}