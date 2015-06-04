package dao;

import java.util.List;
import entity.TearInfo;

public interface TeacherInfoDaoer{
	public boolean insert(TearInfo teacher);
	public boolean update(TearInfo teacher);
	public TearInfo view(String tId);
	//public Tear findTeacherByStr(Object[] parameters, String hql);
	public List<TearInfo> find(Class c, List<Object> strList, List<Object> value);
	public List<TearInfo> findbyStr(Class c, String field, Object value);
}
