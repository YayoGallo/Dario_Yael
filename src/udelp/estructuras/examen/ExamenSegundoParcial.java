package udelp.estructuras.examen;

import java.util.Random;

import udelp.estructuras.colas.CircularQueue;
import udelp.estructuras.colas.LinkedQueue;
import udelp.estructuras.listas.ArrayList;
import udelp.estructuras.listas.tareas.Ordenamientos;
import java.util.Scanner;

public class ExamenSegundoParcial {
	
	public static void main(String[] args) throws NumberFormatException, Exception {
		ArrayList lista=new ArrayList();
		ExamenSegundoParcial movimientos=new  ExamenSegundoParcial();
		String[] palabras;
		Scanner leer=new Scanner(System.in);
		System.out.println("Primer ejercicio\n Ingresa 5 palabras");
		palabras=movimientos.crearArreglo();
		movimientos.separarVocalesYConsonantes(palabras);
		System.out.println("Segundo ejercicio");
		System.out.println("Tercer ejercicico");
		lista=movimientos.datosAleatorios();
		System.out.println(lista.toString());
		System.out.println("Media: "+ movimientos.media(lista));
		System.out.println("Mediana: "+ movimientos.mediana(lista));
		System.out.println("Moda: "+ movimientos.calcularModa(lista));
		System.out.println("Cuarto ejercicico \n"+ movimientos.SacarCuandoEs25());
	}
	
	public int SacarCuandoEs25() {
		int respuesta = 0,aux;
		CircularQueue cola=new CircularQueue(50);
		Random random = new Random();
		do {
			aux=random.nextInt(50) + 1;
			if (25==aux&&!cola.isEmpty()) {
				cola.dequeue();
				cola.dequeue();
				cola.dequeue();
				respuesta+=1;
			}else {
				cola.enqueue(random.nextInt(100) + 1);
			}
		}while(!(cola.size()==50));
		return respuesta;
	}
	
	public ArrayList datosAleatorios () throws NumberFormatException, Exception {
		int aux;
		ArrayList lista=new ArrayList();
		Random random = new Random();
		do {
			aux=random.nextInt(50) + 1;
			lista.add(aux);
		}while(!(lista.size()==50));
		Ordenamientos movimiento=new Ordenamientos();
		movimiento.seleccion(lista);
		return lista;
	}
	
	public double media (ArrayList lista) {
		double respuesta = 0;
		for (int i=0; i< lista.size(); i++) {
			respuesta+=Integer.parseInt(String.valueOf(lista.get(i)));
		}
		respuesta=respuesta/lista.size();
		return respuesta;
	}
	
	public int calcularModa(ArrayList lista) {
        int moda = 0;
        int modaActual = Integer.parseInt(String.valueOf(lista.get(0)));
        int frecuencia = 1;
        int maxFrecuencia = 1;

        for (int i = 1; i < lista.size(); i++) {
            if (Integer.parseInt(String.valueOf(lista.get(i))) == modaActual) {
                frecuencia++;
            } else {
                frecuencia = 1;
                modaActual = Integer.parseInt(String.valueOf(lista.get(i)));
            }

            if (frecuencia > maxFrecuencia) {
                moda = modaActual;
                maxFrecuencia = frecuencia;
            }
        }

        return moda;
    }
	
	public int mediana (ArrayList lista) throws NumberFormatException, Exception {
		int respuesta, index=lista.size()/2;
		respuesta=Integer.parseInt(String.valueOf(lista.get(index)));
		return respuesta;
	}
	
	
    public String[] crearArreglo () {
		Scanner leer=new Scanner(System.in);
		String[] matriz=new String[5];
		for (int i=0; i<matriz.length; i++) {
			System.out.println("Ingresa la palabra "+i);
			matriz[i]=leer.nextLine();
		}
		return matriz;
	}
	
    public void separarVocalesYConsonantes(String[] palabras) {
    	LinkedQueue colaVocales= new LinkedQueue();
    	LinkedQueue colaConsonantes= new LinkedQueue();
    	String palabra;
    	for (int i=0; i<palabras.length; i++) {
    		palabra=palabras[i];
    		palabra.toLowerCase();
    		for (int j=0; j<palabra.length(); j++) {
    			if (palabra.charAt(j)=='a'||palabra.charAt(j)=='e'||palabra.charAt(j)=='i'||palabra.charAt(j)=='o'||palabra.charAt(j)=='u') {
    				colaVocales.enqueue(palabra.charAt(j));
    			}else{
    				colaConsonantes.enqueue(palabra.charAt(j));
    			}
    		}
    	}
    	System.out.println(colaVocales.toString());
    	System.out.println(colaConsonantes.toString());
    }
   

    
}
