package com.ubs.opsit.interviews;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
	static String convertToBerlinForamtHelper(String prefix, String suffux, Optional<String> minutesTop, int limit) {
		StringBuilder toBerlinFormat = new StringBuilder(prefix);
		for (int i = 0; i < limit; i++) {
			toBerlinFormat = minutesTop.isPresent() && ((i + 1) % 3 == 0)
					? toBerlinFormat.replace(i, i + 1, minutesTop.get()) : toBerlinFormat.replace(i, i + 1, suffux);
		}
		return toBerlinFormat.toString();
	}

	static String[] getTime(String inputDate) {
		validateInputDate(inputDate);
		String[] split = inputDate.split(":");
		return split;
	}

	private static void validateInputDate(String inputDate) {
		final Pattern pattern = Pattern.compile("^([0-1]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$");
		final Matcher matcher = pattern.matcher(inputDate);
		if (!matcher.find()) {
			throw new IllegalArgumentException("Incorrect input date, please input in a format hh:mm:ss");
		}
	}

	static int[] getTopBottomTimeValues(int time) {
		int[] topBottomTimeValues = new int[2];
		topBottomTimeValues[0] = (int) Math.floor(time / 5);
		topBottomTimeValues[1] = (int) time % 5;
		return topBottomTimeValues;
	}

}
