package udelp.estructuras.colas;

import udelp.estructuras.nodos.BooleanNodo;

public class BooleanPriorityQueue {
	private int size;
	private BooleanNodo f;
	private BooleanNodo r;
	
	public BooleanPriorityQueue()
	{
		this.size = 0;
		this.f = null;
		this.r = null;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public void enqueue (Object value, boolean prioridad)
	{
		BooleanNodo nodo = new BooleanNodo();
		nodo.setDato(value);
		nodo.setPrioridad(prioridad);
		if (null == r)
		{
			r=nodo;
			f=r;
		}
		else if (null == f)
		{
			f = nodo; 
		}
		r = nodo;
		size++;
	}
	
	public Object dequeue()
	{
		Object value = null;
		if(null!=f)
		{
			value = f.getDato();
			f = f.getEnlace();
			size--;
		}
		return value;
	}
	
	public Object front()
	{
		return (null!= f)?f.getDato():null;
	}
	
	public Object rear()
	{
		return (null!= r)?r.getDato():null;
	}
	public String toString() {
		String s="";
		BooleanNodo temp=f;
		while(null!=temp) {
			s=temp.getDato()+"->"+s;
			temp=temp.getEnlace();
		}
		return s;
	}
}
