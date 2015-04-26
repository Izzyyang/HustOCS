package net.SunLnx.Ffaver;

import java.io.IOException;

public class FfavEncode implements Encoder {
	private FfmpegLocater locater;
	private String options;
	private ProcessBuilder pb;

	/*
	 * 使用默认的ffmpeg和ffprobe
	 */
	public FfavEncode() {
		locater = DefaultFfmpegLocate.getInstance();
	}

	/*
	 * 使用指定的ffmpeg和ffprobe
	 */
	public FfavEncode(FfmpegLocater locater) {
		this.locater = locater;
	}

	/*
	 * 获取一次ffmpeg的全命令
	 */
	public String toCommand() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.locater.getFfmpegExecutablePath()).append(this.options);
		return sb.toString();
	}

	/*
	 * 生成选项
	 */
	private String toOptions(String srcVideo, AbstractFfmpegOption outputOption) {
		StringBuffer sb = new StringBuffer();
		InputInfo inputOption = new InputInfo(null, srcVideo);
		try {
			sb.append(inputOption.toOptions()).append(outputOption.toOptions());
			return sb.toString();
		} catch (InvalidOptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 指定ffmpeg的选项
	 * 
	 * @see net.SunLnx.Ffav.Encoder#encode(java.lang.String,
	 * net.SunLnx.Ffav.FfmpegOptioner)
	 */
	@Override
	public boolean encode(String srcVideo, AbstractFfmpegOption outputOption) {
		this.options = toOptions(srcVideo, outputOption);
		return this.start();

	}

	/*
	 * 转码单个视频，默认为flv格式
	 * 
	 * @see net.SunLnx.Ffav.Encoder#encodeVideo(java.lang.String,
	 * java.lang.String) srcVideo:视频源文件,desVideo:转码目的文件
	 */
	@Override
	public boolean encodeVideo(String srcVideo, String desVideo) {
		VideoInfo video = new VideoInfo(null, desVideo);
		this.options = toOptions(srcVideo, video);
		return start();
	}

	/*
	 * 获取视频截图，默认为1张jpg图片
	 * 
	 * @see net.SunLnx.Ffav.Encoder#encodeImage(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean encodeImage(String srcVideo, String desImage) {
		ImageInfo image = new ImageInfo(null, desImage);
		this.options = toOptions(srcVideo, image);
		return start();
	}

	/*
	 * 开始转码
	 */
	private boolean start() {
		try {
			if ("".equals(this.toCommand()) || null == this.toCommand()) {
				return false;
			}			
			System.out.println(this.toCommand());
			Process pr = Runtime.getRuntime().exec(this.toCommand());
			pr.waitFor();
			return pr.exitValue() == 0;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}

}
