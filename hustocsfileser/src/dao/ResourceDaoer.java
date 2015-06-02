package dao;

import java.util.List;

import entity.Resource;

public interface ResourceDaoer {
	public boolean insert(Resource resource);
	public List<String> selectFiles(String resourceId);
}
