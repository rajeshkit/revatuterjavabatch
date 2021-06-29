package com.hdfc.easypay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class UPITest {
	static UPI upi=null;
	@AfterClass
	public static void tearDown() {
		upi=null;
		System.out.println("After Class annotated method");
	}
	@BeforeClass
	public static void setUp() {
		upi=new UPI();
		System.out.println("Before Class annotated method");
	}
	@Before
	public void before() {
		
		System.out.println("Before Annotation Method");
	}
	@After
	public void after() {
		System.out.println("After Annotation Method");
		// clean up resources that we created before test cases 
	
	}
	@Test
	public void testAddPositiveNos() {
		//assertEquals(expected,actual)
		System.out.println("testAddPositiveNos");
		assertEquals(68, upi.add(23, 45));
		//assertion
		// methods - assert method
	}

	@Test
	public void testAddNegativeNos() {
		//assertEquals(expected,actual)
		System.out.println("testAddNegativeNos");
		assertEquals(-56, upi.add(-34, -22));
		
		//assertion
		// methods - assert method
	}
	
	@Test(timeout = 2000)
	public void testCalcaulateInterest() {
		assertEquals(2400, upi.calcaulateInterest(1000, 5, 12));
		
	}
	@Test
	public void testDivide() {
		assertEquals(100, upi.divison(1000, 10));	
	}
	@Test(expected = ArithmeticException.class)
	public void testDivideException() {
		assertEquals(100, upi.divison(1000, 0));	
	
	}
	
}
