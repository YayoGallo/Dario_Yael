package udelp.estructuras.nodos;

public class BiNodo {
	private Object dato;
	private BiNodo derecha;
	private BiNodo izquierda;
	
	public Object getDato() {
		return dato;
	}
	public void setDato(Object dato) {
		this.dato = dato;
	}
	public BiNodo getDerecha() {
		return derecha;
	}
	public void setDerecha(BiNodo derecha) {
		this.derecha = derecha;
	}
	public BiNodo getIzquierda() {
		return izquierda;
	}
	public void setIzquierda(BiNodo izquierda) {
		this.izquierda = izquierda;
	}
}
