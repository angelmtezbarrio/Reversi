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
	
}
