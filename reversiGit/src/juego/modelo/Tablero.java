/**
 * Paquete modelo.
 */
package juego.modelo;

/**
 * Listado de clases que hemos importado de otro paquete y que vamos a necesitar.
 */
import juego.modelo.Celda;
import juego.modelo.Color;
import juego.util.Dirección;

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
}