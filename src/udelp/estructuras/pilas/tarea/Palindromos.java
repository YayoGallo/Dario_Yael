package udelp.estructuras.pilas.tarea;

import udelp.estructuras.pilas.Stack;

public class Palindromos {

	public static void main(String[] args) {
		Palindromos movimientos=new Palindromos();
		System.out.println(movimientos.esPalindromo("adan nada"));
		System.out.println(movimientos.esPalindromo("mocos"));

	}
	public boolean esPalindromo (String cadena) {
		String derecho = "",alrevez="";
		Stack stack=new Stack(cadena.length());
		for (int i=0; i<cadena.length(); i++) {
			if (cadena.charAt(i)!=' ') {
				stack.push(cadena.charAt(i));
			}
		}
		derecho=stack.toString();
		while(!stack.isEmpty()) {
			alrevez=alrevez+stack.pop();
		}
		return derecho.equals(alrevez);
	}
}
