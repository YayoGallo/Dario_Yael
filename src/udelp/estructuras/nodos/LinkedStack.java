package udelp.estructuras.nodos;

public class LinkedStack {
	private Nodo apuntador;
	private int size;
	public LinkedStack() {
		this.size=0;
		this.apuntador=null;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
		//return null==apuntador;
	}
	public Object peak() {
		return apuntador.getDatos();
	}
	public void push(Object value) {
		Nodo nodo=new Nodo();
		nodo.setDatos(value);
		if (null!=apuntador){
			nodo.setEnlace(apuntador);	
		}
		this.apuntador=nodo;
		this.size++;
	}
	public Object pop() {
		Object value=null;
		if(null!=apuntador.getEnlace()) {
			value=apuntador.getDatos();
			this.apuntador=apuntador.getEnlace();
			size--;
		}
		return value;
	}
	public String toString() {
		String respuesta="";
		Nodo temp=apuntador;
		while(null!=temp) {
			respuesta= temp.getDatos()+"<="+respuesta;
			temp=temp.getEnlace();
		}
		return respuesta;
	}
}