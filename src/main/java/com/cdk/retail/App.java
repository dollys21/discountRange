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
    public static double amntAfterDiscount=0;

	public static void main( String[] args )
    {
    	HashMap<Range, Double> regularRangeMap = new HashMap<Range, Double>();
    	
    	Range range1 = new Range(0, 5000);
    	Range range2 = new Range(5000, 10000);
    	Range range3 = new Range(10000, 999999999);
    	
    	regularRangeMap.put(range1, 0.0);
    	regularRangeMap.put(range2, 10.0);
    	regularRangeMap.put(range3, 20.0);
    	
    	HashMap<Range, Double> premiumRangeMap = new HashMap<Range, Double>();
    	
    	Range range4 = new Range(0, 4000);
    	Range range5 = new Range(4000, 8000);
    	Range range6 = new Range(8000, 12000);
    	Range range7 = new Range(12000, 999999999);
    	
    	premiumRangeMap.put(range4, 10.0);
    	premiumRangeMap.put(range5, 15.0);
    	premiumRangeMap.put(range6, 20.0);
    	premiumRangeMap.put(range7, 30.0);
    	
    	Map<String,HashMap<Range, Double>> customerTypeMap = new HashMap<String,HashMap<Range, Double>>();
    	
    	customerTypeMap.put("Regular",regularRangeMap);
    	customerTypeMap.put("Premium",premiumRangeMap);
    	
    	
    	double totalDiscount=0;
    	
    	Scanner sc = new Scanner(System.in);
    	String customerType = sc.nextLine();
    	double purchaseAmount = sc.nextDouble(); 	
    	
    	for(Entry<String,HashMap<Range, Double>> entryCustomerType :customerTypeMap.entrySet() ){
    		if(entryCustomerType.getKey().equalsIgnoreCase(customerType)){
    			for(Entry<Range, Double> entry :entryCustomerType.getValue().entrySet() ){
    	    		if(purchaseAmount >= entry.getKey().getHigh() ){
    	    			totalDiscount = totalDiscount+  calculateDiscount(entry.getKey().getHigh(),entry.getKey().getLow(),entry.getValue());
    	    			//System.out.println("Amount after discout: "+ totalDiscount);
    	    		 }else if(purchaseAmount <= entry.getKey().getHigh() ){
    	     			totalDiscount = totalDiscount+  calculateDiscount(purchaseAmount,entry.getKey().getLow(),entry.getValue());
    	     			//System.out.println("Amount after discout: "+ totalDiscount);
    	     		 }
    	  		 
    	    	}
    		}
    	}
    	
    	amntAfterDiscount = purchaseAmount-totalDiscount;
		System.out.println("final amount after discount: " + amntAfterDiscount);
	
    }

	private static double calculateDiscount(double purchaseAmount,double low, Double discount) {
		return (((purchaseAmount - low )*discount)/100);
	}
}
