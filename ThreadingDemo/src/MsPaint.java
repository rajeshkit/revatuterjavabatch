
public class MsPaint implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName()+": "+i);
			try {
				Thread.sleep(20000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException  {
		int k=10;
		MsPaint ms1=new MsPaint(); //Runnable
		Thread t1=new Thread(ms1,"Thread t1"); //t1 thread object for my mspaint
		//t1.setName("Thread t1");
		System.out.println("Thread t1: "+t1.getState());
		MsPaint ms2=new MsPaint(); // Runnable
		Thread t2=new Thread(ms2,"Thread t2"); // t2 thread object for the mspaint 
		//t2.setName("Thread t2");
		MsPaint ms3=new MsPaint(); // Runnable
		Thread t3=new Thread(ms3, "Thread t3"); // t3 thread object for the mspaint 
		//t3.setName("Thread t3");
		t1.start();
		t1.wait(20000);
		System.out.println("Thread t1: "+t1.getState());
		t2.start();
		t3.start();
		
	
	}
	

}
