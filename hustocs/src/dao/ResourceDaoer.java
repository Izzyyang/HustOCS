package dao;

import java.io.Serializable;
import java.util.List;
import entity.Rese;

public interface ResourceDaoer {
	public boolean insert(Rese resource);
	public boolean delete(String resourceId);
	public boolean update(Rese resource);
	public Rese view(Class c,Serializable resId);
	public List list(Class c, List<Object> strList, List<Object> value);
	public List list(Class c,String cascadeClass,List<Object> strList, List<Object> value);
}
