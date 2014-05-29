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
 * Nombre de la clase pública: Tablero.
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
	 *            Se le pasa el número de filas.
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
	 * Método con el que se obtiene el número de filas.
	 * 
	 * @return el número de filas.
	 */
	public int obtenerNumeroFilas() {
		return this.celdas.length;
	}

	/**
	 * Método con el que se obtiene el número de columnas.
	 * 
	 * @return el número de columnas.
	 */
	public int obtenerNumeroColumnas() {
		return this.celdas[0].length;
	}

	/**
	 * Método que coloca una pieza en una celda, para ello comprueba que esté en
	 * el tablero, usando el método estaEnTablero, que a su vez usa los dos
	 * anteriores que nos da el número de filas y de columnas.
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
	 * Método que obtiene la posición de una celda, se le pasa por parámetro la
	 * fila y la columna y devuelve el array celdas con la posición
	 * (coordenadas).
	 * 
	 * @param fila
	 *            del tablero.
	 * @param columna
	 *            del tablero.
	 * @return la posición de la celda.
	 */
	public Celda obtenerCelda(int fila, int columna) {
		if (estaEnTablero(fila, columna)) {
			return celdas[fila][columna];
		}
		return null;
	}
}