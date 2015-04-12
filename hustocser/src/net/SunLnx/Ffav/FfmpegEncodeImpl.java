package service;

import java.io.IOException;

import entity.AudioInfo;
import entity.AbsFfmpegOption;
import entity.ImageInfo;
import entity.InvalidOptionException;
import entity.VideoInfo;

public class FfmpegEncodeImpl implements IFfmpegEncoder {
	private static final String FFMPEG_PATH = "/usr/bin/ffmpeg";
	private IFfmpegLocater locater;
	private AbsFfmpegOption options;
	private ProcessBuilder processBuilder;
	public FfmpegEncodeImpl() {}
	public FfmpegEncodeImpl(IFfmpegLocater locater) {
		this.locater = locater;
	}
	private String toCommand(String src) {
		StringBuilder sb = new StringBuilder();
		if (this.locater != null) {
			sb.append(this.locater.toString());
		} else {
			sb.append(FFMPEG_PATH);
		}
		if (this.options != null) {
			try {
				sb.append(" -i ").append(src).append(this.options.toOptions());
				return sb.toString();
			} catch (InvalidOptionException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public boolean encode(String srcVideo, String desVideo, String desImage) {
		ImageInfo image = new ImageInfo(null, desImage);
		VideoInfo video = new VideoInfo(image, desVideo);
		this.options = video;
		this.processBuilder = new ProcessBuilder(this.toCommand(srcVideo));

		return this.run();
	}
	@Override
	public boolean encode(String srcVideo, AbsFfmpegOption options) {
		this.options = options;
		this.processBuilder = new ProcessBuilder(this.toCommand(srcVideo));
		
		return this.run();
	}
	private boolean run() {
		try {
			Process p =  this.processBuilder.start();
			p.waitFor();
			return p.exitValue() == 0;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String agrs[]) {
		IFfmpegEncoder encode = new FfmpegEncodeImpl();
		encode.encode("/home/sunlnx/mov_bbb.ogg", "/home/sunlnx/mov_bbb.flv", "/home/sunlnx/mov_bbb.png");
	}
}
