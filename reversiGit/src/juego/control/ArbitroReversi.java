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
 * Nombre de la clase publica: ArbitroReversi.
 * 
 * @author Angel Martinez Barrio.
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
	 *            Se le pasa un parï¿½metro tablero y se le asigna al objeto
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
	 * Mï¿½todo registrarJugador al que se le pasa un parï¿½metro nombre de tipo
	 * String y asocia el jugador a un color.
	 * 
	 * @param nombre
	 *            Nombre del jugador a registrar.
	 */
	public void registrarJugador(String nombre) {
		// Si j1 == null le crea, si estï¿½ creado comprueba que j2 ==
		// null y lo crea sin necesidad de comprobar que j1 == null
		if (jug1 == null) {
			jug1 = new Jugador(nombre, Color.NEGRO);
		} else if (jug2 == null) {
			jug2 = new Jugador(nombre, Color.BLANCO);
		}
	}
	
	/**
	 * Mï¿½todo consultarTurno. Retorna el jugador cuyo color coincide con el color
	 * del turno.
	 * 
	 * @return jug1 en caso de que el color asociado coincida con el color
	 *         pasado por parï¿½metro, jug2 en caso contrario.
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
		for (Dirección direccion : Dirección.values()) {
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
}