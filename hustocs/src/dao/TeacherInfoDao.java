package dao;

import java.util.List;
import entity.TearInfo;

public class TeacherInfoDao implements TeacherInfoDaoer {
    private static BaseDAO baseDAO = new BaseDAO();

	@Override
	public boolean insert(TearInfo teacher) {
		return baseDAO.add(teacher);
	}

	@Override
	public boolean update(TearInfo teacher) {
		return baseDAO.updateObject(teacher);
	}

	@Override
	public TearInfo view(String tId) {
		return (TearInfo) baseDAO.getById(TearInfo.class, tId);
	}

	@Override
	public List find(Class c, List<Object> strList, List<Object> value) {
		return baseDAO.find(c, strList, value);
	}

	@Override
	public List findbyStr(Class c, String field, Object value) {
		return baseDAO.find(c, field, value);
	}
}