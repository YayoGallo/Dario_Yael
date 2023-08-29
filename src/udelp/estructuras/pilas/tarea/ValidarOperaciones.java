package udelp.estructuras.pilas.tarea;

import udelp.estructuras.pilas.Stack;

public class ValidarOperaciones {

	public static void main(String[] args) {
		ValidarOperaciones movimientos=new ValidarOperaciones();
		System.out.println(movimientos.validar("1"));
		System.out.println(movimientos.validar("((a+b)-c)"));
		System.out.println(movimientos.validar("(6)+(9+5)(7)"));
		System.out.println(movimientos.validar("()("));
		System.out.println(movimientos.validar("(()"));
		System.out.println(movimientos.validar("((b-b)+e "));
	}
	public boolean validar(String cadena) {
		int valida=0;
		Stack stack=new Stack(cadena.length());
		for (int i=0; i<cadena.length(); i++) {
			if (cadena.charAt(i)=='('||cadena.charAt(i)==')') {
				stack.push(cadena.charAt(i));
			}
		}
		while (valida>=0&&!stack.isEmpty()) {
			if (stack.pop().equals(')')) {
				valida++;
			}else {
				valida--;
			}
		}
		return valida==0;
	}
}
