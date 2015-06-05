package dao;

import java.util.List;

import entity.Resource;

public interface ResourceDaoer {
	public boolean insert(String lessonId, String url);
	public String selectFileURL(String resourceId);
}
