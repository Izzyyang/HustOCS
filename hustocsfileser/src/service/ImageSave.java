package service;

public class ImageSave extends AbsFilePathGenerator {

	private static final String IMAGE_PATH = "/home/sunlnx/image";
	private FileWriter w = null;
	public ImageSave() {
		w = new FileWrite();
	}
	public ImageSave(FileWriter w) {
		this.w = w;
	}
	
	@Override
	public String geneTopFilePath() {
		return IMAGE_PATH;
	}

}
