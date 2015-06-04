package service.teacher;

import java.io.Serializable;
import java.util.List;

import util.Page;

import dao.ResourceDaoer;
import entity.Rese;

public class ResourceService implements ResourceServicer{
	private ResourceDaoer resourceDao;
	public ResourceService(ResourceDaoer resourceDao) {
		this.resourceDao = resourceDao;
	}
	public ResourceDaoer getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(ResourceDaoer resourceDao) {
		this.resourceDao = resourceDao;
	}
	@Override
	public boolean addResource(Rese resource) {
		return resourceDao.insert(resource);
	}
	@Override
	public boolean deleteResource(String resourceId) {
		return resourceDao.delete(resourceId);
	}
	@Override
	public boolean updateResource(Rese resource) {
		return resourceDao.update(resource);
	}
	@Override
	public Rese viewResource(Class c, Serializable resId) {
		return resourceDao.view(c, resId);
	}
	@Override
	public List listLessons(Class c, List<Object> fQueryList, List<Object> value) {
		return resourceDao.list(c, fQueryList, value);
	}
	@Override
	public List listLessons(Class c, String cascadeClass,List<Object> fQueryList, List<Object> value) {
		return resourceDao.list(c, cascadeClass,fQueryList, value);
	}
	@Override
	public Page listLessons(Class c, List<Object> fQueryList,List<Object> value, int pageNo, int pageSize) {
		return resourceDao.listPage(c, fQueryList, value, pageNo, pageSize);
	}
}
