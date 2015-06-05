package service;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.SunLnx.streamer.StreamWrite;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public abstract class AbstractFileSaver {

	private IFilePathGenerator filePathGenerator;
	protected abstract String topPath();
	public AbstractFileSaver() {
		filePathGenerator = new FilePathGenerate();
	}

	protected abstract boolean filteType(String type);

	public List<String> saveHttpRequestFile(HttpServletRequest request) {
		ServletFileUpload up = new ServletFileUpload();
		try {
			FileItemIterator iterator = up.getItemIterator(request);
			FileItemStream stream = null;
			while (iterator.hasNext()) {
				stream = iterator.next();
				if (stream.isFormField()) {
				} else {
					if (true == this.filteType(stream.getContentType())) {
						new StreamWrite().write(
								this.filePathGenerator.generateFilePath(
										this.topPath(),
										stream.getName()), stream.openStream());
					}
				}
			}
		} catch (FileUploadException e) {
		} catch (IOException e) {
		}
		return null;
	}

	public IFilePathGenerator getFilePathGenerator() {
		return filePathGenerator;
	}

	public void setFilePathGenerator(IFilePathGenerator filePathGenerator) {
		this.filePathGenerator = filePathGenerator;
	}

}
