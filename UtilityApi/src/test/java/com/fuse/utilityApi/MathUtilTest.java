package com.fuse.utilityApi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.fuse.utilityApi.services.MathFunctionUtility;

public class MathUtilTest {
	
	MathFunctionUtility mathFunction=new MathFunctionUtility();

	@BeforeAll
	static void setup() {
		System.out.println("Starting test for MathUtilityClass");
	}

	@Tag("Add Functionality")
	@DisplayName("Add Functionality")
	@Test
	public void testAddFunction() {
		Assertions.assertEquals(2, mathFunction.add(1, 1));
		Assertions.assertNotEquals(4, mathFunction.add(1, 1));
		Assertions.assertTrue(1<mathFunction.add(1, 1));
	}
	
	@DisplayName("Substraction Functionality")
	@Test
	public void testSubstractFunction() {
		Assertions.assertEquals(5, mathFunction.substract(10, 5));
		Assertions.assertNotEquals(6, mathFunction.substract(10, 5));
	}
	
	@DisplayName("Multipllication Functionality")
	@Test
	public void testMultiplyFunction() {
		Assertions.assertEquals(6, mathFunction.multiply(2, 3));
		Assertions.assertNotEquals(8, mathFunction.multiply(2, 3));
	}
	
	@DisplayName("Division Functionality")
	@Test
	public void testDivideFunction() {
		Assertions.assertEquals(2, mathFunction.divide(8, 4));
		Assertions.assertNotEquals(3, mathFunction.divide(8, 2));
		Assertions.assertEquals(0, mathFunction.divide(8, 0));
	}
	
	@DisplayName("Square roor Functionality")
	@Test
	public void testSquareRootFunction() {
		Assertions.assertEquals(3, mathFunction.squareRoot(9));
		Assertions.assertNotEquals(4, mathFunction.squareRoot(9));
	}
}
