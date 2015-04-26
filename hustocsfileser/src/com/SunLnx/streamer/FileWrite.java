package com.SunLnx.streamer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileWrite implements FileWriter {

	private static final int BUF_SIZE = 1 << 20;

	/*
	 * copy binary data from src file to des file
	 * @see com.SunLnx.streamer.FileWriter#write(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean write(String des, String src) throws IOException {
		File input = FileWrite.touch(src, false);
		File output = FileWrite.touch(des, true);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				input));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(output));
		return this.write(bos, bis);
	}

	/*
	 * read binary data from src file to outputstream
	 * @see com.SunLnx.streamer.FileWriter#write(java.io.OutputStream, java.lang.String)
	 */
	@Override
	public boolean write(OutputStream os, String src) throws IOException {
		File input = FileWrite.touch(src, false);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				input));
		return this.write(os, bis);
	}

	/*
	 * read binary data from inpustream to outputfile indicated by fn
	 * @see com.SunLnx.streamer.FileWriter#write(java.lang.String, java.io.InputStream)
	 */
	@Override
	public boolean write(String fn, InputStream is) throws IOException {
		File output = FileWrite.touch(fn, true);
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(output));
		return this.write(bos, is);
	}

	/*
	 * copy binary data from inoutstream to outputstream it's reconmended to use
	 * bufferedinputstream and bufferedoutputstream before write. this method is
	 * not responsible for close the stream
	 * 
	 * @see com.SunLnx.streamer.FileWriter#write(java.io.OutputStream,
	 * java.io.InputStream)
	 */
	@Override
	public boolean write(OutputStream os, InputStream is) throws IOException {
		byte[] data = new byte[BUF_SIZE];
		int count = 0;
		while ((count = is.read(data, 0, BUF_SIZE)) != -1) {
			os.write(data, 0, count);
		}
		os.flush();
		return true;
	}

	/*
	 * get the file instance indicated by path
	 * if file exist, return the instance soon
	 * or if not exists and cflag is true, then create a new file or directory
	 * or return null
	 */
	private static File touch(String path, boolean cflag) throws IOException {
		File file = new File(path);
		if (!file.exists()) {
			if (cflag == false) {
				return null;
			} else {
				String[] fs = path.split("/");
				if (fs[fs.length - 1].contains(".")) {
					file.createNewFile();
				} else {
					file.mkdirs();
				}
				return file;
			}
		} else {
			return file;
		}

	}

	public static void main(String agrs[]) {
		FileWrite fw = new FileWrite();
		try {
			fw.write("D:/copy.mp4", "D:/movie.mp4");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
