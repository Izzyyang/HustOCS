package dao;

import java.io.Serializable;
import java.util.List;
import entity.ReseSort;

public interface ResourceSortDaoer {
	public boolean insert(ReseSort resource);
	public boolean delete(ReseSort resort);
	public boolean update(ReseSort resource);
	public ReseSort view(Class c,Serializable resId);
	public List list(Class c, List<Object> strList, List<Object> value);
	public List list(Class c,String cascadeClass,List<Object> strList, List<Object> value);
}
