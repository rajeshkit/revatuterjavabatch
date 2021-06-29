package factorydesignpatterm;

public class Customer {
	public static void main(String[] args) {
		Server s = (Server)ComputerFactory.getComputerInstance("Server");
		s.showConfiguration();
		
		Laptop l = (Laptop)ComputerFactory.getComputerInstance("Laptop");
		l.showConfiguration();
		
		PC pc= (PC)ComputerFactory.getComputerInstance("PC");
		pc.showConfiguration();
	}
}
