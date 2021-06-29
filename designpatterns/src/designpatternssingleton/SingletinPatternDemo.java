package designpatternssingleton;

public class SingletinPatternDemo {
	public static void main(String[] args) {
//		Employee e1=new Employee();
//		Employee e2=new Employee();
//		Employee e3=new Employee();
		
		// how to create object for the employee class
		Employee e1 = Employee.getInstance();//909090
		System.out.println(e1.hashCode());//653305407
		Employee e2 = Employee.getInstance();//909090
		System.out.println(e2.hashCode());//909090
		//653305407
		Employee e3 = Employee.getInstance();//909090
		System.out.println(e3.hashCode());//909090
		
	}
}
