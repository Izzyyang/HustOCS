package net.SunLnx.Ffav;

import entity.InvalidOptionException;

public abstract class AbstractFfmpegOption {
	protected AbstractFfmpegOption preOptioner;

	public AbstractFfmpegOption getPreOption() {
		return preOptioner;
	}

	public void setPreOption(AbstractFfmpegOption preOptioner) {
		this.preOptioner = preOptioner;
	}

	public String toOptions() throws InvalidOptionException {
		StringBuffer sb = new StringBuffer();
		System.out.println("lol");
		if (this.preOptioner != null) {
			sb.append(this.preOptioner.toOptions());
		}
		sb.append(this.toOption());
		return sb.toString();
	}
	
	// Ffmpeg 选项
		public abstract String toOption() throws InvalidOptionException;
}
