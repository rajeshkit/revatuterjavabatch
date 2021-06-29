package factorydesignpatterm;

public class ComputerFactory {
	public static Computer getComputerInstance(String computerType) {
		Computer c=null;
		if(computerType.equals("PC")) {
			c=new PC();
		}
		if(computerType.equals("Laptop")) {
			c=new Laptop();
		}
		if(computerType.equals("Server")) {
			c=new Server();
		}
		return c;
	}
}
