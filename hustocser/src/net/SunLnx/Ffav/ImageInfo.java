<<<<<<< HEAD
package net.SunLnx.Ffav;

import entity.InvalidOptionException;
import entity.Size;


public class ImageInfo implements FfmpegOptioner{
	public static final int DEFAULT_START_TIME = 0;
	public static final int DEFAULT_DURATION=1;
	public static final int DEFAULT_FRAME=1;
	public static final String DEFAULT_FORMAT="image2";
	
	private int starttime;
	private int duration;
	private int frame;
	private Size size;
	private String format;
	private String output;
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

	private FfmpegOptioner superOption;
	public ImageInfo(){}
	public ImageInfo(FfmpegOptioner superOption) {
		this.superOption = superOption;
=======
package entity;


public class ImageInfo extends AbsFfmpegOption{
	private int starttime = 0;
	private int duration = 1;
	private int frame = 1;
	private Size size;
	private String format = "image2 ";

	private AbsFfmpegOption superOption;
	public ImageInfo(){}
	public ImageInfo(AbsFfmpegOption superOption, String output) {
		this.superOption = superOption;
		this.output = output;
>>>>>>> c8cba019d0424bde8e4054659c2bb10866e3457d
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

	public ImageInfo clone() {
		ImageInfo image = new ImageInfo();
		image.setDuration(this.duration);
		image.setFormat(this.format);
		image.setFrame(this.frame);
		image.setSize(this.size);
		image.setStarttime(this.starttime);
		return image;
	}
<<<<<<< HEAD
	
	public String toOption() throws InvalidOptionException {
		StringBuilder sb = new StringBuilder();
		if (this.superOption != null) {
			sb.append(this.superOption.toOption());
=======
	public String toOptions() throws InvalidOptionException {
		StringBuilder sb = new StringBuilder();
		if (this.superOption != null) {
			sb.append(this.superOption.toOptions());
>>>>>>> c8cba019d0424bde8e4054659c2bb10866e3457d
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
		if (!this.format.equals("")) {
			sb.append(" -f ").append(this.format);
		}
		if (output != null && !output.equals("")) {
			sb.append(output);
		}
		return sb.toString();
	}

}
