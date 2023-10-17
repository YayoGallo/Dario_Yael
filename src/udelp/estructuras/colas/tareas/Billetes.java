package udelp.estructuras.colas.tareas;

import udelp.estructuras.pilas.Stack;

public class Billetes extends Cambios {
    private Stack billete1000;
    private Stack billete500;
    private Stack billete200;
    private Stack billete100;
    private Stack billete50;
    private Stack billete20;

    public Billetes() {
        super();
        billete1000 = pilaDinero(100, 1000);
        billete500 = pilaDinero(100, 500);
        billete200 = pilaDinero(100, 200);
        billete100 = pilaDinero(100, 100);
        billete50 = pilaDinero(100, 50);
        billete20 = pilaDinero(100, 20);
    }
    private Stack pilaDinero(int estadoInicial, double valor) {
        Stack stack = new Stack(200);
        for (int i = 0; i < estadoInicial; i++) {
            stack.push(valor);
        }
        return stack;
    }
    public Stack getBillete1000() {
		return billete1000;
	}
	public Stack getBillete500() {
		return billete500;
	}
	public Stack getBillete200() {
		return billete200;
	}
	public Stack getBillete100() {
		return billete100;
	}
	public Stack getBillete50() {
		return billete50;
	}
	public Stack getBillete20() {
		return billete20;
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
	
}