package dao;

import java.io.Serializable;
import java.util.List;

import entity.Lesn;
import entity.Rese;

public class ResourceDao implements ResourceDaoer {
	private static BaseDAO baseDAO = new BaseDAO();
	@Override
	public boolean insert(Rese resource) {
		return baseDAO.add(resource);
	}

	@Override
	public boolean delete(String resourceId) {
		return baseDAO.deleObject(resourceId);
	}

	@Override
	public boolean update(Rese resource) {
		return baseDAO.updateObject(resource);
	}

	@Override
	public List list(Class c, List<Object> strList, List<Object> value) {
		return baseDAO.find(c, strList, value);
	}

	@Override
	public Rese view(Class c, Serializable resId) {
		return (Rese) baseDAO.getById(c, resId);
	}

	@Override
	public List list(Class c, String cascadeClass, List<Object> strList,List<Object> value) {
		return baseDAO.find(c, cascadeClass, strList, value);
	}

}
