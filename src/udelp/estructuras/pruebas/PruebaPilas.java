package udelp.estructuras.pruebas;

import udelp.estructuras.pilas.Stack;

public class PruebaPilas {

	public static void main(String[] args) {	
		Stack stack=new Stack(10);
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		stack.push(10);
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack.peak());
		stack.push(5);
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack.peak());
		stack.push(3);
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack.peak());
		Object value=stack.pop();
		System.out.println(value);
	}

}
