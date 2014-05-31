/**
 * Paquete modelo.
 */
package juego.modelo;

import juego.modelo.Color;
import juego.modelo.Pieza;

/**
 * Nombre de la clase p�blica: Jugador.
 * 
 * @author Carolina Colina Zamorano.
 * @author SteBnoOni - Rubén Blanco Alcántara (revision)
 * @author angelillo
 * @since 1.0
 * @version Final
 * 
 */
public class Jugador {

	/**
	 * Atributo color de tipo Color.
	 */
	private Color color;
	/**
	 * Atributo nombre de tipo String.
	 */
	private String nombre;

	/**
	 * Constructor de la clase que crea los objetos nombre y jugador.
	 * 
	 * @param nombre
	 *            nombre del jugador.
	 * @param color
	 *            color que corresponde a ese jugador.
	 */
	public Jugador(String nombre, Color color) {
		this.nombre = nombre;
		this.color = color;
	}

	/**
	 * M�todo que obtiene el color.
	 * 
	 * @return atributo color propio de la clase.
	 */
	public Color obtenerColor() {
		return this.color;
	}

	/**
	 * M�todo que consulta el nombre del jugador.
	 * 
	 * @return atributo nombre propio de la clase.
	 */
	public String consultarNombre() {
		return this.nombre;
	}

	/**
	 * M�todo que genera una pieza de un color.
	 * 
	 * @return pieza genera una pieza.
	 */
	public Pieza generarPieza() {
		return new Pieza(color);
	}

	/**
	 * M�todo que retorna una cadena con el nombre del jugador y el color al que
	 * est� asociado.
	 */
	public String toString() {
		String cadena = this.nombre + " - " + this.color.toChar();
		return cadena;
	}

}