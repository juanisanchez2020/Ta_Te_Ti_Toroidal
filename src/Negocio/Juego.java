package Negocio;

public class Juego {

	private Integer partidasGanadasJ1;
	private Integer partidasGanadasJ2;
	private Integer partidasJugadas;
	private Jugador turno;
	private boolean hayGanador;

	public Juego() {
		partidasGanadasJ1 = 0;
		partidasGanadasJ2 = 0;
		partidasJugadas = 0;
		turno = Jugador.JUGADOR1;
		hayGanador = false;
	}

	public Jugador obtenerTurnoInicio() {
		if (partidasJugadas % 2 == 0)
			return Jugador.JUGADOR1;
		else
			return Jugador.JUGADOR2;
	}

	public void cambiarTurno() {
		if (getTurno() == Jugador.JUGADOR1)
			setTurno(Jugador.JUGADOR2);
		else
			setTurno(Jugador.JUGADOR1);
	}

	public void reiniciarPartida() {
		setHayGanador(false);
		setTurno(obtenerTurnoInicio());
	}

	public void incrementarContadores() {
		if (getTurno() == Jugador.JUGADOR1)
			this.partidasGanadasJ1 = this.partidasGanadasJ1 + 1;
		else
			this.partidasGanadasJ2 = this.partidasGanadasJ2 + 1;
		this.partidasJugadas = this.partidasJugadas + 1;
	}

	public Integer getPartidasGanadasJ1() { return partidasGanadasJ1; }
	
	public Integer getPartidasGanadasJ2() { return partidasGanadasJ2; }

	public Integer getPartidasJugadas() { return partidasJugadas; }

	public boolean getHayGanador() { return hayGanador; }

	public void setHayGanador(boolean hayGanador) { this.hayGanador = hayGanador; }

	public void setTurno(Jugador jugador) { turno = jugador; }

	public Jugador getTurno() { return turno; }
}
