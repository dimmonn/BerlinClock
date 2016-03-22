package com.ubs.opsit.interviews;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeConverterToBerlinFormat implements TimeConverter {
	private static final Logger LOG = LoggerFactory.getLogger(TimeConverterToBerlinFormat.class);

	private String getHours(int hours) {
		int[] topBottomTime = Helper.getTopBottomTimeValues(hours);
		String fiveHoursBerlin = Helper.convertToBerlinForamtHelper("OOOO", "R", Optional.empty(), topBottomTime[0]);
		String oneHourBerlin = Helper.convertToBerlinForamtHelper("OOOO", "R", Optional.empty(), topBottomTime[1]);
		LOG.info("Calculated hours are: " + fiveHoursBerlin + " " + oneHourBerlin);
		return fiveHoursBerlin + "\r\n" + oneHourBerlin + "\r\n";
	}

	private String getMinutes(int minutes) {
		int[] topBottomTime = Helper.getTopBottomTimeValues(minutes);
		String minutesBerlinTop = Helper.convertToBerlinForamtHelper("OOOOOOOOOOO", "Y", Optional.of("R"),
				topBottomTime[0]);
		String minutesBerlinBottom = Helper.convertToBerlinForamtHelper("OOOO", "Y", Optional.empty(),
				topBottomTime[1]);
		LOG.info("Calculated minutes are: " + minutesBerlinTop + " " + minutesBerlinBottom.replace("\r\n", ""));
		return minutesBerlinTop + "\r\n" + minutesBerlinBottom;
	}

	private String getSec(int sec) {
		String berlinFormatSeconds = (sec % 2 == 0) ? "Y\r\n" : "O\r\n";
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
