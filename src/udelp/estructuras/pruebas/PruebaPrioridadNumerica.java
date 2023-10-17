package udelp.estructuras.pruebas;

import udelp.estructuras.colas.NumericPriorityQueue;

public class PruebaPrioridadNumerica {

	public static void main(String[] args) {
		NumericPriorityQueue movimientos=new NumericPriorityQueue();
		movimientos.enqueue("b", 2);
		movimientos.enqueue("c", 3);
		movimientos.enqueue("e", 5);
		movimientos.enqueue("d", 4);
		movimientos.enqueue("a", 1);
		movimientos.enqueue("f", 8);
		System.out.println(movimientos.toString());

	}

}
