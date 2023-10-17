package udelp.estructuras.colas.tareas;

import udelp.estructuras.pilas.Stack;

public class Cambios {
	protected Stack moneda20;
	protected Stack moneda10;
    protected Stack moneda5;
    protected Stack moneda2;
    protected Stack moneda1;
    protected Stack centavo50;

    public Cambios() {
        moneda20 = pilaMonedas(100, 20);
        moneda10 = pilaMonedas(100, 10);
        moneda5 = pilaMonedas(100, 5);
        moneda2 = pilaMonedas(100, 2);
        moneda1 = pilaMonedas(100, 1);
        centavo50 = pilaMonedas(100, 0.50);
    }
    private Stack pilaMonedas(int estadoInicial, double valor) {
        Stack stack = new Stack(200);
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
