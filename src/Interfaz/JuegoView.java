package Interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Negocio.Juego;
import Negocio.Jugador;

import java.awt.Toolkit;

public class JuegoView {

	private JFrame frmTatetoro;
	private Temas temas;
	private Jugadores jugadores;
	private Tablero tablero;
	private Botonera botonera;
	private Juego juego;

	private String iconoJugador1;
	private String iconoJugador2;
	private String iconoJugador1Win;
	private String iconoJugador2Win;
	private String iconoJugador1Small;
	private String iconoJugador2Small;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoView window = new JuegoView();
					window.frmTatetoro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void hayUnGanador() {
		juego.setHayGanador(true);
		jugadores.incrementarContadores();
		String ganador = "";
		if (juego.getTurno() == Jugador.JUGADOR1) {
			ganador = jugadores.getJugador1name();
		} else {
			ganador = jugadores.getJugador2name();
		}
		JOptionPane.showMessageDialog(jugadores, "Gano " + ganador);
		mostrarConsultaContinuarJuego();
	}

	public void mostrarConsultaContinuarJuego() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int resultado = JOptionPane.showConfirmDialog(jugadores, "Desea seguir jugando?", "Partida Finalizada",
				dialogButton);
		if (resultado == 0) { // opcion SI
			reiniciar(false);
		} else {
			tablero.disableBotones();
		}
	}

	public void cambiarTurno() {
		juego.cambiarTurno();
		jugadores.setLbTurno();
	}

	public void reiniciar(boolean partidaFinalizada) {
		tablero.reiniciar();
		if (partidaFinalizada) {
			juego = new Juego();
			jugadores.reiniciar();
		} else
			juego.reiniciarPartida();
		jugadores.setLbTurno();
	}

	public JuegoView() {
		temas = new Temas();
		temas.temaPorDefecto();
		inicioDelJuego();
		initialize();
	}

	private void initialize() {
		frmTatetoro = new JFrame();
		frmTatetoro.setResizable(false);
		frmTatetoro.setIconImage(
				Toolkit.getDefaultToolkit().getImage(JuegoView.class.getResource("/imagenes/VentanaIcon.jpg")));
		frmTatetoro.setTitle("Ta-Te-Toro");
		frmTatetoro.setBounds(50, 50, 500, 600);
		frmTatetoro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTatetoro.getContentPane().setLayout(null);

		juego = new Juego();
		
		tablero = new Tablero(this);
		frmTatetoro.getContentPane().add(tablero);

		botonera = new Botonera(this);
		frmTatetoro.getContentPane().add(botonera);

		jugadores = new Jugadores(this);
		frmTatetoro.getContentPane().add(jugadores);

		tablero.setBounds(0, 150, 400, 350);
		botonera.setBounds(0, 0, 500, 40);
		jugadores.setBounds(0, 50, 500, 500);


	}

	private void inicioDelJuego() {
		iconoJugador1 = "/imagenes/circulo.png";
		iconoJugador2 = "/imagenes/equis.png";
		iconoJugador1Win = "/imagenes/circuloWin.png";
		iconoJugador2Win = "/imagenes/equisWin.png";
		iconoJugador1Small = "/imagenes/circuloSmall.png";
		iconoJugador2Small = "/imagenes/equisSmall.png";
	}
	///////////////////////////////////////////////////////////////////////////// GETTERS
	///////////////////////////////////////////////////////////////////////////// &
	///////////////////////////////////////////////////////////////////////////// SETTERS

	public void cambiarTema() {
		temas.cambiarTema();
	}

	public String getIconoJugador1() { return iconoJugador1; }

	public String getIconoJugador2() { return iconoJugador2; }

	public String getIconoJugador1Win() { return iconoJugador1Win; }

	public String getIconoJugador2Win() { return iconoJugador2Win; }

	public String getIconoJugador1Small() { return iconoJugador1Small; }

	public String getIconoJugador2Small() { return iconoJugador2Small; }

	public boolean getHayGanador() { return juego.getHayGanador(); }

	public Jugador getTurno() { return juego.getTurno(); }

	public int partidasGanadasJ1() {
		return juego.getPartidasGanadasJ1();
	}

	public int partidasGanadasJ2() {
		return juego.getPartidasGanadasJ2();
	}

	public int partidasJugadas() {
		return juego.getPartidasJugadas();
	}

	public void incrementarContadores() {
juego.incrementarContadores();
	}
}
