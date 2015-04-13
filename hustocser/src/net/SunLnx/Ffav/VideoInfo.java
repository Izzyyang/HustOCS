
package net.SunLnx.Ffav;

import entity.InvalidOptionException;
import entity.Size;


public class VideoInfo implements FfmpegOptioner{
	
	/*
	 * 默认视频bitrate：
	 */
	/*
	 * 默认视频codec：h264
	 */
	private int bitRate;
	private Size size = null;
	private String codec = "h264 ";
	private int frameRate;
	private FfmpegOptioner superOption;
	private String output;
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public void setSuperOption(FfmpegOptioner superOption) {
		this.superOption = superOption;
	}
	public VideoInfo() {
		
	}
	public VideoInfo(FfmpegOptioner superOption) {
		this.superOption = superOption;
	}

	public int getBitRate() {
		return bitRate;
	}
	public void setBitRate(int bitRate) {
		this.bitRate = bitRate;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public String getCodec() {
		return codec;
	}
	public void setCodec(String codec) {
		this.codec = codec;
	}
	public int getFrameRate() {
		return frameRate;
	}
	public void setFrameRate(int frameRate) {
		this.frameRate = frameRate;
	}
	public VideoInfo clone() {
		VideoInfo video = new VideoInfo();
		video.setBitRate(this.bitRate);
		video.setCodec(this.codec);
		video.setFrameRate(this.frameRate);
		video.setSize(this.size);
		video.setSuperOption(this.superOption);
		return video;
	}

	public String toOption()  throws InvalidOptionException{
		StringBuilder sb = new StringBuilder();
		if (this.superOption != null) {
			sb.append(this.superOption.toOption());

		}
		//bitrate		-vb		200k
		if (this.bitRate < 0) {
			throw new InvalidOptionException("Invalid video bitrate");
		} else if(this.bitRate > 0) {
			sb.append(" -vb ").append(this.bitRate);
		}
		//framterate		-vr
		if (this.frameRate < 0) {
			throw new InvalidOptionException("Invalid video framrate");
		} else if (this.frameRate > 0) {
			sb.append(" -vr ").append(this.frameRate);
		}
		//size		-s			1024*768
		if (this.size != null && (this.size.getLength() <= 0 || this.size.getWidth()<= 0)) {
			throw new InvalidOptionException("Invalid video size");
		} else if(this.size != null) {
			sb.append(" -s ").append(this.size.getLength()).append("*").append(this.size.getWidth());
		}
		//codec		-vcodec
		if (!this.codec.equals("")) {
			sb.append(" -vcodec ").append(this.codec);
		}
		if (output != null && !output.equals("")) {
			sb.append(output);
		}
		return sb.toString();
	}
	
	
	public static void main(String args[]) {
		ImageInfo image = new ImageInfo();
		AudioInfo audio = new AudioInfo(image);
		VideoInfo video = new VideoInfo(audio);
		video.setSize(new Size(640, 320));
		video.setFrameRate(1);
		try {
			String option = video.toOption();
			System.out.println(option);
		} catch (InvalidOptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
