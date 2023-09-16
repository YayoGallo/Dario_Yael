package udelp.estructuras.colas.tareas;

import udelp.estructuras.colas.CircularQueue;

public class Productos {
	private String nombreProducto;
    private double precio;
    private CircularQueue cola;
    public Productos(String nombreProducto, double precio){
    	this.nombreProducto=nombreProducto;
    	this.precio=precio;
    	cola=inicioProductos();
    }
    private CircularQueue inicioProductos() {
        CircularQueue cola= new CircularQueue(20);
        for (int i = 0; i < 20; i++) {
            cola.enqueue(1);
        }
        return cola;
    }
	public String getNombreProducto() {
		return nombreProducto;
	}
	public double getPrecio() {
		return precio;
	}
	public CircularQueue getCola() {
		return cola;
	}
     public void ingresar() {
    	 this.cola.enqueue(1);
     }
}
