package udelp.estructuras.colas.tareas;

import udelp.estructuras.nodos.LinkedStack;

public class Persona {
    private String cuenta;
    private int tarea;
    private int monto;
    private LinkedStack cartera = new LinkedStack();
    public boolean prioridad;

    public Persona(String cuenta, int tarea, boolean prioridad) {
        this.cuenta = cuenta;
        this.tarea = tarea;
        this.prioridad = prioridad;
        this.monto = generarMontoAleatorio(tarea);
        if (tarea == 0) {
            generarCarteraDeposito();
        }
    }

    public String getCuenta() {
        return cuenta;
    }

    public int getTarea() {
        return tarea;
    }

    public int getMonto() {
        return monto;
    }

    public LinkedStack getCartera() {
        return cartera;
    }
    
    public void setCartera(LinkedStack nuevaCartera) {
        cartera = nuevaCartera;
    }
    
    private int generarMontoAleatorio(int tarea) {
    	return (int) (Math.random() * 9000);
    }

    private void generarCarteraDeposito() {
        int[] cambio = {1, 5, 10, 20, 50, 100, 200, 500};
        int dinero = 0;
        do {
            int aleatorio = cambio[(int) (Math.random() * 7)];
            if (dinero + aleatorio <= monto) {
                cartera.push(aleatorio);
                dinero = dinero + aleatorio;
            }
        } while (dinero < monto);
    }
}
