package udelp.estructuras.colas.tareas;
import java.util.Scanner;

import udelp.estructuras.nodos.LinkedStack;
public class MaquinaExpendedora {

	public static void main(String[] args) {
		Cambios cambios=new Cambios();
		LinkedStack cartera=new LinkedStack();
		MaquinaExpendedora movimientos=new MaquinaExpendedora();
		Productos[][] maquina=new Productos[3][2];
		Scanner leer=new Scanner(System.in);
		boolean ciclo=false;
		String nombre,codigo;
		double precio, moneda, monto, ganancia;
		byte opcion = 0;
		int indiceFila, indiceColumna, faltantes,meter, ciclo1 = 0;
		System.out.println("Iniciando maquina\n Todos los productos ingresados iniciaran con 20 unidades");
		for (int i=0; i<maquina.length; i++) {
			for (int j=0; j<maquina[i].length; j++) {
				System.out.println("Ingrese el nombre del producto");
				nombre= leer.nextLine();
				System.out.println("Ingrese el precio del producto");
				precio= Double.parseDouble(leer.nextLine());
				Productos producto=new Productos(nombre,precio);
				maquina[i][j]=producto;
			}	
		}
		do {
			System.out.println("Maquina expendedora\nElige una opcion\n1)Ver maquina\n2)Rellenar maquina\n3)Comprar\n4)Sacar monedas\n5)Salir");
			opcion=Byte.parseByte(leer.nextLine());
			switch(opcion) {
				case 1:
					System.out.println(movimientos.verMaquina(maquina));
					ciclo=true;
					break;
				case 2:
					if(movimientos.productosLlenos(maquina)) {
						System.out.println("Todos los productos estan completos");
					}else {
						System.out.println("Ingresa el codigo del producto que deseas rellenar");
						codigo=leer.nextLine();
						if (!(codigo.length()==2)) {
							System.out.println("Codigo invalido");
						}else {
							indiceFila=((codigo.charAt(0) == 'A') ? 0 :(codigo.charAt(0) == 'B') ? 1 :(codigo.charAt(0) == 'C') ? 2:-1);
							indiceColumna=(codigo.charAt(1)=='1' ) ? 0:(codigo.charAt(1)=='2' ) ? 1:-1 ;
							if(indiceFila==-1||indiceColumna==-1) {
								System.out.println("El codigo es invalido");
							}else if (maquina[indiceFila][indiceColumna].getCola().size()<20) {
								faltantes=20-maquina[indiceFila][indiceColumna].getCola().size();
								System.out.println("Faltan: "+faltantes+"\n¿Cuantos productos deseas meter?");
								meter=Integer.parseInt(leer.nextLine());
								if(meter>faltantes) {
									while(ciclo1<=faltantes) {
										maquina[indiceFila][indiceColumna].ingresar();
										ciclo1++;
									}
									System.out.println("Se ingresaron "+faltantes+" sobraron"+ (meter-faltantes));
								}else {
									while(ciclo1<=faltantes) {
										maquina[indiceFila][indiceColumna].ingresar();
										ciclo1++;
									}
									System.out.println("Se agregaron los productos");
								}
							}
						}
					}
					ciclo1=0;
					ciclo=true;
					break;
				case 3:
					System.out.println("Ingresa el codigo del producto que deseas");
					codigo=leer.nextLine();
					if (!(codigo.length()==2)) {
						System.out.println("Ingresa un codigo valido");
					}else {
						indiceFila=((codigo.charAt(0) == 'A') ? 0 :(codigo.charAt(0) == 'B') ? 1 :(codigo.charAt(0) == 'C') ? 2:-1);
						indiceColumna=(codigo.charAt(1)=='1' ) ? 0:(codigo.charAt(1)=='2' ) ? 1:-1 ;
						if(indiceFila==-1||indiceColumna==-1||movimientos.soMuchCash(indiceFila, indiceColumna, maquina, cambios)) {
							System.out.println("El codigo es invalido o la maquina no puede recibir mas monedas");
						}else if(!maquina[indiceFila][indiceColumna].getCola().isEmpty()) {
							do {
								System.out.println("Ingresa la moneda");
								moneda=Double.parseDouble(leer.nextLine());
								if (moneda==.5||moneda==1||moneda==2||moneda==5||moneda==10||moneda==20) {
									cartera.push(moneda);
								}
								monto=movimientos.sumaStack(cartera);
							}while(monto<=maquina[indiceFila][indiceColumna].getPrecio());
							
							if (monto==maquina[indiceFila][indiceColumna].getPrecio()) {
								movimientos.meterMonedas(cartera, cambios);
								maquina[indiceFila][indiceColumna].getCola().dequeue();
								System.out.println(maquina[indiceFila][indiceColumna].getNombreProducto()+" entregado");
							}else {
								if(movimientos.somosPobres(indiceFila, indiceColumna, maquina, cambios, monto)) {
									System.out.println("No hay cambio suficiente para entregar su producto");
								}else {
									movimientos.meterMonedas(cartera, cambios);
									maquina[indiceFila][indiceColumna].getCola().dequeue();
									System.out.println(maquina[indiceFila][indiceColumna].getNombreProducto()+" entregado\nCambio en monedas: "+movimientos.suCambio(monto, maquina[indiceFila][indiceColumna], cambios));
								}
							}
							
						}else {
							System.out.println("No quedan productos");
						}
					}
					ciclo=true;
					break;
				case 4:
					System.out.println("Se sacaran las monedas hasta la mitad de su capacidad para seqguir con las ventas");
					ganancia=movimientos.ganancias(cambios);
					System.out.println("Ganancias: "+ganancia);
					ciclo=true;
					break;
				case 5: 
					System.out.println("Fin del programa");
					ciclo=false;
					break;
			}
		}while(ciclo);
		
	}
	
