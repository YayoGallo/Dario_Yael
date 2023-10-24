package udelp.estructuras.listas.tareas;

import java.util.Random;
import java.util.Scanner;
import udelp.estructuras.listas.ArrayList;
public class Ordenamientos {

	public static void main(String[] args) throws Exception, Exception {
		ArrayList lista=new ArrayList();
		Scanner leer=new Scanner(System.in);
		Ordenamientos movimientos=new Ordenamientos();
		int tamanoLista;
		System.out.println("Ingrese el tamaño de la lista");
		tamanoLista=leer.nextInt();
		lista=movimientos.listaNumeros(tamanoLista);
		System.out.println("Arreglo sin acomodar\n"+lista.toString());
		System.out.println("Arreglo acomodado por seleccion\n"+movimientos.seleccion(lista).toString());
		System.out.println("Arreglo acomodado por shell\n"+movimientos.shell(lista).toString());
		System.out.println("Arreglo acomodado por quick");
		movimientos.quick(lista, 0, lista.size()-1);
		System.out.println(lista.toString());
	}
	
	public ArrayList listaNumeros (int tamano) {
		ArrayList lista=new ArrayList();
        Random random = new Random();
        for (int i = 0; i < tamano; i++) {
            lista.add(random.nextInt(100) + 1); 
        }
        return lista;
	}
	
	public ArrayList seleccion(ArrayList lista) throws NumberFormatException, Exception{
		ArrayList listaAcomodada=lista;
		for (int i = 0; i < listaAcomodada.size(); i++) {
	        for (int j = i + 1; j < listaAcomodada.size(); j++) {
	            if (Integer.parseInt(String.valueOf(listaAcomodada.get(i))) > Integer.parseInt(String.valueOf(listaAcomodada.get(j)))) {
	                int temporal = Integer.parseInt(String.valueOf(listaAcomodada.get(i)));
	                listaAcomodada.set(i, Integer.parseInt(String.valueOf(listaAcomodada.get(j)))); 
	                listaAcomodada.set(j, temporal);
	            }
	        }
	    }
		return listaAcomodada;
	}
	
	public ArrayList shell(ArrayList desacomodada) throws NumberFormatException, Exception {
        int salto, aux, i;
        boolean cambios;
        ArrayList lista=desacomodada;
        for (salto = lista.size() / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {                                      
                cambios = false;
                for (i = salto; i < lista.size(); i++)   
                {
                    if (Integer.parseInt(String.valueOf(lista.get(i-salto))) > Integer.parseInt(String.valueOf(lista.get(i)))) {       
                        aux = Integer.parseInt(String.valueOf(lista.get(i)));                  
                        lista.set(i, Integer.parseInt(String.valueOf(lista.get(i-salto))));
                        lista.set(i-salto, aux);
                        cambios = true;                                                 
                    }
                }
            }
        }
        return lista;
	}
	
	public void quick(ArrayList lista, int bajo, int alto) throws NumberFormatException, Exception {
		if (bajo < alto) {
            int pivote = particion(lista, bajo, alto);
            quick(lista, bajo, pivote - 1);
            quick(lista, pivote + 1, alto);
        }
    }

    public int particion(ArrayList lista, int bajo, int alto) throws NumberFormatException, Exception {
        int pivote = Integer.parseInt(String.valueOf(lista.get(bajo)));
        int i = bajo;
        int j = alto;
        while (i < j) {
            while (i <= alto && Integer.parseInt(String.valueOf(lista.get(i))) <= pivote) {
                i++;
            }
            while (Integer.parseInt(String.valueOf(lista.get(j))) > pivote) {
                j--;
            }
            if (i < j) {
                int temp = Integer.parseInt(String.valueOf(lista.get(i)));
                lista.set(i, Integer.parseInt(String.valueOf(lista.get(j)))); 
                lista.set(j, temp);
            }
        }

        int temp = Integer.parseInt(String.valueOf(lista.get(bajo)));
        lista.set(bajo, Integer.parseInt(String.valueOf(lista.get(j))));
        lista.set(j, temp);
        return j;
    }
	
}
