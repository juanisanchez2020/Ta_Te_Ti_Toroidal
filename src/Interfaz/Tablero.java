package Interfaz;

import javax.swing.JPanel;

import com.formdev.flatlaf.FlatLaf;

import Negocio.Estado;
import Negocio.Jugador;
import Negocio.PosicionXY;
import Negocio.TableroVirtual;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tablero extends JPanel {

	private static final long serialVersionUID = 1L; // lo agrego porque lo pide el eclipse
	JLabel lbCartelInfo;
	private JuegoView juego;
	TableroVirtual tablero;
	private List<JButton> btnList;

	public void reiniciar() {
		for (JButton boton : btnList) {
			boton.setEnabled(true);
			boton.setBackground(null);
			boton.setIcon(null);
		}
		tablero.liberarBotones();
		FlatLaf.updateUI();
	}

	public void disableBotones() {
		for (JButton boton : btnList) {
			boton.setEnabled(false);
		}
	}

	public void marcarBoton(JButton boton) {
		if (!tablero.estaOcupado(botonIndex(boton)) && !juego.getHayGanador())
			marcarBoton(boton, false);
	}

	public void marcarBotonEstado(JButton boton) {
		marcarBoton(boton, true);
	}

	private void marcarBoton(JButton boton, boolean click) {
		Estado estado = null;
		if (juego.getTurno() == Jugador.JUGADOR1) {
			boton.setIcon(new ImageIcon(Tablero.class.getResource(juego.getIconoJugador1())));
			estado = Estado.JUGADOR1;
		} else {
			boton.setIcon(new ImageIcon(Tablero.class.getResource(juego.getIconoJugador2())));
			estado = Estado.JUGADOR2;
		}
		if (click)
			tablero.setEstadoBoton(botonIndex(boton), estado);
	}

	private void marcarLineaGanadora(List<Integer> botonesGanadores) {
		for (Integer pos : botonesGanadores) {
			JButton boton = btnList.get(pos);
			if (juego.getTurno() == Jugador.JUGADOR1)
				boton.setIcon(new ImageIcon(Tablero.class.getResource(juego.getIconoJugador1Win())));
			else
				boton.setIcon(new ImageIcon(Tablero.class.getResource(juego.getIconoJugador2Win())));
		}

	}

	public List<PosicionXY> posiciones() {
		List<PosicionXY> posiciones = new LinkedList<PosicionXY>();
		posiciones.add(new PosicionXY(115, 55));
		posiciones.add(new PosicionXY(200, 55));
		posiciones.add(new PosicionXY(285, 55));
		posiciones.add(new PosicionXY(115, 140));
		posiciones.add(new PosicionXY(200, 140));
		posiciones.add(new PosicionXY(285, 140));
		posiciones.add(new PosicionXY(115, 225));
		posiciones.add(new PosicionXY(200, 225));
		posiciones.add(new PosicionXY(285, 225));

		// tablero.reconocerVecinos(posiciones); // esto debe ser realizado por
		// TableroController. ver
		// como pasar botonVirtualList de otra forma

		return posiciones;
	}

	public int botonIndex(JButton boton) {
		return btnList.indexOf(boton);
	}

	public Tablero(JuegoView juegoView) {
		juego = juegoView;
		
		btnList = new ArrayList<JButton>();

		tablero = new TableroVirtual();

		setLayout(null);

		List<PosicionXY> posiciones = posiciones();

		for (int i = 0; i < posiciones.size(); i++) {
			JButton boton = new JButton("");
			btnList.add(boton);

			boton.setFocusable(false);
			boton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					marcarBoton(boton);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (tablero.getEstado(botonIndex(boton)) == Estado.LIBRE)
						boton.setIcon(null);
				}
			});
			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!tablero.estaOcupado(botonIndex(boton)) && !juego.getHayGanador()) {
						marcarBotonEstado(boton);

						List<Integer> botonesGanadores = tablero.buscar3Consecutivos(botonIndex(boton));
						if (botonesGanadores == null) {
							juego.cambiarTurno();
						} else {
							marcarLineaGanadora(botonesGanadores);
							juego.hayUnGanador();
						}
					}
				}
			});
			PosicionXY posicion = posiciones.get(i);
			boton.setBounds(posicion.getX(), posicion.getY(), 90, 90);
			add(boton);
		}

	}
}
