package udelp.estructuras.pruebas;

import udelp.estructuras.nodos.LinkedStack;

public class PruebaNodos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedStack stack=new LinkedStack();
		stack.push(10);
		stack.push(5);
		stack.push(8);
		stack.push(9);
		stack.push(11);
		stack.push(34);
		stack.push(1);
		stack.push(0);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
