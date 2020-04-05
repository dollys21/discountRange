package com.cdk.retail;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Test;

public class AppTest {

	@Test
	public void testRegularMain() throws FileNotFoundException {
		
		String[] args =null;
	    final InputStream original = System.in;
	    final FileInputStream fips = new FileInputStream(new File("regular.txt"));
	    System.setIn(fips);
	    App.main(args);
	    System.setIn(original);
	    
		System.out.println(App.amntAfterDiscount);
		assertEquals(13500.0, App.amntAfterDiscount,0.0);
		
		
		
	}
	
	@Test
	public void testPremiumMain() throws FileNotFoundException {
		
		String[] args =null;
	    final InputStream original = System.in;
	    final FileInputStream fips = new FileInputStream(new File("premium.txt"));
	    System.setIn(fips);
	    App.main(args);
	    System.setIn(original);
	    
		System.out.println(App.amntAfterDiscount);
		assertEquals(10200.0, App.amntAfterDiscount,0.0);
		
		
		
	}

}
