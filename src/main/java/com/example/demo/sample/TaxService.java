package com.example.demo.sample;

public class TaxService {
	
	
	 public double getTaxCalcResult(int priceWithoutTax) {

	        // 税込計算
	        double taxCalcResult = priceWithoutTax + getTax(priceWithoutTax);

	        return taxCalcResult;
	    }
	 
	 
	 public double getTax(int priceWithoutTax) {

	       double tax = priceWithoutTax * 0.2 ;

	        return tax;
	    }
}
