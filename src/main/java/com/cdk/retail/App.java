package com.cdk.retail;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.cdk.retail.model.Range;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Map<Range, Double> rangeMap = new HashMap<Range, Double>();
    	
    	Range range1 = new Range(0, 5000);
    	Range range2 = new Range(5000, 10000);
    	Range range3	 = new Range(10000, 999999999);
    	
    	rangeMap.put(range1, 0.0);
    	rangeMap.put(range2, 10.0);
    	rangeMap.put(range3, 20.0);
    	
    	Scanner sc = new Scanner(System.in);
    	double purchaseAmount = sc.nextDouble();
    	
    	for(Entry<Range, Double> entry :rangeMap.entrySet() ){
    		 //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
    		 
    		 if(entry.getKey().contains(purchaseAmount)){
    			System.out.println("Amount after discout: "+ calculateDiscount(purchaseAmount,entry.getKey().getLow(),entry.getValue()));
    		 }
    		 
    	}
	
    }

	private static double calculateDiscount(double purchaseAmount,double low, Double discount) {
		return purchaseAmount - (((purchaseAmount - low )*discount)/100);
	}
}
