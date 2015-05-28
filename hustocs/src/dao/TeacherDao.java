package dao;

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
	public Tear view(String tId) {
		return (Tear) baseDAO.getById(Tear.class, tId);
	}

	@Override
	public List find(Class c, List<String> strList, List<Object> value) {
		return baseDAO.find(c, strList, value);
	}
}
