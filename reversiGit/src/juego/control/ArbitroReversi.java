/**
 * Paquete control.
 */
package juego.control;

/**
 * Listado de clases que hemos importado de otro paquete y que vamos a necesitar.
 */
import juego.modelo.Celda;
import juego.modelo.Color;
import juego.modelo.Jugador;
import juego.modelo.Pieza;
import juego.modelo.Tablero;
import juego.util.Direccion;

/**
 * Nombre de la clase pública: ArbitroReversi.
 * 
 * @author Carolina Colina Zamorano.
 * @since 1.0
 * 
 */
public class ArbitroReversi {

	/**
	 * Atributo tablero de tipo Tablero.
	 */
	private Tablero tablero;
	/**
	 * Atributo jug1 de tipo Jugador.
	 */
	private Jugador jug1;
	/**
	 * Atributo jug2 de tipo Jugador.
	 */
	private Jugador jug2;
	/**
	 * Atributo turno de tipo Color.
	 */
	private Color turno;

	/**
	 * Constructor que crea el objeto tablero.
	 * 
	 * @param tablero
	 *            Se le pasa un parámetro tablero y se le asigna al objeto
	 *            this.tablero.
	 */
	public ArbitroReversi(Tablero tablero) {
		this.tablero = tablero;

		int comienzoFilas = (tablero.obtenerNumeroFilas() / 2) - 1;
		int comienzoColumnas = (tablero.obtenerNumeroColumnas() / 2) - 1;

		Pieza pieza1 = new Pieza(Color.BLANCO);
		Pieza pieza2 = new Pieza(Color.NEGRO);
		Pieza pieza3 = new Pieza(Color.BLANCO);
		Pieza pieza4 = new Pieza(Color.NEGRO);

		//Coloca las 4 piezas centrales
		this.tablero.obtenerCelda(comienzoFilas, comienzoColumnas)
				.establecerPieza(pieza1);
		this.tablero.obtenerCelda(comienzoFilas, comienzoColumnas + 1)
				.establecerPieza(pieza2);
		this.tablero.obtenerCelda(comienzoFilas + 1, comienzoColumnas + 1)
				.establecerPieza(pieza3);
		this.tablero.obtenerCelda(comienzoFilas + 1, comienzoColumnas)
				.establecerPieza(pieza4);

		//Que comience por el turno de las piezas de color negro
		turno = Color.NEGRO;
	}

	/**
	 * Método registrarJugador al que se le pasa un parámetro nombre de tipo
	 * String y asocia el jugador a un color.
	 * 
	 * @param nombre
	 *            Nombre del jugador a registrar.
	 */
	public void registrarJugador(String nombre) {
		// Si j1 == null le crea, si está creado comprueba que j2 ==
		// null y lo crea sin necesidad de comprobar que j1 == null
		if (jug1 == null) {
			jug1 = new Jugador(nombre, Color.NEGRO);
		} else if (jug2 == null) {
			jug2 = new Jugador(nombre, Color.BLANCO);
		}
	}

	/**
	 * Método consltarTurno. Retorna el jugador cuyo color coincide con el color
	 * del turno.
	 * 
	 * @return jug1 en caso de que el color asociado coincida con el color
	 *         pasado por parámetro, jug2 en caso contrario.
	 */
	public Jugador consultarTurno() {
		if (jug1.obtenerColor() == turno) {
			return jug1;
		} else {
			return jug2;
		}
	}

	/**
	 * Consulta el tablero.
	 * 
	 * @return el tablero
	 */
	public Tablero consultarTablero() {
		return this.tablero;
	}

	/**
	 * Coloca una pieza de un color en una celda.
	 * 
	 * @param celda
	 *            celda a colocar.
	 * @param color
	 *            del color que se va a colocar la pieza.
	 */
	public void colocar(Celda celda, Color color) {
		Pieza piezaAux;
		piezaAux = new Pieza(color);
		tablero.colocar(piezaAux, celda);
	}

