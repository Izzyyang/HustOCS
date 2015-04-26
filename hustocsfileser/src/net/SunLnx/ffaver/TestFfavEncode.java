package net.SunLnx.ffaver;

public class TestFfavEncode {
	public void testEncodeVideo() {
		String srcVideo ="D:/movie.mp4";
		String desVideo = "D:/movie.flv";
		new FfavEncode().encodeVideo(srcVideo, desVideo);
	}
	public void testEncode() {
		
	}
	
	public void testEncodeImage() {
		String srcVideo ="D:/movie.mp4";
		String desImage = "D:/movie.jpg";
		new FfavEncode().encodeImage(srcVideo, desImage);
	}
	
	public static void main(String agrs[]) {
		TestFfavEncode test = new TestFfavEncode();
		//test.testEncodeVideo();
		test.testEncodeImage();
	}
}
