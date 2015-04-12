package service;
import org.joda.time.DateTime;

/*
 * 保存文件模板类
 */
public abstract class AbsFilePathGenerator {
	private static final String XG = "/";
	
	/*
	 * 生成文件本地保存目录， fn为文件名称
	 *返回文件绝对路径
	 */
	public String geneFilePath() {
		DateTime dt = new DateTime();
		int m, d, h, mi, se;
		m = dt.getMonthOfYear();
		d = dt.getDayOfMonth();
		h = dt.getHourOfDay();
		mi = dt.getMinuteOfHour();
		se = dt.getSecondOfMinute();
		StringBuffer s = new StringBuffer();
		s.append(geneTopFilePath()).append(se).append(XG).append(mi)
				.append(XG).append(h).append(XG).append(d).append(XG).append(m).append(XG);
		return s.toString();
	}

	public abstract String geneTopFilePath();
}
