package udelp.estructuras.listas.tareas;
import udelp.estructuras.listas.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class McdYCifrados {

	Random random = new Random();
	
	public static void main(String[] args) throws NumberFormatException, Exception {
		McdYCifrados movimientos=new McdYCifrados();
		movimientos.llenarADFGVX();
		Scanner leer=new Scanner(System.in);
		String mensaje = null;
		System.out.println("MCD\nEscribe el primer numero");
        int numero1 = leer.nextInt();
        System.out.println("Escribe el segundo numero");
        int numero2 = leer.nextInt();
        int mcd = movimientos.calcularMCD(numero1, numero2);
        System.out.println("El Máximo Común Divisor de " + numero1 + " y " + numero2 + " es: " + mcd);
        System.out.println("Cifrados \n Ingresa el mensaje a codificar");
        mensaje=leer.next();
        System.out.println("XOR: "+ movimientos.cifradoXOR(mensaje, movimientos.generarClaveXOR().toString()));
        movimientos.imprimirMatriz(movimientos.matrizPolibio);
        System.out.println("Polibio: " + movimientos.cifradoPolibio(mensaje).toString());
        movimientos.imprimirMatriz(movimientos.matrizADFGVX);
        System.out.println("ADFGVX: "+ movimientos.cifradoADFGVX(mensaje).toString());
    }
	
	public int calcularMCD(int numero1, int numero2) throws NumberFormatException, Exception {
		LinkedList factoresPrimos1 = calcularFactoresPrimos(numero1);
		LinkedList factoresPrimos2 = calcularFactoresPrimos(numero2);
        int i = 0, j = 0;
        int mcd = 1;
        while (i < factoresPrimos1.size() && j < factoresPrimos2.size()) {
            if (factoresPrimos1.get(i) == factoresPrimos2.get(j)) {
                mcd *= Integer.parseInt(String.valueOf(factoresPrimos1.get(i)));
                i++;
                j++;
            } else if (Integer.parseInt(String.valueOf(factoresPrimos1.get(i))) < Integer.parseInt(String.valueOf(factoresPrimos2.get(j)))) {
                i++;
            } else {
                j++;
            }
        }
        return mcd;
    }

    public LinkedList calcularFactoresPrimos(int numero) {
        int temp = numero;
        LinkedList factoresPrimos = new
        		LinkedList();
        temp = numero;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            while (temp % i == 0) {
                factoresPrimos.add(i);;
                temp /= i;
            }
        }
        if (temp > 1) {
            factoresPrimos.add(temp);;
        }
        return factoresPrimos;
    }

    public String generarClaveXOR() {
        StringBuilder claveEncriptado = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int numeroAleatorio = (int) (Math.random() * 2);
            claveEncriptado.append(numeroAleatorio);
        }
        return claveEncriptado.toString();
    }

    public LinkedList cifradoXOR(String cadena, String claveCifrado) {
        LinkedList cadenaCifrada = new LinkedList();
        byte[] cadenaBytes = cadena.getBytes();
        byte[] claveBytes = claveCifrado.getBytes();      
        for (int i = 0; i < cadenaBytes.length; i++) {
            byte xorResult = (byte) (cadenaBytes[i] ^ claveBytes[i % claveBytes.length]);
            cadenaCifrada.add(String.format("%8s", Integer.toBinaryString(xorResult & 0xFF)).replace(' ', '0'));
        }
        
        return cadenaCifrada;
    }

	public String matrizPolibio [][] = {
			{"-", "1", "2", "3", "4", "5"},
			{"1", "A", "B", "C", "D", "E"},
			{"2" , "F", "G", "H", "I,J", "K"},
			{"3" , "L", "M", "N", "O", "P"},
			{"4" , "Q", "R", "S", "T", "U"},
			{"5" , "V", "W", "X", "Y", "Z"}
	};
    
	public LinkedList cifradoPolibio(String cadena) {
        LinkedList cadenaCifrada = new LinkedList();
        cadena = cadena.toUpperCase();

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            String auxiliar = encontrarLetraEnMatriz(caracter);
            if (!auxiliar.isEmpty()) {
                cadenaCifrada.add(auxiliar);
            }
        }

        return cadenaCifrada;
    }

    private String encontrarLetraEnMatriz(char letra) {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if (matrizPolibio[i][j].contains(String.valueOf(letra))) {
                    return i + "" + j + " ";
                }
            }
        }
        return "";
    }

    public String matrizADFGVX [][] = {
			{"-", "A", "D", "F", "G", "V", "X"},
			{"A", null, null, null, null, null, null},
			{"D" , null, null, null, null, null, null},
			{"F" , null, null, null, null, null, null},
			{"G" , null, null, null, null, null, null},
			{"V" , null, null, null, null, null, null},
			{"X", null, null , null, null, null, null}
	};
    
	public void llenarADFGVX() throws Exception
	{
		char[] caracteres = caracteresAleatorios("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray());
		int auxiliar = 0;
		for (int i = 1; i < matrizADFGVX.length; i++) 
		{
			for (int j = 1; j < matrizADFGVX[0].length; j++) 
			{
				matrizADFGVX[i][j]=String.valueOf(caracteres[auxiliar]);
				auxiliar++;
			}
		} 
	}

	public LinkedList cifradoADFGVX(String palabra) throws Exception
	{	
		LinkedList cadenaCifrada = new LinkedList();

		for (int i = 0; i < palabra.length(); i++) 
		{
			for (int j = 1; j < matrizADFGVX.length; j++) 
			{
				for (int k = 1; k < matrizADFGVX[0].length; k++) 
				{
					if(matrizADFGVX [j][k].equalsIgnoreCase(String.valueOf(palabra.charAt(i))))
					{
						cadenaCifrada.add(String.valueOf(matrizADFGVX [j][0])+String.valueOf(matrizADFGVX [0][k]));
						j=7;
						break;
					}
				}
			}
		}

		return cadenaCifrada;
	}

	public static char[] caracteresAleatorios(char[] abecedario) throws Exception
	{
		Random random = new Random();
		for (int i = abecedario.length - 1; i > 0; i--) 
		{
			int index = random.nextInt(i + 1);
			if (index != 36) 
			{
				char letra = abecedario[index];
				abecedario[index] = abecedario[i];
				abecedario[i] = letra;
			}
			else 
			{
				i++;
			}
		}
		return abecedario;

	}
	
	public void imprimirMatriz (String[][] matrizPolibio2) {
		for (int i=0; i<matrizPolibio2.length; i++) {
			for (int j=0; j<matrizPolibio2[i].length; j++) {
				System.out.print(matrizPolibio2[i][j]+" ");
			}
			System.out.println();
		}
	}
    
	
}
