package abstractiondemo;

public class UPOffice implements PassportHeadOffice{

	@Override
	public void applyPassport() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verification() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispatch() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		UPOffice up=new UPOffice();
		up.applyPassport();
		up.verification();
		up.dispatch();
	}
}
