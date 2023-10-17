package udelp.estructuras.colas.tareas;
	import java.util.Scanner;
	public class Banco {
	    public static void main(String[] args) {
	        Ingresar ingreso = new Ingresar();
	        ingreso.start();
	        Scanner leer = new Scanner(System.in);
	        String opcion;
	        Caja caja1 = new Caja(ingreso.getCola());
	        caja1.start();
	        Caja caja2 = new Caja(ingreso.getCola());
	        caja2.start();
	        Caja caja3 = new Caja(ingreso.getCola());
	        caja3.start();
	        Caja caja4 = new Caja(ingreso.getCola());
	        caja4.start();
	        boolean ciclo = true;
	        while (ciclo) {
	            System.out.println("\tBanco " + "\n" + "Escoge una opcion:" + "\n" + "1)Estatus" + "\n" + "2)Salir");
	            opcion = leer.nextLine();
	            if (validarEntero(opcion)) {
	                int seleccion = Integer.parseInt(opcion);
	                switch (seleccion) {
	                    case 1:
	                        System.out.println("\tFila de Banco:\n" + ingreso.getCola().toString());
	                        System.out.println(caja1.estatus());
	                        System.out.println(caja2.estatus());
	                        System.out.println(caja3.estatus());
	                        System.out.println(caja4.estatus());
	                        break;
	                    case 2:
	                        System.out.println("Adios");
	                        ciclo = false;
	                        break;
	                    default:
	                        System.out.println("Opcion invalida");
	                        break;
	                }
	            } else {
	                System.out.println("Elige un numero del menu");
	            }
	        }
	    }
	    public static boolean validarEntero(String valor) {
	        try {
	            Integer.parseInt(valor);
	            return true;
	        } catch (NumberFormatException ex) {
	            return false;
	        }
	    }
	}