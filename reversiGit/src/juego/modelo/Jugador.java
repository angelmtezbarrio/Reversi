/**
 * Paquete modelo.
 */
package juego.modelo;

/**
 * Nombre de la clase pública: Jugador.
 * 
 * @author Carolina Colina Zamorano.
 * @since 1.0
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
	 * Método que obtiene el color.
	 * 
	 * @return atributo color propio de la clase.
	 */
	public Color obtenerColor() {
		return this.color;
	}
}