package udelp.estructuras.nodos;

public class NumericNodo {
	private Object dato;
	private NumericNodo enlace;
	private Integer prioridad;
	
	public Object getDato() {
		return dato;
	}
	public void setDato(Object dato) {
		this.dato = dato;
	}
	public NumericNodo getEnlace() {
		return enlace;
	}
	public void setEnlace(NumericNodo enlace) {
		this.enlace = enlace;
	}
	public Integer getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}
}