	/**
	 * Consprueba si el juego ha acabado, para ello llama al método estáCompleto
	 * que nos dice si el tablero está completo o no.
	 * 
	 * @return true si está acabado, es decir, si el tablero está completo,
	 *         false en caso contrario.
	 */
	public boolean estaAcabado() {
		if (tablero.estaCompleto()
				|| (!puedeMover(Color.BLANCO) && !puedeMover(Color.NEGRO))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método que retorna el jugador ganador, en caso de no haberse terminado la
	 * partida o quedar en tablas retorna null.
	 * 
	 * @return null en caso de que no se haya acabado la partida o que hayan
	 *         quedado en tablas; retorna jug1 si hay más fichas de color
	 *         blanco, o jug2 en caso de que sean más negras.
	 */
	public Jugador consultarGanador() {
		if (estaAcabado()) {
			// SI LAS PIEZAS DE CADA COLOR SON IGUALES: return null
			if (tablero.obtenerNumeroPiezas(Color.BLANCO) == tablero
					.obtenerNumeroPiezas(Color.NEGRO)) {
				return null;
			}
			// SI CONTAR PIEZAS NEGRAS > CONTAR PIEZAS BLANCAS : return jug1
			else if (tablero.obtenerNumeroPiezas(Color.BLANCO) > tablero
					.obtenerNumeroPiezas(Color.NEGRO)) {
				return jug2;
			}
			// SI CONTAR PIEZAS NEGRAS < CONTAR PIEZAS BLANCAS : return jug2
			else {
				return jug1;
			}
		} else {
			// SI NO SE HA ACABADO LA PARTIDA: return null
			return null;
		}

	}

	/**
	 * Método que coloca la pieza del color del turno actual en la celda dada
	 * por coordenadas (fila y columnas) Cambia el color de las piezas
	 * comprobando todas las direcciones Comprueba si ha terminado la partida,
	 * sino es así, comprueba que el jugador actual pueda mover, en ese caso
	 * salta el turno.
	 * 
	 * @param x
	 *            coordenada de la fila donde se va a colocar la pieza.
	 * @param y
	 *            coordenada de la columna donde se va a colocar la pieza.
	 */

	public void jugar(int x, int y) {
		Celda celdaAux = tablero.obtenerCelda(x, y);
		// COLOCAR LA PIEZA DEL TURNO ACTUAL EN celdaAux
		colocar(celdaAux, turno);

		// BUCLE FOR-EACH, PARA RECOGER TODOS LOS TIPOS DE DIRECCIONES
		for (Direccion direccion : Direccion.values()) {
			// SENTIDO ASCENDENTE
			int piezas = tablero.contarPiezas(celdaAux, direccion, turno, true);
			if (piezas > 0)
				sustituirPiezas(celdaAux, direccion, piezas, true);
			// SENTIDO DESCENDENTE
			piezas = tablero.contarPiezas(celdaAux, direccion, turno, false);
			if (piezas > 0)
				sustituirPiezas(celdaAux, direccion, piezas, false);
		}

		// COMPROBAR SI HA TERMINADO LA PARTIDA: salgo
		if (!estaAcabado()) {
			if (turno == Color.BLANCO) {
				if (puedeMover(Color.NEGRO)) {
					turno = Color.NEGRO;
				}
			} else {
				if (puedeMover(Color.BLANCO)) {
					turno = Color.BLANCO;
				}
			}
		}
	}

	/**
	 * Método que comprueba si de todas las celdas que quedan vacías, invocando
	 * al método obtenerCelda para saber si está vacía el jugador del turno
	 * actual puede colocar pieza en alguna celda, usando el método
	 * esMovimientoLegal.
	 * 
	 */
	private boolean puedeMover(Color color) {
		for (int i = 0; i < tablero.obtenerNumeroFilas(); i++) {
			for (int j = 0; j < tablero.obtenerNumeroColumnas(); j++) {
				if (esMovimientoLegal(tablero.obtenerCelda(i, j), color)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Método que nos dice si la colocación de la pieza en la celda está dentro
	 * de los máximos de filas y columnas, para ello usamos el método
	 * esMovimientoLegal al que le pasamos las coordenadas de la celda y el
	 * color del que queremos colocar la pieza.
	 * 
	 * @param fila
	 *            fila donde se pretende colocar la pieza.
	 * @param columna
	 *            columna donde se pretende colocar la pieza.
	 * @return true en caso de que sea movimiento legal, false en caso
	 *         contrario.
	 */
	public boolean esMovimientoLegal(int fila, int columna) {
		// si las coordenadas estan en el tablero, es decir que esté dentro de
		// lo máximos de filas y columnas
		if (esMovimientoLegal((tablero.obtenerCelda(fila, columna)), turno)) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Método que comprueba si la celda está vacía y llamando al método
	 * contarPiezas si cambia alguna de color, en ese caso retorna true, en caso
	 * contrario false. Para ello guardo en variables el número de piezas a
	 * cambiar de color de las cuatro direcciones. Compruebo que el valor de
	 * dichas variables sea mayor que cero.
	 * 
	 * @param celda
	 *            donde se pretende colocar la pieza.
	 * @param color
	 *            del color que se pretende colocar la pieza.
	 * @return true en caso de que haya piezas a cambiar de color (movimiento
	 *         legal), false en caso contrario.
	 * 
	 * 
	 */
	public boolean esMovimientoLegal(Celda celda, Color color) {
		// SI LA CELDA ESTA VACIA Y LLAMANDO A CONTAR PIEZAS SI CAMBIA ALGUNA DE
		// COLOR, SINO NO ES LEGAL
		int piezasVert, piezasHor, piezasDiagSONE, piezasDiagNOSE, piezasVert2, piezasHor2, piezasDiagSONE2, piezasDiagNOSE2;

		if (celda.estaVacia()) {

			// GUARDAR PIEZAS DE LAS 4 DIRECCIONES
			piezasVert = tablero.contarPiezas(celda, Direccion.VERTICAL, color,
					true);
			piezasVert2 = tablero.contarPiezas(celda, Direccion.VERTICAL,
					color, false);
			piezasHor = tablero.contarPiezas(celda, Direccion.HORIZONTAL,
					color, true);
			piezasHor2 = tablero.contarPiezas(celda, Direccion.HORIZONTAL,
					color, false);
			piezasDiagNOSE = tablero.contarPiezas(celda,
					Direccion.DIAGONAL_NO_SE, color, true);
			piezasDiagNOSE2 = tablero.contarPiezas(celda,
					Direccion.DIAGONAL_NO_SE, color, false);
			piezasDiagSONE = tablero.contarPiezas(celda,
					Direccion.DIAGONAL_SO_NE, color, true);
			piezasDiagSONE2 = tablero.contarPiezas(celda,
					Direccion.DIAGONAL_SO_NE, color, false);

			// SI UNO DE LOS CONTADORES DE PIEZAS ES > 0 , return true
			if (piezasVert > 0 || piezasHor > 0 || piezasDiagNOSE > 0
					|| piezasDiagSONE > 0 || piezasVert2 > 0 || piezasHor2 > 0
					|| piezasDiagNOSE2 > 0 || piezasDiagSONE2 > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Método que sustituye el color de las piezas. A partir de la Direccion de
	 * la celda colocada, según sea la Direccion ascendentemente o
	 * descendentemente, a la fila y a la columna le sumamos el desplazamiento
	 * de fila y columna; recorre con un bucle for mientras que no haya cambiado
	 * todas las piezas que le pasamos como parámetro, cambiando el color y
	 * sigue sumándole el desplazamiento de fila y de columna.
	 * 
	 * @param celda
	 *            a partir de la cual busco piezas a sustituir.
	 * @param direccion
	 *            del desplazamiento.
	 * @param piezas
	 *            número de piezas que se van a cambiar de color.
	 * @param ascendente
	 *            de valor true en caso de que busque de manera ascendente y
	 *            false en caso contrario.
	 * 
	 */
	private void sustituirPiezas(Celda celda, Direccion direccion, int piezas,
			boolean ascendente) {
		int desplazFila;
		int desplazCol;
		if (ascendente) {
			desplazFila = direccion.obtenerDesplazamientoFila();
			desplazCol = direccion.obtenerDesplazamientoColumna();
		} else {
			desplazFila = direccion.obtenerDesplazamientoFila() * -1;
			desplazCol = direccion.obtenerDesplazamientoColumna() * -1;
		}

		int i = celda.obtenerFila() + desplazFila;
		int j = celda.obtenerColumna() + desplazCol;

		for (int x = 0; x < piezas; x++) {
			tablero.obtenerCelda(i, j).establecerPieza(
					new Pieza(celda.obtenerPieza().obtenerColor()));
			i = i + desplazFila;
			j = j + desplazCol;
		}
	}
}
