package service;

public class DocSave extends AbstractFileSaver{
	private static final String DOC_PATH = "D:/Docs/";

	@Override
	protected String topPath() {
		return DocSave.DOC_PATH;
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
