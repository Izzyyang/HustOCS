package service.teacher;

import java.io.Serializable;
import java.util.List;
import dao.ResourceSortDaoer;
import entity.ReseSort;

public class ResourceSortService implements ResourceSortServicer{
	private ResourceSortDaoer resourceSortDao;
	public ResourceSortService(ResourceSortDaoer resourceSortDao){
		this.setResourceSortDao(resourceSortDao);
	}
	@Override
	public boolean addResourceSort(ReseSort resourceSort) {
		return resourceSortDao.insert(resourceSort);
	}

	@Override
	public boolean deleteResourceSort(ReseSort reseSort) {
		return resourceSortDao.delete(reseSort);
	}

	@Override
	public boolean updateResourceSort(ReseSort reseSort) {
		return resourceSortDao.update(reseSort);
	}

	@Override
	public ReseSort viewResourceSort(Class c, Serializable resId) {
		return resourceSortDao.view(c, resId);
	}

	@Override
	public List listResourceSort(Class c, List<Object> fQueryList, List<Object> value) {
		return resourceSortDao.list(c, fQueryList, value);
	}

	@Override
	public List listResourceSort(Class c, String cascadeClass,List<Object> fQueryList, List<Object> value) {
		return resourceSortDao.list(c, cascadeClass, fQueryList, value);
	}
	public ResourceSortDaoer getResourceSortDao() {
		return resourceSortDao;
	}
	public void setResourceSortDao(ResourceSortDaoer resourceSortDao) {
		this.resourceSortDao = resourceSortDao;
	}
	}
