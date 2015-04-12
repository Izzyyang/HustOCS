package service;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class VideoSave extends AbsFilePathGenerator {
	
	private IFileWriter fwriter = null;
	private static final String VIDEO_PATH  = "/home/sunlnx/video/";
	
	
	public VideoSave() {
		this.fwriter = new FileWriteImpl();
	}
	public VideoSave(IFileWriter fwrite) {
		this.fwriter = fwrite;
	}

	/*
	 * 实现模板类中的生成文件存储路径父目录方法
	 * @see service.AbsFileSaver#getParentePath()
	 */
	@Override
	public String  geneTopFilePath() {
		return VideoSave.VIDEO_PATH;
	}

	/*
	 * 保存来自HttpServletRequest中的单个视频流文件
	 * 一般在所有的视频流处理操作中放在最前
	 * fn为文件名称,不能为路径
	 */
	public boolean saveFile(InputStream is, String fn) {
		String pp = super.geneFilePath();
		File pf = new File(pp);
		if (!pf.exists()) {
			pf.mkdirs();
		}
		if (this.fwriter.write(is, pp + fn)) {
			return true;
		}
		return false;
	}
	public static void main(String agrs[]) throws FileNotFoundException {
		InputStream is = new FileInputStream("/home/sunlnx/test.txt");
		System.out.println(new VideoSave().saveFile( is, "test.txt.bak"));
	}


}
