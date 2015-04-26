package net.SunLnx.Ffaver;

public class DefaultFfmpegLocate implements FfmpegLocater{
	private DefaultFfmpegLocate(){}
	private static DefaultFfmpegLocate locater = new DefaultFfmpegLocate();
	
	// TODO 将ffmpeg和ffprobe可执行文件复制到本地计算机
	static {
		
	}
	
	public static FfmpegLocater getInstance(){
		return locater;
	}
	/*
	 * 获取ffmpeg可执行文件路径
	 * @see net.SunLnx.Ffav.IFfmpegLocater#getFfmpegExecutablePath()
	 */
	@Override
	public String getFfmpegExecutablePath() {
		// TOMODIFY
		return "E:/ffmpeg/bin/ffmpeg.exe";
	}

	/*
	 * 获取ffprobe可执行文件路径
	 * @see net.SunLnx.Ffav.IFfmpegLocater#getFfprobeExecutePath()
	 */
	@Override
	public String getFfprobeExecutePath() {
		// TOMODIFY
		return "E:/ffmpeg/bin/ffprobe.exe";
	}
	
}
