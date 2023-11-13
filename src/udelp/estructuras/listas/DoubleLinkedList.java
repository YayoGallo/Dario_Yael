package udelp.estructuras.listas;

import udelp.estructuras.nodos.BiNodo;

public class DoubleLinkedList {
	private int size;
	private BiNodo f;
	private BiNodo r;

	public DoubleLinkedList() {
		size=0;
		f=null;
		r=null;
	}

	private void addFirst(Object value) {
		BiNodo nodo=new BiNodo();
		nodo.setDato(value);
		if(null!=r)
		{
			nodo.setIzquierda(f);
			f.setDerecha(nodo);;
		}else if(f==null) {
			r=nodo;
		}
		f=nodo;
		size++;
	}

	private void addLast(Object value) {
		BiNodo nodo=new BiNodo();
		nodo.setDato(value);
		if(null!=r)
		{
			nodo.setDerecha(r);
			r.setIzquierda(nodo);;
		}else if(f==null) {
			f=nodo;
		}
		r=nodo;
		size++;
	}

	private void addMiddle(int index, Object value) {
		BiNodo temp=search(index);
		BiNodo nodo=new BiNodo();
		nodo.setDato(value);
		BiNodo derecha=temp.getDerecha();
		nodo.setDerecha(temp);
		nodo.setIzquierda(derecha);
		derecha.setDerecha(nodo);
		temp.setIzquierda(nodo);
		size++;
	}
	
	private BiNodo search(int index) {
		int mitad=size/2;	
		BiNodo temp;
		int tempIndex=0;
		if(index<mitad) {
			temp=f;
			tempIndex=0;
			while(tempIndex<index) {
				tempIndex++;
				temp=temp.getDerecha();
			}
		}else {
			temp=r;
			tempIndex=size-1;
			while(tempIndex>index) {
				tempIndex--;
				temp=temp.getIzquierda();
			}
		}
		return temp;
	}
	
	public void add(int index, Object value) throws Exception{
		if (index<0||index>size) {
			throw new Exception("Fuera de rango");
		}
		BiNodo nodo=new BiNodo();
		nodo.setDato(value);
		if (index==0) {
			addFirst(nodo);
		}else if(index==size-1) {
			addLast(value);
		}else {
			addMiddle(index, nodo);
		}
	}
	
	private Object removeLast() {
		Object value=null;
		if(null!=r) {
			value=r.getDato();
			this.r=r.getDerecha();
			size--;
		}
	
		return value;
	}
	
	private Object removeFirst() {
		BiNodo temp=f;
		Object value;
		int tempSize=size;
		while(null!=temp.getIzquierda() && tempSize>1) {
			temp=temp.getIzquierda();
			tempSize--;
		}
		value=temp.getIzquierda().getDato();
		temp.setIzquierda(null);
		size--;
		return value;
	}
	
	private Object removeMiddle(int index) {
		BiNodo temp= search(index);
		BiNodo derecha= temp.getDerecha();
		BiNodo izquierda= temp.getIzquierda();
		derecha.setIzquierda(izquierda);
		izquierda.setDerecha(derecha);
		temp.setIzquierda(null);
		temp.setDerecha(null);
		size--;
		return temp.getDato();
	}
	
	public Object remove(int index) throws Exception{
		if(index<0 || index >= size) {
			throw new Exception("Fuera de rango");
		}
		Object value;
		if(index==0) {
			value=removeFirst();
		}else if(index==size-1) {
			value=removeLast();
		}else {
			value=removeMiddle(index);
		}
		return value;
	}
	
	public Object get(int index) {
		BiNodo temp=search(index);
		return temp.getDato();
	}
	
	public void set(int index, Object value) {
		BiNodo temp=search(index);
		temp.setDato(value);
	}

}
