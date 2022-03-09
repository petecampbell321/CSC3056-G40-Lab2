package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class RangeTest extends TestCase {
	
	private Range rangeObjectUnderTest;
	private Range rangeContains;
	private Range rangeConstrain;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
		rangeContains = new Range(1,5);
		rangeConstrain = new Range(1,5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	// CONTAINS TESTING METHODS
	@Test
	public void testContainsInRange() {
		assertEquals("Range should contain 3 and return True", true, rangeContains.contains(3));		assertEquals("Range shouldn't contain 20 and return false", false, rangeContains.contains(20));
	}
	@Test
	public void testContainsAboveRange() {		
		assertEquals("Range shouldn't contain 20 and return false", false, rangeContains.contains(20));
	}
	@Test
	public void testContainsBelowRange() {
	assertEquals("Range shouldn't contain -5 and return false", false, rangeContains.contains(-5));
    }
	// CONSTRAIN TESTING METHODS
	@Test
	public void testConstrainInRange() {
		System.out.print("Expected: 3 Actual: " + rangeConstrain.constrain(3) + " ");
		assertEquals("Range should contain 3 and return 3", 3, rangeConstrain.constrain(3),0.000000001d);	
	}
	@Test
	public void testConstrainAboveRange() {	
		System.out.print("Expected: 5 Actual: " + rangeConstrain.constrain(20)+" ");
		assertEquals("Range shouldnt contain 20 but return clostest value in range with 5", 5, rangeConstrain.constrain(20),0.000000001d);
	}
	@Test
	public void testConstrainBelowRange() {
		System.out.print("Expected: 1 Actual: " + rangeConstrain.constrain(-20)+" ");
		assertEquals("Range shouldnt contain -20 but return clostest value in range with 1", 5, rangeConstrain.constrain(-20),0.000000001d);
	
	}

}
