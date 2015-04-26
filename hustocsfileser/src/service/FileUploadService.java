package service;

import javax.servlet.http.HttpServletRequest;

import service.VideoSave;

public class FileUploadService {
	public void draw(HttpServletRequest req) {
		new VideoSave().saveHttpRequestFile(req);
	}
}
