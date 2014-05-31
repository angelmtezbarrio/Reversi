/**
 * Paquete modelo.
 */
package juego.modelo;

/**
 * Listado de clases que hemos importado de otro paquete y que vamos a necesitar.
 */
import juego.modelo.Celda;
import juego.modelo.Color;
import juego.util.Direccion;

/**
 * Nombre de la clase p�blica: Tablero.
 * 
 * @author Carolina Colina Zamorano.
 * @since 1.0
 * 
 */
public class Tablero {

	/**
	 * Atributo celda de tipo Celda[][].
	 */
	private Celda[][] celdas;

	/**
	 * Constructor que crea el objeto celdas.
	 * 
	 * @param fila
	 *            Se le pasa el n�mero de filas.
	 * @param columna
	 *            Se le pasa el numero de columnas.
	 */
	public Tablero(int fila, int columna) {
		celdas = new Celda[fila][columna];
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				celdas[i][j] = new Celda(i, j);
			}
		}
	}
	
	/**
	 * M�todo con el que se obtiene el n�mero de filas.
	 * 
	 * @return el n�mero de filas.
	 */
	public int obtenerNumeroFilas() {
		return this.celdas.length;
	}

	/**
	 * M�todo con el que se obtiene el n�mero de columnas.
	 * 
	 * @return el n�mero de columnas.
	 */
	public int obtenerNumeroColumnas() {
		return this.celdas[0].length;
	}

	/**
	 * M�todo que coloca una pieza en una celda, para ello comprueba que est� en
	 * el tablero, usando el m�todo estaEnTablero, que a su vez usa los dos
	 * anteriores que nos da el n�mero de filas y de columnas.
	 * 
	 * @param pieza
	 *            que queremos colocar.
	 * @param celda
	 *            donde queremos colocar la pieza.
	 */
	public void colocar(Pieza pieza, Celda celda) {
		int fila = celda.obtenerFila();
		int columna = celda.obtenerColumna();
		if (celdas[fila][columna] == celda) {
			celda.establecerPieza(pieza);
			pieza.colocar(celda);
		}
	}

	/**
	 * M�todo que obtiene la posici�n de una celda, se le pasa por par�metro la
	 * fila y la columna y devuelve el array celdas con la posici�n
	 * (coordenadas).
	 * 
	 * @param fila
	 *            del tablero.
	 * @param columna
	 *            del tablero.
	 * @return la posici�n de la celda.
	 */
	public Celda obtenerCelda(int fila, int columna) {
		if (estaEnTablero(fila, columna)) {
			return celdas[fila][columna];
		}
		return null;
	}
	/**
	 * M�todo que nos dice si la fila y la columna que le pasamos por par�metro
	 * est� dentro de los m�ximos del tablero. Tambi�n comprueba que los datos
	 * introducidos no sean n�meros negativos.
	 * 
	 * @param fila
	 *            si est� en el tablero.
	 * @param columna
	 *            si est� en el tablero.
	 * @return true si est� en el tablero, false sino est�.
	 */
	public boolean estaEnTablero(int fila, int columna) {
		if (fila >= 0 && fila < celdas.length && columna >= 0
				&& columna < celdas[0].length) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * M�todo que obtiene el m�mero de piezas del mismo color que hay en el
	 * tablero en un momento dado. Para ello recorre el tablero y comprueba que
	 * la celda no est� vac�a y que la pieza sea del color que se le pasa por
	 * par�metro.
	 * 
	 * @param color
	 *            de la pieza.
	 * @return el n�mero de piezas del mismo color.
	 */
	public int obtenerNumeroPiezas(Color color) {
		int piezas = 0;
		for (int i = 0; i < celdas.length; i++) {
			for (int j = 0; j < celdas[0].length; j++) {
				// Celda celdaAux = celdas[i][j]; if (celdaAux.estaVacia())
				if (!(celdas[i][j].estaVacia())
						&& celdas[i][j].obtenerPieza().obtenerColor() == color) {
					piezas++;
				}
			}
		}

		return piezas;
	}

	/**
	 * M�todo para comprobar si el tablero est� completo.
	 * 
	 * @return true si est�completo, false en caso contrario.
	 */
	public boolean estaCompleto() {
		for (int i = 0; i < celdas.length; i++) {
			for (int j = 0; j < celdas[0].length; j++) {
				if (celdas[i][j].estaVacia()) {
					return false;
				}

			}
		}
		return true;
	}

	/**
	 * M�todo que devuelve las piezas disponibles a sustituir, en una direcci�n
	 * dada.
	 * 
	 * @param celda
	 *            Celda de origen sobre la quecontar piezas.
	 * @param direccion
	 *            Direcci�n para contar piezas.
	 * @param color
	 *            Color de las piezas a comparar.
	 * @param ascendente
	 *            Sentido de la direcci�n.
	 * @return N�mero de piezas.
	 */
	public int contarPiezas(Celda celda, Direccion direccion, Color color,
			boolean ascendente) {
		int piezas = 0;
		int desplazFila;
		int desplazCol;
		boolean control = false;
		if (ascendente) {
			desplazFila = direccion.obtenerDesplazamientoFila();
			desplazCol = direccion.obtenerDesplazamientoColumna();
		} else {
			desplazFila = direccion.obtenerDesplazamientoFila() * -1;
			desplazCol = direccion.obtenerDesplazamientoColumna() * -1;
		}

		int i = celda.obtenerFila() + desplazFila;
		int j = celda.obtenerColumna() + desplazCol;

		while (estaEnTablero(i, j) && !control) {
			Celda aux = obtenerCelda(i, j);
			if (!aux.estaVacia()) {
				if (aux.obtenerPieza().obtenerColor() != color) {
					piezas++;
				}
				// SI ENCUENTRO UNA DE MI COLOR, SALGO DEL BUCLE
				else {
					control = true;
				}
				i = i + desplazFila;
				j = j + desplazCol;
			} else {
				// De esta manera le fuerzo a salir del bucle while
				i = -1;
				j = -1;
			}
		}
		// SI SALGO DEL BUCLE, SIN ENCONTRAR NINGUNA DE MI COLOR
		if (!control) {
			piezas = 0;
		}
		return piezas;
	}
}