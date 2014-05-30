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
 * @since 1.0
 * @version 1.0
 */
public class Reversi {

	/**
	 * Árbitro encargado de gestionar el juego.
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

			// Que las filas y las columnas sean más de 4 y siempre pares, sino
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

		// Creo una variable árbitro para acceder a los métodos de
		// ÁrbitroReversi
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

			// Llamada al método jugar
			arbitro.jugar(i, j);

			// Muestra el tablero después de la jugada
			mostrarTablero();
		}

		// Llamada al método mostrar ganador cuando salga del while, que
		// significa que la partida ha acabado
		mostrarGanador(arbitro.consultarGanador());
	}
	
	/**
	 * Método que muestra un mensaje en pantalla en caso de que el número de
	 * filas y columnas introducido no coincida con lo establecido en las
	 * indicaciones de la práctica.
	 */
	private static void mostrarMensajeAyudaTablero() {
		System.out
				.println("El número de Filas y Columnas del tablero debe ser superior o igual a 4 y debe ser un número par.");
	}

	/**
	 * Método que muestra un mensaje en pantalla en caso de que el número de
	 * argumentos introducidos no sea correcto, indicando cómo debe ser la
	 * entrada de argumentos.
	 */
	private static void mostrarMensajeAyudaArgumentos() {
		System.out
				.println("El número de argumentos introducido no es correcto.");
		System.out
				.println("Debes introducir dos nombres de jugadores y dos números: filas y columnas.");
	}

	/**
	 * Método que muestra un mensaje en pantalla que nos indica que el
	 * movimiento a realizar no está permitido por no cambiar ninguna ficha de
	 * color.
	 */
	private static void mostrarMensajeCoordenadas() {
		System.out
				.println("Movimiento no permitido; no cambia ninguna ficha de color.");
	}

	/**
	 * Método que muestra el tablero.
	 */
	private static void mostrarTablero() {
		for (int i = 0; i < arbitro.consultarTablero().obtenerNumeroFilas(); i++) {

			// Muestro el número de filas en la parte izquierda del tablero
			System.out.print(i + "\t");

			// Muestra el contenido de las celdas bien estén vacías ('-') o bien
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

		// Muestra el número de columnas en la parte inferior del tablero
		for (int k = 0; k < arbitro.consultarTablero().obtenerNumeroColumnas(); k++) {
			System.out.print(k);
		}

		System.out.println("");
	}
	
	/**
	 * @author angelillo
	 * Método que dice a qué jugador le toca mover, mostrando su nombre, y el
	 * color de sus fichas.
	 */
	private static void mostrarTurno() {
		System.out.println("El turno es de: "
				+ arbitro.consultarTurno().consultarNombre() + " con fichas "
				+ arbitro.consultarTurno().obtenerColor().toChar()
				+ " de color " + arbitro.consultarTurno().obtenerColor());
	}

	/**
	 * Método que mustra un mensaje en pantalla pidiendo la fila y guardando su
	 * valor convirtiéndolo a entero.
	 * @author angelillo
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
}
