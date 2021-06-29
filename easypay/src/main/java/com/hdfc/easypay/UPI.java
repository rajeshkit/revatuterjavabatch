package com.hdfc.easypay;

import org.apache.log4j.Logger;

public class UPI {
	private static final Logger log=Logger.getLogger(UPI.class);
	public boolean isEnabled() {
		log.info("is enable method is called");
		return true;
		
		
	}
	public int add(int no1, int no2) {
		log.warn("parameter value must be a integers");
		log.info("add method started");
		return no1 + no2;// 68
	}
	public int divison(int no1, int no2) throws ArithmeticException {
		log.warn("parameter value must be a integers");
		log.info("divison method started");
		log.error("no2 must not be zero");
		return no1 / no2;// 68
	}


	public long calcaulateInterest(int principal, float roi, int tenure) {
		long cacluatedRoi=0;
			log.debug("roi is very imported");
			cacluatedRoi = (long) (principal / roi * tenure);
		
		return cacluatedRoi;// 2400
	}
	public static void main(String[] args) {
		UPI upi=new UPI();
		upi.add(34, 35);
		upi.calcaulateInterest(1000, 5, 12);
		upi.isEnabled();
		upi.divison(45, 5);
	}
}
