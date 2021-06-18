package Calculator;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1, num2, operator;
		System.out.println("enter 1st number:");
		num1 = input.nextInt();
		System.out.println("enter 2nd number:");
		num2 = input.nextInt();
		System.out.println("enter 1 for addition");
		System.out.println("enter 2 for substraction");
		System.out.println("enter 3 for multiplication");
		System.out.println("enter 4 for division");
		System.out.println("enter required operator:");
		operator = input.nextInt();

		Calculator c = new Calculator();
		switch (operator) {
		case 1:
			System.out.println("sum:" + c.sum(num1, num2));
			break;
		case 2:
			System.out.println("difference:" + c.subtract(num1, num2));
			break;
		case 3:
			System.out.println("product:" + c.product(num1, num2));
			break;
		case 4:
			System.out.println("diision:" + c.divide(num1, num2));
			break;
		default:
			System.out.println("please enter valid operator!!!");
			break;
		}

	}

	int sum(int a, int b) {
		return a + b;

	}

	int subtract(int a, int b) {
		return a - b;
	}

	int product(int a, int b) {
		return a * b;
	}

	double divide(double a, double b) {
		return a / b;
	}

}
