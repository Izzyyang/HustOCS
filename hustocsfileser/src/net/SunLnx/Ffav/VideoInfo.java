package net.SunLnx.Ffav;

import java.io.Serializable;

import entity.InvalidOptionException;
import entity.Size;

public class VideoInfo extends AbstractFfmpegOption implements Serializable {

	/*
	 * 默认视频bitrate：
	 */
	public static final int DEFAULT_BITRATE = 1;
	/*
	 * 默认视频codec：h264
	 */
	private int bitRate;
	private String codec = "h264 ";
	private int frameRate;
	private Size size = null;
	private String output;

	public VideoInfo() {}

	public VideoInfo(AbstractFfmpegOption preOptioner) {
		this.setPreOption(preOptioner);
	}

	public VideoInfo(AbstractFfmpegOption preOption, int bitRate, String codec,
			int frameRate, int length, int width, String output) {
		this.preOptioner = preOption;
		this.bitRate = bitRate;
		this.codec = codec;
		this.frameRate = frameRate;
		this.size = new Size(length, width);
		this.output = output;
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

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String toOption() throws InvalidOptionException {
		StringBuilder sb = new StringBuilder();
		// bitrate -vb 200k
		if (this.bitRate < 0) {
			throw new InvalidOptionException("Invalid video bitrate");
		} else if (this.bitRate > 0) {
			sb.append(" -vb ").append(this.bitRate);
		}
		// framterate -vr
		if (this.frameRate < 0) {
			throw new InvalidOptionException("Invalid video framrate");
		} else if (this.frameRate > 0) {
			sb.append(" -vr ").append(this.frameRate);
		}
		// size -s 1024*768
		if (this.size != null
				&& (this.size.getLength() <= 0 || this.size.getWidth() <= 0)) {
			throw new InvalidOptionException("Invalid video size");
		} else if (this.size != null) {
			sb.append(" -s ").append(this.size.getLength()).append("*")
					.append(this.size.getWidth());
		}
		// codec -vcodec
		if (!this.codec.equals("")) {
			sb.append(" -vcodec ").append(this.codec);
		}
		if (output != null && !output.equals("")) {
			sb.append(output);
		}
		return sb.toString();
	}

	public VideoInfo clone() {
		return new VideoInfo(null, this.bitRate, this.codec, this.frameRate,
				this.size.getLength(), this.size.getWidth(), null);
	}

	public static void main(String args[]) {
		ImageInfo image = new ImageInfo();
		image.setFormat("image2");
		image.setOutput("D:/test.png");
		AudioInfo audio = new AudioInfo(image);
		VideoInfo video = new VideoInfo(audio);
		video.setSize(new Size(640, 320));
		video.setFrameRate(1);
		try {
			String option = video.toOptions();
			System.out.println(option);
		} catch (InvalidOptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
