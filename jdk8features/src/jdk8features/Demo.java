package jdk8features;

@FunctionalInterface
interface Bank{
	public float getROI(int p,float roi,int ten);

}


public class Demo //implements Bank
{

//	@Override
//	public float getROI() {
//		return 7.8f;
//	}
	public static void main(String[] args) { // lambda expressio ()
//		Demo d=new Demo();
//		System.out.println(d.getROI());
		Bank b=(p1, roi1, ten1)-> {
				float ans = p1/roi1;
				float croi= ans*ten1;
				return croi;
			};
		

		
		b.getROI(1000,5,12);
	}
}
