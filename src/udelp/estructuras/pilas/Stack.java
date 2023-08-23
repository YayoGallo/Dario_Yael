package udelp.estructuras.pilas;

public class Stack {
	private Object[] stack;
	private int size;
	public Stack(int size) {
		this.stack=new Object[size];
	}
	public void push(Object value) {
		if(stack.length>=size) {
			stack[size]=value;
			size++;
		}
	}
	public Object pop() {
		Object value=null;
		if (!isEmpty()){
			size--;
			value=stack[size];
		}
		return value;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public Object peak() {
		Object value=null;
		if (!isEmpty()){
			value=stack[size-1];
		}
		return value;
	}
	public String toString() {
		StringBuilder s=new StringBuilder();
		for(int i=0; i<size; i++) {
			s.append(stack[i]).append("->");
		}
		return s.toString();
	}
}
