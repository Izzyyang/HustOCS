
package net.SunLnx.Ffav;

import java.io.IOException;
import entity.InvalidOptionException;

public class FfavEncode implements Encoder {
	private FfmpegLocater locater;
	private FfmpegOptioner optioner;
	private ProcessBuilder pb;
	
	/*
	 * 使用默认的ffmpeg和ffprobe 
	 */
	public FfavEncode() {
		locater = new DefaultFfmpegLocate();
	}
	
	/*
	 * 指定ffmpeg和ffprobe
	 */
	public FfavEncode(FfmpegLocater locater) {
		this.locater = locater;
		pb = new ProcessBuilder(this.locater.getFfmpegExecutablePath());
	}
	
	/*
	 * 指定ffmpeg的选项
	 * @see net.SunLnx.Ffav.Encoder#encode(java.lang.String, net.SunLnx.Ffav.FfmpegOptioner)
	 */
	@Override
	public boolean encode(String srcVideo, FfmpegOptioner optioner) {
		this.optioner = optioner;
		return this.start();
		
	}

	
	@Override
	public boolean encodeVideo(String srcVideo, String desVideo) {
		VideoInfo video = new VideoInfo();
		video.setOutput(desVideo);
		optioner = video;
		return start();
	}

	@Override
	public boolean encodeImage(String srcVideo, String desImage) {
		ImageInfo image = new ImageInfo();
		image.setOutput(desImage);
		optioner = image;
		return start();
	}
	
	private boolean start() {
		try {
			pb = new ProcessBuilder(locater.getFfmpegExecutablePath(), optioner.toOption());
			Process pr = pb.start();
			return pr.waitFor() == 0;
		} catch (InvalidOptionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}

}
