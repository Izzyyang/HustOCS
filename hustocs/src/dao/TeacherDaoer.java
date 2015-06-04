package dao;

import java.io.Serializable;
import java.util.List;

import entity.Tear;
import entity.TearInfo;

public interface TeacherDaoer {
	public boolean insert(Tear teacher);
	public boolean update(Tear teacher);
	public boolean delete(Class c,Serializable tId);
	public Tear view(Class c,Serializable tId);
	//public Tear findTeacherByStr(Object[] parameters, String hql);
	public List<Tear> find(Class c, List<Object> strList, List<Object> value);
}
