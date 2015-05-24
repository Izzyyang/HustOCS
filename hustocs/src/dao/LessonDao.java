package dao;

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
	public void view(String lessonId) {
         Lesn lesn = (Lesn) baseDAO.getById(Lesn.class, lessonId);	
         System.out.println(lesn.getId()+" -- less ion id ");
	}

	@Override
	public List list(String hqlString,int lessonId) {
		return baseDAO.find(Lesn.class, hqlString, lessonId);
	}

}
