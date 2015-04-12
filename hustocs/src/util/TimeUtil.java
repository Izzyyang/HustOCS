package util;

import java.sql.Timestamp;
import java.util.Date;

public class TimeUtil {
	public static Timestamp getCurrTimeStamp() {
		return new Timestamp(System.currentTimeMillis());
	}
}
