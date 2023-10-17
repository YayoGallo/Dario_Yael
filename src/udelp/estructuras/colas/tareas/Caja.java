package udelp.estructuras.colas.tareas;
import udelp.estructuras.colas.BooleanPriorityQueue;
import udelp.estructuras.nodos.LinkedStack;
public class Caja extends Thread {
	private Persona persona, ultimoBeneficiario;
    private boolean ocupada;
    private Billetes caja = new Billetes();
    private BooleanPriorityQueue ingresos;

    public Caja(BooleanPriorityQueue cola) {
        this.ingresos = cola;
    }

    public void run() {
        while (true) {
            try {
                if (!ingresos.isEmpty()) {
                    atenderCliente();
                }
                Thread.sleep((int) (1 + Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void atenderCliente() {
        if (!ingresos.isEmpty()) {
            ocupada = true;
            persona = (Persona) ingresos.dequeue();
            ultimoBeneficiario = persona;
            if (persona.getTarea() == 0) {
                deposito(persona.getCartera());
            } else {
                rellenarCaja();
                retiro(persona.getMonto());
            }
            ocupada = false;
        }
    }

		public Billetes getCajaExpendedora() {
			return this.caja;
		}
		public Persona getPersona() {
			return this.persona;
		}
		public boolean getEstado() {
			return this.ocupada;
		}
		public void deposito(LinkedStack cartera) {
			int aux;
			double moneda;
			do {
				moneda=Double.parseDouble(String.valueOf(cartera.pop()));
				aux=(int)moneda;
				switch (aux) {
				case 1:
					if (!(caja.getMoneda1().size()==200)) {
						caja.getMoneda1().push(moneda);
					}
					break;
				case 5:
					if (!(caja.getMoneda5().size()==200)) {
						caja.getMoneda5().push(moneda);
					}
					break;
				case 10:
					if (!(caja.getMoneda10().size()==200)) {
						caja.getMoneda10().push(moneda);
					}
					break;
				case 20:
					if (!(caja.getBillete20().size()==200)) {
						caja.getBillete20().push(moneda);
					}
					break;
				case 50:
					if (!(caja.getBillete50().size()==200)) {
						caja.getBillete50().push(moneda);
					}
					break;
				case 100:
					if (!(caja.getBillete100().size()==200)) {
						caja.getBillete100().push(moneda);
					}
					break;
				case 200:
					if (!(caja.getBillete200().size()==200)) {
						caja.getBillete200().push(moneda);
					}
					break;
				case 500:
					if (!(caja.getBillete500().size()==200)) {
						caja.getBillete500().push(moneda);
					}
					break;
				case 1000:
					if (!(caja.getBillete1000().size()==200)) {
						caja.getBillete1000().push(moneda);
					}
					break;
				}
			}while (cartera.size()>0);	
		}
		public void retiro (double cartera) {
			double restante=cartera, moneda;
			while(restante>0) {
				if(restante>=1000) {
					moneda=Double.parseDouble(String.valueOf(caja.getBillete1000().pop()));
					restante-=moneda;
				}else if (restante>=500) {
					moneda=Double.parseDouble(String.valueOf(caja.getBillete500().pop()));
					restante-=moneda;
				}else if (restante>=10) {
					moneda=Double.parseDouble(String.valueOf(caja.getBillete200().pop()));
					restante-=moneda;
				}else if (restante>=10) {
					moneda=Double.parseDouble(String.valueOf(caja.getBillete100().pop()));
					restante-=moneda;
				}else if (restante>=10) {
					moneda=Double.parseDouble(String.valueOf(caja.getBillete50().pop()));
					restante-=moneda;
				}else if (restante>=10) {
					moneda=Double.parseDouble(String.valueOf(caja.getBillete20().pop()));
					restante-=moneda;
				}else if (restante>=10) {
					moneda=Double.parseDouble(String.valueOf(caja.getMoneda10().pop()));
					restante-=moneda;
				}else if (restante>=5) {
					moneda=Double.parseDouble(String.valueOf(caja.getMoneda5().pop()));
					restante-=moneda;
				}else if (restante>=2) {
					moneda=Double.parseDouble(String.valueOf(caja.getMoneda2().pop()));
					restante-=moneda;
				}else if (restante>=1) {
					moneda=Double.parseDouble(String.valueOf(caja.getMoneda1().pop()));
					restante-=moneda;
				}
			}
		}
		public void rellenarCaja() {
			if(caja.getMoneda1().size()<=20) {
				for(int i = 0; i < 50; i++) {
					caja.getMoneda1().push(1);
				}	
			}else if(caja.getMoneda5().size()<=10) {
				for(int i = 0; i < 50; i++) {
					caja.getMoneda5().push(5);
				}
			}else if(caja.getMoneda10().size()<=10) {
				for(int i = 0; i < 50; i++) {
					caja.getMoneda10().push(10);
				}
			}else if(caja.getBillete20().size()<=10) {
				for(int i = 0; i < 50; i++) {
					caja.getBillete20().push(20);
				}
			}else if(caja.getBillete50().size()<=10) {
				for(int i = 0; i < 50; i++) {
					caja.getBillete50().push(50);
				}
			}else if(caja.getBillete100().size()<=10) {
				for(int i = 0; i < 50; i++) {
					caja.getBillete100().push(100);
				}
			}else if(caja.getBillete200().size()<=10) {
				for(int i = 0; i < 50; i++) {
					caja.getBillete200().push(200);
				}
			}else if(caja.getBillete500().size()<=10) {
				for(int i = 0; i < 50; i++) {
					caja.getBillete500().push(500);
				}
			}else if(caja.getBillete1000().size()<=10) {
				for(int i = 0; i < 50; i++) {
					caja.getBillete1000().push(1000);
				}
			}
		}
		public String estatus() {
		    String s = "Caja ";
		    if (ultimoBeneficiario != null) {
		        s += "Último beneficiario atendido:\n";
		        s += "Cuenta: " + ultimoBeneficiario.getCuenta() + "\n";
		        s += "Accion: " + (ultimoBeneficiario.getTarea() == 0 ? "Deposito" : "Retiro") + "\n";
		    }
		    s += "Dinero en caja:\n";
		    s += "Billetes/Monedas de $1: " + caja.getMoneda1().size() + "\n";
		    s += "Monedas de $5: " + caja.getMoneda5().size() + "\n";
		    s += "Monedas de $10: " + caja.getMoneda10().size() + "\n";
		    s += "Billetes de $20: " + caja.getBillete20().size() + "\n";
		    s += "Billetes de $50: " + caja.getBillete50().size() + "\n";
		    s += "Billetes de $100: " + caja.getBillete100().size() + "\n";
		    s += "Billetes de $200: " + caja.getBillete200().size() + "\n";
		    s += "Billetes de $500: " + caja.getBillete500().size() + "\n";
		    s += "Billetes de $1000: " + caja.getBillete1000().size() + "\n";

		    return s;
		}


	}

