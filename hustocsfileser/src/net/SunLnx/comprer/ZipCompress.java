package net.SunLnx.comprer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Checksum;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompress extends AbstractChecksumContainer implements Comprer {
	
	public ZipCompress() {
		super.checksum = new Adler32();
	}
	
	public ZipCompress(Checksum checksum) {
		super.checksum = checksum;
	}
	
	/*
	 * compress files  to one zip file
	 * srcFilePath: source files's path, desFilePath:desitination zip file path
	 * and a adler32 code will be generated in the zip file
	 * @see net.SunLnx.Comprer.Comprer#compress(java.util.List, java.lang.String)
	 */
	@Override
	public boolean compress(String desFilePath, String... srcFilePaths) {
		File desFile = new File(desFilePath);
		File srcFile = null;
		BufferedInputStream bis;
		ZipOutputStream zos;
		CheckedOutputStream cos = null;
		ZipEntry entry;
		try {
			
			if (null == super.checksum) {
				zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(desFile)));
			} else {
				cos = new CheckedOutputStream(new FileOutputStream(desFile),super.checksum);
				zos = new ZipOutputStream(new BufferedOutputStream(cos));
			}
			for (String srcFilePath : srcFilePaths) {
				srcFile = new File(srcFilePath);
				bis = new BufferedInputStream(new FileInputStream(srcFile));
				entry = new ZipEntry(srcFile.getName());
				zos.putNextEntry(entry);
				StreamUtil.write(zos, bis);
				bis.close();
			}
			if (null != cos) {
				super.checksumNumber = cos.getChecksum().getValue();
			}
			zos.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	
	public static void main(String agrs[]) {
		ZipCompress zipC = new ZipCompress(new Adler32());
		long time = System.currentTimeMillis();
		zipC.compress("D:/mkv.zip", "D:/Video/mkv.mkv", "D:/Video/movie.mp4");
		time = System.currentTimeMillis() - time;
		System.out.println("cost time " + time + " check sum is" + zipC.getChecksumNumber());
	}

	

}
