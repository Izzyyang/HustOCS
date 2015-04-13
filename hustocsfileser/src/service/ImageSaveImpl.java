package service;

public class ImageSaveImpl extends AbsFilePathGenerator {

	private static final String IMAGE_PATH = "/home/sunlnx/image";
	private IFileWriter w = null;
	public ImageSaveImpl() {
		w = new FileWriteImpl();
	}
	public ImageSaveImpl(IFileWriter w) {
		this.w = w;
	}
	
	@Override
	public String geneTopFilePath() {
		return IMAGE_PATH;
	}

}
