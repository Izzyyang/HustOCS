package net.SunLnx.Ffav;

import entity.InvalidOptionException;
import entity.Size;

public class ImageInfo implements FfmpegOptioner {
	/*
	 * 默认图片截取起始时间:0
	 */
	public static final int DEFAULT_START_TIME = 0;

	/*
	 * 默认图片内的帧持续时间：1s
	 */
	public static final int DEFAULT_DURATION = 1;

	/*
	 * 默认图片对应的视频的帧数目：1
	 */
	public static final int DEFAULT_FRAME = 1;

	/*
	 * 默认图片尺寸：64x64
	 */
	public static final Size DEFAULT_SIZE = new Size(64, 64);

	/*
	 * 默认图片格式：image2
	 */
	public static final String DEFAULT_FORMAT = "image2";

	private int starttime;
	private int duration;
	private int frame;
	private Size size;
	private String format;
	private String output;
	private FfmpegOptioner superOption;

	public ImageInfo() {}

	/*
	 * 设置图片输出前的选项
	 */
	public ImageInfo(FfmpegOptioner superOption) {
		this.superOption = superOption;
	}

	public int getStarttime() {
		return starttime;
	}

	public void setStarttime(int starttime) {
		this.starttime = starttime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public FfmpegOptioner getSuperOption() {
		return superOption;
	}

	public void setSuperOption(FfmpegOptioner superOption) {
		this.superOption = superOption;
	}

	public ImageInfo clone() {
		ImageInfo image = new ImageInfo();
		image.setDuration(this.duration);
		image.setFormat(this.format);
		image.setFrame(this.frame);
		image.setSize(this.size);
		image.setStarttime(this.starttime);
		return image;
	}

	public String toOption() throws InvalidOptionException {
		StringBuilder sb = new StringBuilder();
		if (this.superOption != null) {
			sb.append(this.superOption.toOption());
		}
		// starttime -ss
		if (this.starttime < 0) {
			throw new InvalidOptionException("Invalid image starttime");
		}
		sb.append(" -ss ").append(this.starttime);

		// duration -t
		if (this.duration < 0) {
			throw new InvalidOptionException("Invalid image duration");
		}
		sb.append(" -t ").append(this.duration);
		// frame -r
		if (this.frame < 0) {
			throw new InvalidOptionException("Invaid image frame");
		}
		sb.append(" -r ").append(this.frame);
		// size -s eg.1024*768
		if (this.size != null
				&& (this.size.getLength() <= 0 || this.size.getWidth() <= 0)) {
			throw new InvalidOptionException("Invalid image size");
		} else if (this.size != null) {
			sb.append(" -s ").append(this.size.getLength()).append("*")
					.append(this.size.getWidth());
		}
		// format
		if (this.format != null && !this.format.equals("")) {
			sb.append(" -f ").append(this.format);
		} else {
			throw new InvalidOptionException("Invalid image format");
		}

		if (this.output != null && !this.output.equals("")) {
			sb.append(" ").append(this.output);
		} else {
			throw new InvalidOptionException(
					"Invalid output file path and name");
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		ImageInfo image = new ImageInfo();
		image.setFormat("image2");
		image.setOutput("D:/test.jif");
		try {
			System.out.println(image.toOption());
		} catch (InvalidOptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
