package com.ubs.opsit.interviews;

import java.util.Optional;

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
		String[] split = inputDate.split(":");
		return split;
	}
	
	static int[] getTopBottomTimeValues(int time){
		int[] topBottomTimeValues = new int[2];
		topBottomTimeValues[0] = (int) Math.floor(time / 5);
		topBottomTimeValues[1] = (int) time % 5;
		return topBottomTimeValues;
	}

}
