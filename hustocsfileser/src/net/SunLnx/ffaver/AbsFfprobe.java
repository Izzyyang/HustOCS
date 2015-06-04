package net.SunLnx.ffaver;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public  class AbsFfprobe {
	protected String outputFormat;
	protected ByteArrayOutputStream bos; 
	protected String attrisInfo;
	protected FfmpegLocater locater;

	public AbsFfprobe() {
		this.locater = DefaultFfmpegLocate.getInstance();
	}

	public AbsFfprobe(FfmpegLocater locater) {
		this.locater = locater;
	}

	public String outputFormat() {
		return this.outputFormat;
	}

	protected boolean probe(String filePath) {
		StringBuilder sb = new StringBuilder();
		sb.append(locater.getFfprobeExecutePath()).append(" -hide_banner -print_format ").append(this.outputFormat).append(" -i ").append(filePath);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String args[]) {
		AbsFfprobe probe = new AbsFfprobe();
		probe.outputFormat = "JSON";
		probe.probe("D:/Video/movie.mp4");
	}
}
