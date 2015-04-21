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
import java.util.zip.Checksum;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import util.StringUtil;

public class ZipDecompress extends AbstractChecksumContainer implements Decomprer {

	public ZipDecompress() {}
	
	public ZipDecompress(Checksum checksum) {
		super.checksum = checksum;
	}
	
	/*
	 * Decompress a zip file to one dir
	 * srcFilePath: source zip file path, desFilePath: destination dir path
	 * @see net.SunLnx.Comprer.Decomprer#decompress(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean decompress(String srcFilePath, String desFilePath) {
		File srcFile = new File(srcFilePath);
		ZipEntry entry = null;
		String filePath = null;
		File file = null;
		FileOutputStream fos = null;
		CheckedInputStream cis = null;
		ZipInputStream zis = null;
		try {
			if (null != super.checksum ) {
				cis =  new CheckedInputStream(new FileInputStream(srcFile),new Adler32());
				zis = new ZipInputStream(new BufferedInputStream(cis));
			} else {
				zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(srcFile)));
			}
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
			if (null != cis) {
				super.checksumNumber = cis.getChecksum().getValue();
			}
			zis.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String agrs[]) {
		ZipDecompress zipD = new ZipDecompress(new Adler32());
		long duration = System.currentTimeMillis();
		zipD.decompress("D:/mkv.zip", "D:/Video");
		duration = System.currentTimeMillis() - duration;
		System.out.println("decompress cost " + duration +" and checksum is " + zipD.getChecksumNumber());
	}
}
