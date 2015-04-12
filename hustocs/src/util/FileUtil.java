package util;

import java.io.File;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

public class FileUtil {
	private static final String DATEPATH = "/home/sunlnx/data/";
	public static String geneFileDiry() {
		DateTime dt = new DateTime();
		int m, d, h, mi;
		m = dt.getMonthOfYear();
		d = dt.getDayOfMonth();
		h = dt.getHourOfDay();
		mi = dt.getMinuteOfHour();
		StringBuffer s = new StringBuffer();
		s.append(DATEPATH).append(m).append("/").append(d).append("/").append(h).append("/").append(mi).append("/");
		return s.toString();
	}
	
	public List<String> cloneFiles(String path, int count) {
		List<String> uris = new ArrayList<String>();
		return null;
	}
	private String cloneFile(String path) {
		String uri = this.geneFileDiry();
		File d = new File(uri);
		if (d.mkdir()) {
			System.out.print(" create ok");
		}
		return null;
	}
	
	public static void main(String args[]) {
		System.out.println(geneFileDiry());
		new FileUtil().cloneFile("hello.txt");
	}
}
