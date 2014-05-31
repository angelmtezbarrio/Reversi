/**
 * Paquete modelo.
 */
package juego.modelo;

import juego.modelo.Celda;
import juego.modelo.Color;

/**
 * Nombre de la clase p�blica. Pieza.
 * 
 * @author Carolina Colina Zamorano.
 * @since Final
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
	/**
	 * M�todo que obtiene el color de una pieza.
	 * @author angelillo
	 * @return el atributo color propio de la clase
	 */
	public Color obtenerColor() {
		return this.color;
	}

	/**
	 * M�todo que retorna el car�cter correspondiente a la pieza ('X', 'O').
	 */
	public String toString() {
		return "" + color.toChar();
	}

	/**
	 * M�todo que coloca una celda.
	 * 
	 * @param celda
	 *            celda.
	 */
	public void colocar(Celda celda) {
		this.celda = celda;
	}

	/**
	 * M�todo que obtiene una celda.
	 * 
	 * @return el atributo celda propio de la clase.
	 */
	public Celda obtenerCelda() {
		return this.celda;
	}
}