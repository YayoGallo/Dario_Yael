package udelp.estructuras.examen;

import java.util.Random;

import udelp.estructuras.colas.CircularQueue;
import udelp.estructuras.nodos.LinkedStack;
import udelp.estructuras.pilas.Stack;

public class ExamenPrimerParcial {

	public static void main(String[] args) {
		ExamenPrimerParcial movimientos=new ExamenPrimerParcial();
		System.out.println("Primer ejercicico \n"+ movimientos.SumaCuandoSea50());
		System.out.println("Segundo ejercicio");
		movimientos.DiezNumeros();
		System.out.println("Cuarto ejercicico \n"+ movimientos.SacarCuandoEs25());
	}
	
	public int SumaCuandoSea50(){
		LinkedStack stack=new LinkedStack();
		Random random = new Random();
		int resultado = 0;
		do {
			stack.push(random.nextInt(100) + 1);
		}while (50!=Integer.parseInt(String.valueOf(stack.peak())));
		while(stack.size()>0) {
			resultado+=Integer.parseInt(String.valueOf(stack.pop()));
		}
		
		return resultado;
	}
	
	public void DiezNumeros(){
		LinkedStack stack=new LinkedStack();
		LinkedStack pila=new LinkedStack();
		Random random = new Random();
		int a, b,c;
		do {
			pila.push(random.nextInt(100) + 1);
		}while (pila.size()<10);
		while(!(pila.size()==0)) {
			a=Integer.parseInt(String.valueOf(pila.pop()));
			b=Integer.parseInt(String.valueOf(pila.pop()));
			c=a+b;
			System.out.println(a+"+"+b+"="+c);
			stack.push(c);
		}
		a=Integer.parseInt(String.valueOf(stack.pop()));
		b=Integer.parseInt(String.valueOf(stack.pop()));
		c=a-b;
		System.out.println(a+"-"+b+"="+c);
		a=Integer.parseInt(String.valueOf(stack.pop()));
		b=c*a;
		System.out.println(c+"*"+a+"="+b);
		a=Integer.parseInt(String.valueOf(stack.pop()));
		c=b+a;
		System.out.println(b+"+"+a+"="+c);
		a=Integer.parseInt(String.valueOf(stack.pop()));
		b=c-a;
		System.out.println(c+"-"+a+"="+b);
	}
	
	public String[] ListaSinRepeticiones() {
		CircularQueue cola=new CircularQueue(50);
		Random random = new Random();
		String aux;
		String[] respuesta= new String[50];
		for (int i=0; i<50; i++) {
			cola.enqueue(random.nextInt(100) + 1);
		}
		while (cola.size()>0) {
			aux=String.valueOf(cola.dequeue());
			for (int i=0; i<respuesta.length; i++) {
				if(null!=respuesta[i]) {
					if(Integer.parseInt(aux)==Integer.parseInt(respuesta[i])) {
						break;
					}else if (null==respuesta[i]) {
						respuesta[i]=aux;
					}
				}
			}
		}
		return respuesta;
	}
	
	public String mostrarArreglo(String[] arreglo) {
		String respuesta="";
		for (int i=0; i<arreglo.length; i++) {
			if(null!=arreglo[i]) {
				respuesta+=arreglo[i];
				respuesta=respuesta+"\n";
			}
		}
		return respuesta;
	}
	
	public int SacarCuandoEs25() {
		int respuesta = 0,aux;
		CircularQueue cola=new CircularQueue(50);
		Random random = new Random();
		do {
			aux=random.nextInt(100) + 1;
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
}
