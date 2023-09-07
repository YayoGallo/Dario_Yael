package udelp.estructuras.pilas.tarea;

import udelp.estructuras.nodos.LinkedStack;

public class PolancaInversa {
	public String convertirANPI (String ecuacion) {
		String respuesta = "", aux="";
        LinkedStack stack = new LinkedStack();

        for (int i=0; i<ecuacion.length();i++) {
            if (ecuacion.charAt(i)>='0'&& ecuacion.charAt(i)<='9') {
                aux += ecuacion.charAt(i);
            }else {
            	if (aux.length() > 0) {
                    respuesta += aux + " "; 
                    aux=""; 
                }
	            if (ecuacion.charAt(i) == '(') {
	                stack.push(ecuacion.charAt(i));
	            } else if (ecuacion.charAt(i) == ')') {
	                while (!stack.isEmpty() && (char) stack.peak() != '(') {
	                    respuesta += stack.pop()+" ";
	                }
	                stack.pop(); 
	            } else {
	                while (!stack.isEmpty() && ordenOperadores(ecuacion.charAt(i)) <= ordenOperadores((char) stack.peak())) {
	                    respuesta += stack.pop()+" ";
	                }
	                stack.push(ecuacion.charAt(i));
	            }
            }
        }

        while (!stack.isEmpty()) {
            respuesta += stack.pop()+" ";
        }

        return respuesta;
    }
	private static int ordenOperadores(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }
	
	public double resultadoPolaca (String ecuacion) {
        LinkedStack stack = new LinkedStack();
        String aux="";
        double a,b,resultado;
        for (int i=0; i<ecuacion.length();i++) {
        	if (ecuacion.charAt(i)>='0'&& ecuacion.charAt(i)<='9') {
                aux += ecuacion.charAt(i);
            }else {
            	if (aux.length() > 0) {
                    stack.push(aux); 
                    aux=""; 
                }
            	if (ecuacion.charAt(i)=='+') {
	                b = Double.parseDouble(String.valueOf(stack.pop()));
	                a = Double.parseDouble(String.valueOf(stack.pop()));
	                resultado = a+b;
	                stack.push(resultado);
            	}else if(ecuacion.charAt(i)=='-'){
            		b = Double.parseDouble(String.valueOf(stack.pop()));
	                a = Double.parseDouble(String.valueOf(stack.pop()));
	                resultado = a-b;
	                stack.push(resultado);
            	}else if(ecuacion.charAt(i)=='*'){
            		b = Double.parseDouble(String.valueOf(stack.pop()));
	                a = Double.parseDouble(String.valueOf(stack.pop()));
	                resultado = a*b;
	                stack.push(resultado);
            	}else if(ecuacion.charAt(i)=='/'){
            		b = Double.parseDouble(String.valueOf(stack.pop()));
	                a = Double.parseDouble(String.valueOf(stack.pop()));
	                resultado = a/b;
	                stack.push(resultado);
            	}
            }
        }

        return (double) stack.pop();
    }
	
	
	
    public static void main(String[] args) {
    	PolancaInversa movimientos=new PolancaInversa();
        String ecuacion = "((7+6+8)*(5+7/2)+36/6)";
        String notacionPolaca = movimientos.convertirANPI(ecuacion);
        System.out.println("Expresión en notación infija: " + ecuacion);
        System.out.println("Expresión en notación polaca inversa: " + notacionPolaca);
        System.out.println("Resultado: " + movimientos.resultadoPolaca(notacionPolaca));
    }
}
