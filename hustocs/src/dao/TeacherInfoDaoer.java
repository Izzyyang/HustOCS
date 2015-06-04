package dao;

import java.io.Serializable;
import java.util.List;
import util.Page;
import entity.TearInfo;

public interface TeacherInfoDaoer{
	public boolean insert(TearInfo teacher);
	public boolean update(TearInfo teacher);
	public boolean delete(Class c,Serializable tearInfoID);
	public TearInfo view(Class c,Serializable resId);
	public List findTeacherInfoByStr(Class c,String field,Object value);
	public List list(Class c, List<Object> strList, List<Object> value);
	public Page listPage(Class c, List<Object> strList, List<Object> value,int pageNo,int pageSize);
	public List list(Class c,String cascadeClass,List<Object> strList, List<Object> value);
}
