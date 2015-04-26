package service;

public class StringUtil {
	public static String concate(String sign,String ...strs) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strs.length - 1; ++i) {
			sb.append(strs[i]).append(sign);
		}
		sb.append(strs[strs.length - 1]);
		return sb.toString();
	}
	
	public static void main(String args[]) {
		System.out.println(StringUtil.concate(",", "Welcoem", "to", "China"));
	}
}
