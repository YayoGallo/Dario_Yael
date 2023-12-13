package udelp.estructuras.examenFinal;
import java.util.Random;
import udelp.estructuras.listas.ArrayList;
import udelp.estructuras.listas.tareas.Ordenamientos;
import java.util.Scanner;
public class OrdenamientoListas {
	
	public static void main(String[] args) throws NumberFormatException, Exception {
		int tamaño;
		OrdenamientoListas movimientos=new OrdenamientoListas();
		Scanner leer=new Scanner(System.in);
		ArrayList listaUno=new ArrayList();
		ArrayList listaDos=new ArrayList();
		System.out.println("Ingrese el tamaño de las listas");
		tamaño=leer.nextInt();
		listaUno=movimientos.datosAleatorios(tamaño);
		listaDos=movimientos.datosAleatorios(tamaño);
		System.out.println("Lista Uno"+ listaUno.toString());
		System.out.println("Lista Dos"+ listaDos.toString());
		System.out.println("Lista Repetidos" + movimientos.listaDeRepetidos(listaUno, listaDos).toString());
	}
	
	public ArrayList datosAleatorios (int tamaño) throws NumberFormatException, Exception {
		int aux;
		ArrayList lista=new ArrayList();
		Random random = new Random();
		do {
			aux=random.nextInt(100) + 1;
			lista.add(aux);
		}while(!(lista.size()==tamaño));
		Ordenamientos movimiento=new Ordenamientos();
		movimiento.seleccion(lista);
		return lista;
	}
	
	public ArrayList listaDeRepetidos(ArrayList listaUno, ArrayList listaDos) throws NumberFormatException, Exception {
		int aux,aux1,aux2, aux3=0;
		ArrayList lista=new ArrayList();
		for(int i=0; i<listaUno.size(); i++) {
			aux=Integer.parseInt(String.valueOf(listaUno.get(i)));
			aux1=Integer.parseInt(String.valueOf(listaDos.get(i)));
			if(aux==aux1) {
				lista.add(lista.get(i));
			}
			for(int j=i+1; j<listaUno.size(); j++) {
				aux2=Integer.parseInt(String.valueOf(listaDos.get(j)));
				aux3=Integer.parseInt(String.valueOf(listaUno.get(j)));
				if((aux==aux2&&aux==aux3)||(aux1==aux2&&aux1==aux3)) {
					lista.add(listaUno.get(j));
					lista.add(listaDos.get(j));
				}else if(aux==aux2||aux1==aux2) {
					lista.add(listaDos.get(j));
				}else if(aux==aux3||aux1==aux2) {
					lista.add(listaUno.get(j));
				}
			}
		}
		Ordenamientos movimiento=new Ordenamientos();
		movimiento.seleccion(lista);
		return lista;
	}
	
}
