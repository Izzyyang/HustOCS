package util;

import java.util.UUID;

public class UUIDUtil {
	
 	
	public static String generate32() {
		UUID uuid = UUID.randomUUID();
		String strs[] = uuid.toString().split("-");
		StringBuffer sb = new StringBuffer();
		for (int i= 0 ; i < strs.length; ++i) {
			sb.append(strs[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(new UUIDUtil().generate32());
			
	}

}
