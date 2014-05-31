/**
 * Paquete textui.
 */
package juego.textui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import juego.control.ArbitroReversi;
import juego.modelo.Jugador;
import juego.modelo.Tablero;

/**
 * Clase principal del modo textui.
 * 
 * @author Carolina Colina Zamorano.
 * @author SteBnoOni - Rubén Blanco Alcántara (revision)
 * @since 1.0
 * @version Final
 */
public class Reversi {

	/**
	 * �rbitro encargado de gestionar el juego.
	 */
	private static ArbitroReversi arbitro;

	/**
	 * Clase principal del modo texto.
	 * 
	 * @param args
	 *            Argumentos del main.
	 */
	public static void main(String[] args) {

		/**
		 * Atributo filas de tipo entero.
		 */
		int filas = 8;
		/**
		 * Atributo columnas de tipo entero.
		 */
		int columnas = 8;
		/**
		 * Atributo jugador2 de tipo string.
		 */
		String jugador1 = "Abel";
		/**
		 * Atributo jugador2 de tipo string.
		 */
		String jugador2 = "Caín";

		// Si he ejecutado el reversi con atributos y son 4
		if (args.length == 4) {
			jugador1 = args[0];
			jugador2 = args[1];
			filas = Integer.parseInt(args[2]);
			columnas = Integer.parseInt(args[3]);

			// Que las filas y las columnas sean m�s de 4 y siempre pares, sino
			// finaliza el reversi
			if (filas <= 4 || columnas <= 4 || (filas % 2 != 0)
					|| (columnas % 2 != 0)) {
				mostrarMensajeAyudaTablero();
				System.exit(0);
			}

			// Si le he ejecutado el reversi con menos de 4 argumentos que
			// termine
		} else if (args.length != 0) {
			mostrarMensajeAyudaArgumentos();
			System.exit(0);
		}

		// Creo una variable �rbitro para acceder a los m�todos de
		// �rbitroReversi
		arbitro = new ArbitroReversi(new Tablero(filas, columnas));
		arbitro.registrarJugador(jugador1);
		arbitro.registrarJugador(jugador2);

		// Mustra el tablero inicial
		mostrarTablero();

		// Sino ha acabado que pida fila y columna hasta que las coordenadas que
		// de el jugador sean correctas
		while (!arbitro.estaAcabado()) {
			mostrarTurno();
			int i = 0;
			int j = 0;
			boolean legal = false;
			while (!legal) {
				i = pedirFila();
				j = pedirColumna();
				if (arbitro.esMovimientoLegal(i, j)) {
					legal = true;
				} else {
					mostrarMensajeCoordenadas();
				}
			}

			// Llamada al m�todo jugar
			arbitro.jugar(i, j);

			// Muestra el tablero despu�s de la jugada
			mostrarTablero();
		}

		// Llamada al m�todo mostrar ganador cuando salga del while, que
		// significa que la partida ha acabado
		mostrarGanador(arbitro.consultarGanador());
	}

	/**
	 * M�todo que muestra un mensaje en pantalla en caso de que el n�mero de
	 * filas y columnas introducido no coincida con lo establecido en las
	 * indicaciones de la pr�ctica.
	 */
	private static void mostrarMensajeAyudaTablero() {
		System.out
				.println("El n�mero de Filas y Columnas del tablero debe ser superior o igual a 4 y debe ser un n�mero par.");
	}

	/**
	 * M�todo que muestra un mensaje en pantalla en caso de que el n�mero de
	 * argumentos introducidos no sea correcto, indicando c�mo debe ser la
	 * entrada de argumentos.
	 */
	private static void mostrarMensajeAyudaArgumentos() {
		System.out
				.println("El n�mero de argumentos introducido no es correcto.");
		System.out
				.println("Debes introducir dos nombres de jugadores y dos n�meros: filas y columnas.");
	}

	/**
	 * M�todo que muestra un mensaje en pantalla que nos indica que el
	 * movimiento a realizar no est� permitido por no cambiar ninguna ficha de
	 * color.
	 */
	private static void mostrarMensajeCoordenadas() {
		System.out
				.println("Movimiento no permitido; no cambia ninguna ficha de color.");
	}

	/**
	 * M�todo que muestra el tablero.
	 */
	private static void mostrarTablero() {
		for (int i = 0; i < arbitro.consultarTablero().obtenerNumeroFilas(); i++) {

			// Muestro el n�mero de filas en la parte izquierda del tablero
			System.out.print(i + "\t");

			// Muestra el contenido de las celdas bien est�n vac�as ('-') o bien
			// tengan pieza ('X', 'O')
			for (int j = 0; j < arbitro.consultarTablero()
					.obtenerNumeroColumnas(); j++) {
				System.out.print(arbitro.consultarTablero().obtenerCelda(i, j)
						.toString());
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.print("\t");

		// Muestra el n�mero de columnas en la parte inferior del tablero
		for (int k = 0; k < arbitro.consultarTablero().obtenerNumeroColumnas(); k++) {
			System.out.print(k);
		}

		System.out.println("");
	}

	/**
	 * M�todo que dice a qu� jugador le toca mover, mostrando su nombre, y el
	 * color de sus fichas.
	 */
	private static void mostrarTurno() {
		System.out.println("El turno es de: "
				+ arbitro.consultarTurno().consultarNombre() + " con fichas "
				+ arbitro.consultarTurno().obtenerColor().toChar()
				+ " de color " + arbitro.consultarTurno().obtenerColor());
	}

	/**
	 * M�todo que mustra un mensaje en pantalla pidiendo la fila y guardando su
	 * valor convirti�ndolo a entero.
	 * 
	 * @return coordenada fila del tablero.
	 */
	private static int pedirFila() {

		String cadenaFila = "";
		int fila = 0;
		System.out.print("Introduce Fila: ");

		// Leo del teclado la fila
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(in);

		try {
			cadenaFila = teclado.readLine();
			fila = Integer.parseInt(cadenaFila);
		} catch (IOException e) { // En caso de haber un error de lectura del
									// buffer (desde el teclado).
		}

		return fila;

	}

	/**
	 * M�todo que mustra un mensaje en pantalla pidiendo la columna y guardando
	 * su valor convirti�ndolo a entero.
	 * 
	 * @return coordenada columna del tablero.
	 */
	private static int pedirColumna() {
		String cadenaColumna = "";
		int columna = 0;
		System.out.print("Introduce Columna: ");

		// Leo del teclado la columna
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(in);

		try {
			cadenaColumna = teclado.readLine();
			columna = Integer.parseInt(cadenaColumna);
		} catch (IOException e) {
		}

		return columna;
	}

	/**
	 * M�todo que muestra el resultado cuando ha acabado el juego. Mostrando un
	 * mensaje, bien si han quedado en tablas, o bien si ha habido un ganador,
	 * en este caso muestra el nombre y el color de las fichas que le
	 * corresponde al jugador vencedor.
	 * 
	 * @param jugador
	 *            jugador que mayor n�mero de piezas ha conseguido poner en el
	 *            tablero.
	 */
	private static void mostrarGanador(Jugador jugador) {
		if (jugador == null) {
			System.out.println("RESULTADO FINAL:");
			System.out
					.println("TABLAS. Los dos jugadores tienen el mismo n�mero de piezas");
		} else {
			System.out.println("RESULTADO FINAL:");
			System.out.println("GANADOR: " + jugador.consultarNombre()
					+ " con las fichas de color " + jugador.obtenerColor()
					+ "(" + jugador.obtenerColor().toChar() + ")");
		}
	}
}
