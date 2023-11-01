package udelp.estructuras.listas;

import udelp.estructuras.nodos.Nodo;

public class LinkedList {
	private Nodo apuntador;
	private int size;
	public LinkedList() {
		apuntador=null;
		size=0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void add(Object value) {
		Nodo nodo=new Nodo();
		nodo.setDato(value);
		if(null==apuntador) {
			this.apuntador=nodo;
			this.size++;
		}else {
			nodo.setEnlace(apuntador);
			this.apuntador=nodo;
			this.size++;
		}
	}
	
	private Object removeLast() {
		Object value=null;
		if(null!=apuntador) {
			value=apuntador.getDato();
			this.apuntador=apuntador.getEnlace();
			size--;
		}
	
		return value;
	}
	
	private void addFirst (Nodo value) {
		Nodo actual=apuntador;
		while(null!=actual.getEnlace()) {
			actual=actual.getEnlace();
		}
		actual.setEnlace(value);
		size++;
	}
	
	private void addMiddle (int index, Nodo value) {
		int tempSize=size-1;
		Nodo actual=apuntador;
		while(tempSize>index) {
			tempSize--;
			actual=actual.getEnlace();
		}
		Nodo siguiente=actual.getEnlace();
		actual.setEnlace(value);
		value.setEnlace(siguiente);
		size++;
	}
	
	public void add(int index, Object value) throws Exception{
		if (index<0||index>size) {
			throw new Exception("Fuera de rango");
		}
		Nodo nodo=new Nodo();
		nodo.setDato(value);
		if (index==0) {
			addFirst(nodo);
		}else if(index==size-1) {
			add(value);
		}else {
			addMiddle(index, nodo);
		}
	}
	
	public Object get(int index)throws Exception{
		if (index<0|| index>=size) {
			throw new Exception("Fuera de rango");
		}
		Nodo actual=apuntador;
		int tempSize=size-1;
		while(index<tempSize) {
			actual=actual.getEnlace();
			tempSize--;
		}
		return actual.getDato();
	}
	
	public void set(int index, Object value) throws Exception {
		if (index<0|| index>=size) {
			throw new Exception("Fuera de rango");
		}
		Nodo actual=apuntador;
		int tempSize=size-1;
		while(index<tempSize) {
			actual=actual.getEnlace();
			tempSize--;
		}
		actual.setDato(value);
	}
	private Object removeFirst() {
		Nodo temp=apuntador;
		Object value;
		int tempSize=size;
		while(null!=temp.getEnlace() && tempSize>1) {
			temp=temp.getEnlace();
			tempSize--;
		}
		value=temp.getEnlace().getDato();
		temp.setEnlace(null);
		size--;
		return value;
	}
	
	private Object removeMiddle(int index) {
		int tempSize=size-2;
		Nodo temp=apuntador;
		Object value;
		while(tempSize>index) {
			temp=temp.getEnlace();
			tempSize--;
		}
		Nodo siguiente=temp.getEnlace();
		value=siguiente.getDato();
		temp.setEnlace(siguiente.getEnlace());
		size--;
		return value;
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
	
	public String toString() {
		String s="";
		Nodo temp=apuntador;
		while(null!=temp) {
			s=temp.getDato()+"->"+s;
			temp=temp.getEnlace();
		}
		return s;
	}
}
