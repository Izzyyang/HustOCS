package net.SunLnx.Comprer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamUtil {
	private static final int BUFFER_SIZE = 1024;
	/*
	 *  read binary data from is, and write to os
	 *  and this function is not responsible for close is and os
	 */
	public static boolean write(OutputStream os, InputStream is) throws IOException {
		byte[] data = new byte[BUFFER_SIZE];
		int count = 0;
		while ((count = is.read(data,0, BUFFER_SIZE)) > 0) {
			os.write(data, 0, count);
		}
		os.flush();
		return true;
	}
}
