
public class WinWord extends Thread {
	public WinWord() {
		super();
	}
	@Override
	public void run() {
		
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName()+": "+i);
		
			
		}
	}
	public static void main(String[] args) {
		WinWord ww1=new WinWord();// one thread
		ww1.setName("Thread One ");
		System.out.println("Thread id: "+ww1.getId());
		System.out.println("Thread Name: "+ww1.getName());
		System.out.println("Thread One priority: "+ww1.getPriority());
		ww1.setPriority(1);// 1 to 10
		System.out.println("Thread One priority: "+ww1.getPriority());
		System.out.println("state: "+ww1.getState());
		System.out.println(ww1.isDaemon());
		ww1.setDaemon(true);
		System.out.println(ww1.isDaemon());
		System.out.println("is Alive: "+ww1.isAlive());
		WinWord ww2=new WinWord();// two thread
		ww2.setName("Thread two");
	
		WinWord ww3=new WinWord();// third thread
		ww3.setName("Thread Three");
		ww1.start();// run will be called
		System.out.println("is Alive: "+ww1.isAlive());
		System.out.println("state: "+ww1.getState());
		ww2.start();// run will be called
		ww3.start();// run will be called
	}
	
}
