<<<<<<< HEAD
package net.SunLnx.Ffav;

=======
package service;

import entity.AbsFfmpegOption;
>>>>>>> c8cba019d0424bde8e4054659c2bb10866e3457d

public interface IFfmpegEncoder {
	// 从srcVideo源视频文件，使用默认项， 转码成对应的视频文件，并生成一张缩略图
	boolean encode(String srcVideo, String desVideo, String desImage);
	// 从srcVideo源视频文件，使用自定义项，转码生成对应的视频文件，缩略图等
	boolean encode(String srcVideo, AbsFfmpegOption options);
}
