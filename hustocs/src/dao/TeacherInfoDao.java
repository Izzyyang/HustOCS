package dao;

import java.io.Serializable;
import java.util.List;

import util.Page;
import entity.Rese;
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
	public TearInfo view(Class c, Serializable teacherInfoId) {
		return (TearInfo) baseDAO.getById(c, teacherInfoId);
	}

	@Override
	public List list(Class c, List<Object> strList, List<Object> value) {
		return baseDAO.find(c, strList, value);
	}

	@Override
	public Page listPage(Class c, List<Object> strList, List<Object> value,
			int pageNo, int pageSize) {
		return baseDAO.findPage(c, strList, value, pageNo, pageSize);
	}

	@Override
	public List list(Class c, String cascadeClass, List<Object> strList,
			List<Object> value) {
		return baseDAO.find(c, cascadeClass, strList, value);
	}

	@Override
	public List findTeacherInfoByStr(Class c, String field, Object value) {
		// TODO Auto-generated method stub
		return baseDAO.find(c, field, value);
	}

	@Override
	public boolean delete(Class c, Serializable tearInfoID) {
		return baseDAO.deleteById(c, tearInfoID);
	}

	
}