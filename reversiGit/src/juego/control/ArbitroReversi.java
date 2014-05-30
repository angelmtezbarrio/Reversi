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
 * Nombre de la clase p�blica: ArbitroReversi.
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
	 *            Se le pasa un par�metro tablero y se le asigna al objeto
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
}

/**
 * M�todo registrarJugador al que se le pasa un par�metro nombre de tipo
 * String y asocia el jugador a un color.
 * 
 * @param nombre
 *            Nombre del jugador a registrar.
 */
public void registrarJugador(String nombre) {
	// Si j1 == null le crea, si est� creado comprueba que j2 ==
	// null y lo crea sin necesidad de comprobar que j1 == null
	if (jug1 == null) {
		jug1 = new Jugador(nombre, Color.NEGRO);
	} else if (jug2 == null) {
		jug2 = new Jugador(nombre, Color.BLANCO);
	}
}

/**
 * M�todo consultarTurno. Retorna el jugador cuyo color coincide con el color
 * del turno.
 * 
 * @return jug1 en caso de que el color asociado coincida con el color
 *         pasado por par�metro, jug2 en caso contrario.
 */
public Jugador consultarTurno() {
	if (jug1.obtenerColor() == turno) {
		return jug1;
	} else {
		return jug2;
	}
}