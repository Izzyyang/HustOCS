package service;


public class VideoSave extends AbstractFileSaver {
	
	private static final String VIDEO_PATH  = "D:/Video/";

	@Override
	protected String topPath() {
		return VideoSave.VIDEO_PATH;
	}

	@Override
	protected boolean filteType(String type) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
