package com.ubs.opsit.interviews;

import static org.junit.Assert.*;

import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

public class HelperTest {

	@Test
	public void testConvertToBerlinForamtHelper() {
		assertEquals("YOOO", Helper.convertToBerlinForamtHelper("OOOO", "Y", Optional.empty(), 1));
		assertEquals("ROOO", Helper.convertToBerlinForamtHelper("OOOO", "R", Optional.empty(), 1));
		assertEquals("RROO", Helper.convertToBerlinForamtHelper("OOOO", "R", Optional.empty(), 2));
		assertEquals("YYRYYRYYRYY", Helper.convertToBerlinForamtHelper("OOOOOOOOOOO", "Y", Optional.of("R"), 11));
		assertEquals("YYRYYRYYRYO", Helper.convertToBerlinForamtHelper("OOOOOOOOOOO", "Y", Optional.of("R"), 10));
		assertEquals("YYRYYRYYROO", Helper.convertToBerlinForamtHelper("OOOOOOOOOOO", "Y", Optional.of("R"), 9));

	}

	@Test
	public void testGetTime() {

		Assert.assertArrayEquals(new String[] { "11", "05", "02" }, Helper.getTime("11:05:02"));
		Assert.assertArrayEquals(new String[] { "10", "01", "17" }, Helper.getTime("10:01:17"));
	}

	@Test
	public void testGetTopBottomTimeValues() {
		assertEquals(2, Helper.getTopBottomTimeValues(40).length);
		Assert.assertArrayEquals(new int[] { 4, 0 }, Helper.getTopBottomTimeValues(20));
		Assert.assertArrayEquals(new int[] { 3, 4 }, Helper.getTopBottomTimeValues(19));
		Assert.assertArrayEquals(new int[] { 11, 4 }, Helper.getTopBottomTimeValues(59));

	}

}
