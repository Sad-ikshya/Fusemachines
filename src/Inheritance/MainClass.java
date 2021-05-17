package Inheritance;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Student s;
		int id, age;
		String name, address;
		double grade;
		Scanner input = new Scanner(System.in);

		String graduation;
		System.out.println("Enter whether Student is graduated or not:");
		System.out.println("Please enter yes or no");
		graduation = input.next();

		System.out.println("Enter id:");
		id = input.nextInt();
		System.out.println("Enter Name:");
		name = input.next();
		System.out.println("Enter Address:");
		address = input.next();
		System.out.println("Enter Age:");
		age = input.nextInt();
		System.out.println("Enter Grade:");
		grade = input.nextDouble();

		switch (graduation.toLowerCase()) {
		case "yes":
			s = new Graduate(id, name, address, age, grade);
			if (s.isPassed(s.getGrade()))
				System.out.println("Pass");
			else
				System.out.println("Fail");
			break;
		case "no":
			s = new UnderGraduate(id, name, address, age, grade);
			if (s.isPassed(s.getGrade()))
				System.out.println("Pass");
			else
				System.out.println("Fail");
			break;
		default:
			System.out.println("Please enter yes or no");

		}

	}
}
