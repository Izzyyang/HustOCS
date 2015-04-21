package net.SunLnx.Comprer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import util.StringUtil;

public class ZipDecompress implements Decomprer {

	/*
	 * Decompress a zip file to one dir
	 * srcFilePath: source zip file path, desFilePath: destination dir path
	 * @see net.SunLnx.Comprer.Decomprer#decompress(java.lang.String, java.lang.String)
	 */
	@Override
	public String decompress(String srcFilePath, String desFilePath) {
		File srcFile = new File(srcFilePath);
		ZipEntry entry = null;
		String filePath = null;
		File file = null;
		FileOutputStream fos = null;
		CheckedOutputStream cos = null;
		try {
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(
					new CheckedInputStream(new FileInputStream(srcFile),
							new Adler32())));
			BufferedOutputStream bos = null;
			while ((entry = zis.getNextEntry()) != null) {
				filePath = StringUtil
						.concate("/", desFilePath, entry.getName());
				file = new File(filePath);
				bos = new BufferedOutputStream(new FileOutputStream(file));
				System.out.println(entry.getName());
				StreamUtil.write(bos, zis);
				bos.close();
			}
			zis.close();
			return desFilePath;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String agrs[]) {
		ZipDecompress zipD = new ZipDecompress();
		long duration = System.currentTimeMillis();
		zipD.decompress("D:/rmvb.zip", "D:/Video");
		duration = System.currentTimeMillis() - duration;
		System.out.println("decompress cost " + duration);
	}
}
