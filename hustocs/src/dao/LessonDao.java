package dao;

import java.io.Serializable;
import java.util.List;

import entity.Lesn;

public class LessonDao implements LessonDaoer {
    private static BaseDAO baseDAO = new BaseDAO();
	@Override
	public boolean insert(Lesn lesson) {
		return baseDAO.add(lesson);
	}

	@Override
	public boolean delete(String lessonId) {
		return baseDAO.deleObject(lessonId);
	}

	@Override
	public boolean update(Lesn lesson) {
		return baseDAO.updateObject(lesson);
	}

	@Override
	public Lesn view(Class c, Serializable lessonId) {
		return (Lesn) baseDAO.getById(c, lessonId);
	}

	@Override
	public List list(Class c, List<Object> strList, List<Object> value) {
		return baseDAO.find(c, strList, value);
	}

	@Override
	public List list(Class c, String cascadeClass, List<Object> strList,
			List<Object> value) {
		return baseDAO.find(c,cascadeClass, strList, value);
	}

}
