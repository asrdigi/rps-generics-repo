package com.wipro.app;

import com.wipro.service.ISumOfSquare;
import com.wipro.service.MaxFinder;

/**
 * Lambda expression represents an instance of functional interface
 * 
 * InterfaceType objectName = (arguments) -> {implementation }
 * 
 * 
 */
public class LambdaDemo {

	public static void main(String[] args) {
		MaxFinder maxFinder = (int n1, int n2) -> {
			if(n1>n2) {
				return n1;
			}else {
				return n2;
			}
		};

		
		System.out.println(maxFinder.maxmimum(1029,1029));
		
		MaxFinder maxFinderNew = (n1,n2) -> (n1>n2)?n1:n2;
		System.out.println(maxFinderNew.maxmimum(10,15));
		
		
		ISumOfSquare iSum = (n) ->{
			long sum=0;
			for(int i=1;i<=n;i++) {
				sum = sum + i*i;
			}
			return sum;
			
		};
		
		System.out.println(iSum.sumOfSquares(10));
		
		
	}

}
