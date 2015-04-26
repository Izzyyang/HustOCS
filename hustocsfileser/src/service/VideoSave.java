package service;


public class VideoSave extends AbstractFileSaver {
	
	private static final String VIDEO_PATH  = "/home/sunlnx/video/";

	@Override
	protected String generateTopPath() {
		return VideoSave.VIDEO_PATH;
	}

	@Override
	protected boolean filteType(String type) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
