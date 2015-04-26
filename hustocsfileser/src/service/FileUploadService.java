package service;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.VideoSave;

public class FileUploadService {
	public void draw(HttpServletRequest req) {
		ServletFileUpload up = new ServletFileUpload();
		try {
			FileItemIterator iterator = up.getItemIterator(req);
			FileItemStream stream = null;
			while (iterator.hasNext()) {
				stream = iterator.next();
				if (stream.isFormField()) {

				} else {
					System.out.println(stream.getContentType());
					// if (stream.getContentType().equals(anObject))
					new VideoSave().saveFile(stream.openStream(),
							stream.getName());
					// To-do 非视频文件
				}
			}
		} catch (FileUploadException e) {
		} catch (IOException e) {
		}
	}
}
