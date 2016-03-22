package com.ubs.opsit.interviews;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimeConverterToBerlinFormatTest {
	TimeConverterToBerlinFormat timeConvertor;
	String lineSeparator;

	@Before
	public void setUp() throws Exception {
		timeConvertor = new TimeConverterToBerlinFormat();
		lineSeparator = System.getProperty("line.separator");
	}

	@Test
	public void testGetHours() {
		assertEquals("RRRR" + lineSeparator + "RRRR" + lineSeparator, timeConvertor.getHours(24));
		assertEquals("RRRR" + lineSeparator + "OOOO" + lineSeparator, timeConvertor.getHours(20));
	}

	@Test
	public void testGetMinutes() {
		assertEquals("YYROOOOOOOO" + lineSeparator + "YYYY", timeConvertor.getMinutes(19));
		assertEquals("YYRYOOOOOOO" + lineSeparator + "OOOO", timeConvertor.getMinutes(20));
	}

	@Test
	public void testGetSec() {
		assertEquals("Y" + lineSeparator, timeConvertor.getSec(0));
		assertEquals("O" + lineSeparator, timeConvertor.getSec(1));
		assertEquals("Y" + lineSeparator, timeConvertor.getSec(2));
		assertEquals("O" + lineSeparator, timeConvertor.getSec(59));
	}

	@Test
	public void testConvertTime() {
		assertEquals("Y" + lineSeparator + "OOOO" + lineSeparator + "OOOO" + lineSeparator + "OOOOOOOOOOO"
				+ lineSeparator + "OOOO", timeConvertor.convertTime("00:00:00"));
		assertEquals("Y" + lineSeparator + "RRRO" + lineSeparator + "RRRR" + lineSeparator + "YYRYYRYOOOO"
				+ lineSeparator + "YOOO", timeConvertor.convertTime("19:36:00"));
	}

}
