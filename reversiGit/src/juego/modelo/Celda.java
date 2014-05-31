/**
 * Paquete modelo
 */
package juego.modelo;

import juego.modelo.Pieza;

/**
 * Clase p�blica: Celda.
 * 
 * @author Carolina Colina Colina Zamorano.
 * @author SteBnoOni - Rubén Blanco Alcántara (revision)
 * @author angelillo
 * @since 1.0
 * @version Final
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
	 * M�todo que nos dice la pieza.
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

	/**
	 * M�todo que nos dice si la pieza est� vacia.
	 * 
	 * @return si est� vac�a, false en caso contrario.
	 */
	public boolean estaVacia() {
		if (this.pieza == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * M�todo que obtiene la fila.
	 * 
	 * @return fila.
	 */
	public int obtenerFila() {
		return this.fila;
	}

	/**
	 * M�todo que obtiene la columna.
	 * 
	 * @return columna.
	 */
	public int obtenerColumna() {
		return this.columna;
	}

	/**
	 * M�todo que nos indica si est� vac�a la celda o no.
	 */
	public String toString() {
		if (estaVacia()) {
			return "-";
		} else {
			return obtenerPieza().toString();
		}
	}
}
