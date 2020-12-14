package Negocio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class TableroVirtual {
	
	private List<BotonVirtual> btnVirtualList;
	private final int[][] matriz3x3 = { { 9, 7, 8, 9, 7 }, 
										{ 3, 1, 2, 3, 1 }, 
										{ 6, 4, 5, 6, 4 },
										{ 9, 7, 8, 9, 7 }, 
										{ 3, 1, 2, 3, 1 } };


	public TableroVirtual() {
		this.btnVirtualList = generarTablero3x3(); 
		reconocerVecinos(btnVirtualList);
	}
	
	private ArrayList<BotonVirtual> generarTablero3x3() {
		ArrayList<BotonVirtual> list = new ArrayList<BotonVirtual>();
		for (int i =0; i<9; i++)
			list.add(new BotonVirtual());
		return list;
	}
	
	// modificar para que no reciba parametros relacionados con la interfaz
	// (posiblemente haya que modificar la implementacion de boton virtual)

	private void reconocerVecinos(List<BotonVirtual> lista) {
		if (lista.size() != 9)
			throw new RuntimeException("no implementado para listas de tamaño distinto a 9");
		int x = 1;
		int y = 1;
		for (BotonVirtual btnVirtual : lista) {
			btnVirtualSetVecinosAlrededor(lista, btnVirtual, x, y);
			if (y == 3) {
				x = x + 1;
				y = 0;
			}
			y = y + 1;
		}
	}

	private void btnVirtualSetVecinosAlrededor(List<BotonVirtual> lista, BotonVirtual btnVirtual, int x, int y) {
		btnVirtual.setAbajo(lista.get(matriz3x3[x + 1][y] - 1));
		btnVirtual.setArriba(lista.get(matriz3x3[x - 1][y] - 1));
		btnVirtual.setDerecha(lista.get(matriz3x3[x][y + 1] - 1));
		btnVirtual.setIzquierda(lista.get(matriz3x3[x][y - 1] - 1));
	}

	public List<Integer> buscar3Consecutivos(int index) {// uso operador del tipo
																					// short-circuiting para no evaluar
																					// las condiciones
																					// restantes en cuanto una resulta
																					// verdadera
		BotonVirtual btnVirtual = btnVirtualList.get(index);
		List<Integer> botonesGanadores = new LinkedList<Integer>();
		if (compararBotones(botonesGanadores, btnVirtual, btnVirtual.getDerecha(), btnVirtual.getDerecha().getDerecha())
		 || compararBotones(botonesGanadores, btnVirtual, btnVirtual.getAbajo(), btnVirtual.getAbajo().getAbajo())
		 || compararBotones(botonesGanadores, btnVirtual, btnVirtual.getAbajoDerecha(),btnVirtual.getAbajoDerecha().getAbajoDerecha())
		 || compararBotones(botonesGanadores, btnVirtual, btnVirtual.getAbajoIzquierda(),btnVirtual.getAbajoIzquierda().getAbajoIzquierda()))
			return botonesGanadores;
		return null;
	}

	private boolean compararBotones(List<Integer> botonesGanadores, BotonVirtual btn1, BotonVirtual btn2,
			BotonVirtual btn3) {
		if (btn1.getEstado() == btn2.getEstado() && btn1.getEstado() == btn3.getEstado()) { // la igualdad es transitiva
			botonesGanadores.add(btnVirtualList.indexOf(btn1));
			botonesGanadores.add(btnVirtualList.indexOf(btn2));
			botonesGanadores.add(btnVirtualList.indexOf(btn3));
			return true;
		}
		return false;
	}

	public void liberarBotones() {
		for (BotonVirtual boton : btnVirtualList)
			boton.setEstado(Estado.LIBRE);
		
	}

	public void setEstadoBoton(int index, Estado estado) {
		btnVirtualList.get(index).setEstado(estado);		
	}

	public boolean estaOcupado(int index) {
		return btnVirtualList.get(index).estaOcupado();
	}

	public Estado getEstado(int index) {
		return btnVirtualList.get(index).getEstado();
	}

}
