package dao;

import java.io.Serializable;
import java.util.List;

import entity.Tear;

public class TeacherDao implements TeacherDaoer {
    private static BaseDAO baseDAO = new BaseDAO();
    
	@Override
	public boolean insert(Tear teacher) {
		return baseDAO.add(teacher);
	}

	@Override
	public boolean update(Tear teacher) {
		return baseDAO.updateObject(teacher);
	}

	@Override
	public Tear view(Class c,Serializable tId) {
		return (Tear) baseDAO.getById(Tear.class, tId);
	}

	@Override
	public List find(Class c, List<Object> strList, List<Object> value) {
		return baseDAO.find(c, strList, value);
	}

	@Override
	public boolean delete(Class c,Serializable TeacherId) {
		return baseDAO.deleteById(c,TeacherId);
	}
}
