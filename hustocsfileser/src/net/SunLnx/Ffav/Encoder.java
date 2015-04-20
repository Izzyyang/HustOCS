
package net.SunLnx.Ffav;

public interface Encoder {
	// 从srcVideo源视频文件，使用自定义项，转码生成对应的视频文件，缩略图等
	boolean encode(String srcVideo, AbstractFfmpegOption options);
	
	// 单个视频文件转码
	boolean encodeVideo(String srcVideo, String desVIdeo);
	
	// 单张视频截图
	boolean encodeImage(String srcVideo, String desImage);
}
