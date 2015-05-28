package dao;

import java.util.List;

import entity.Tear;
import entity.TearInfo;

public interface TeacherDaoer {
	public boolean insert(Tear teacher);
	public boolean update(Tear teacher);
	public Tear view(String tId);
	//public Tear findTeacherByStr(Object[] parameters, String hql);
	public List<Tear> find(Class c, List<String> strList, List<Object> value);
}
