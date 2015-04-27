package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encrypte implements Encrypter {
	@SuppressWarnings("finally")
	public String encrypt(Salter salt) {
		String str = salt.saltPlain();
		if (!str.equals(null)) {
			String result = null;
			try {
				StringBuffer sb = new StringBuffer(str);
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(sb.toString().getBytes());
				byte byteData[] = md.digest();
				sb = new StringBuffer();
				for (int i = 0; i < byteData.length; i++) {
					sb.append(Integer
							.toString((byteData[i] & 0xff) + 0x100, 16)
							.substring(1));
				}
				result = sb.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} finally {
				return result;
			}
		}
		return null;
	}
}
