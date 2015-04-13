package net.SunLnx.Ffav;

import entity.InvalidOptionException;

public interface FfmpegOptioner {
	//Ffmpeg 选项
	String toOption() throws InvalidOptionException;
}
