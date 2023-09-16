package udelp.estructuras.colas.tareas;

import udelp.estructuras.pilas.Stack;

public class Cambios {
	private Stack moneda20;
    private Stack moneda10;
    private Stack moneda5;
    private Stack moneda2;
    private Stack moneda1;
    private Stack centavo50;

    public Cambios() {
        moneda20 = pilaMonedas(50, 20);
        moneda10 = pilaMonedas(50, 10);
        moneda5 = pilaMonedas(50, 5);
        moneda2 = pilaMonedas(50, 2);
        moneda1 = pilaMonedas(50, 1);
        centavo50 = pilaMonedas(50, 0.50);
    }
    private Stack pilaMonedas(int estadoInicial, double valor) {
        Stack stack = new Stack(100);
        for (int i = 0; i < estadoInicial; i++) {
            stack.push(valor);
        }
        return stack;
    }
	public Stack getMoneda20() {
		return moneda20;
	}
	public Stack getMoneda10() {
		return moneda10;
	}
	public Stack getMoneda5() {
		return moneda5;
	}
	public Stack getMoneda2() {
		return moneda2;
	}
	public Stack getMoneda1() {
		return moneda1;
	}
	public Stack getCentavo50() {
		return centavo50;
	}
    
}
