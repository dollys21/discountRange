package com.cdk.retail.model;

public class Range 
{
    private double low;
    private double high;

    public Range(double low, double high){
        this.low = low;
        this.high = high;
    }

    public boolean contains(double number){
        return (number > low && number <= high);
    }

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}
}