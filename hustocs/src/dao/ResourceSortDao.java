package dao;

import java.io.Serializable;
import java.util.List;

import entity.ReseSort;

public class ResourceSortDao implements ResourceSortDaoer {
	private static BaseDAO baseDAO = new BaseDAO();
	@Override
	public boolean insert(ReseSort reseSort) {
		return baseDAO.add(reseSort);
	}

	@Override
	public boolean delete(ReseSort reseSort) {
		return baseDAO.deleObject(reseSort);
	}

	@Override
	public boolean update(ReseSort resSort) {
		return baseDAO.updateObject(resSort);
	}

	@Override
	public ReseSort view(Class c, Serializable resSortId) {
		return (ReseSort) baseDAO.getById(c, resSortId);
	}

	@Override
	public List list(Class c, List<Object> strList, List<Object> value) {
		return baseDAO.find(c, strList, value);
	}

	@Override
	public List list(Class c, String cascadeClass, List<Object> strList,
			List<Object> value) {
		return baseDAO.find(c, cascadeClass, strList, value);
	}
	}
