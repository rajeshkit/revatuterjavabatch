package designpatternssingleton;

public class Employee  {
	private static Employee e=null;
	private Employee() {
		
	}
	public static Employee getInstance() {
		if(e==null) {
			e=new Employee();//909090
		}
		return e;//909090
		
	}
}
