package Negocio;

public class BotonVirtual {
	private Estado estado;
	private BotonVirtual arriba;
	private BotonVirtual abajo;
	private BotonVirtual derecha;
	private BotonVirtual izquierda;

	public BotonVirtual() {
		estado = Estado.LIBRE;
	}

	///////////////////////////////////////////////////////////////////////////// GETTERS
	///////////////////////////////////////////////////////////////////////////// &
	///////////////////////////////////////////////////////////////////////////// SETTERS

	public Estado getEstado() { return estado; }

	public void setEstado(Estado estado) { this.estado = estado; }

	public boolean estaOcupado() { return this.getEstado() != Estado.LIBRE; }

	public BotonVirtual getArriba() { return arriba; }

	public BotonVirtual getAbajo() { return abajo; }

	public BotonVirtual getDerecha() { return derecha; }

	public BotonVirtual getIzquierda() { return izquierda; }

	public void setDerecha(BotonVirtual derecha) { this.derecha = derecha; }

	public void setAbajo(BotonVirtual abajo) { this.abajo = abajo; }

	public void setArriba(BotonVirtual arriba) { this.arriba = arriba; }

	public void setIzquierda(BotonVirtual izquierda) { this.izquierda = izquierda; }

	public BotonVirtual getArribaIzquierda() { return arriba.izquierda; }

	public BotonVirtual getArribaDerecha() { return arriba.derecha; }

	public BotonVirtual getAbajoIzquierda() { return abajo.izquierda; }

	public BotonVirtual getAbajoDerecha() { return abajo.derecha; }

}
