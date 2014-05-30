
package juego.modelo;

/**
 * Clase p�blica: Celda.
 * 
 * @author Carolina Colina Colina Zamorano.
 * @since 1.0
 * 
 */
public class Celda {

	/**
	 * Atributo pieza de tipo Pieza.
	 */
	private Pieza pieza;
	/**
	 * Atributo fila de tipo entero.
	 */
	int fila;
	/**
	 * Atributo columna de tipo entero.
	 */
	int columna;

	/**
	 * Constructor de la clase que crea los objetos fila y columna.
	 * 
	 * @param fila
	 *            donde est� la celda
	 * @param columna
	 *            donde esta la celda
	 * 
	 */
	public Celda(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}
	
	/**
	 * M�todo que nos dice la pieza que usamos.
	 * 
	 * @return pieza.
	 */
	public Pieza obtenerPieza() {
		return this.pieza;
	}

	/**
	 * M�todo que establece la pieza.
	 * 
	 * @param pieza
	 *            que queremos establecer
	 */
	public void establecerPieza(Pieza pieza) {
		this.pieza = pieza;
	}
}