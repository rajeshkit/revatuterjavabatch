package abstractiondemo;

public abstract class HeadOffcie {// abstract class - abstraction
									// not a 100% abstraction
	public void applyPassport() {
		System.out.println("download the form");
		System.out.println("fill the form");
		System.out.println("submit the form");
	}
	public abstract void verification();
}
