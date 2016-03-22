package com.ubs.opsit.interviews;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeConverterToBerlinFormat implements TimeConverter {
	private static final Logger LOG = LoggerFactory.getLogger(TimeConverterToBerlinFormat.class);

	private String getHours(int hours) {
		String lineSeparator = System.getProperty("line.separator");
		int[] topBottomTime = Helper.getTopBottomTimeValues(hours);
		String fiveHoursBerlin = Helper.convertToBerlinForamtHelper("OOOO", "R", Optional.empty(), topBottomTime[0]);
		String oneHourBerlin = Helper.convertToBerlinForamtHelper("OOOO", "R", Optional.empty(), topBottomTime[1]);
		LOG.info("Calculated hours are: " + fiveHoursBerlin + " " + oneHourBerlin);
		return fiveHoursBerlin + lineSeparator + oneHourBerlin + lineSeparator;
	}

	private String getMinutes(int minutes) {
		String lineSeparator = System.getProperty("line.separator");
		int[] topBottomTime = Helper.getTopBottomTimeValues(minutes);
		String minutesBerlinTop = Helper.convertToBerlinForamtHelper("OOOOOOOOOOO", "Y", Optional.of("R"),
				topBottomTime[0]);
		String minutesBerlinBottom = Helper.convertToBerlinForamtHelper("OOOO", "Y", Optional.empty(),
				topBottomTime[1]);
		LOG.info("Calculated minutes are: " + minutesBerlinTop + " " + minutesBerlinBottom);
		return minutesBerlinTop + lineSeparator + minutesBerlinBottom;
	}

	private String getSec(int sec) {
		String lineSeparator = System.getProperty("line.separator");
		String berlinFormatSeconds = (sec % 2 == 0) ? "Y" + lineSeparator : "O" + lineSeparator;
		LOG.info("Calculated seconds are: " + berlinFormatSeconds);
		return berlinFormatSeconds;

	}

	@Override
	public String convertTime(String aTime) {
		String[] timeSplit = Helper.getTime(aTime);
		int hours = Integer.valueOf(timeSplit[0]);
		int minutes = Integer.valueOf(timeSplit[1]);
		int seconds = Integer.valueOf(timeSplit[2]);
		StringBuilder builder = new StringBuilder();
		builder.append(getSec(seconds));
		builder.append(getHours(hours));
		builder.append(getMinutes(minutes));
		return builder.toString();
	}

}
