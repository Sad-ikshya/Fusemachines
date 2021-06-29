package com.fuse.junitPractice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class CubeTest {
	Calculation calculation=new Calculation();
	@Test
	public void testCube() {
		System.out.println("test case of cube");
		assertEquals(125,calculation.cube(5));
	}
}
