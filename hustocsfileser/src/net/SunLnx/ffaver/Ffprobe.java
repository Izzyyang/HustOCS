package net.SunLnx.ffaver;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public  class Ffprobe {
	protected ByteArrayOutputStream bos; 
	protected String attrisInfo;
	protected FfmpegLocater locater;

	public Ffprobe() {
		this.locater = DefaultFfmpegLocate.getInstance();
	}

	public Ffprobe(FfmpegLocater locater) {
		this.locater = locater;
	}

	protected boolean probe(String filePath, String format) {
		StringBuilder sb = new StringBuilder();
		sb.append(locater.getFfprobeExecutePath()).append(" -hide_banner -print_format ").append(format).append(" -i ").append(filePath);
		try {
			System.out.println(sb.toString());
			Process p = Runtime.getRuntime().exec(sb.toString());
			p.getOutputStream().close();
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			sb.delete(0, sb.length());
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				sb.append(currentLine);
			}
			System.out.println(sb.toString());
			p.waitFor();
			return p.exitValue() == 0;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String args[]) {
		Ffprobe probe = new Ffprobe();
		probe.probe("D:/Video/movie.mp4", "JSON");
	}
}
