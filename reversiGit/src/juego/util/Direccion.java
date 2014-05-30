package juego.util;

public class Direccion {
	/**
	 * Paquete util.
	 */
	package juego.util;

	/**
	 * Clase de tipo enumerado: Direccion.
	 * @Ruben
	 * @since 1.1
	 */
	public enum Direccion {
		/**
		 * Tipo enumerado dirección HORIZONTAL.
		 */
		HORIZONTAL(0, 1),
		/**
		 * Tipo enumerado dirección VERTICAL.
		 */
		VERTICAL(1, 0),
		/**
		 * Tipo enumerado dirección DIAGONAL_SO_NE.
		 */
		DIAGONAL_SO_NE(1, -1),
		/**
		 * Tipo enumerado dirección DIAGONAL_NO_SE.
		 */
		DIAGONAL_NO_SE(1, 1);

		/**
		 * Atributo desplazamientoFila de tipo entero.
		 */
		private int desplazamientoFila;

		/**
		 * Atributo desplazamientoColumna de tipo entero.
		 */
		private int desplazamientoColumna;

		/**
		 * Constructor que crea los objetos desplFila y desplColumna.
		 * 
		 * @param desplFila
		 *            desplazamiento de la fila.
		 * @param desplColumna
		 *            desplazamiento de la columna.
		 *            @autor angel
		 */
		private Direccion(int desplFila, int desplColumna) {
			this.desplazamientoFila = desplFila;
			this.desplazamientoColumna = desplColumna;
		}
	}
}
