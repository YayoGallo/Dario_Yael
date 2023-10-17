package udelp.estructuras.listas;

public class ArrayList {
	private Object[] list;
	private int size;
	private int increment;
	public ArrayList() {
		size=0;
		increment=10;
		list=new Object[20];
	}
	
	public ArrayList(int size, int increment){
		this.size=0;
		this.increment=increment;
		this.list=new Object[size];
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int size() {
		return size;
	}
	
	public void add(int index, Object value) {
		int nIndex=index>size?size:index;
		if(size>=list.length) {
			incrementArray();
		}
		if(nIndex<size) {
			for(int i=size-1;i>nIndex; i--) {
				list[i+1]=list[i];
			}
		}
		list[nIndex]= value;
		size++;
	}
	
	private void incrementArray() {
		Object[]temp=new Object[list.length+increment];
		for(int i=0; list.length>i; i++) {
			temp[i]=list[i];
		}
		list=temp;
	}
	
	public void add(Object value) {
		add(size,value);
	}
}
