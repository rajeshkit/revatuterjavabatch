package abstractiondemo;

public class ChennaiOffice extends HeadOffcie{

	@Override
	public void verification() {
		System.out.println("Aadhar card");
	}
	public static void main(String[] args) {
		ChennaiOffice c=new ChennaiOffice();
		c.applyPassport();
		c.verification();
	}

}
