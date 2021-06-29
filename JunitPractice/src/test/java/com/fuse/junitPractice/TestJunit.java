package com.fuse.junitPractice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJunit {
	String message="Hello world";
	MessageUtil messageUtil=new MessageUtil(message);
	@Test
	public void testPrintMessage() {
		assertEquals(message, messageUtil.printMessage());
	}

}
