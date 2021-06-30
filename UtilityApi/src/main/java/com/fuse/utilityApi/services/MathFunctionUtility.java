package com.fuse.utilityApi.services;


import org.springframework.stereotype.Service;

@Service
public class MathFunctionUtility {
	public int add(int num1, int num2) {
		return num1+num2;
	}
	public int substract(int num1, int num2) {
		return num1-num2;
	}
	public int multiply(int num1, int num2) {
		return num1*num2;
	}
	public int divide(int num1, int num2) {
		try {
		return num1/num2;
		}
		catch(ArithmeticException e){
			return 0;
		}
	}
	public double squareRoot(double num) {
		return Math.pow(num, 0.5);
	}

}
