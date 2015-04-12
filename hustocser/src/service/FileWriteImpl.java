package service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileWriteImpl  implements IFileWriter {
	
	private static final int BUF_SIZE = 1 << 20;
	@Override
	public boolean write(InputStream is, String fp) {
		System.out.println("write a file");
		File f = new File(fp);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				return false;
			}
		}
		BufferedInputStream bis = new BufferedInputStream(is);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			byte[] buf = new byte[BUF_SIZE];
			int c;
			try {
				while ((c = bis.read(buf)) > 0) {
					bos.write(buf, 0, c);
				}
				bos.flush();
				bis.close();
				bos.close();
				fos.close();
				return true;
			} catch (IOException e) {
			}
		} catch (FileNotFoundException e) {
			return false;
		}
		return false;
	}
	

	public static void main(String args[]) throws FileNotFoundException {
		FileWriteImpl fw = new FileWriteImpl();
		File f = new File("/home/sunlnx/Videos/How fast.ogg");
		fw.write(new FileInputStream(f), "/home/sunlnx/How fast.ogg");
	}
}
