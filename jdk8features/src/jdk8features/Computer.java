package jdk8features;
@FunctionalInterface
public interface Computer {
	public void createComputer();
	default public void show() {// instance function inside interface
		System.out.println("show method");
	}
	public static void display() { // static function inside interface
		System.out.println("display method");
	}
}