	public String verMaquina(Productos[][] maquina) {
		String respuesta="",codigo;
		for (int i=0; i<maquina.length; i++) {
			for (int j=0; j<maquina[i].length; j++) {
				codigo = (i == 0) ? "A" :(i == 1) ? "B" :(i == 2) ? "C":"Error";
				respuesta=respuesta+maquina[i][j].getNombreProducto()+
						": $"+maquina[i][j].getPrecio()+
						" Quedan:"+maquina[i][j].getCola().size()+" Codigo:"+codigo+(j+1)
						+"\t";
			}
			respuesta=respuesta+"\n";
		}
		return respuesta;
	}
	
	public void meterMonedas(LinkedStack monedas, Cambios cambios) {
		int aux;
		double moneda;
		do {
			moneda=Double.parseDouble(String.valueOf(monedas.pop()));
			aux=((moneda==.5)?-1:(int)moneda);
			switch (aux) {
			case -1:
				if (!(cambios.getCentavo50().size()==100)) {
					cambios.getCentavo50().push(moneda);
				}
				break;
			case 1:
				if (!(cambios.getMoneda1().size()==100)) {
					cambios.getMoneda1().push(moneda);
				}
				break;
			case 2:
				if (!(cambios.getMoneda2().size()==100)) {
					cambios.getMoneda2().push(moneda);
				}
				break;
			case 5:
				if (!(cambios.getMoneda5().size()==100)) {
					cambios.getMoneda5().push(moneda);
				}
				break;
			case 10:
				if (!(cambios.getMoneda10().size()==100)) {
					cambios.getMoneda10().push(moneda);
				}
				break;
			case 20:
				if (!(cambios.getMoneda20().size()==100)) {
					cambios.getMoneda20().push(moneda);
				}
				break;
			}
		}while (monedas.size()>0);
	}
	
	public boolean soMuchCash(int indiceF,int indiceC, Productos[][] maquina, Cambios cambios) {
		double tope=((100-cambios.getCentavo50().size())*.5)+((100-cambios.getMoneda1().size())*1)+((100-cambios.getMoneda2().size())*2)+((100-cambios.getMoneda5().size())*5)+((100-cambios.getMoneda10().size())*10)+((100-cambios.getMoneda20().size())*20);
		return maquina[indiceF][indiceC].getPrecio()>tope;
	}
	
