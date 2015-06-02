package net.SunLnx.ffaver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class AbsFfprobe {
	protected String outputFormat;
	protected ByteArrayOutputStream bos; 
	protected String attrisInfo;
	protected FfmpegLocater locater;

	public AbsFfprobe() {}

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
			Process p = Runtime.getRuntime().exec(sb.toString());
			p.getOutputStream()
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

	public abstract AudioInfo getAutio();

	public abstract VideoInfo getVideo();
}
