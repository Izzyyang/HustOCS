package service.teacher;

import java.util.List;

import dao.ResourceDaoer;

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
	public boolean addResource() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteResource() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateResource() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void viewResource() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List listLessonResource() {
		// TODO Auto-generated method stub
		return null;
	}

}
