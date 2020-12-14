package Interfaz;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Botonera extends JPanel {

	private static final long serialVersionUID = 1L; // lo agrego porque lo pide el eclipse

	public Botonera(JuegoView juegoView) {
		setLayout(null);
		JButton btn_nuevo = new JButton("Reiniciar");
		btn_nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juegoView.reiniciar(true);
			}
		});
		btn_nuevo.setBounds(10, 10, 85, 27);
		add(btn_nuevo);

		/*
		 * JButton btn_trampas = new JButton("Trampas");
		 * btn_trampas.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent arg0) { // juego.toggleTrampas(); } });
		 * btn_trampas.setBounds(100, 10, 85, 27); add(btn_trampas);
		 */

		JButton btn_temas = new JButton("Tema");
		btn_temas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juegoView.cambiarTema();
			}
		});
		btn_temas.setBounds(105, 10, 85, 27);
		add(btn_temas);

		JButton btn_info = new JButton("Info");
		btn_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"     Segundo Semestre 2020\r\n" + "        Sanchez Juan Ignacio\r\n"
								+ "        Schmidt Maximiliano\r\n" + "          Sosa Martín Leonel",
						"TaTeToro - Programacion 3", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btn_info.setBounds(200, 10, 85, 27);
		add(btn_info);

	}
}
