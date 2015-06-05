package service;

public class ImageSave extends AbstractFileSaver {

	private static final String IMAGE_PATH = "D:/Images/";

	@Override
	protected String topPath() {
		return ImageSave.IMAGE_PATH;
	}

	@Override
	protected boolean filteType(String type) {
		return true;
	}

	public static void main(String agrs[]) {
		ImageSave is = new ImageSave();
		System.out.println(is.getFilePathGenerator().generateFilePath(is.topPath(), "test.png"));
	}

}
