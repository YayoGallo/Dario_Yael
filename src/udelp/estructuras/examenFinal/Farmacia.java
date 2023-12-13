package udelp.estructuras.examenFinal;

import java.util.Scanner;
import udelp.estructuras.examenFinal.Medicamento;
import udelp.estructuras.listas.ArrayList;

public class Farmacia {
	public static void main(String[] args){
		Scanner leer=new Scanner(System.in);
		Farmacia movimientos=new Farmacia();
		int opcion,opcion2, total = 0;
		String nombre, fecha, codigo;
		int precio;
		ArrayList lista=new ArrayList();
		ArrayList listaAgregados=new ArrayList();
		boolean repetir=false, valido = false;
		movimientos.iniciarInventario(lista);
		do {
			System.out.println("Menu\n1)Añadir nuevo\n2)Añadir existente\n3)Ver inventario\n4)Vender\n5)Ver productos añadidos\n6)Salir");
			System.out.println("Ingrese una opcion");
			opcion=leer.nextInt();
			switch(opcion) {
			case 1:
				Medicamento medicamento=new Medicamento();
				System.out.println("Ingresa el nombre del medicamento");
				nombre=leer.nextLine();
				System.out.println("Ingresa la fecha de caducidad");
				fecha=leer.nextLine();
				do {
					System.out.println("Ingresa el codigo");
					codigo=leer.nextLine();
					if(!movimientos.comprobarCodigoUnico(codigo, lista)) {
						System.out.println("Codigo Invalido");
						valido=false;
					}else {
						valido=true;
					}
				}while(!valido);
				System.out.println("Ingresa el precio");
				precio=leer.nextInt();
				medicamento.setCodigo(codigo);
				medicamento.setFecha(fecha);
				medicamento.setNombre(nombre);
				medicamento.setPrecio(precio);
				lista.add(medicamento);
				listaAgregados.add(medicamento);
				repetir=true;
				break;
			case 2:
				Medicamento aux=new Medicamento();
				do {
					System.out.println("Ingresa el nombre");
					nombre=leer.nextLine();
					Medicamento medicamentoExistente=new Medicamento();
					medicamentoExistente=movimientos.buscarCoincidencias(nombre, lista);
					if(null==medicamentoExistente) {
						valido=false;
						System.out.println("No se encuentran coincidencias");
					}
					aux=medicamentoExistente;
				}while(!valido);
				System.out.println("Ingresa la fecha de caducidad");
				fecha=leer.nextLine();
				aux.setFecha(fecha);
				lista.add(aux);
				listaAgregados.add(aux);
				repetir=true;
				break;
			case 3:
				System.out.println(movimientos.verInventario(lista));
				repetir=true;
				break;
			case 4:
				Medicamento aux2=new Medicamento();
				do {
					do {
						System.out.println("Ingresa el nombre del producto a vender");
						nombre=leer.nextLine();
						Medicamento medicamentoExistente=new Medicamento();
						medicamentoExistente=movimientos.buscarCoincidencias(nombre, lista);
						if(null==medicamentoExistente) {
							valido=false;
							System.out.println("No se encuentran coincidencias");
						}
						aux2=medicamentoExistente;
					}while(!valido);
					total+=aux2.getPrecio();
					System.out.println("Desea ingresar otro producto 1)Si\t Cualquier otro)No");
					opcion2=leer.nextInt();
				}while(opcion2==1);				
				System.out.println("Total a pagar"+ total);
				repetir=true;
				break;
			case 5:
				System.out.println(movimientos.verInventario(listaAgregados));
				repetir=true;
				break;
			case 6:
				System.out.println("Adios");
				repetir=false;
				break;
			default:
				System.out.println("Opcion invalida");
				repetir=true;
				break;
			}
		}while(repetir);
	}
	
	public void ordenarPorFechas(ArrayList lista) throws NumberFormatException, Exception {
		Medicamento aux=new Medicamento();
		Medicamento aux2=new Medicamento();
		String[] fecha1, fecha2;
		String fechaUno, fechaDos;
		for (int i = 0; i < lista.size(); i++) {
	        for (int j = i + 1; j < lista.size(); j++) {
	                aux=(Medicamento) lista.get(i);
	                aux2=(Medicamento) lista.get(j);
	                fechaUno= aux.getFecha();
	                fechaDos= aux2.getFecha();
	                fecha1=fechaUno.split("/");
	                fecha2=fechaDos.split("/");
	                if(Integer.parseInt(fecha1[2])>Integer.parseInt(fecha2[2])) {
	                	lista.set(i, aux2);
	                	lista.set(j, aux);
	                }else if(Integer.parseInt(fecha1[2])==Integer.parseInt(fecha2[2])&&Integer.parseInt(fecha1[1])>Integer.parseInt(fecha2[1])){
	                	lista.set(i, aux2);
	                	lista.set(j, aux);
	                }else if(Integer.parseInt(fecha1[2])==Integer.parseInt(fecha2[2])&&Integer.parseInt(fecha1[1])==Integer.parseInt(fecha2[1])&&Integer.parseInt(fecha1[0])>Integer.parseInt(fecha2[0])) {
	                	lista.set(i, aux2);
	                	lista.set(j, aux);
	                }
	        }
	    }
	}
	
	public boolean comprobarCodigoUnico(String codigo, ArrayList lista) {
		Medicamento aux=new Medicamento();
		boolean valido = true;
		if(lista.size()!=0) {
			for (int i = 0; i < lista.size(); i++) {
				aux=(Medicamento) lista.get(i);
				if(aux.getCodigo().equalsIgnoreCase(codigo)) {
					valido=false;
				}
			}
		}
		return valido;
	}
	
	public Medicamento buscarCoincidencias(String nombre, ArrayList lista) {
		Medicamento aux=new Medicamento();
		boolean valido = true;
		if(lista.size()!=0) {
			for (int i = 0; i < lista.size(); i++) {
				aux=(Medicamento) lista.get(i);
				if(aux.getNombre().equals(nombre)) {
					return aux;
				}
			}
		}
		return null;
	}
	
	public String verInventario(ArrayList lista) {
		String respuesta = "";
		Medicamento aux=new Medicamento();
		for (int i = 0; i < lista.size(); i++) {
			aux=(Medicamento) lista.get(i);
			respuesta+=aux.getNombre()+"|"+aux.getCodigo()+"|"+aux.getPrecio()+"|"+aux.getFecha()+"\n";
		}
		return respuesta;
	}
	
	public void iniciarInventario(ArrayList lista) {
		Medicamento uno=new Medicamento();
		uno.setCodigo("1023125697");
		uno.setFecha("21/11/2017");
		uno.setNombre("kETOROLACO");
		uno.setPrecio(100);
		lista.add(uno);
	}
}
