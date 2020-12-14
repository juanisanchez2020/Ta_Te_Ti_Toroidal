package Interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import Negocio.Jugador;

import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class Jugadores extends JPanel {

	private static final long serialVersionUID = 1L; // lo agrego porque lo pide el eclipse
	private JTextField txtJugador1;
	private JTextField txtJugador2;
	private JuegoView juegoView;
	JLabel lblPartidasJugadas;
	JLabel lblPartidasGanadasJ1;
	JLabel lblPartidasGanadasJ2;
	JLabel lbCartelInfo;

	public void reiniciar() {
		clearNames();
		setPartidasGanadas();
		setPartidasJugadas();
		setLbTurno();
	}

	private void clearNames() {
		txtJugador1.setText("Jugador 1");
		txtJugador2.setText("Jugador 2");
	}

	private String textPartidasGanadas(int cantidad) {
		return "Partidas Ganadas: " + cantidad;
	}

	private String textPartidasJugadas(int cantidad) {
		return "Partidas Jugadas: " + cantidad;
	}

	private void setPartidasGanadas() {
		lblPartidasGanadasJ1.setText(textPartidasGanadas(juegoView.partidasGanadasJ1()));
		lblPartidasGanadasJ2.setText(textPartidasGanadas(juegoView.partidasGanadasJ2()));
	}

	private void setPartidasJugadas() {
		lblPartidasJugadas.setText(textPartidasJugadas(juegoView.partidasJugadas()));
	}

	public void setLbTurno() {
		if (juegoView.getTurno() == Jugador.JUGADOR1)
			lbCartelInfo.setText("Es el turno de " + getJugador1name());
		else
			lbCartelInfo.setText("Es el turno de " + getJugador2name());
	}

	public void incrementarContadores() {
		juegoView.incrementarContadores();
		if (juegoView.getTurno() == Jugador.JUGADOR1)
			lblPartidasGanadasJ1.setText(textPartidasGanadas(juegoView.partidasGanadasJ1()));
		else
			lblPartidasGanadasJ2.setText(textPartidasGanadas(juegoView.partidasGanadasJ2()));
		lblPartidasJugadas.setText("Partidas Jugadas: " + juegoView.partidasJugadas());
	}

	public Jugadores(JuegoView juegoView) {
		this.juegoView = juegoView;

		setLayout(null);

		JLabel lbCirculo = new JLabel("");
		lbCirculo.setIcon(new ImageIcon(Jugadores.class.getResource(juegoView.getIconoJugador1Small())));
		lbCirculo.setBounds(10, 14, 57, 57);
		add(lbCirculo);

		txtJugador1 = new JTextField();
		txtJugador1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				setLbTurno();
			}
		});
		txtJugador1.setText("Jugador 1");
		txtJugador1.setHorizontalAlignment(SwingConstants.LEFT);
		txtJugador1.setBounds(77, 24, 151, 37);
		add(txtJugador1);

		txtJugador2 = new JTextField();
		txtJugador2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				setLbTurno();
			}
		});
		txtJugador2.setText("Jugador 2");
		txtJugador2.setHorizontalAlignment(SwingConstants.RIGHT);
		txtJugador2.setBounds(257, 24, 151, 37);
		add(txtJugador2);

		lbCartelInfo = new JLabel("Es el turno de " + getJugador1name());
		lbCartelInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lbCartelInfo.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbCartelInfo.setBounds(0, 430, 500, 60);
		add(lbCartelInfo);

		JLabel lbEquis = new JLabel("");
		lbEquis.setIcon(new ImageIcon(Jugadores.class.getResource(juegoView.getIconoJugador2Small())));
		lbEquis.setBounds(417, 14, 57, 57);
		add(lbEquis);

		lblPartidasGanadasJ1 = new JLabel(textPartidasGanadas(juegoView.partidasGanadasJ1()));
		lblPartidasGanadasJ1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPartidasGanadasJ1.setBounds(77, 72, 151, 14);
		add(lblPartidasGanadasJ1);

		lblPartidasGanadasJ2 = new JLabel(textPartidasGanadas(juegoView.partidasGanadasJ2()));
		lblPartidasGanadasJ2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPartidasGanadasJ2.setBounds(257, 72, 151, 14);
		add(lblPartidasGanadasJ2);

		lblPartidasJugadas = new JLabel(textPartidasJugadas(juegoView.partidasJugadas()));
		lblPartidasJugadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartidasJugadas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPartidasJugadas.setBounds(174, 86, 135, 14);
		add(lblPartidasJugadas);

	}

	///////////////////////////////////////////////////////////////////////////// GETTERS
	///////////////////////////////////////////////////////////////////////////// &
	///////////////////////////////////////////////////////////////////////////// SETTERS
	public String getJugador1name() { return txtJugador1.getText(); }

	public String getJugador2name() { return txtJugador2.getText(); }

}
