package service;

import org.joda.time.DateTime;

public class FilePathGenerate implements IFilePathGenerator {
	private static final String XG = "/";

	@Override
	public String generateFilePath(String topPath, String filename) {
		DateTime dt = new DateTime();
		int m, d, h, mi, se;
		m = dt.getMonthOfYear();
		d = dt.getDayOfMonth();
		h = dt.getHourOfDay();
		mi = dt.getMinuteOfHour();
		se = dt.getSecondOfMinute();
		StringBuffer s = new StringBuffer();
		s.append(topPath).append(se).append(FilePathGenerate.XG).append(mi)
				.append(FilePathGenerate.XG).append(h)
				.append(FilePathGenerate.XG).append(d)
				.append(FilePathGenerate.XG).append(m)
				.append(FilePathGenerate.XG).append(filename);
		return s.toString();
	}

}