	public boolean somosPobres(int indiceF,int indiceC, Productos[][] maquina, Cambios cambios,double cartera) {
		double totalCambio=((cambios.getCentavo50().size())*.5)+((cambios.getMoneda1().size())*1)+((cambios.getMoneda2().size())*2)+((cambios.getMoneda5().size())*5)+((cambios.getMoneda10().size())*10)+((cambios.getMoneda20().size())*20);
		return (cartera-maquina[indiceF][indiceC].getPrecio())>totalCambio;
	}
	
	public String suCambio (double cartera, Productos maquina, Cambios cambio) {
		String respuesta = "";
		double restante=cartera-maquina.getPrecio(), moneda;
		double aux=restante;
		while(restante>0) {
			if(restante>=20) {
				moneda=Double.parseDouble(String.valueOf(cambio.getMoneda20().pop()));
				restante-=moneda;
				respuesta+=moneda+", ";
			}else if (restante>=10) {
				moneda=Double.parseDouble(String.valueOf(cambio.getMoneda10().pop()));
				restante-=moneda;
				respuesta+=moneda+", ";
			}else if (restante>=5) {
				moneda=Double.parseDouble(String.valueOf(cambio.getMoneda5().pop()));
				restante-=moneda;
				respuesta+=moneda+", ";
			}else if (restante>=2) {
				moneda=Double.parseDouble(String.valueOf(cambio.getMoneda2().pop()));
				restante-=moneda;
				respuesta+=moneda+", ";
			}else if (restante>=1) {
				moneda=Double.parseDouble(String.valueOf(cambio.getMoneda1().pop()));
				restante-=moneda;
				respuesta+=moneda+", ";
			}else if (restante>=.5) {
				moneda=Double.parseDouble(String.valueOf(cambio.getCentavo50().pop()));
				restante-=moneda;
				respuesta+=moneda+", ";
			}
		}
		return (respuesta+="Total: "+aux);
	}
	
	public double sumaStack(LinkedStack stack) {
	    LinkedStack aux = new LinkedStack();
	    double total = 0;
	    while (!stack.isEmpty()) {
	        double elemento = Double.parseDouble(String.valueOf(stack.pop()));
	        aux.push(elemento);
	        total += elemento;
	    }
	    while (!aux.isEmpty()) {
	        stack.push(aux.pop());
	    }
	    return total;
	}
	
	public boolean productosLlenos (Productos[][] maquina) {
		int faltantes=0;
		for (int i=0; i<maquina.length; i++) {
			for (int j=0; j<maquina[i].length; j++) {
				if(maquina[i][j].getCola().size()<20) {
					faltantes++;
				}
			}
		}
		return faltantes==0;
	}
	
	public double ganancias(Cambios cambios) {
		int ganancias = 0;
		while (cambios.getCentavo50().size()<20) {
			ganancias+=Double.parseDouble(String.valueOf(cambios.getCentavo50().pop()));
		}
		while (cambios.getMoneda1().size()<20) {
			ganancias+=Double.parseDouble(String.valueOf(cambios.getMoneda1().pop()));
		}
		while (cambios.getMoneda2().size()<20) {
			ganancias+=Double.parseDouble(String.valueOf(cambios.getMoneda2().pop()));
		}
		while (cambios.getMoneda5().size()<20) {
			ganancias+=Double.parseDouble(String.valueOf(cambios.getMoneda5().pop()));
		}
		while (cambios.getMoneda10().size()<20) {
			ganancias+=Double.parseDouble(String.valueOf(cambios.getMoneda10().pop()));
		}
		while (cambios.getMoneda20().size()<20) {
			ganancias+=Double.parseDouble(String.valueOf(cambios.getMoneda20().pop()));
		}
		return ganancias;
	}
}
